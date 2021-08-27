package com.manueh.winxclubreborn.core;

import com.manueh.winxclubreborn.core.init.Registration;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;

public class CreativeTab extends ItemGroup {
    public CreativeTab(String label) {
        super(label);
    }

    @Override
    public ItemStack makeIcon() {
        return Registration.MAGIC_POWDER.get().getDefaultInstance();
    }
}
