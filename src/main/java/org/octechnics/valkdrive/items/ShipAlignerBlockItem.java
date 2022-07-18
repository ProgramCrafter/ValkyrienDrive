package org.octechnics.valkdrive.items;

import net.minecraft.world.item.BlockItem;

import org.octechnics.valkdrive.ValkyrienDrive;

public class ShipAlignerBlockItem extends BlockItem {
    public ShipAlignerBlockItem() {
        super(ValkyrienDrive.registry_blocks.SHIP_ALIGN_BLOCK.get(),
              new Properties() /* .tab(ItemGroup.COMMON) */ );
    }
}
