package org.octechnics.valkdrive.items;

import net.minecraft.world.item.BlockItem;

import org.octechnics.valkdrive.ValkyrienDrive;

public class CloakControllerBlockItem extends BlockItem {
    public CloakControllerBlockItem() {
        super(ValkyrienDrive.registry_blocks.CLOAK_CONTR_BLOCK.get(),
              new Properties() /* .tab(ItemGroup.COMMON) */ );
    }
}
