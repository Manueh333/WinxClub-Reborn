package com.manueh.winxclubreborn.common.armor;

import com.manueh.winxclubreborn.Client.ClientEvents;
import com.manueh.winxclubreborn.Client.ClientProxy;
import com.manueh.winxclubreborn.Main;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.client.model.HumanoidModel;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.TranslatableComponent;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.*;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.DispenserBlock;
import net.minecraftforge.client.IItemRenderProperties;

import javax.annotation.Nullable;
import java.util.List;

public class WingsItem extends ArmorItem {

    public WingsItem(ArmorMaterial p_40386_, EquipmentSlot p_40387_, Item.Properties p_40388_) {
        super(p_40386_, p_40387_, p_40388_);
        DispenserBlock.registerBehavior(this, ArmorItem.DISPENSE_ITEM_BEHAVIOR);
    }

    @Nullable
    public SoundEvent getEquipSound() {
        return SoundEvents.ARMOR_EQUIP_ELYTRA;
    }

    @Override
    public void appendHoverText(ItemStack stack, @Nullable Level level, List<Component> tooltip, TooltipFlag flag) {
        super.appendHoverText(stack, level, tooltip, flag);
        Minecraft mc = Minecraft.getInstance();

        if (level == null || mc.player == null) {
            return;
        }
        boolean sneakPressed = Screen.hasShiftDown();

        if(sneakPressed) {
            tooltip.add(new TranslatableComponent("tooltip.winxclubreborn.wings", ClientEvents.keyFly.getKey().getDisplayName()));
        }else {
            tooltip.add(new TranslatableComponent("tooltip.winxclubreborn.hold_shift"));
        }
    }

    @Override
    public void initializeClient(java.util.function.Consumer<net.minecraftforge.client.IItemRenderProperties> consumer)
    {
        consumer.accept(new IItemRenderProperties()
        {
            @Override
            public <A extends HumanoidModel<?>> A getArmorModel(LivingEntity entityLiving, ItemStack itemStack, EquipmentSlot armorSlot, A _default)
            {
                if(armorSlot == EquipmentSlot.CHEST) {
                    return (Main.PROXY instanceof ClientProxy) ? (A)((ClientProxy)Main.PROXY).getWingModel() : null;
                }
                return null;
            }
        });
    }

    @Override
    public String getArmorTexture(ItemStack stack, Entity entity, EquipmentSlot slot, String type) {
        return "winxclubreborn:textures/models/armor/wings_layer_" + (slot == EquipmentSlot.LEGS ? "2" : "1") + ".png";
    }

}
