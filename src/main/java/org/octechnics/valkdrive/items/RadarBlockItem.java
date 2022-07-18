package org.octechnics.valkdrive.items;

import net.minecraft.world.item.BlockItem;

import org.octechnics.valkdrive.ValkyrienDrive;

public class RadarBlockItem extends BlockItem {
    public RadarBlockItem() {
        super(ValkyrienDrive.registry_blocks.RADAR_BLOCK.get(),
              new Properties() /* .tab(ItemGroup.COMMON) */ );
    }
}
