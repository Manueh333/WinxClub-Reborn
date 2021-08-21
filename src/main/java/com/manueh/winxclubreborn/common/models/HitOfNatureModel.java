package com.manueh.winxclubreborn.common.models;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.model.Model;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.CubeListBuilder;
import net.minecraft.client.model.geom.builders.LayerDefinition;
import net.minecraft.client.model.geom.builders.MeshDefinition;
import net.minecraft.client.model.geom.builders.PartDefinition;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.resources.ResourceLocation;

public class HitOfNatureModel extends Model {
    public static final ResourceLocation TEXTURE = new ResourceLocation("textures/entity/hit_of_nature.png");
    private final ModelPart root;

    public HitOfNatureModel(ModelPart part) {
        super(RenderType::entitySolid);
        this.root = part;
    }



    public static LayerDefinition createLayer() {
        MeshDefinition meshdefinition = new MeshDefinition();
        PartDefinition partdefinition = meshdefinition.getRoot();
        PartDefinition partdefinition1 = partdefinition.addOrReplaceChild("log", CubeListBuilder.create().texOffs(0, 12).addBox(-2.0F, -8.0F, -1.0F, 3.0F, 8.0F, 3.0F), PartPose.offsetAndRotation(0,0,0,0,24F,0));
        PartDefinition partdefinition2 = partdefinition1.addOrReplaceChild("leaves", CubeListBuilder.create().texOffs(0, 0).addBox(-4.0F, -12.0F, -3.0F, 7.0F, 5.0F, 7.0F), PartPose.offsetAndRotation(0,0,0,0,24f,0));
        return LayerDefinition.create(meshdefinition, 32, 32);
    }

    @Override
    public void renderToBuffer(PoseStack p_103111_, VertexConsumer p_103112_, int p_103113_, int p_103114_, float p_103115_, float p_103116_, float p_103117_, float p_103118_) {
        this.root.render(p_103111_, p_103112_, p_103113_, p_103114_, p_103115_, p_103116_, p_103117_, p_103118_);
    }
}
