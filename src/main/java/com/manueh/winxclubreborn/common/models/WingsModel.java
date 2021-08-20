package com.manueh.winxclubreborn.common.models;

import com.google.common.collect.ImmutableList;
import net.minecraft.client.model.AgeableListModel;
import net.minecraft.client.model.PlayerModel;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.PlayerModelPart;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.ItemStack;

public class WingsModel<T extends LivingEntity> extends AgeableListModel<T> {
    private final ModelPart rightWing;
    private final ModelPart leftWing;

    public WingsModel(ModelPart p_170538_) {
        this.leftWing = p_170538_.getChild("left_wing");
        this.rightWing = p_170538_.getChild("right_wing");
    }

    public static LayerDefinition createLayer() {
        MeshDefinition meshdefinition = new MeshDefinition();
        PartDefinition partdefinition = meshdefinition.getRoot();
        CubeDeformation cubedeformation = new CubeDeformation(1.0F);
        partdefinition.addOrReplaceChild("left_wing", CubeListBuilder.create().texOffs(22, 0).addBox(-12.0F, -25.0F, 1.0F, 10.0F, 12.0F, 0.0F, cubedeformation), PartPose.offsetAndRotation(0.0F, 2.3562F, 0.0F, 0, 0.0F, -0));
        partdefinition.addOrReplaceChild("right_wing", CubeListBuilder.create().texOffs(22, 0).mirror().addBox(-12.0F, -25.0F, -1.0F, 10.0F, 12.0F, 0.0F, cubedeformation), PartPose.offsetAndRotation(0.0F, 0.6109F, 0.0F, 0, 0.0F, 0));
        return LayerDefinition.create(meshdefinition, 64, 32);
    }

    protected Iterable<ModelPart> headParts() {
        return ImmutableList.of();
    }

    protected Iterable<ModelPart> bodyParts() {
        return ImmutableList.of(this.leftWing, this.rightWing);
    }

    @Override
    public void setupAnim(T p_102618_, float p_102619_, float p_102620_, float p_102621_, float p_102622_, float p_102623_) {

    }
}
