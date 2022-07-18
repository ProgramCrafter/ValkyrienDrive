package org.octechnics.valkdrive.items;

import net.minecraft.world.item.BlockItem;

import org.octechnics.valkdrive.ValkyrienDrive;

public class LaserMediumBlockItem extends BlockItem {
    public LaserMediumBlockItem() {
        super(ValkyrienDrive.registry_blocks.LASER_BLOCK.get(),
              new Properties() /* .tab(ItemGroup.COMMON) */ );
    }
}
