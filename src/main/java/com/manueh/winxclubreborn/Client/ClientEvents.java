package com.manueh.winxclubreborn.Client;

import com.manueh.winxclubreborn.Main;
import com.manueh.winxclubreborn.core.init.Registration;
import net.minecraft.client.KeyMapping;
import net.minecraft.client.Minecraft;
import net.minecraft.client.Options;
import net.minecraft.client.main.GameConfig;
import net.minecraft.core.particles.*;
import net.minecraft.nbt.Tag;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.Blocks;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.Bindings;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.items.CapabilityItemHandler;
import net.minecraftforge.items.IItemHandler;
import org.lwjgl.glfw.GLFW;

@Mod.EventBusSubscriber(modid = Main.MODID, bus = Mod.EventBusSubscriber.Bus.FORGE, value = Dist.CLIENT)
public class ClientEvents {


    public static boolean flying = false;
    private static int particleHelper;
    private static int particleCooldown = 10;
    public static final KeyMapping keyFly = new KeyMapping("key.winxclubreborn.fly", GLFW.GLFW_KEY_LEFT_ALT, "key.categories.winxclubreborn");


    @SubscribeEvent
    public static void activateFly(final TickEvent.PlayerTickEvent event) {
        Player player = event.player;
        if(player != null) {
            Options settings = Minecraft.getInstance().options;
            KeyMapping jump = settings.keyJump;
            KeyMapping crouch = settings.keyShift;
            KeyMapping fly = keyFly;
            if(player.getItemBySlot(EquipmentSlot.CHEST).getItem() == Registration.WINGS.get()) {
                if(flying) {
                    if(jump.isDown()) {
                        player.setDeltaMovement(player.getDeltaMovement().x,0.3f, player.getDeltaMovement().z);

                    }if(crouch.isDown()) {
                        player.setDeltaMovement(player.getDeltaMovement().x,-0.3f, player.getDeltaMovement().z);

                    }if(!jump.isDown() && !crouch.isDown()) {
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
                        player.getCommandSenderWorld().addParticle(DustColorTransitionOptions.SCULK_TO_REDSTONE, player.getX(), player.getY(), player.getZ(), 0, 0, 0);
                        player.getCommandSenderWorld().addParticle( DustColorTransitionOptions.SCULK_TO_REDSTONE, player.position().x + (player.getCommandSenderWorld().random.nextFloat() - player.getCommandSenderWorld().random.nextFloat()) / 2, player.position().y + 1 + (player.getCommandSenderWorld().random.nextFloat() / 2 - player.getCommandSenderWorld().random.nextFloat()) / 2, player.position().z + (player.getCommandSenderWorld().random.nextFloat() - player.getCommandSenderWorld().random.nextFloat()) / 4, player.getCommandSenderWorld().random.nextFloat() / 4, 0, player.getCommandSenderWorld().random.nextFloat() / 4);
                        player.getCommandSenderWorld().addParticle( DustColorTransitionOptions.SCULK_TO_REDSTONE, player.position().x + (player.getCommandSenderWorld().random.nextFloat() - player.getCommandSenderWorld().random.nextFloat()) / 2, player.position().y + 1 + (player.getCommandSenderWorld().random.nextFloat() / 2 - player.getCommandSenderWorld().random.nextFloat()) / 2, player.position().z + (player.getCommandSenderWorld().random.nextFloat() - player.getCommandSenderWorld().random.nextFloat()) / 4, - player.getCommandSenderWorld().random.nextFloat() / 4, 0, - player.getCommandSenderWorld().random.nextFloat() / 4);
                        player.getCommandSenderWorld().addParticle( DustColorTransitionOptions.SCULK_TO_REDSTONE, player.position().x + (player.getCommandSenderWorld().random.nextFloat() - player.getCommandSenderWorld().random.nextFloat()) / 2, player.position().y + 1 + (player.getCommandSenderWorld().random.nextFloat() / 2 - player.getCommandSenderWorld().random.nextFloat()) / 2, player.position().z + (player.getCommandSenderWorld().random.nextFloat() - player.getCommandSenderWorld().random.nextFloat()) / 4, player.getCommandSenderWorld().random.nextFloat() / 4, 0, - player.getCommandSenderWorld().random.nextFloat() / 4);
                        player.getCommandSenderWorld().addParticle( DustColorTransitionOptions.SCULK_TO_REDSTONE, player.position().x + (player.getCommandSenderWorld().random.nextFloat() - player.getCommandSenderWorld().random.nextFloat()) / 2, player.position().y + 1 + (player.getCommandSenderWorld().random.nextFloat() / 2 - player.getCommandSenderWorld().random.nextFloat()) / 2, player.position().z + (player.getCommandSenderWorld().random.nextFloat() - player.getCommandSenderWorld().random.nextFloat()) / 4, - player.getCommandSenderWorld().random.nextFloat() / 4, 0, player.getCommandSenderWorld().random.nextFloat() / 4);
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

