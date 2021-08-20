package com.manueh.winxclubreborn.Client;

import com.manueh.winxclubreborn.Main;
import net.minecraft.client.KeyMapping;
import net.minecraft.client.Minecraft;
import net.minecraft.client.Options;
import net.minecraft.client.main.GameConfig;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.world.entity.player.Player;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.Bindings;
import net.minecraftforge.fml.common.Mod;
import org.lwjgl.glfw.GLFW;

@Mod.EventBusSubscriber(modid = Main.MODID, bus = Mod.EventBusSubscriber.Bus.FORGE, value = Dist.CLIENT)
public class ClientEvents {

    public static final KeyMapping keyFly = new KeyMapping("key.winxclubreborn.fly", GLFW.GLFW_KEY_LEFT_ALT, "key.categories.winxclubreborn");

    private static boolean flying = false;

    @SubscribeEvent
    public static void activateFly(final TickEvent.PlayerTickEvent event) {
        Player player = event.player;
        if(player != null) {
            Options settings = Minecraft.getInstance().options;
            KeyMapping jump = settings.keyJump;
            KeyMapping crouch = settings.keyShift;
            KeyMapping fly = ClientEvents.keyFly;
            //if(player.getItemBySlot(EquipmentSlotType.HEAD).getStack().sameItemStackIgnoreDurability(ItemInit.IRONMAN_HELMET.get().getDefaultInstance()) && player.getItemBySlot(EquipmentSlotType.CHEST).getStack().sameItemStackIgnoreDurability(ItemInit.IRONMAN_CHESTPLATE.get().getDefaultInstance()) && player.getItemBySlot(EquipmentSlotType.LEGS).getStack().sameItemStackIgnoreDurability(ItemInit.IRONMAN_LEGGINS.get().getDefaultInstance()) && player.getItemBySlot(EquipmentSlotType.FEET).getStack().sameItemStackIgnoreDurability(ItemInit.IRONMAN_BOOTS.get().getDefaultInstance())) {
                if(flying) {
                    if(jump.isDown()) {
                        player.setDeltaMovement(player.getDeltaMovement().x,0.3f, player.getDeltaMovement().z);

                    }if(crouch.isDown()) {
                        player.setDeltaMovement(player.getDeltaMovement().x,-0.3f, player.getDeltaMovement().z);

                    }if(!jump.isDown() && !crouch.isDown()) {
                        player.setDeltaMovement(player.getDeltaMovement().x * 1.03,0, player.getDeltaMovement().z * 1.03);

                    }

               // }

                if(fly.consumeClick()) {
                    flying = !flying;
                    if(flying) {
                        player.setDeltaMovement(player.getDeltaMovement().x ,1, player.getDeltaMovement().z);
                    }
                }
                if(flying) {
                    player.getCommandSenderWorld().addParticle(ParticleTypes.CLOUD, player.position().x + (player.getCommandSenderWorld().random.nextFloat() - player.getCommandSenderWorld().random.nextFloat()) / 2, player.position().y + (player.getCommandSenderWorld().random.nextFloat() / 2 - player.getCommandSenderWorld().random.nextFloat()) / 2, player.position().z + (player.getCommandSenderWorld().random.nextFloat() - player.getCommandSenderWorld().random.nextFloat()) / 4, 0, -0.5, 0);
                }
                player.fallDistance = 0;



            }
        }
    }
}
