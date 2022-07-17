package org.octechnics.valkdrive;  // TODO: move to package (...).blocks

import net.minecraft.world.level.storage.loot.LootContext;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.Material;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.item.ItemStack;

import java.util.List;

public class StargateBaseBlock extends Block {
    public StargateBaseBlock() {
        super(Properties.of(Material.METAL)
                        .sound(SoundType.METAL)
                     /* .harvestTool(ToolType.PICKAXE) */ );
    }
    @Override
    public List<ItemStack> getDrops(BlockState state, LootContext.Builder builder) {
        return List.of(new ItemStack(this));
    }
}
