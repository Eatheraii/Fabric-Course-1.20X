package net.eatheraii.mccourse.world.tree;

import net.eatheraii.mccourse.world.ModConfiguredFeatures;
import net.minecraft.block.sapling.SaplingGenerator;
import net.minecraft.registry.RegistryKey;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import org.jetbrains.annotations.Nullable;

public class DriftwoodSaplingGenerator extends SaplingGenerator {
    @Nullable
    @Override
    protected RegistryKey<ConfiguredFeature<?, ?>> getTreeFeature(Random random, boolean bees) {
        //deliberate error, need to register the configure feature first.
        return ModConfiguredFeatures.DRIFTWOOD_KEY;
    }
}
