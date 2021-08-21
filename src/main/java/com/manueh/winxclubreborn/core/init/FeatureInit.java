package com.manueh.winxclubreborn.core.init;

import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.GenerationStep;
import net.minecraft.world.level.levelgen.VerticalAnchor;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.OreConfiguration;
import net.minecraft.world.level.levelgen.structure.templatesystem.RuleTest;
import net.minecraftforge.common.world.BiomeGenerationSettingsBuilder;
import net.minecraftforge.event.world.BiomeLoadingEvent;

public class FeatureInit{

    /**
     * event, configuration, block, veinSize, minH, maxH, count
     * **/
    public static void generateOres(final BiomeLoadingEvent event) {
        if (!event.getCategory().equals(Biome.BiomeCategory.NETHER) && !event.getCategory().equals(Biome.BiomeCategory.THEEND)) {
            OreGenerate(event.getGeneration(), OreConfiguration.Predicates.NATURAL_STONE, ((Block) Registration.MAGIC_ORE.get()).defaultBlockState(), (Integer) 4, (Integer) 10, (Integer) 30, (Integer) 12);
        }
    }

    private static void OreGenerate(BiomeGenerationSettingsBuilder settings, RuleTest fillerType, BlockState state, int veinSize, int minHeight, int maxHeight, int amount) {
        settings.addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, (ConfiguredFeature)((ConfiguredFeature)((ConfiguredFeature) Feature.ORE.configured(new OreConfiguration(fillerType, state, veinSize)).rangeUniform(VerticalAnchor.absolute(minHeight), VerticalAnchor.absolute(maxHeight))).squared()).count(amount));
    }

}
