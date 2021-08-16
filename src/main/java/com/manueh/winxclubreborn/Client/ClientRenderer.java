package com.manueh.winxclubreborn.Client;

import com.manueh.winxclubreborn.common.entity.CompuExplosionThrown;
import com.manueh.winxclubreborn.common.entity.CompuExplosionThrownRenderer;
import com.manueh.winxclubreborn.core.init.Registration;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD, modid = "winxclubreborn")
public class ClientRenderer {

    @SubscribeEvent
    public static void registerRenderers(EntityRenderersEvent.RegisterRenderers event) {
        event.registerEntityRenderer(Registration.COMPU_EXPLOSION_ENTITY.get(), CompuExplosionThrownRenderer::new);
    }
}
