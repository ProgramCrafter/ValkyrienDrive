package org.octechnics.valkdrive.items;

import net.minecraft.world.item.BlockItem;

import org.octechnics.valkdrive.ValkyrienDrive;

public class StargateBaseBlockItem extends BlockItem {
    public StargateBaseBlockItem() {
        super(ValkyrienDrive.STARGATE_BASE_BLOCK.get(),
              new Properties() /* .tab(ItemGroup.COMMON) */ );
    }
}
