import json
import os

base = os.path.abspath(__file__ + '/../')

def camel_to_upper_snake_case(s):
  # ValkgateControllerBlockItem -> VALKGATE_CONTROLLER_BLOCK[_ITEM]
  s1 = ''
  for c in s:
    if c.isupper() and s1: s1 += '_'
    s1 += c.upper()
  return s1.rstrip('_ITEM')

with open(base + '/unpack-data-blocks.json', encoding='utf-8') as f:
  blocks = json.load(f)

with open(base + '/unpack-data-items.json', encoding='utf-8') as f:
  items = json.load(f)

code = '''package org.octechnics.valkdrive;

import net.minecraftforge.client.event.EntityRenderersEvent.RegisterRenderers;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.item.Item;

'''

for name, block in blocks.items():
  code += f'import org.octechnics.valkdrive.blocks.{block[1]};\n'

code += '\n'

for name, block in blocks.items():
  if block[0] != 'tile': continue
  
  code += f'import org.octechnics.valkdrive.tile.{block[1].replace("Block", "BE")};\n'

code += '\n'

for name, item in items.items():
  code += f'import org.octechnics.valkdrive.items.{item[1]};\n'

code += '''
// use org.octechnics.valkdrive.ValkgateRenderer;
// use org.octechnics.valkdrive.ValkgateEntity;
// use org.octechnics.valkdrive.ValkyrienDrive;

public class BlocksItemsRegistryHelper {
    private static final DeferredRegister<Block> BLOCKS =
        DeferredRegister.create(ForgeRegistries.BLOCKS, ValkyrienDrive.MOD_ID);
    private static final DeferredRegister<Item> ITEMS =
        DeferredRegister.create(ForgeRegistries.ITEMS, ValkyrienDrive.MOD_ID);
    private static final DeferredRegister<BlockEntityType<?>> TILES =
        DeferredRegister.create(ForgeRegistries.BLOCK_ENTITIES, ValkyrienDrive.MOD_ID);
    private static final DeferredRegister<EntityType<?>> ENTITIES =
        DeferredRegister.create(ForgeRegistries.ENTITIES, ValkyrienDrive.MOD_ID);
    
'''

for name, block in blocks.items():
  code += f'    public static final RegistryObject<Block> {block[2]} =\n'
  code += f'        BLOCKS.register("{name}", {block[1]}::new);\n'

code += '\n'

for name, block in blocks.items():
  if block[0] != 'tile': continue
  tile_name = block[1].replace('Block', 'BE')
  tile_var = block[2].replace('_BLOCK', '_TILE')
  
  code += f'    public static final RegistryObject<BlockEntityType<{tile_name}>> {tile_var} =\n'
  code += f'        TILES.register("{name}", () -> BlockEntityType.Builder.of({tile_name}::new, {block[2]}.get()).build(null));\n'

code += '\n'

for name, item in items.items():
  code += f'    public static final RegistryObject<Item> {camel_to_upper_snake_case(name)}_ITEM =\n'
  code += f'        ITEMS.register("{name}", {item[1]}::new);\n'

code += '''

    public static final RegistryObject<EntityType<ValkgateEntity>> VALKGATE_ENTITY = ENTITIES.register("valkgate_entity",
      () -> EntityType.Builder.<ValkgateEntity>of(ValkgateEntity::new, MobCategory.MISC)
        .fireImmune()
        .canSpawnFarFromPlayer()
        .sized(4.0F, 4.0F)
        .clientTrackingRange(10).build("valkgate_entity"));
    
    public void initialize() {
        ValkyrienDrive.logger.info("valkdrive - requesting to register blocks");
        BLOCKS.register(FMLJavaModLoadingContext.get().getModEventBus());
        
        ValkyrienDrive.logger.info("valkdrive - requesting to register items");
        ITEMS.register(FMLJavaModLoadingContext.get().getModEventBus());
        
        ValkyrienDrive.logger.info("valkdrive - requesting to register tile entities");
        TILES.register(FMLJavaModLoadingContext.get().getModEventBus());
        
        ValkyrienDrive.logger.info("valkdrive - requesting to register entities");
        ENTITIES.register(FMLJavaModLoadingContext.get().getModEventBus());
        
        FMLJavaModLoadingContext.get().getModEventBus().register(this);
    }
    
    @SubscribeEvent
    @OnlyIn(Dist.CLIENT)
    public void client_initialize_entity_renders(RegisterRenderers e) {
        ValkyrienDrive.logger.info("valkdrive - requesting to register entity renderers");
        
        e.registerEntityRenderer(VALKGATE_ENTITY.get(), ValkgateRenderer<ValkgateEntity>::new);
    }
}
'''

with open(base + '/src/main/java/org/octechnics/valkdrive/BlocksItemsRegistryHelper.java', 'w',
          encoding='utf-8') as f: f.write(code)
