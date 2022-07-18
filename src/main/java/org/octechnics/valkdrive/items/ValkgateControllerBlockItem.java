package org.octechnics.valkdrive.items;

import net.minecraft.world.item.BlockItem;

import org.octechnics.valkdrive.ValkyrienDrive;

public class ValkgateControllerBlockItem extends BlockItem {
    public ValkgateControllerBlockItem() {
        super(ValkyrienDrive.registry_blocks.VALKGATE_CONTR_BLOCK.get(),
              new Properties() /* .tab(ItemGroup.COMMON) */ );
    }
}
