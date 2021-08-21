package com.manueh.winxclubreborn;

import com.manueh.winxclubreborn.Client.ClientEvents;
import com.manueh.winxclubreborn.common.armor.WingsLayer;
import com.manueh.winxclubreborn.core.CreativeTab;
import com.manueh.winxclubreborn.core.init.FeatureInit;
import com.manueh.winxclubreborn.core.init.Registration;
import net.minecraft.client.KeyMapping;
import net.minecraft.client.gui.screens.MenuScreens;
import net.minecraft.client.renderer.entity.EntityRenderers;
import net.minecraft.core.Registry;
import net.minecraft.data.BuiltinRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.levelgen.VerticalAnchor;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.FeatureConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.OreConfiguration;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.EventPriority;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.fmlclient.registry.ClientRegistry;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.lwjgl.glfw.GLFW;

// The value here should match an entry in the META-INF/mods.toml file
@Mod(Main.MODID)
public class Main
{

    // Directly reference a log4j logger.
    private static final Logger LOGGER = LogManager.getLogger();
    public static final String MODID = "winxclubreborn";
    public static final CreativeTab GROUP = new CreativeTab("winxclubreborn_tab");

    public Main() {
        Registration.init();

        // Register the setup method for modloading

        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::setup);
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::ClientSetup);
        MinecraftForge.EVENT_BUS.addListener(EventPriority.HIGH, FeatureInit::generateOres);
        // Register ourselves for server and other game events we are interested in
        MinecraftForge.EVENT_BUS.register(this);
    }

    private void setup(final FMLCommonSetupEvent event)
    {

    }


    public void ClientSetup(final FMLClientSetupEvent event) {
        event.enqueueWork(() -> {
         //   MenuScreens.register(Registration.GENERATOR_CONTAINER.get(), MagicGeneratorScreen::new);
            ClientRegistry.registerKeyBinding(ClientEvents.keyFly);
            });}

}
