package com.manueh.winxclubreborn.Client;

import com.manueh.winxclubreborn.Main;
import com.manueh.winxclubreborn.common.items.Phantoblade;
import com.manueh.winxclubreborn.core.init.Registration;
import net.minecraft.client.renderer.item.ItemProperties;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fmlclient.registry.ClientRegistry;

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
        ItemProperties.register(item, Main.PHANTOBLADE_ACTIVE_PROPERTY,
                (stack, level, entity, damage) -> item.isActive(stack));
        Phantoblade item2 = Registration.PHANTOBLADE_2.get();
        ItemProperties.register(item2, Main.PHANTOBLADE_ACTIVE_PROPERTY,
                (stack, level, entity, damage) -> item.isActive(stack));
        Phantoblade item3 = Registration.PHANTOBLADE_3.get();
        ItemProperties.register(item3, Main.PHANTOBLADE_ACTIVE_PROPERTY,
                (stack, level, entity, damage) -> item.isActive(stack));
    }

}
