package net.eatheraii.mccourse.datagen;

import net.eatheraii.mccourse.block.ModBlocks;
import net.eatheraii.mccourse.block.custom.PinkGarnetLampBlock;
import net.eatheraii.mccourse.item.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import net.minecraft.block.Blocks;
import net.minecraft.data.client.*;
import net.minecraft.item.ArmorItem;
import net.minecraft.state.property.Properties;
import net.minecraft.util.Identifier;

public class ModModelProvider extends FabricModelProvider {
    public ModModelProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generateBlockStateModels(BlockStateModelGenerator blockStateModelGenerator) {
        BlockStateModelGenerator.BlockTexturePool pinkGarnetTexturePool =
                blockStateModelGenerator.registerCubeAllModelTexturePool(ModBlocks.PINK_GARNET_BLOCK);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.RAW_PINK_GARNET_BLOCK);

        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.PINK_GARNET_ORE);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.DEEPSLATE_PINK_GARNET_ORE);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.END_STONE_PINK_GARNET_ORE);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.NETHER_PINK_GARNET_ORE);

        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.SOUND_BLOCK);

        pinkGarnetTexturePool.stairs(ModBlocks.PINK_GARNET_STAIRS);
        pinkGarnetTexturePool.slab(ModBlocks.PINK_GARNET_SLAB);
        pinkGarnetTexturePool.button(ModBlocks.PINK_GARNET_BUTTON);
        pinkGarnetTexturePool.pressurePlate(ModBlocks.PINK_GARNET_PRESSURE_PLATE);
        pinkGarnetTexturePool.fence(ModBlocks.PINK_GARNET_FENCE);
        pinkGarnetTexturePool.fenceGate(ModBlocks.PINK_GARNET_FENCE_GATE);
        pinkGarnetTexturePool.wall(ModBlocks.PINK_GARNET_WALL);

        registerCustomLamp(blockStateModelGenerator);

    }

    private void registerCustomLamp(BlockStateModelGenerator blockStateModelGenerator) {
        Identifier identifier = TexturedModel.CUBE_ALL.upload(ModBlocks.PINK_GARNET_LAMP, blockStateModelGenerator.modelCollector);
        Identifier identifier2 = blockStateModelGenerator.createSubModel(ModBlocks.PINK_GARNET_LAMP, "_on", Models.CUBE_ALL, TextureMap::all);
        blockStateModelGenerator.blockStateCollector.accept(VariantsBlockStateSupplier.create(ModBlocks.PINK_GARNET_LAMP)
                .coordinate(BlockStateModelGenerator.createBooleanModelMap(PinkGarnetLampBlock.CLICKED, identifier2, identifier)));
    }


    @Override
    public void generateItemModels(ItemModelGenerator itemModelGenerator) {
        itemModelGenerator.register(ModItems.PINK_GARNET, Models.GENERATED);
        itemModelGenerator.register(ModItems.RAW_PINK_GARNET, Models.GENERATED);

        itemModelGenerator.register(ModItems.CAULIFLOWER, Models.GENERATED);
        itemModelGenerator.register(ModItems.PEAT_BRICK, Models.GENERATED);
        itemModelGenerator.register(ModItems.METAL_DETECTOR, Models.GENERATED);

        itemModelGenerator.register(ModItems.PINK_GARNET_SWORD, Models.GENERATED);
        itemModelGenerator.register(ModItems.PINK_GARNET_SHOVEL, Models.GENERATED);
        itemModelGenerator.register(ModItems.PINK_GARNET_PICKAXE, Models.GENERATED);
        itemModelGenerator.register(ModItems.PINK_GARNET_AXE, Models.GENERATED);
        itemModelGenerator.register(ModItems.PINK_GARNET_HOE, Models.GENERATED);
        itemModelGenerator.register(ModItems.PINK_GARNET_PAXEL, Models.GENERATED);

        itemModelGenerator.registerArmor((ArmorItem)ModItems.PINK_GARNET_HELMET);
        itemModelGenerator.registerArmor((ArmorItem)ModItems.PINK_GARNET_CHESTPLATE);
        itemModelGenerator.registerArmor((ArmorItem)ModItems.PINK_GARNET_LEGGINGS);
        itemModelGenerator.registerArmor((ArmorItem)ModItems.PINK_GARNET_BOOTS);

    }
}
