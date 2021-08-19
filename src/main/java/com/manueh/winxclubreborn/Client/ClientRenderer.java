package com.manueh.winxclubreborn.Client;

import com.manueh.winxclubreborn.Main;
import com.manueh.winxclubreborn.common.entity.*;
import com.manueh.winxclubreborn.common.models.*;
import com.manueh.winxclubreborn.core.init.Registration;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.projectile.Arrow;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD, modid = "winxclubreborn", value = Dist.CLIENT)
public class ClientRenderer {
    public static ModelLayerLocation COMPU_EXPLOSION_LAYER = new ModelLayerLocation(new ResourceLocation(Main.MODID, "compu_explosion"), "compu_explosion");
    public static ModelLayerLocation HIT_OF_NATURE_LAYER = new ModelLayerLocation(new ResourceLocation(Main.MODID, "hit_of_nature"), "hit_of_nature");
    public static ModelLayerLocation SOUND_WAVE_LAYER = new ModelLayerLocation(new ResourceLocation(Main.MODID, "sound_wave"), "sound_wave");
    public static ModelLayerLocation WOLF_CLAW_LAYER = new ModelLayerLocation(new ResourceLocation(Main.MODID, "wolf_claw"), "wolf_claw");
    public static ModelLayerLocation DRAGON_FURY_LAYER = new ModelLayerLocation(new ResourceLocation(Main.MODID, "dragon_fury"), "dragon_fury");
    public static ModelLayerLocation SOLARIA_RING_LAYER = new ModelLayerLocation(new ResourceLocation(Main.MODID, "solaria_ring"), "solaria_ring");
    public static ModelLayerLocation POWER_BALL_LAYER = new ModelLayerLocation(new ResourceLocation(Main.MODID, "power_ball"), "power_ball");


    @SubscribeEvent
    public static void registerRenderers(EntityRenderersEvent.RegisterRenderers event) {
        event.registerEntityRenderer(Registration.COMPU_EXPLOSION_ENTITY.get(), CompuExplosionThrownRenderer::new);
        event.registerEntityRenderer(Registration.HIT_OF_NATURE_ENTITY.get(), HitOfNatureRenderer::new);
        event.registerEntityRenderer(Registration.SOUND_WAVE_ENTITY.get(), SoundWaveThrownRenderer::new);
        event.registerEntityRenderer(Registration.WOLF_CLAW_ENTITY.get(), WolfClawThrownRenderer::new);
        event.registerEntityRenderer(Registration.DRAGON_FURY_ENTITY.get(), DragonFuryThrownRenderer::new);
        event.registerEntityRenderer(Registration.SOLARIA_RING_ENTITY.get(), SolariaRingThrownRenderer::new);
        event.registerEntityRenderer(Registration.POWER_BALL_ENTITY.get(), PowerBallThrownRenderer::new);

    }

    @SubscribeEvent
    public static void registerLayerDefinition(EntityRenderersEvent.RegisterLayerDefinitions event) {
        event.registerLayerDefinition(COMPU_EXPLOSION_LAYER, CompuExplosionModel::createLayer);
        event.registerLayerDefinition(HIT_OF_NATURE_LAYER, HitOfNatureModel::createLayer);
        event.registerLayerDefinition(SOUND_WAVE_LAYER, SoundWaveModel::createLayer);
        event.registerLayerDefinition(WOLF_CLAW_LAYER, WolfClawModel::createLayer);
        event.registerLayerDefinition(DRAGON_FURY_LAYER, DragonFuryModel::createLayer);
        event.registerLayerDefinition(SOLARIA_RING_LAYER, SolariaRingModel::createLayer);
        event.registerLayerDefinition(POWER_BALL_LAYER, PowerBallModel::createLayer);
    }
}
