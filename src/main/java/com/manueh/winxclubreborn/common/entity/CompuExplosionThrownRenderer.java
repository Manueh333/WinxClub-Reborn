package com.manueh.winxclubreborn.common.entity;

import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class CompuExplosionThrownRenderer extends EntityRenderer<CompuExplosionThrown> {
    public static final ResourceLocation COMPU_EXPLOSION_TEXTURE = new ResourceLocation("textures/entity/compu_explosion.png");

    protected CompuExplosionThrownRenderer(EntityRendererProvider.Context p_174008_) {
        super(p_174008_);
    }

    @Override
    public ResourceLocation getTextureLocation(CompuExplosionThrown p_114482_) {
        return COMPU_EXPLOSION_TEXTURE;
    }
}
