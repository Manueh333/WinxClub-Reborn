package com.manueh.winxclubreborn.Client;

import com.manueh.winxclubreborn.Main;
import com.manueh.winxclubreborn.core.init.Registration;
import net.minecraft.client.GameSettings;
import net.minecraft.client.Minecraft;
import net.minecraft.client.settings.KeyBinding;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.particles.RedstoneParticleData;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import org.lwjgl.glfw.GLFW;


@Mod.EventBusSubscriber(modid = Main.MODID, bus = Mod.EventBusSubscriber.Bus.FORGE, value = Dist.CLIENT)
public class ClientEvents {



    public static boolean flying = false;
    private static int particleHelper;
    private static int particleCooldown = 10;
    public static final KeyBinding keyFly = new KeyBinding("key.winxclubreborn.fly", GLFW.GLFW_KEY_LEFT_ALT, "key.categories.winxclubreborn");


    @SubscribeEvent
    public static void activateFly(final TickEvent.PlayerTickEvent event) {
        PlayerEntity player = event.player;
        if(player != null) {
            GameSettings settings = Minecraft.getInstance().options;
            KeyBinding jump = settings.keyJump;
            KeyBinding crouch = settings.keyShift;
            KeyBinding fly = keyFly;
            if(player.getItemBySlot(EquipmentSlotType.CHEST).getItem() == Registration.WINGS.get()) {
                if(flying) {
                    if(jump.isDown()) {
                        player.setDeltaMovement(player.getDeltaMovement().x,0.3f, player.getDeltaMovement().z);

                    }if(player.isShiftKeyDown()) {
                        player.setDeltaMovement(player.getDeltaMovement().x,-0.3f, player.getDeltaMovement().z);

                    }if(!jump.isDown() && !player.isShiftKeyDown()) {
                        player.setDeltaMovement(player.getDeltaMovement().x * 1.03,0, player.getDeltaMovement().z * 1.03);

                    }

                }

                if(fly.consumeClick()) {
                    flying = !flying;
                    if(flying) {
                        player.setDeltaMovement(player.getDeltaMovement().x ,1, player.getDeltaMovement().z);
                    }
                }
                if(flying) {
                    if(particleHelper == 0) {
                        player.getCommandSenderWorld().addParticle(new RedstoneParticleData( 153, 153, 255,1), player.getX(), player.getY(), player.getZ(), 0, 0, 0);
                        player.getCommandSenderWorld().addParticle( new RedstoneParticleData( 153, 153, 255,1), player.position().x + (player.getCommandSenderWorld().random.nextFloat() - player.getCommandSenderWorld().random.nextFloat()) / 2, player.position().y + 1 + (player.getCommandSenderWorld().random.nextFloat() / 2 - player.getCommandSenderWorld().random.nextFloat()) / 2, player.position().z + (player.getCommandSenderWorld().random.nextFloat() - player.getCommandSenderWorld().random.nextFloat()) / 4, player.getCommandSenderWorld().random.nextFloat() / 4, 0, player.getCommandSenderWorld().random.nextFloat() / 4);
                        player.getCommandSenderWorld().addParticle( new RedstoneParticleData( 153, 153, 255,1), player.position().x + (player.getCommandSenderWorld().random.nextFloat() - player.getCommandSenderWorld().random.nextFloat()) / 2, player.position().y + 1 + (player.getCommandSenderWorld().random.nextFloat() / 2 - player.getCommandSenderWorld().random.nextFloat()) / 2, player.position().z + (player.getCommandSenderWorld().random.nextFloat() - player.getCommandSenderWorld().random.nextFloat()) / 4, - player.getCommandSenderWorld().random.nextFloat() / 4, 0, - player.getCommandSenderWorld().random.nextFloat() / 4);
                        player.getCommandSenderWorld().addParticle( new RedstoneParticleData( 153, 153, 255,1), player.position().x + (player.getCommandSenderWorld().random.nextFloat() - player.getCommandSenderWorld().random.nextFloat()) / 2, player.position().y + 1 + (player.getCommandSenderWorld().random.nextFloat() / 2 - player.getCommandSenderWorld().random.nextFloat()) / 2, player.position().z + (player.getCommandSenderWorld().random.nextFloat() - player.getCommandSenderWorld().random.nextFloat()) / 4, player.getCommandSenderWorld().random.nextFloat() / 4, 0, - player.getCommandSenderWorld().random.nextFloat() / 4);
                        player.getCommandSenderWorld().addParticle( new RedstoneParticleData( 153, 153, 255,1), player.position().x + (player.getCommandSenderWorld().random.nextFloat() - player.getCommandSenderWorld().random.nextFloat()) / 2, player.position().y + 1 + (player.getCommandSenderWorld().random.nextFloat() / 2 - player.getCommandSenderWorld().random.nextFloat()) / 2, player.position().z + (player.getCommandSenderWorld().random.nextFloat() - player.getCommandSenderWorld().random.nextFloat()) / 4, - player.getCommandSenderWorld().random.nextFloat() / 4, 0, player.getCommandSenderWorld().random.nextFloat() / 4);
                        particleHelper = particleCooldown;
                    }else {
                        particleHelper--;
                    }
                }
                player.fallDistance = 0;

            }
        }
    }
}

