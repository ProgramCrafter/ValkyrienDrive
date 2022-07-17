package org.octechnics.valkdrive;  // TODO: move to package (...).items

import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;

import java.util.List;

// use org.octechnics.valkdrive.StargateBaseBlock;
// use org.octechnics.valkdrive.ValkyrienDrive;

public class StargateBaseBlockItem extends BlockItem {
    public StargateBaseBlockItem() {
        super(ValkyrienDrive.STARGATE_BASE_BLOCK.get(),
              new Properties() /* .tab(ItemGroup.COMMON) */ );
    }
}
