package com.manueh.winxclubreborn.Client;

import com.manueh.winxclubreborn.Main;
import com.manueh.winxclubreborn.common.entity.CompuExplosionThrown;
import com.manueh.winxclubreborn.common.entity.CompuExplosionThrownRenderer;
import com.manueh.winxclubreborn.common.models.CompuExplosionModel;
import com.manueh.winxclubreborn.core.init.Registration;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD, modid = "winxclubreborn")
public class ClientRenderer {
    public static ModelLayerLocation COMPU_EXPLOSION_LAYER = new ModelLayerLocation(new ResourceLocation(Main.MODID, "compu_explosion_air"), "compu_explosion_air");
    @SubscribeEvent
    public static void registerRenderers(EntityRenderersEvent.RegisterRenderers event) {
        event.registerEntityRenderer(Registration.COMPU_EXPLOSION_ENTITY.get(), CompuExplosionThrownRenderer::new);
    }

    @SubscribeEvent
    public static void registerLayerDefinition(EntityRenderersEvent.RegisterLayerDefinitions event) {
        event.registerLayerDefinition(COMPU_EXPLOSION_LAYER, CompuExplosionModel::createLayer);
    }
}
