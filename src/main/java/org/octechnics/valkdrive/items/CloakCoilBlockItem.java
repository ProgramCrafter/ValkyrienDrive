package org.octechnics.valkdrive.items;

import net.minecraft.world.item.BlockItem;

import org.octechnics.valkdrive.ValkyrienDrive;

public class CloakCoilBlockItem extends BlockItem {
    public CloakCoilBlockItem() {
        super(ValkyrienDrive.registry_blocks.CLOAK_COIL_BLOCK.get(),
              new Properties() /* .tab(ItemGroup.COMMON) */ );
    }
}
