package com.manueh.winxclubreborn.Client;

import com.manueh.winxclubreborn.Main;
import com.manueh.winxclubreborn.common.entity.CompuExplosionThrown;
import com.manueh.winxclubreborn.common.items.Phantoblade;
import com.manueh.winxclubreborn.core.init.Registration;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.entity.SpriteRenderer;
import net.minecraft.client.renderer.entity.TridentRenderer;
import net.minecraft.item.ItemModelsProperties;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.fml.client.registry.ClientRegistry;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;


@Mod.EventBusSubscriber(value = Dist.CLIENT, modid = Main.MODID)
public class ClientSetup {

    public static void setup(final FMLClientSetupEvent event) {

        event.enqueueWork(() -> {
            //   MenuScreens.register(Registration.GENERATOR_CONTAINER.get(), MagicGeneratorScreen::new);
            ClientRegistry.registerKeyBinding(ClientEvents.keyFly);
            initTestItemOverrides();
             });}

    public static void initTestItemOverrides() {
        Phantoblade item = Registration.PHANTOBLADE_1.get();
        ItemModelsProperties.register(item, Main.PHANTOBLADE_ACTIVE_PROPERTY,
                (stack, entity, damage) -> item.isActive(stack));
        Phantoblade item2 = Registration.PHANTOBLADE_2.get();
        ItemModelsProperties.register(item2, Main.PHANTOBLADE_ACTIVE_PROPERTY,
                (stack, entity, damage) -> item.isActive(stack));
        Phantoblade item3 = Registration.PHANTOBLADE_3.get();
        ItemModelsProperties.register(item3, Main.PHANTOBLADE_ACTIVE_PROPERTY,
                (stack, entity, damage) -> item.isActive(stack));
    }

}
