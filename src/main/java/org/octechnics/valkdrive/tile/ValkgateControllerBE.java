package org.octechnics.valkdrive.tile;

import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.Level;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.core.BlockPos;

import org.octechnics.valkdrive.BlocksItemsRegistryHelper;
import org.octechnics.valkdrive.ValkyrienDrive;
import org.octechnics.valkdrive.ValkgateEntity;

public class ValkgateControllerBE extends BlockEntity {
    public boolean valid = false;
    public int     dx    = 0xC0;
    public int     dy    = 0xFF;
    public int     dz    = 0xEE;
    
    private ValkgateEntity entity = null;
    
    public ValkgateControllerBE(final BlockPos pos, final BlockState state) {
        super(ValkyrienDrive.registry_blocks.VALKGATE_CONTR_TILE.get(), pos, state);
    }
    
    @Override
    public void setLevel(Level level) throws IllegalStateException {
        super.setLevel(level);
        
        if (level != null && !level.isClientSide()) {
            if (entity != null) {
                entity.discard();
                entity = null;
            }
            
            final ServerLevel world = (ServerLevel)level;
            if (world == null) {assert false;}
            
            entity = new ValkgateEntity(BlocksItemsRegistryHelper.VALKGATE_ENTITY.get(), world);
            entity.moveTo(this.getBlockPos().getX(), this.getBlockPos().getY(), this.getBlockPos().getZ(), 0, 0);
            if (!world.tryAddFreshEntityWithPassengers(entity)) {
                throw new IllegalStateException("Failed to create entity bound to block entity");
            }
        }
    }
    
    private boolean validateDelta(int adx, int ady, int adz) {
        if (adx == 1 && ady == 0 && adz == 0) {return true;}
        if (adx == -1 && ady == 0 && adz == 0) {return true;}
        if (adx == 0 && ady == 0 && adz == 1) {return true;}
        if (adx == 0 && ady == 0 && adz == -1) {return true;}
        return false;
    }
    
    public void markAssemblyInvalid() {
        valid = false;
        dx = 0xC0; dy = 0xFF; dz = 0xEE;
    }
    
    public void markAssemblyValid(int adx, int ady, int adz) {
        if (!validateDelta(adx, ady, adz)) {
            markAssemblyInvalid();
            return;
        }
        valid = true; dx = adx; dy = ady; dz = adz;
    }
    
    @Override
    public void load(CompoundTag nbt) {
        boolean _valid = nbt.getBoolean("valid_assembly");
        if (!_valid) {
            markAssemblyInvalid();
        } else {
            int adx = nbt.getInt("dx_assembly");
            int ady = nbt.getInt("dy_assembly");
            int adz = nbt.getInt("dz_assembly");
            markAssemblyValid(adx, ady, adz);
        }
        
        super.load(nbt);
    }
    
    @Override
    public void saveAdditional(CompoundTag nbt) {
        super.saveAdditional(nbt);
        
        if (valid) {
            nbt.putBoolean("valid_assembly", true);
            nbt.putInt("dx_assembly", dx);
            nbt.putInt("dy_assembly", dy);
            nbt.putInt("dz_assembly", dz);
        } else {
            nbt.putBoolean("valid_assembly", false);
        }
    }
}
