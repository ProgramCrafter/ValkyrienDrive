package org.octechnics.valkdrive;

import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.common.MinecraftForge;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.fml.common.Mod;
import net.minecraft.world.item.Item;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;

// use org.octechnics.valkdrive.StargateBaseBlock;
import org.octechnics.valkdrive.items.StargateBaseBlockItem;
import org.octechnics.valkdrive.items.StarMechanismItem;

@Mod(ValkyrienDrive.MOD_ID)
public class ValkyrienDrive {
    public static Logger logger = LogManager.getLogger();
    
    private static final DeferredRegister<Block> BLOCKS =
        DeferredRegister.create(ForgeRegistries.BLOCKS, ValkyrienDrive.MOD_ID);
    private static final DeferredRegister<Item> ITEMS =
        DeferredRegister.create(ForgeRegistries.ITEMS, ValkyrienDrive.MOD_ID);
    public static final RegistryObject<Block> STARGATE_BASE_BLOCK =
        BLOCKS.register("stargate_base_block",  StargateBaseBlock::new);
    public static final RegistryObject<Item> STARGATE_BASE_BITEM =
        ITEMS.register("stargate_base_block", StargateBaseBlockItem::new);
    public static final RegistryObject<Item> STAR_MECHANISM_ITEM =
        ITEMS.register("star_mechanism_item", StarMechanismItem::new);
    
    public static final String MOD_ID = "valkdrive";
    
    public ValkyrienDrive() {
        logger.info("valkdrive - registering mod");
        MinecraftForge.EVENT_BUS.register(this);
        
        logger.info("valkdrive - requesting to register blocks");
        BLOCKS.register(FMLJavaModLoadingContext.get().getModEventBus());
        
        logger.info("valkdrive - requesting to register items");
        ITEMS.register(FMLJavaModLoadingContext.get().getModEventBus());
    }
}
