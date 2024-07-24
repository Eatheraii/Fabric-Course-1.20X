package net.eatheraii.mccourse.world;

import net.eatheraii.mccourse.MCCourseMod;
import net.eatheraii.mccourse.block.ModBlocks;
import net.minecraft.registry.Registerable;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.intprovider.ConstantIntProvider;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.FeatureConfig;
import net.minecraft.world.gen.feature.TreeFeatureConfig;
import net.minecraft.world.gen.feature.size.TwoLayersFeatureSize;
import net.minecraft.world.gen.foliage.BlobFoliagePlacer;
import net.minecraft.world.gen.stateprovider.BlockStateProvider;
import net.minecraft.world.gen.trunk.StraightTrunkPlacer;

//features that are configured.
//adds some amount of functionality and configuration, placed is the thing we will spawn.
public class ModConfiguredFeatures {
    public static final RegistryKey<ConfiguredFeature<?, ?>> DRIFTWOOD_KEY = registerKey("driftwood");

    public static void bootstrap(Registerable<ConfiguredFeature<?, ?>> context) {
        //calling our register method below
        register(context, DRIFTWOOD_KEY, Feature.TREE, new TreeFeatureConfig.Builder(
                //build our tree
                //wood type
                BlockStateProvider.of(ModBlocks.DRIFTWOOD_LOG),
                //trunk placement pattern - straight for us (can middle mouse to look)
                new StraightTrunkPlacer(5, 6, 3),
                //supply leaves
                BlockStateProvider.of(ModBlocks.DRIFTWOOD_LEAVES),
                new BlobFoliagePlacer(ConstantIntProvider.create(2), ConstantIntProvider.create(1), 2),
                new TwoLayersFeatureSize(1, 0, 2)).build());
    }

    //copied in because its the same every time
    public static RegistryKey<ConfiguredFeature<?, ?>> registerKey(String name) {
        return RegistryKey.of(RegistryKeys.CONFIGURED_FEATURE, new Identifier(MCCourseMod.MOD_ID, name));
    }
    //copied in because its the same every time
    private static <FC extends FeatureConfig, F extends Feature<FC>> void register(Registerable<ConfiguredFeature<?, ?>> context,
                                                                                   RegistryKey<ConfiguredFeature<?, ?>> key, F feature, FC configuration) {
        context.register(key, new ConfiguredFeature<>(feature, configuration));
    }
}
