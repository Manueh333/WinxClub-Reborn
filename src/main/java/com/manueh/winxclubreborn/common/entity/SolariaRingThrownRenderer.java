package com.manueh.winxclubreborn.common.entity;

import com.manueh.winxclubreborn.Client.ClientRenderer;
import com.manueh.winxclubreborn.Main;
import com.manueh.winxclubreborn.common.models.SolariaRingModel;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.math.Vector3f;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.ItemRenderer;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;

public class SolariaRingThrownRenderer extends EntityRenderer<SolariaRingThrown> {
    public static final ResourceLocation TEXTURE = new ResourceLocation(Main.MODID, "textures/entity/solaria_ring.png");
    private SolariaRingModel model;

    public SolariaRingThrownRenderer(EntityRendererProvider.Context context) {
        super(context);
        this.model = new SolariaRingModel(context.bakeLayer(ClientRenderer.SOLARIA_RING_LAYER));
    }

    public void render(SolariaRingThrown p_116111_, float p_116112_, float p_116113_, PoseStack p_116114_, MultiBufferSource p_116115_, int p_116116_) {
        p_116114_.pushPose();
        p_116114_.mulPose(Vector3f.YP.rotationDegrees(Mth.lerp(p_116113_, p_116111_.yRotO, p_116111_.getYRot()) - 90.0F));
        p_116114_.mulPose(Vector3f.ZP.rotationDegrees(Mth.lerp(p_116113_, p_116111_.xRotO, p_116111_.getXRot()) + 90.0F));
        VertexConsumer vertexconsumer = ItemRenderer.getFoilBufferDirect(p_116115_, this.model.renderType(this.getTextureLocation(p_116111_)), false, false);
        this.model.renderToBuffer(p_116114_, vertexconsumer, p_116116_, OverlayTexture.NO_OVERLAY, 1.0F, 1.0F, 1.0F, 1.0F);
        p_116114_.popPose();
        super.render(p_116111_, p_116112_, p_116113_, p_116114_, p_116115_, p_116116_);
    }

    @Override
    public ResourceLocation getTextureLocation(SolariaRingThrown p_114482_) {
        return TEXTURE;
    }
}
