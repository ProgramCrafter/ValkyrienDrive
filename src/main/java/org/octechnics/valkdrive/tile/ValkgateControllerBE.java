package org.octechnics.valkdrive.tile;

import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.Block;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.core.BlockPos;

import org.octechnics.valkdrive.ValkyrienDrive;

public class ValkgateControllerBE extends BlockEntity {
    public boolean valid = false;
    public int     dx    = 0xC0;
    public int     dy    = 0xFF;
    public int     dz    = 0xEE;
    
    public ValkgateControllerBE(final BlockPos pos, final BlockState state) {
        super(ValkyrienDrive.registry_blocks.VALKGATE_CONTR_TILE.get(), pos, state);
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
    
    /*
    @Override
    public SUpdateBlockEntityPacket getUpdatePacket() {
        return new UpdatePacket(write(new CompoundTag()));
    }
    @Override
    public void onDataPacket(NetworkManager net, SUpdateBlockEntityPacket pkt) {
        read((UpdatePacket)pkt.nbt);
    }

    static class UpdatePacket extends SUpdateBlockEntityPacket {
        public CompoundTag nbt;

        public UpdatePacket(CompoundTag _nbt) {
            nbt = _nbt;
        }

        @Override
        public void readPacketData(PacketBuffer buffer) throws IOException {
            buffer.writeNBT(nbt);
            super.readPacketData(buffer);
        }

        @Override
        public void writePacketData(PacketBuffer buffer) throws IOException {
            nbt = buffer.readNBT();
            super.writePacketData(buffer);
        }
    }
    */
}
