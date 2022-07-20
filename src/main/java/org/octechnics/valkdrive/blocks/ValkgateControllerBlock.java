// Written manually.

package org.octechnics.valkdrive.blocks;

import net.minecraft.world.level.pathfinder.PathComputationType;
import net.minecraft.world.level.storage.loot.LootContext;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.level.block.EntityBlock;
import net.minecraft.world.level.material.Material;
import net.minecraft.world.level.block.RenderShape;
import net.minecraft.world.phys.shapes.VoxelShape;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.core.Direction;
import net.minecraft.core.BlockPos;

import java.util.List;

import org.octechnics.valkdrive.tile.ValkgateControllerBE;
import org.octechnics.valkdrive.ValkyrienDrive;

// use org.octechnics.valkdrive.blocks.ValkgateAlignerBlock;

public class ValkgateControllerBlock extends Block implements EntityBlock {
    protected static final VoxelShape AABB = 
      Shapes.or(
        Block.box(0.0D, 0.0D, 0.0D, 16.0D, 15.0D, 16.0D),
        Block.box(1.0D, 15.0D, 1.0D, 15.0D, 16.0D, 15.0D)
      );
    
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
    
    private boolean isAligner(final Level level, final BlockPos pos, final Direction dir) {
        final Block block = level.getBlockState(pos.relative(dir)).getBlock();
        return block != null && block instanceof ValkgateAlignerBlock;
    }
    
    @Override
    public void neighborChanged(final BlockState state, final Level level, final BlockPos pos, final Block changedBlock, final BlockPos changedBlockPos, final boolean isMoving) {
        final BlockEntity blockEntity = level.getBlockEntity(pos);
        if (!(blockEntity instanceof final ValkgateControllerBE valkgateController)) {
            return;
        }
        
        final boolean validXPos = isAligner(level, pos, Direction.fromNormal(1, 0, 0));
        final boolean validXNeg = isAligner(level, pos, Direction.fromNormal(-1, 0, 0));
        final boolean validZPos = isAligner(level, pos, Direction.fromNormal(0, 0, 1));
        final boolean validZNeg = isAligner(level, pos, Direction.fromNormal(0, 0, -1));
        
        final int aligners = (validXPos ? 1 : 0) + (validXNeg ? 1 : 0)
                           + (validZPos ? 1 : 0) + (validZNeg ? 1 : 0);
        if (aligners != 1) {
            ValkyrienDrive.logger.info("valkgateController.markAssemblyInvalid();");
            valkgateController.markAssemblyInvalid();
        } else if (validXPos) {
            ValkyrienDrive.logger.info("valkgateController.markAssemblyValid(1, 0, 0);");
            valkgateController.markAssemblyValid(1, 0, 0);
        } else if (validXNeg) {
            ValkyrienDrive.logger.info("valkgateController.markAssemblyValid(-1, 0, 0);");
            valkgateController.markAssemblyValid(-1, 0, 0);
        } else if (validZPos) {
            ValkyrienDrive.logger.info("valkgateController.markAssemblyValid(0, 0, 1);");
            valkgateController.markAssemblyValid(0, 0, 1);
        } else if (validZNeg) {
            ValkyrienDrive.logger.info("valkgateController.markAssemblyValid(0, 0, -1);");
            valkgateController.markAssemblyValid(0, 0, -1);
        } else {
            assert false;
        }
    }
    
    @Override
    public RenderShape getRenderShape(final BlockState state) {
        return RenderShape.MODEL;
    }
    
    @Override
    public boolean useShapeForLightOcclusion(BlockState state) {
        return false;
    }
    
    
    @Override
    public boolean hasDynamicShape() {
        return true;
    }
    
    @Override
    public VoxelShape getOcclusionShape(BlockState state, BlockGetter level, BlockPos pos) {
        return AABB;
    }
    @Override
    public VoxelShape getShape(BlockState state, BlockGetter level, BlockPos pos,
                               CollisionContext ctx) {
        return AABB;
    }
    @Override
    public VoxelShape getCollisionShape(BlockState state, BlockGetter level, BlockPos pos,
                                        CollisionContext ctx) {
        return getShape(state, level, pos, ctx);
    }
    @Override
    public VoxelShape getVisualShape(BlockState state, BlockGetter level, BlockPos pos,
                                     CollisionContext ctx) {
        return getShape(state, level, pos, ctx);
    }
    @Override
    public boolean isPathfindable(BlockState state, BlockGetter level, BlockPos pos,
                                  PathComputationType pct) {
        return false;
    }
    
    @Override
    public boolean skipRendering(BlockState cur, BlockState other, Direction dir) {
        return false;
    }
    
    @Override
    public InteractionResult use(final BlockState state, final Level level, final BlockPos pos, final Player player, final InteractionHand hand, final BlockHitResult hit) {
        final BlockEntity blockEntity = level.getBlockEntity(pos);
        if (!(blockEntity instanceof final ValkgateControllerBE valkgateController)) {
            return super.use(state, level, pos, player, hand, hit);
        }
        
        ValkyrienDrive.logger.info("Clicked Valkgate Controller: {} {} {} {} is_client={}",
          valkgateController.valid, valkgateController.dx,
          valkgateController.dy,    valkgateController.dz, level.isClientSide());
        
        return InteractionResult.sidedSuccess(level.isClientSide());
    }
}

