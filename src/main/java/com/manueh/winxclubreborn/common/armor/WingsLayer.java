package com.manueh.winxclubreborn.common.armor;

import com.manueh.winxclubreborn.Client.ClientRenderer;
import com.manueh.winxclubreborn.Main;
import com.manueh.winxclubreborn.common.models.WingsModel;
import com.manueh.winxclubreborn.core.init.Registration;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.geom.EntityModelSet;
import net.minecraft.client.player.AbstractClientPlayer;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.ItemRenderer;
import net.minecraft.client.renderer.entity.RenderLayerParent;
import net.minecraft.client.renderer.entity.layers.RenderLayer;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.PlayerModelPart;
import net.minecraft.world.item.ItemStack;


public class WingsLayer<T extends LivingEntity, M extends EntityModel<T>> extends RenderLayer<T, M> {
    private static ResourceLocation WINGS_LOCATION = new ResourceLocation(Main.MODID, "textures/entity/wings.png");
    private final WingsModel<T> wingModel;

    public WingsLayer(RenderLayerParent<T, M> p_174493_, EntityModelSet p_174494_) {
        super(p_174493_);
        this.wingModel = new WingsModel(p_174494_.bakeLayer(ClientRenderer.WINGS_LAYER));

    }

    public void render(PoseStack p_116951_, MultiBufferSource p_116952_, int p_116953_, T p_116954_, float p_116955_, float p_116956_, float p_116957_, float p_116958_, float p_116959_, float p_116960_) {
        ItemStack itemstack = p_116954_.getItemBySlot(EquipmentSlot.CHEST);
        if (shouldRender(itemstack, p_116954_)) {
            ResourceLocation resourcelocation;
            if (p_116954_ instanceof AbstractClientPlayer) {
                AbstractClientPlayer abstractclientplayer = (AbstractClientPlayer)p_116954_;
                if (abstractclientplayer.isElytraLoaded() && abstractclientplayer.getElytraTextureLocation() != null) {
                    resourcelocation = abstractclientplayer.getElytraTextureLocation();
                } else if (abstractclientplayer.isCapeLoaded() && abstractclientplayer.getCloakTextureLocation() != null && abstractclientplayer.isModelPartShown(PlayerModelPart.CAPE)) {
                    resourcelocation = abstractclientplayer.getCloakTextureLocation();
                } else {
                    resourcelocation = getWingsTexture(itemstack, p_116954_);
                }
            } else {
                resourcelocation = getWingsTexture(itemstack, p_116954_);
            }

            p_116951_.pushPose();
            p_116951_.translate(0.0D, 0.0D, 0.125D);
            this.getParentModel().copyPropertiesTo(this.wingModel);
            this.wingModel.setupAnim(p_116954_, p_116955_, p_116956_, p_116958_, p_116959_, p_116960_);
            VertexConsumer vertexconsumer = ItemRenderer.getArmorFoilBuffer(p_116952_, RenderType.armorCutoutNoCull(resourcelocation), false, itemstack.hasFoil());
            this.wingModel.renderToBuffer(p_116951_, vertexconsumer, p_116953_, OverlayTexture.NO_OVERLAY, 1.0F, 1.0F, 1.0F, 1.0F);
            p_116951_.popPose();
        }
    }



    public boolean shouldRender(ItemStack stack, T entity) {
        return stack.getItem() == Registration.WINGS.get();
    }


    public ResourceLocation getWingsTexture(ItemStack stack, T entity) {
        return WINGS_LOCATION;
    }
}
