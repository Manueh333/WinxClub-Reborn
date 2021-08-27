package com.manueh.winxclubreborn.Server;

import com.manueh.winxclubreborn.core.init.Registration;

import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraftforge.event.entity.living.LivingFallEvent;

public class ServerEvents {


    public static void entityAttacked(LivingFallEvent event)
    {
        Entity attackedEnt = event.getEntity();
        if(attackedEnt instanceof PlayerEntity)
        {
            if(((PlayerEntity) attackedEnt).getItemBySlot(EquipmentSlotType.CHEST).getItem() == Registration.WINGS.get())
            {
                event.setDistance(0);
            }
        }
    }
}