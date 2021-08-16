package com.manueh.winxclubreborn.common.entity;

import com.google.common.collect.Sets;
import com.manueh.winxclubreborn.common.models.CompuExplosionModel;
import net.minecraft.client.model.TridentModel;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.ModelLayers;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.vehicle.Boat;
import net.minecraft.world.level.block.state.properties.WoodType;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

import java.util.Set;
import java.util.stream.Stream;

public class CompuExplosionThrownRenderer extends EntityRenderer<CompuExplosionThrown> {
    public static final ResourceLocation COMPU_EXPLOSION_TEXTURE = new ResourceLocation("textures/entity/compu_explosion.png");
    private CompuExplosionModel model;

    public CompuExplosionThrownRenderer(EntityRendererProvider.Context context) {
        super(context);
        this.model = new CompuExplosionModel(context.bakeLayer());
    }

    @Override
    public ResourceLocation getTextureLocation(CompuExplosionThrown p_114482_) {
        return COMPU_EXPLOSION_TEXTURE;
    }
}
