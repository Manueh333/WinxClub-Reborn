package com.manueh.winxclubreborn.Server;

import com.manueh.winxclubreborn.core.init.Registration;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.player.Player;
import net.minecraftforge.event.entity.living.LivingFallEvent;

public class ServerEvents {


    public static void entityAttacked(LivingFallEvent event)
    {
        Entity attackedEnt = event.getEntity();
        if(attackedEnt instanceof Player)
        {
            if(((Player) attackedEnt).getItemBySlot(EquipmentSlot.CHEST).getItem() == Registration.WINGS.get())
            {
                event.setDistance(0);
            }
        }
    }
}