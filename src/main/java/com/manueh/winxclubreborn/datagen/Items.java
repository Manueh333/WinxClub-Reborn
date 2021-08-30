package com.manueh.winxclubreborn.datagen;

import com.manueh.winxclubreborn.Main;
import com.manueh.winxclubreborn.core.init.Registration;
import net.minecraft.data.DataGenerator;
import net.minecraftforge.client.model.generators.ItemModelBuilder;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.common.data.ExistingFileHelper;

public class Items extends ItemModelProvider {


    public Items(DataGenerator generator, ExistingFileHelper existingFileHelper) {
        super(generator, Main.MODID, existingFileHelper);
    }

    @Override
    protected void registerModels() {
        /*singleTexture(Registration.MAGIC_POWDER.get().getRegistryName().getPath(),
                new ResourceLocation("item/handheld"), "layer0",
                new ResourceLocation(Main.MODID, "item/magic_powder"));
*/
        getBuilder(Registration.PHANTOBLADE_3.get().getRegistryName().getPath())
                .parent(getExistingFile(mcLoc("item/handheld")))
                .texture("layer0", "item/phantoblade3_0")
                .override().predicate(Main.PHANTOBLADE_ACTIVE_PROPERTY, 0).model(createTestModel(0)).end()
                .override().predicate(Main.PHANTOBLADE_ACTIVE_PROPERTY, 1).model(createTestModel(1)).end();

       // withExistingParent(Registration.MAGIC_ORE_ITEM.get().getRegistryName().getPath(), new ResourceLocation(Main.MODID, "block/magic_ore"));
    }



    private ItemModelBuilder createTestModel(int suffix) {
        return getBuilder("phantoblade3_" + suffix).parent(getExistingFile(mcLoc("item/handheld")))
                .texture("layer0", "item/phantoblade3_" + suffix);
    }

}
