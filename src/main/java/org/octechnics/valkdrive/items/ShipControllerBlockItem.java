package org.octechnics.valkdrive.items;

import net.minecraft.world.item.BlockItem;

import org.octechnics.valkdrive.ValkyrienDrive;

public class ShipControllerBlockItem extends BlockItem {
    public ShipControllerBlockItem() {
        super(ValkyrienDrive.registry_blocks.SHIP_CONTR_BLOCK.get(),
              new Properties() /* .tab(ItemGroup.COMMON) */ );
    }
}
