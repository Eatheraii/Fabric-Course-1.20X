package net.eatheraii.mccourse.world.gen;

import net.eatheraii.mccourse.world.ModPlacedFeatures;
import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.minecraft.world.biome.BiomeKeys;
import net.minecraft.world.gen.GenerationStep;

public class ModTreeGeneration {
    public static void generateTrees(){
        BiomeModifications.addFeature(BiomeSelectors.includeByKey(BiomeKeys.PLAINS),
                GenerationStep.Feature.VEGETAL_DECORATION, ModPlacedFeatures.DRIFTWOOD_PLACED_KEY);
        //during the vegetational decoration step in the plains biome, the driftwood key will be considered

        //can look at biome selectors class andBiomeKeys for more options
    }
}
