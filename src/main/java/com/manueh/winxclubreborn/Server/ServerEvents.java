package com.manueh.winxclubreborn.Server;

import com.manueh.winxclubreborn.Client.ClientEvents;
import com.manueh.winxclubreborn.Main;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = Main.MODID, bus = Mod.EventBusSubscriber.Bus.FORGE, value = Dist.DEDICATED_SERVER)
public class ServerEvents {

    @SubscribeEvent
    public static void activateFly(final TickEvent.PlayerTickEvent event) {
        if(ClientEvents.flying) {
            event.player.fallDistance = 0;
        }
    }


}
