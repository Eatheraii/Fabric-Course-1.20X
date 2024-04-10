package net.eatheraii.mccourse;

import net.eatheraii.mccourse.block.ModBlocks;
import net.eatheraii.mccourse.particle.ModParticles;
import net.eatheraii.mccourse.particle.PinkGarnetParticle;
import net.eatheraii.mccourse.util.ModModelPredicateProvider;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.fabricmc.fabric.api.client.particle.v1.ParticleFactoryRegistry;
import net.minecraft.client.particle.ParticleFactory;
import net.minecraft.client.render.RenderLayer;

public class MCCourseModClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.CAULIFLOWER_CROP, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.PETUNIA, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.POTTED_PETUNIA, RenderLayer.getCutout());

        ModModelPredicateProvider.registerModels();

        ParticleFactoryRegistry.getInstance().register(ModParticles.PINK_GARNET_PARTICLE, PinkGarnetParticle.Factory::new);

    }
}
