package com.manueh.winxclubreborn.Client;

import com.manueh.winxclubreborn.core.init.Registration;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.ItemRenderer;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import javax.swing.*;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD, modid = "winxclubreborn", value = Dist.CLIENT)
public class ClientRenderer {
    /* public static ModelResourceLocation COMPU_EXPLOSION_LAYER = new ModelResourceLocation(new ResourceLocation(Main.MODID, "compu_explosion"), "compu_explosion");
    public static ModelResourceLocation HIT_OF_NATURE_LAYER = new ModelResourceLocation(new ResourceLocation(Main.MODID, "hit_of_nature"), "hit_of_nature");
    public static ModelResourceLocation SOUND_WAVE_LAYER = new ModelResourceLocation(new ResourceLocation(Main.MODID, "sound_wave"), "sound_wave");
    public static ModelResourceLocation WOLF_CLAW_LAYER = new ModelResourceLocation(new ResourceLocation(Main.MODID, "wolf_claw"), "wolf_claw");
    public static ModelResourceLocation DRAGON_FURY_LAYER = new ModelResourceLocation(new ResourceLocation(Main.MODID, "dragon_fury"), "dragon_fury");
    public static ModelResourceLocation SOLARIA_RING_LAYER = new ModelResourceLocation(new ResourceLocation(Main.MODID, "solaria_ring"), "solaria_ring");
    public static ModelResourceLocation POWER_BALL_LAYER = new ModelResourceLocation(new ResourceLocation(Main.MODID, "power_ball"), "power_ball");
    public static ModelResourceLocation WINGS_LAYER = new ModelResourceLocation(new ResourceLocation(Main.MODID, "wings"), "wings");
*/

/*
    @SubscribeEvent
    public static void registerLayerDefinition(EntityRenderersEvent.RegisterLayerDefinitions event) {
        event.registerLayerDefinition(COMPU_EXPLOSION_LAYER, CompuExplosionModel::createLayer);
        event.registerLayerDefinition(HIT_OF_NATURE_LAYER, HitOfNatureModel::createLayer);
        event.registerLayerDefinition(SOUND_WAVE_LAYER, SoundWaveModel::createLayer);
        event.registerLayerDefinition(WOLF_CLAW_LAYER, WolfClawModel::createLayer);
        event.registerLayerDefinition(DRAGON_FURY_LAYER, DragonFuryModel::createLayer);
        event.registerLayerDefinition(SOLARIA_RING_LAYER, SolariaRingModel::createLayer);
        event.registerLayerDefinition(POWER_BALL_LAYER, PowerBallModel::createLayer);
        event.registerLayerDefinition(WINGS_LAYER, WingsModel::createLayer);
    }*/
}
