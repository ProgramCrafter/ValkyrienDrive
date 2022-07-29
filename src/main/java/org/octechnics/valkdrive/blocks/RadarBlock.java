package org.octechnics.valkdrive.blocks;

import net.minecraft.world.level.storage.loot.LootContext;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.Material;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.item.ItemStack;

import java.util.List;

public class RadarBlock extends Block {
    public RadarBlock() {
        super(Properties.of(Material.METAL)
                        .sound(SoundType.METAL)
                     /* .harvestTool(ToolType.PICKAXE) */ );
    }
}

