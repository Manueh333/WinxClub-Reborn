package com.manueh.winxclubreborn.common.armor;

import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Wearable;
import net.minecraft.world.level.block.DispenserBlock;

import javax.annotation.Nullable;

public class WingsItem extends Item implements Wearable {

    public WingsItem(Properties p_41383_) {
        super(p_41383_);
        DispenserBlock.registerBehavior(this, ArmorItem.DISPENSE_ITEM_BEHAVIOR);
    }

    @Nullable
    public SoundEvent getEquipSound() {
        return SoundEvents.ARMOR_EQUIP_ELYTRA;
    }

}
