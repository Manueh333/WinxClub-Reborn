package com.manueh.winxclubreborn.datagen;

import com.manueh.winxclubreborn.core.init.Registration;
import net.minecraft.advancements.critereon.InventoryChangeTrigger;
import net.minecraft.data.BlockFamilies;
import net.minecraft.data.BlockFamily;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.recipes.FinishedRecipe;
import net.minecraft.data.recipes.RecipeProvider;
import net.minecraft.data.recipes.ShapedRecipeBuilder;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.block.Blocks;
import net.minecraftforge.common.Tags;

import java.util.function.Consumer;

public class Recipes extends RecipeProvider {

    public Recipes(DataGenerator p_125973_) {
        super(p_125973_);
    }

    @Override
    protected void buildCraftingRecipes(Consumer<FinishedRecipe> consumer) {
        ShapedRecipeBuilder.shaped(Registration.COMPU_EXPLOSION.get())
                .pattern("ptp")
                .pattern("tpt")
                .pattern("ptp")
                .define('t', Ingredient.of(Blocks.TNT.asItem().getDefaultInstance()))
                .define('p', Registration.MAGIC_POWDER.get()).group("winxclubreborn")
                .unlockedBy("compu_explosion", InventoryChangeTrigger.TriggerInstance.hasItems(Registration.COMPU_EXPLOSION.get()))
                .save(consumer);

        ShapedRecipeBuilder.shaped(Registration.POWER_BALL.get())
                .pattern("ppp")
                .pattern("p p")
                .pattern("ppp")
                .define('p', Registration.MAGIC_POWDER.get()).group("winxclubreborn")
                .unlockedBy("compu_explosion", InventoryChangeTrigger.TriggerInstance.hasItems(Registration.COMPU_EXPLOSION.get()))
                .save(consumer);


        ShapedRecipeBuilder.shaped(Registration.SOUND_WAVE.get())
                .pattern("ppp")
                .pattern("psp")
                .pattern("ppp")
                .define('p', Registration.MAGIC_POWDER.get()).group("winxclubreborn")
                .define('s', Ingredient.of(Blocks.NOTE_BLOCK.asItem().getDefaultInstance()))
                .unlockedBy("compu_explosion", InventoryChangeTrigger.TriggerInstance.hasItems(Registration.COMPU_EXPLOSION.get()))
                .save(consumer);

        ShapedRecipeBuilder.shaped(Registration.HIT_OF_NATURE.get())
                .pattern("ppp")
                .pattern("psp")
                .pattern("ppp")
                .define('p', Registration.MAGIC_POWDER.get()).group("winxclubreborn")
                .define('s', Tags.Items.SEEDS)
                .unlockedBy("compu_explosion", InventoryChangeTrigger.TriggerInstance.hasItems(Registration.COMPU_EXPLOSION.get()))
                .save(consumer);

        ShapedRecipeBuilder.shaped(Registration.SOLARIA_RING.get())
                .pattern("pdp")
                .pattern(" p ")
                .pattern(" p ")
                .define('p', Registration.MAGIC_POWDER.get()).group("winxclubreborn")
                .define('d', Ingredient.of(Blocks.DIAMOND_BLOCK.asItem().getDefaultInstance()))
                .unlockedBy("compu_explosion", InventoryChangeTrigger.TriggerInstance.hasItems(Registration.COMPU_EXPLOSION.get()))
                .save(consumer);

        ShapedRecipeBuilder.shaped(Registration.DRAGON_FURY.get())
                .pattern("ppp")
                .pattern("pdp")
                .pattern("ppp")
                .define('p', Registration.MAGIC_POWDER.get()).group("winxclubreborn")
                .define('d', Items.FLINT_AND_STEEL)
                .unlockedBy("compu_explosion", InventoryChangeTrigger.TriggerInstance.hasItems(Registration.COMPU_EXPLOSION.get()))
                .save(consumer);

        ShapedRecipeBuilder.shaped(Registration.WOLF_CLAW.get())
                .pattern("pdp")
                .pattern("dpd")
                .pattern("pdp")
                .define('p', Registration.MAGIC_POWDER.get()).group("winxclubreborn")
                .define('d', Items.BONE)
                .unlockedBy("compu_explosion", InventoryChangeTrigger.TriggerInstance.hasItems(Registration.COMPU_EXPLOSION.get()))
                .save(consumer);

    }

}
