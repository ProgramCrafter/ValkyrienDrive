package org.octechnics.valkdrive;

import net.minecraft.client.color.block.BlockColors;
import net.minecraft.client.model.geom.ModelPart;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraft.client.model.EntityModel;
import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.world.entity.Entity;
import net.minecraft.util.Mth;

import java.util.ArrayList;
import java.util.HashMap;

// use org.octechnics.valkdrive.ValkgateEntity;

@OnlyIn(Dist.CLIENT)
public class ValkgateEntityModel<T extends ValkgateEntity> extends EntityModel<T> {
    private final ModelPart model;
     
    public ValkgateEntityModel() {
        super();
    	
        // Cube(             int startU,    int startV,
        //    float minX,    float minY,    float minZ,    float dx, float dy, float dz,   float outsetX, float outsetY, float outsetZ,
        //    boolean invX,  float scaleU,  float scaleV)
        
        ArrayList<ModelPart.Cube> cubes = new ArrayList<>();
        
    	cubes.add(
          new ModelPart.Cube(0, 0,
              16.0F,0.0F,0.0F,   48.0F,16.0F,16.0F,   0.0F,0.0F,0.0F,
              false, 1.0F, 1.0F)
        );
    	cubes.add(
          new ModelPart.Cube(0, 0,
              0.0F,16.0F,0.0F,   80.0F,16.0F,16.0F,   0.0F,0.0F,0.0F,
              false, 1.0F, 1.0F)
        );
    	cubes.add(
          new ModelPart.Cube(0, 0,
              16.0F,32.0F,0.0F,  48.0F,16.0F,16.0F,   0.0F,0.0F,0.0F,
              false, 1.0F, 1.0F)
        );
    	
        model = new ModelPart(cubes, new HashMap());
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
	    model.render(matrixStack, buffer, packedLight, packedOverlay);
	}
}
