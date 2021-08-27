package com.manueh.winxclubreborn.datagen;

import com.manueh.winxclubreborn.core.init.Registration;
import net.minecraft.advancements.criterion.InventoryChangeTrigger;
import net.minecraft.block.Blocks;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.IFinishedRecipe;
import net.minecraft.data.RecipeProvider;
import net.minecraft.data.ShapedRecipeBuilder;
import net.minecraft.item.crafting.Ingredient;
import net.minecraftforge.common.Tags;

import java.util.function.Consumer;


public class Recipes extends RecipeProvider {

    public Recipes(DataGenerator p_125973_) {
        super(p_125973_);
    }

    @Override
    protected void buildShapelessRecipes(Consumer<IFinishedRecipe> consumer) {
        ShapedRecipeBuilder.shaped(Registration.COMPU_EXPLOSION.get())
                .pattern("ptp")
                .pattern("tpt")
                .pattern("ptp")
                .define('t', Ingredient.of(Blocks.TNT.asItem().getDefaultInstance()))
                .define('p', Registration.MAGIC_POWDER.get()).group("winxclubreborn")
                .unlockedBy("compu_explosion", InventoryChangeTrigger.Instance.hasItems(Registration.COMPU_EXPLOSION.get()))
                .save(consumer);

        ShapedRecipeBuilder.shaped(Registration.POWER_BALL.get())
                .pattern("ppp")
                .pattern("p p")
                .pattern("ppp")
                .define('p', Registration.MAGIC_POWDER.get()).group("winxclubreborn")
                .unlockedBy("compu_explosion", InventoryChangeTrigger.Instance.hasItems(Registration.COMPU_EXPLOSION.get()))
                .save(consumer);


        ShapedRecipeBuilder.shaped(Registration.SOUND_WAVE.get())
                .pattern("ppp")
                .pattern("psp")
                .pattern("ppp")
                .define('p', Registration.MAGIC_POWDER.get()).group("winxclubreborn")
                .define('s', Ingredient.of(Blocks.NOTE_BLOCK.asItem().getDefaultInstance()))
                .unlockedBy("compu_explosion", InventoryChangeTrigger.Instance.hasItems(Registration.COMPU_EXPLOSION.get()))
                .save(consumer);

        ShapedRecipeBuilder.shaped(Registration.HIT_OF_NATURE.get())
                .pattern("ppp")
                .pattern("psp")
                .pattern("ppp")
                .define('p', Registration.MAGIC_POWDER.get()).group("winxclubreborn")
                .define('s', Tags.Items.SEEDS)
                .unlockedBy("compu_explosion", InventoryChangeTrigger.Instance.hasItems(Registration.COMPU_EXPLOSION.get()))
                .save(consumer);

        ShapedRecipeBuilder.shaped(Registration.SOLARIA_RING.get())
                .pattern("pdp")
                .pattern(" p ")
                .pattern(" p ")
                .define('p', Registration.MAGIC_POWDER.get()).group("winxclubreborn")
                .define('d', Ingredient.of(Blocks.DIAMOND_BLOCK.asItem().getDefaultInstance()))
                .unlockedBy("compu_explosion", InventoryChangeTrigger.Instance.hasItems(Registration.COMPU_EXPLOSION.get()))
                .save(consumer);

        ShapedRecipeBuilder.shaped(Registration.DRAGON_FURY.get())
                .pattern("ppp")
                .pattern("pdp")
                .pattern("ppp")
                .define('p', Registration.MAGIC_POWDER.get()).group("winxclubreborn")
                .define('d', net.minecraft.item.Items.FLINT_AND_STEEL)
                .unlockedBy("compu_explosion", InventoryChangeTrigger.Instance.hasItems(Registration.COMPU_EXPLOSION.get()))
                .save(consumer);

        ShapedRecipeBuilder.shaped(Registration.WOLF_CLAW.get())
                .pattern("pdp")
                .pattern("dpd")
                .pattern("pdp")
                .define('p', Registration.MAGIC_POWDER.get()).group("winxclubreborn")
                .define('d', net.minecraft.item.Items.BONE)
                .unlockedBy("compu_explosion", InventoryChangeTrigger.Instance.hasItems(Registration.COMPU_EXPLOSION.get()))
                .save(consumer);

        ShapedRecipeBuilder.shaped(Registration.WINGS.get())
                .pattern("ppp")
                .pattern("ppp")
                .pattern("p p")
                .define('p', Registration.MAGIC_POWDER.get()).group("winxclubreborn")
                .unlockedBy("compu_explosion", InventoryChangeTrigger.Instance.hasItems(Registration.COMPU_EXPLOSION.get()))
                .save(consumer);




        ShapedRecipeBuilder.shaped(Registration.PHANTOBLADE_1.get())
                .pattern(" pp")
                .pattern(" ap")
                .pattern("b  ")
                .define('p', Registration.MAGIC_POWDER.get())
                .define('a', net.minecraft.item.Items.EMERALD)
                .define('b', net.minecraft.item.Items.LEVER)
                .group("winxclubreborn")
                .unlockedBy("compu_explosion", InventoryChangeTrigger.Instance.hasItems(Registration.COMPU_EXPLOSION.get()))
                .save(consumer);

        ShapedRecipeBuilder.shaped(Registration.PHANTOBLADE_2.get())
                .pattern("  p")
                .pattern(" p ")
                .pattern("ab ")
                .define('p', Registration.MAGIC_POWDER.get())
                .define('a', net.minecraft.item.Items.DIAMOND)
                .define('b', net.minecraft.item.Items.LEVER)
                .group("winxclubreborn")
                .unlockedBy("compu_explosion", InventoryChangeTrigger.Instance.hasItems(Registration.COMPU_EXPLOSION.get()))
                .save(consumer);

        ShapedRecipeBuilder.shaped(Registration.PHANTOBLADE_3.get())
                .pattern(" pp")
                .pattern(" p ")
                .pattern(" ab")
                .define('p', Registration.MAGIC_POWDER.get())
                .define('a', net.minecraft.item.Items.REDSTONE)
                .define('b', net.minecraft.item.Items.LEVER)
                .group("winxclubreborn")
                .unlockedBy("compu_explosion", InventoryChangeTrigger.Instance.hasItems(Registration.COMPU_EXPLOSION.get()))
                .save(consumer);
    }

}
