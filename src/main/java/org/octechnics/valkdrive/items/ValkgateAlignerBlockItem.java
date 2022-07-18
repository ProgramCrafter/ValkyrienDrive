package org.octechnics.valkdrive.items;

import net.minecraft.world.item.BlockItem;

import org.octechnics.valkdrive.ValkyrienDrive;

public class ValkgateAlignerBlockItem extends BlockItem {
    public ValkgateAlignerBlockItem() {
        super(ValkyrienDrive.registry_blocks.VALKGATE_ALIGN_BLOCK.get(),
              new Properties() /* .tab(ItemGroup.COMMON) */ );
    }
}
