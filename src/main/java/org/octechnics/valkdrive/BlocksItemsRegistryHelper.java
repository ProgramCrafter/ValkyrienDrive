package org.octechnics.valkdrive;

import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.item.Item;

import org.octechnics.valkdrive.blocks.ValkgateControllerBlock;
import org.octechnics.valkdrive.blocks.ValkgateAlignerBlock;
import org.octechnics.valkdrive.blocks.ShipControllerBlock;
import org.octechnics.valkdrive.blocks.ShipAlignerBlock;
import org.octechnics.valkdrive.blocks.LaserMediumBlock;
import org.octechnics.valkdrive.blocks.RadarBlock;
import org.octechnics.valkdrive.blocks.CloakControllerBlock;
import org.octechnics.valkdrive.blocks.CloakCoilBlock;

import org.octechnics.valkdrive.tile.ValkgateControllerBE;

import org.octechnics.valkdrive.items.StarMechanismItem;
import org.octechnics.valkdrive.items.ValkgateControllerBlockItem;
import org.octechnics.valkdrive.items.ValkgateAlignerBlockItem;
import org.octechnics.valkdrive.items.ShipControllerBlockItem;
import org.octechnics.valkdrive.items.ShipAlignerBlockItem;
import org.octechnics.valkdrive.items.LaserMediumBlockItem;
import org.octechnics.valkdrive.items.RadarBlockItem;
import org.octechnics.valkdrive.items.CloakControllerBlockItem;
import org.octechnics.valkdrive.items.CloakCoilBlockItem;

// use org.octechnics.valkdrive.ValkyrienDrive;

public class BlocksItemsRegistryHelper {
    private static final DeferredRegister<Block> BLOCKS =
        DeferredRegister.create(ForgeRegistries.BLOCKS, ValkyrienDrive.MOD_ID);
    private static final DeferredRegister<Item> ITEMS =
        DeferredRegister.create(ForgeRegistries.ITEMS, ValkyrienDrive.MOD_ID);
    private static final DeferredRegister<BlockEntityType<?>> TILES =
        DeferredRegister.create(ForgeRegistries.BLOCK_ENTITIES, ValkyrienDrive.MOD_ID);
    
    public static final RegistryObject<Block> VALKGATE_CONTR_BLOCK =
        BLOCKS.register("valkgate_controller_block", ValkgateControllerBlock::new);
    public static final RegistryObject<Block> VALKGATE_ALIGN_BLOCK =
        BLOCKS.register("valkgate_aligner_block", ValkgateAlignerBlock::new);
    public static final RegistryObject<Block> SHIP_CONTR_BLOCK =
        BLOCKS.register("ship_controller_block", ShipControllerBlock::new);
    public static final RegistryObject<Block> SHIP_ALIGN_BLOCK =
        BLOCKS.register("ship_aligner_block", ShipAlignerBlock::new);
    public static final RegistryObject<Block> LASER_BLOCK =
        BLOCKS.register("laser_medium_block", LaserMediumBlock::new);
    public static final RegistryObject<Block> RADAR_BLOCK =
        BLOCKS.register("radar_block", RadarBlock::new);
    public static final RegistryObject<Block> CLOAK_CONTR_BLOCK =
        BLOCKS.register("cloak_controller_block", CloakControllerBlock::new);
    public static final RegistryObject<Block> CLOAK_COIL_BLOCK =
        BLOCKS.register("cloak_coil_block", CloakCoilBlock::new);

    public static final RegistryObject<BlockEntityType<ValkgateControllerBE>> VALKGATE_CONTR_TILE =
        TILES.register("valkgate_controller_block", () -> BlockEntityType.Builder.of(ValkgateControllerBE::new, VALKGATE_CONTR_BLOCK.get()).build(null));

    public static final RegistryObject<Item> STAR_MECHANIS_ITEM =
        ITEMS.register("star_mechanism_item", StarMechanismItem::new);
    public static final RegistryObject<Item> VALKGATE_CONTROLLER_BLOCK_ITEM =
        ITEMS.register("valkgate_controller_block", ValkgateControllerBlockItem::new);
    public static final RegistryObject<Item> VALKGATE_ALIGNER_BLOCK_ITEM =
        ITEMS.register("valkgate_aligner_block", ValkgateAlignerBlockItem::new);
    public static final RegistryObject<Item> SHIP_CONTROLLER_BLOCK_ITEM =
        ITEMS.register("ship_controller_block", ShipControllerBlockItem::new);
    public static final RegistryObject<Item> SHIP_ALIGNER_BLOCK_ITEM =
        ITEMS.register("ship_aligner_block", ShipAlignerBlockItem::new);
    public static final RegistryObject<Item> LASER_MEDIUM_BLOCK_ITEM =
        ITEMS.register("laser_medium_block", LaserMediumBlockItem::new);
    public static final RegistryObject<Item> RADAR_BLOCK_ITEM =
        ITEMS.register("radar_block", RadarBlockItem::new);
    public static final RegistryObject<Item> CLOAK_CONTROLLER_BLOCK_ITEM =
        ITEMS.register("cloak_controller_block", CloakControllerBlockItem::new);
    public static final RegistryObject<Item> CLOAK_COIL_BLOCK_ITEM =
        ITEMS.register("cloak_coil_block", CloakCoilBlockItem::new);

    public void initialize() {
        ValkyrienDrive.logger.info("valkdrive - requesting to register blocks");
        BLOCKS.register(FMLJavaModLoadingContext.get().getModEventBus());
        
        ValkyrienDrive.logger.info("valkdrive - requesting to register items");
        ITEMS.register(FMLJavaModLoadingContext.get().getModEventBus());
        
        ValkyrienDrive.logger.info("valkdrive - requesting to register tile entities");
        TILES.register(FMLJavaModLoadingContext.get().getModEventBus());
    }
}
