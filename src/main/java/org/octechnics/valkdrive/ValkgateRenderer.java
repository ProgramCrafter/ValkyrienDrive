package org.octechnics.valkdrive;

import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.model.geom.ModelLayers;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;
import com.mojang.blaze3d.vertex.PoseStack;

// use org.octechnics.valkdrive.ValkgateEntityModel;
// use org.octechnics.valkdrive.ValkgateEntity;

@OnlyIn(Dist.CLIENT)
public class ValkgateRenderer<T extends ValkgateEntity> extends EntityRenderer<T> {
   private static final ResourceLocation TEX_LOCATION = new ResourceLocation("textures/blocks/dhd_top.png");

   public ValkgateRenderer(EntityRendererProvider.Context ctx) {
      super(ctx);
   }

   public ResourceLocation getTextureLocation(T entity) {
      return TEX_LOCATION;
   }

   protected void scale(T entity, PoseStack poses, float v) {
      float f = 1.0F;
      float f1 = 4.5F;
      float f2 = 4.5F;
      poses.scale(4.5F, 4.5F, 4.5F);
   }
}