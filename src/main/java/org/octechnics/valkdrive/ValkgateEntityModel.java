package org.octechnics.valkdrive;

import net.minecraft.client.model.geom.builders.CubeListBuilder;
import net.minecraft.client.model.geom.builders.LayerDefinition;
import net.minecraft.client.model.geom.builders.MeshDefinition;
import net.minecraft.client.model.geom.builders.PartDefinition;
import net.minecraft.client.model.HierarchicalModel;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraft.world.entity.Entity;
import net.minecraft.util.Mth;

// use org.octechnics.valkdrive.ValkgateEntity;

@OnlyIn(Dist.CLIENT)
public class ValkgateEntityModel<T extends ValkgateEntity> extends HierarchicalModel<T> {
    private final ModelPart root;
     
    public ValkgateEntityModel(ModelPart _root) {
        this.root = _root;
    }
    
    public static LayerDefinition createBodyLayer() {
        MeshDefinition mesh_type = new MeshDefinition();
        PartDefinition root_type = mesh_type.getRoot();
        
        root_type.addOrReplaceChild("bottom",
          CubeListBuilder.create().texOffs(0, 0).addBox(0.0F, 0.0F, 0.0F, 48.0F, 16.0F, 16.0F),
          PartPose.offset(16.0F, 0.0F, 0.0F));
        root_type.addOrReplaceChild("middle",
          CubeListBuilder.create().texOffs(0, 0).addBox(0.0F, 0.0F, 0.0F, 80.0F, 16.0F, 16.0F),
          PartPose.offset(0.0F, 16.0F, 0.0F));
        root_type.addOrReplaceChild("top",
          CubeListBuilder.create().texOffs(0, 0).addBox(0.0F, 0.0F, 0.0F, 48.0F, 16.0F, 16.0F),
          PartPose.offset(16.0F, 32.0F, 0.0F));
        
        return LayerDefinition.create(mesh_type, 64, 32);
    }
    
    public ModelPart root() {
        return this.root;
    }
    
    public void setupAnim(T _v_0,float _v_1,float _v_2,float _v_3,float _v_4,float _v_5) {
        // TODO: further research is needed what does this method do
    }
}