package com.manueh.winxclubreborn.common.models;

import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;

public class WingsModel {

    public static ModelPart createModel() {
        MeshDefinition meshdefinition = new MeshDefinition();
        PartDefinition partdefinition = meshdefinition.getRoot();
        CubeDeformation cubedeformation = new CubeDeformation(0.0F);
        partdefinition.addOrReplaceChild("head", CubeListBuilder.create(), PartPose.ZERO);
        partdefinition.addOrReplaceChild("hat", CubeListBuilder.create(), PartPose.ZERO);
        PartDefinition partDefinition1 = partdefinition.addOrReplaceChild("body", CubeListBuilder.create(), PartPose.ZERO);
        partDefinition1.addOrReplaceChild("left_wing", CubeListBuilder.create().texOffs(2, 0).addBox(-8.0F, -6.0F, 0.0F, 8.0F, 12.0F, 0.0F, cubedeformation), PartPose.offsetAndRotation(0.0F, 6.0F, 2.0F, 0.0F, 2.3562F, 0.0F));
        partDefinition1.addOrReplaceChild("right_wing", CubeListBuilder.create().texOffs(2, 12).addBox(-8.0F, -6.0F, 0.0F, 8.0F, 12.0F, 0.0F, cubedeformation), PartPose.offsetAndRotation(0.0F, 6.0F, 2.0F, 0.0F, 0.7854F, 0.0F));
        partdefinition.addOrReplaceChild("right_arm", CubeListBuilder.create(), PartPose.ZERO);
        partdefinition.addOrReplaceChild("left_arm", CubeListBuilder.create(), PartPose.ZERO);
        partdefinition.addOrReplaceChild("right_leg", CubeListBuilder.create(), PartPose.ZERO);
        partdefinition.addOrReplaceChild("left_leg", CubeListBuilder.create(), PartPose.ZERO);
        return LayerDefinition.create(meshdefinition, 32, 32).bakeRoot();
    }

}
