package org.octechnics.valkdrive;

import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.model.geom.ModelLayers;
import net.minecraft.client.renderer.RenderType;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;
import com.mojang.blaze3d.vertex.PoseStack;

// use org.octechnics.valkdrive.ValkgateEntityModel;
// use org.octechnics.valkdrive.ValkgateEntity;
// use org.octechnics.valkdrive.ValkyrienDrive;

@OnlyIn(Dist.CLIENT)
public class ValkgateRenderer<T extends ValkgateEntity> extends EntityRenderer<T> {
    private static final ResourceLocation TEX_LOCATION = new ResourceLocation(ValkyrienDrive.MOD_ID, "textures/blocks/dhd_top.png");
    private final ValkgateEntityModel model = new ValkgateEntityModel();
    
    public ValkgateRenderer(EntityRendererProvider.Context ctx) {
        super(ctx);
    }
    
    public ResourceLocation getTextureLocation(T entity) {
        return TEX_LOCATION;
    }
    
    protected void scale(T entity, PoseStack poses, float v) {
        // intentionally blank
    }
    
    @Override
    public void render(T entity, float yaw, float partialTicks,
                       PoseStack matrixStack, MultiBufferSource buffers,
	                   int packedLight) {
        matrixStack.pushPose();
        ResourceLocation rl = this.getTextureLocation(entity);
        VertexConsumer buffer = buffers.getBuffer(this.model.renderType(rl));
        this.model.renderToBuffer(matrixStack, buffer, packedLight, 0, 1.0F, 1.0F, 1.0F, 1.0F);
        matrixStack.popPose();
    }
}
