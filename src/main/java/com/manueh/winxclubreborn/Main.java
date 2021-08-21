package com.manueh.winxclubreborn;

import com.manueh.winxclubreborn.Client.ClientEvents;
import com.manueh.winxclubreborn.Server.ServerEvents;
import com.manueh.winxclubreborn.common.items.Phantoblade;
import com.manueh.winxclubreborn.core.CreativeTab;
import com.manueh.winxclubreborn.core.init.FeatureInit;
import com.manueh.winxclubreborn.core.init.Registration;
import net.minecraft.client.renderer.item.ItemProperties;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.EventPriority;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.fmlclient.registry.ClientRegistry;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Mod(Main.MODID)
public class Main
{

    // Directly reference a log4j logger.
    private static final Logger LOGGER = LogManager.getLogger();
    public static final String MODID = "winxclubreborn";
    public static final CreativeTab GROUP = new CreativeTab("winxclubreborn_tab");



    public Main() {
        Registration.init();
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::setup);
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::ClientSetup);
        MinecraftForge.EVENT_BUS.addListener(EventPriority.HIGH, FeatureInit::generateOres);
        MinecraftForge.EVENT_BUS.addListener(EventPriority.HIGH, ServerEvents::entityAttacked);
        // Register ourselves for server and other game events we are interested in
        MinecraftForge.EVENT_BUS.register(this);
    }

    private void setup(final FMLCommonSetupEvent event)
    {

    }

    public static final ResourceLocation PHANTOBLADE_ACTIVE_PROPERTY = new ResourceLocation(Main.MODID, "active");

    public void ClientSetup(final FMLClientSetupEvent event) {
        event.enqueueWork(() -> {
         //   MenuScreens.register(Registration.GENERATOR_CONTAINER.get(), MagicGeneratorScreen::new);
            ClientRegistry.registerKeyBinding(ClientEvents.keyFly);
            initTestItemOverrides();
            });}

    public static void initTestItemOverrides() {
        Phantoblade item = Registration.PHANTOBLADE_1.get();
        ItemProperties.register(item, PHANTOBLADE_ACTIVE_PROPERTY,
                (stack, level, entity, damage) -> item.isActive(stack));
        Phantoblade item2 = Registration.PHANTOBLADE_2.get();
        ItemProperties.register(item2, PHANTOBLADE_ACTIVE_PROPERTY,
                (stack, level, entity, damage) -> item.isActive(stack));
    }
}
