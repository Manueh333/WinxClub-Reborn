package com.manueh.winxclubreborn.core;

import com.manueh.winxclubreborn.core.init.Registration;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;

public class CreativeTab extends CreativeModeTab {
    public CreativeTab(String label) {
        super(label);
    }

    @Override
    public ItemStack makeIcon() {
        return Registration.MAGIC_POWDER.get().getDefaultInstance();
    }
}
