package com.manueh.winxclubreborn;

import com.manueh.winxclubreborn.Client.ClientSetup;
import com.manueh.winxclubreborn.Server.ServerEvents;
import com.manueh.winxclubreborn.core.CreativeTab;
import com.manueh.winxclubreborn.core.IProxy;
import com.manueh.winxclubreborn.core.init.FeatureInit;
import com.manueh.winxclubreborn.core.init.Registration;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.EventPriority;
import net.minecraftforge.fml.DistExecutor;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Mod(Main.MODID)
public class Main
{

    // Directly reference a log4j logger.
    private static final Logger LOGGER = LogManager.getLogger();
    public static final String MODID = "winxclubreborn";
    public static final CreativeTab GROUP = new CreativeTab("winxclubreborn_tab");

    public static final IProxy PROXY = (IProxy) DistExecutor.safeRunForDist(() -> com.manueh.winxclubreborn.Client.ClientProxy::new, () -> com.manueh.winxclubreborn.Server.ServerProxy::new);

    public Main() {
        Registration.init();
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::setup);
        FMLJavaModLoadingContext.get().getModEventBus().addListener(EventPriority.HIGH, ClientSetup::setup);
        MinecraftForge.EVENT_BUS.addListener(EventPriority.HIGH, FeatureInit::generateOres);
        MinecraftForge.EVENT_BUS.addListener(EventPriority.HIGH, ServerEvents::entityAttacked);
        // Register ourselves for server and other game events we are interested in
        MinecraftForge.EVENT_BUS.register(this);
    }

    private void setup(final FMLCommonSetupEvent event)
    {

    }
    public static final ResourceLocation PHANTOBLADE_ACTIVE_PROPERTY = new ResourceLocation(Main.MODID, "active");




}
