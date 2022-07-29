package org.octechnics.valkdrive;

import net.minecraft.network.protocol.game.ClientboundAddEntityPacket;
import net.minecraft.world.entity.decoration.HangingEntity;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.EntityDimensions;
import net.minecraft.network.protocol.Packet;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MoverType;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.Pose;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.Vec3;
import net.minecraft.core.Direction;

import javax.annotation.Nullable;

public class ValkgateEntity extends HangingEntity {
    protected Direction direction = Direction.SOUTH;
    
    public ValkgateEntity(EntityType<? extends ValkgateEntity> entity_type, Level level) {
        super(entity_type, level);
        
        this.recalculateBoundingBox();
    }
    
    @Override
    protected float getEyeHeight(Pose pose, EntityDimensions dimensions) {
        // eye for valkgate has no meaning
        return 0.0F;
    }
    
    @Override
    protected void defineSynchedData() {
        // entity is bound to valkgate == created and destroyed manually
        // no need to synchronize anything (?)
        // maybe, coords synchronization will be needed later for rendering
    }
    
    @Override
    public boolean survives() {
        // TODO: further research is needed what does this method do
        return true;
    }
    
    @Override
    public void move(MoverType mover, Vec3 delta) {
        // valkgate cannot be moved except with the ship
    }
    
    @Override
    public void push(double dx, double dy, double dz) {
        // valkgate cannot be moved except with the ship
    }
    
    @Override
    public float getPickRadius() {
        // valkgate is not an item :-) it cannot be picked
        return 0.0F;
    }
    
    @Override
    public boolean hurt(DamageSource damage, float value) {
        return damage != DamageSource.OUT_OF_WORLD && !damage.isCreativePlayer() ? false : super.hurt(damage, value);
    }
    
    @Override
    public int getWidth() {
        return 80;
    }
    
    @Override
    public int getHeight() {
        return 64;
    }
    
    @Override
    public void playPlacementSound() {}
    
    @Override
    public void dropItem(@Nullable Entity entity) {}
    
    @Override
    public Packet<?> getAddEntityPacket() {
        return new ClientboundAddEntityPacket(this, this.getType(), this.direction.get3DDataValue(), this.getPos());
    }
}
