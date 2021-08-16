package com.manueh.winxclubreborn.datagen;

import com.manueh.winxclubreborn.Main;
import com.manueh.winxclubreborn.core.init.Registration;
import net.minecraft.data.DataGenerator;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.common.data.ExistingFileHelper;

public class Items extends ItemModelProvider {


    public Items(DataGenerator generator, ExistingFileHelper existingFileHelper) {
        super(generator, Main.MODID, existingFileHelper);
    }

    @Override
    protected void registerModels() {
        singleTexture(Registration.MAGIC_POWDER.get().getRegistryName().getPath(),
                new ResourceLocation("item/handheld"), "layer0",
                new ResourceLocation(Main.MODID, "item/magic_powder"));
    }
}
