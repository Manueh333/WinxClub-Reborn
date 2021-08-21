package com.manueh.winxclubreborn.core.init;

import com.manueh.winxclubreborn.Main;
import com.mojang.serialization.Codec;
import net.minecraft.core.Registry;
import net.minecraft.data.BuiltinRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.profiling.FilledProfileResults;
import net.minecraft.util.valueproviders.IntProvider;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.OreBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.BaseStoneSource;
import net.minecraft.world.level.levelgen.GenerationStep;
import net.minecraft.world.level.levelgen.Heightmap;
import net.minecraft.world.level.levelgen.VerticalAnchor;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.FeaturePlaceContext;
import net.minecraft.world.level.levelgen.feature.OreFeature;
import net.minecraft.world.level.levelgen.feature.configurations.FeatureConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.OreConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.RangeDecoratorConfiguration;
import net.minecraft.world.level.levelgen.heightproviders.HeightProvider;
import net.minecraft.world.level.levelgen.structure.templatesystem.RuleTest;
import net.minecraft.world.level.levelgen.structure.templatesystem.RuleTestType;
import net.minecraftforge.common.world.BiomeGenerationSettingsBuilder;
import net.minecraftforge.event.world.BiomeLoadingEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import java.util.Random;

public class FeatureInit{

    /**
     * event, configuration, block, veinSize, minH, maxH,
     *
     *
     * **/
    public static void generateOres(final BiomeLoadingEvent event) {
        if (!event.getCategory().equals(Biome.BiomeCategory.NETHER) && !event.getCategory().equals(Biome.BiomeCategory.THEEND)) {
            exampleOreGenerate(event.getGeneration(), OreConfiguration.Predicates.NATURAL_STONE, ((Block) Registration.MAGIC_ORE.get()).defaultBlockState(), (Integer) 4, (Integer) 10, (Integer) 30, (Integer) 12);
        }
    }

    private static void exampleOreGenerate(BiomeGenerationSettingsBuilder settings, RuleTest fillerType, BlockState state, int veinSize, int minHeight, int maxHeight, int amount) {
        settings.addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, (ConfiguredFeature)((ConfiguredFeature)((ConfiguredFeature) Feature.ORE.configured(new OreConfiguration(fillerType, state, veinSize)).rangeUniform(VerticalAnchor.aboveBottom(minHeight), VerticalAnchor.belowTop(maxHeight))).squared()).count(amount));
    }

}
