package org.octechnics.valkdrive;

import net.minecraft.client.model.geom.ModelPart.Polygon; // AccessTransformed
import net.minecraft.client.model.geom.ModelPart.Vertex;
import net.minecraft.client.color.block.BlockColors;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraft.client.model.EntityModel;
import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.world.entity.Entity;
import net.minecraft.core.Direction;
import com.mojang.math.Matrix3f;
import com.mojang.math.Matrix4f;
import com.mojang.math.Vector3f;
import com.mojang.math.Vector4f;
import net.minecraft.util.Mth;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// use org.octechnics.valkdrive.ValkgateEntity;

@OnlyIn(Dist.CLIENT)
public class ValkgateEntityModel<T extends ValkgateEntity> extends EntityModel<T> {
    private final Polygon[] quads;
    
    public ValkgateEntityModel() {
        super();
        
        Vertex back_cent  = new Vertex(40.0F,24.0F,0.0F,   40.0F,24.0F);
        Vertex back_top_l = new Vertex(30.0F,48.0F,0.0F,   30.0F,48.0F);
        Vertex back_lft_t = new Vertex(16.0F,34.0F,0.0F,   16.0F,34.0F);
        Vertex back_lft_b = new Vertex(16.0F,14.0F,0.0F,   16.0F,14.0F);
        Vertex back_bot_l = new Vertex(30.0F,0.0F, 0.0F,   30.0F,0.0F);
        Vertex back_bot_r = new Vertex(50.0F,0.0F, 0.0F,   50.0F,0.0F);
        Vertex back_rgt_b = new Vertex(64.0F,14.0F,0.0F,   64.0F,14.0F);
        Vertex back_rgt_t = new Vertex(64.0F,34.0F,0.0F,   64.0F,34.0F);
        Vertex back_top_r = new Vertex(50.0F,48.0F,0.0F,   50.0F,48.0F);
        
        Vertex back_sm_cent  = new Vertex(40.0F,24.0F,2.0F,   40.0F,24.0F);
        Vertex back_sm_top_l = new Vertex(31.0F,46.0F,2.0F,   31.0F,46.0F);
        Vertex back_sm_lft_t = new Vertex(18.0F,33.0F,2.0F,   18.0F,33.0F);
        Vertex back_sm_lft_b = new Vertex(18.0F,15.0F,2.0F,   18.0F,15.0F);
        Vertex back_sm_bot_l = new Vertex(31.0F,2.0F, 2.0F,   31.0F,2.0F);
        Vertex back_sm_bot_r = new Vertex(49.0F,2.0F, 2.0F,   49.0F,2.0F);
        Vertex back_sm_rgt_b = new Vertex(62.0F,15.0F,2.0F,   62.0F,15.0F);
        Vertex back_sm_rgt_t = new Vertex(62.0F,33.0F,2.0F,   62.0F,33.0F);
        Vertex back_sm_top_r = new Vertex(49.0F,46.0F,2.0F,   49.0F,46.0F);
        
        quads = new Polygon[] {
            new Polygon(
              new Vertex[]{back_cent,back_top_l,back_lft_t,back_lft_b},
              8.0F,8.0F,16.0F,16.0F,16.0F,16.0F,
              false, Direction.NORTH
            ),
            new Polygon(
              new Vertex[]{back_cent,back_lft_b,back_bot_l,back_bot_r},
              8.0F,0.0F,16.0F,8.0F,16.0F,16.0F,
              false, Direction.NORTH
            ),
            new Polygon(
              new Vertex[]{back_cent,back_bot_r,back_rgt_b,back_rgt_t},
              0.0F,8.0F,8.0F,16.0F,16.0F,16.0F,
              false, Direction.NORTH
            ),
            new Polygon(
              new Vertex[]{back_cent,back_rgt_t,back_top_r,back_top_l},
              0.0F,0.0F,8.0F,8.0F,16.0F,16.0F,
              false, Direction.NORTH
            ),
            new Polygon(
              new Vertex[]{back_sm_cent,back_sm_top_l,back_sm_lft_t,back_sm_lft_b},
              0.0F,0.0F,8.0F,8.0F,16.0F,16.0F,
              false, Direction.SOUTH
            ),
            new Polygon(
              new Vertex[]{back_sm_cent,back_sm_lft_b,back_sm_bot_l,back_sm_bot_r},
              0.0F,8.0F,8.0F,16.0F,16.0F,16.0F,
              false, Direction.SOUTH
            ),
            new Polygon(
              new Vertex[]{back_sm_cent,back_sm_bot_r,back_sm_rgt_b,back_sm_rgt_t},
              8.0F,0.0F,16.0F,8.0F,16.0F,16.0F,
              false, Direction.SOUTH
            ),
            new Polygon(
              new Vertex[]{back_sm_cent,back_sm_rgt_t,back_sm_top_r,back_sm_top_l},
              8.0F,8.0F,16.0F,16.0F,16.0F,16.0F,
              false, Direction.SOUTH
            )
        };
    }
    
    private void compileQuads(
            PoseStack.Pose pose, VertexConsumer buffer,
            int packedLight, int packedOverlay,
            float r, float g, float b, float a) {
        Matrix4f mtx_pose = pose.pose();
        Matrix3f mtx_norm = pose.normal();
        
        for (Polygon quad : quads) {
            Vector3f norm = quad.normal.copy();
            norm.transform(mtx_norm);
            
            float normMaxX = norm.x();
            float normMaxY = norm.y();
            float normMaxZ = norm.z();
            
            for (Vertex vert : quad.vertices) {
                float vx = vert.pos.x() / 16.0F;
                float vy = vert.pos.y() / 16.0F;
                float vz = vert.pos.z() / 16.0F;
                
                Vector4f pos = new Vector4f(vx, vy, vz, 1.0F);
                pos.transform(mtx_pose);
                buffer.vertex(pos.x(), pos.y(), pos.z(),
                              r, g, b, a, vert.u, vert.v,
                              packedOverlay, packedLight,
                              normMaxX, normMaxY, normMaxZ);
            }
        }
    }
    
    @Override
    public void setupAnim(
            T entity,         float limbSwing,  float limbSwingAmount,
            float ageInTicks, float netHeadYaw, float headPitch) {
        // intentionally blank
    }
    
    @Override
	public void renderToBuffer(
	        PoseStack matrixStack, VertexConsumer buffer,
	        int packedLight, int packedOverlay,
	        float r, float g, float b, float a) {
        matrixStack.pushPose();
        // translateAndRotate(matrixStack);
        compileQuads(matrixStack.last(), buffer, packedLight, packedOverlay, r, g, b, a);
        matrixStack.popPose();
	}
}
