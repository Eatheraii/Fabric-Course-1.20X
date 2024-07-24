package net.eatheraii.mccourse.world;

import net.eatheraii.mccourse.MCCourseMod;
import net.eatheraii.mccourse.block.ModBlocks;
import net.minecraft.registry.Registerable;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.util.Identifier;
import net.minecraft.world.gen.feature.*;
import net.minecraft.world.gen.placementmodifier.PlacementModifier;

import java.util.List;

//how placed in the world
public class ModPlacedFeatures {
    public static final RegistryKey<PlacedFeature> DRIFTWOOD_PLACED_KEY = registerKey("driftwood_placed");

    public static void bootstrap (Registerable<PlacedFeature> context){
        var configuredFeatureRegistryEntryLookup = context.getRegistryLookup(RegistryKeys.CONFIGURED_FEATURE);

        //copied lines
        //giving context, key, configured feature we made.
        register(context, DRIFTWOOD_PLACED_KEY, configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.DRIFTWOOD_KEY),
                VegetationPlacedFeatures.treeModifiersWithWouldSurvive(
                        //count, 1 per chunk and a chance 2 more will spawn.be careful with chance math, rewatch lecture if needed.
                        //sapling constrains where sapling can spawn.
                        PlacedFeatures.createCountExtraModifier(1, 0.1f, 2), ModBlocks.DRIFTWOOD_SAPLING));

    }

    //copied method
    public static RegistryKey<PlacedFeature> registerKey(String name) {
        return RegistryKey.of(RegistryKeys.PLACED_FEATURE, new Identifier(MCCourseMod.MOD_ID, name));
    }

    //copied method
    private static void register(Registerable<PlacedFeature> context, RegistryKey<PlacedFeature> key, RegistryEntry<ConfiguredFeature<?, ?>> configuration,
                                 List<PlacementModifier> modifiers) {
        context.register(key, new PlacedFeature(configuration, List.copyOf(modifiers)));
    }

    //copied method
    private static <FC extends FeatureConfig, F extends Feature<FC>> void register(Registerable<PlacedFeature> context, RegistryKey<PlacedFeature> key,
                                                                                   RegistryEntry<ConfiguredFeature<?, ?>> configuration,
                                                                                   PlacementModifier... modifiers) {
        register(context, key, configuration, List.of(modifiers));
    }
}
