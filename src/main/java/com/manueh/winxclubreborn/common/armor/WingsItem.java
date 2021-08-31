package com.manueh.winxclubreborn.common.armor;

import com.manueh.winxclubreborn.common.tiers.MagicArmorTier;
import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;
import net.minecraft.block.DispenserBlock;
import net.minecraft.client.renderer.entity.model.BipedModel;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;


public class WingsItem extends ArmorItem {

    public WingsItem(Item.Properties p_41383_) {
        super(MagicArmorTier.MAGIC, EquipmentSlotType.CHEST, p_41383_);
        DispenserBlock.registerBehavior(this, ArmorItem.DISPENSE_ITEM_BEHAVIOR);
    }
    @Override
    @OnlyIn(Dist.CLIENT)
    public BipedModel getArmorModel(LivingEntity living, ItemStack stack, EquipmentSlotType slot, BipedModel defaultModel) {
        BipedModel armorModel = new BipedModel(1);
        armorModel.body = new Wings().Wings;
        armorModel.leftArm = new Wings().Wings;
        armorModel.rightArm = new Wings().Wings;
        return armorModel;
    }

    @Override
    public String getArmorTexture(ItemStack stack, Entity entity, EquipmentSlotType slot, String type) {
        return "winxclubreborn:textures/models/armor/wings_layer_" + (slot == EquipmentSlotType.LEGS ? "2" : "1") + ".png";
    }

    public class Wings extends EntityModel<Entity> {
        private final ModelRenderer Wings;
        private final ModelRenderer rightWing_r1;
        private final ModelRenderer leftWing_r1;

        public Wings() {
            texWidth = 32;
            texHeight = 32;

            Wings = new ModelRenderer(this);

            rightWing_r1 = new ModelRenderer(this);
            rightWing_r1.x = 0;
            rightWing_r1.y = 6;
            rightWing_r1.z = 2;

            Wings.addChild(rightWing_r1);
            setRotationAngle(rightWing_r1, 0.0F, 0.7854F, 0.0F);
            rightWing_r1.texOffs(2, 12).addBox(-8.0F, -6.0F, 0.0F, 8.0F, 12.0F, 0.0F, 0.0F, false);

            leftWing_r1 = new ModelRenderer(this);
            leftWing_r1.x = 0;
            leftWing_r1.y = 6;
            leftWing_r1.z = 2;
            Wings.addChild(leftWing_r1);
            setRotationAngle(leftWing_r1, 0.0F, 2.3562F, 0.0F);
            leftWing_r1.texOffs(2, 0).addBox(-8.0F, -6.0F, 0.0F, 8.0F, 12.0F, 0.0F, 0.0F, false);
        }

        @Override
        public void setupAnim(Entity p_225597_1_, float p_225597_2_, float p_225597_3_, float p_225597_4_, float p_225597_5_, float p_225597_6_) {

        }



        public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
            modelRenderer.xRot = x;
            modelRenderer.yRot = y;
            modelRenderer.zRot = z;
        }

        @Override
        public void renderToBuffer(MatrixStack p_225598_1_, IVertexBuilder p_225598_2_, int p_225598_3_, int p_225598_4_, float p_225598_5_, float p_225598_6_, float p_225598_7_, float p_225598_8_) {
            Wings.render(p_225598_1_, p_225598_2_, p_225598_3_, p_225598_4_);
        }
    }
}
