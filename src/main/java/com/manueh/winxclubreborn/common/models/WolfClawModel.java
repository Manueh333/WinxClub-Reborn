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

public class WolfClawModel extends Model {
    public static final ResourceLocation TEXTURE = new ResourceLocation("textures/entity/wolf_claw.png");
   private final ModelPart root;

    public WolfClawModel(ModelPart part) {
        super(RenderType::entitySolid);
        this.root = part;
    }

    public static LayerDefinition createLayer() {
        MeshDefinition meshdefinition = new MeshDefinition();
        PartDefinition partdefinition = meshdefinition.getRoot();
        PartDefinition partdefinition1 = partdefinition.addOrReplaceChild("base", CubeListBuilder.create().texOffs(0, 0).addBox(-1.0F, -4.0F, -8.0F, 1.0F, 4.0F, 16.0F), PartPose.rotation(0, 0, 0));
        PartDefinition partdefinition2 = partdefinition1.addOrReplaceChild("claw_one", CubeListBuilder.create().texOffs(0, 24).addBox(-1.0F, -9.0F, -8.0F, 1.0F, 5.0F, 2.0F), PartPose.offset(0, 0, 0));
        PartDefinition partdefinition3 = partdefinition2.addOrReplaceChild("claw_two", CubeListBuilder.create().texOffs(10, 21).addBox(-1.0F, -12.0F, -3.0F, 1.0F, 8.0F, 2.0F), PartPose.offset(0, 0, 0));
        PartDefinition partdefinition4 = partdefinition3.addOrReplaceChild("claw_three", CubeListBuilder.create().texOffs(18, 22).addBox(-1.0F, -11.0F, 1.0F, 1.0F, 7.0F, 2.0F), PartPose.offset(0, 0, 0));
        PartDefinition partdefinition5 = partdefinition4.addOrReplaceChild("claw_four", CubeListBuilder.create().texOffs(26, 24).addBox(-1.0F, -9.0F, 6.0F, 1.0F, 5.0F, 2.0F), PartPose.offset(0, 0, 0));
        return LayerDefinition.create(meshdefinition, 32, 32) ;
    }

    @Override
    public void renderToBuffer(PoseStack p_103111_, VertexConsumer p_103112_, int p_103113_, int p_103114_, float p_103115_, float p_103116_, float p_103117_, float p_103118_) {
        this.root.render(p_103111_, p_103112_, p_103113_, p_103114_, p_103115_, p_103116_, p_103117_, p_103118_);
    }
}
