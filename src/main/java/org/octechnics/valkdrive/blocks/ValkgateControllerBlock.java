// Written manually.

package org.octechnics.valkdrive.blocks;

import net.minecraft.world.level.storage.loot.LootContext;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.EntityBlock;
import net.minecraft.world.level.material.Material;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.core.BlockPos;

import java.util.List;

import org.octechnics.valkdrive.tile.ValkgateControllerBE;
import org.octechnics.valkdrive.ValkyrienDrive;

public class ValkgateControllerBlock extends Block implements EntityBlock {
    public ValkgateControllerBlock() {
        super(Properties.of(Material.METAL)
                        .sound(SoundType.METAL)
                     /* .harvestTool(ToolType.PICKAXE) */ );
    }
    
    @Override
    public List<ItemStack> getDrops(BlockState state, LootContext.Builder builder) {
        return List.of(new ItemStack(this));
    }
    
    @Override public BlockEntity newBlockEntity(final BlockPos pos, final BlockState state) {
        return new ValkgateControllerBE(pos, state);
    }
    
    @Override
    public InteractionResult use(final BlockState state, final Level level, final BlockPos pos, final Player player, final InteractionHand hand, final BlockHitResult hit) {
        final BlockEntity blockEntity = level.getBlockEntity(pos);
        if (!(blockEntity instanceof final ValkgateControllerBE valkgateController)) {
            return super.use(state, level, pos, player, hand, hit);
        }
        
        ValkyrienDrive.logger.info("Clicked Valkgate Controller: {} {} {} {}",
          valkgateController.valid, valkgateController.dx,
          valkgateController.dy,    valkgateController.dz);
        
        return InteractionResult.sidedSuccess(level.isClientSide());
    }
}

