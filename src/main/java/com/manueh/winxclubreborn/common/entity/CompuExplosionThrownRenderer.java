package com.manueh.winxclubreborn.common.entity;

import com.google.common.collect.Sets;
import com.manueh.winxclubreborn.Main;
import com.manueh.winxclubreborn.common.models.CompuExplosionModel;
import net.minecraft.client.model.TridentModel;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.ModelLayers;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.builders.CubeListBuilder;
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
    public static final ResourceLocation COMPU_EXPLOSION_TEXTURE = new ResourceLocation(Main.MODID, "textures/entity/compu_explosion.png");
    private CompuExplosionModel model;
public static class ModelLayers {
    private static final String DEFAULT_LAYER = "main";
    private static final Set<ModelLayerLocation> ALL_MODELS = Sets.newHashSet();
    public static final ModelLayerLocation COMPU_EXPLOSION = register("item/compu_explosion_air.json");

    private static ModelLayerLocation register(String p_171294_) {
        return register(p_171294_, "layer0");
    }

    private static ModelLayerLocation register(String p_171296_, String p_171297_) {
        ModelLayerLocation modellayerlocation = createLocation(p_171296_, p_171297_);
        if (!ALL_MODELS.add(modellayerlocation)) {
            throw new IllegalStateException("Duplicate registration for " + modellayerlocation);
        } else {
            return modellayerlocation;
        }
    }

    private static ModelLayerLocation createLocation(String p_171301_, String p_171302_) {
        return new ModelLayerLocation(new ResourceLocation("winxclubreborn", p_171301_), p_171302_);
    }

    private static ModelLayerLocation registerInnerArmor(String p_171299_) {
        return register(p_171299_, "inner_armor");
    }

    private static ModelLayerLocation registerOuterArmor(String p_171304_) {
        return register(p_171304_, "outer_armor");
    }

    public static ModelLayerLocation createBoatModelName(Boat.Type p_171290_) {
        return createLocation("boat/" + p_171290_.getName(), "main");
    }

    public static ModelLayerLocation createSignModelName(WoodType p_171292_) {
        return createLocation("sign/" + p_171292_.name(), "main");
    }

    public static Stream<ModelLayerLocation> getKnownLocations() {
        return ALL_MODELS.stream();
    }
}
    public CompuExplosionThrownRenderer(EntityRendererProvider.Context context) {
        super(context);
        this.model = new CompuExplosionModel(context.bakeLayer(ModelLayers.COMPU_EXPLOSION));
    }

    @Override
    public ResourceLocation getTextureLocation(CompuExplosionThrown p_114482_) {
        return COMPU_EXPLOSION_TEXTURE;
    }
}
