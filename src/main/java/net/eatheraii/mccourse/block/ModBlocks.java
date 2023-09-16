package net.eatheraii.mccourse.block;

import net.eatheraii.mccourse.MCCourseMod;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModBlocks {

    //now add the new BLOCK
    public static final Block PINK_GARNET_BLOCK = registerBlock("pink_garnet_block",
            new Block(FabricBlockSettings.copyOf(Blocks.IRON_BLOCK)));
    //add the SECOND BLOCK
    public static final Block RAW_PINK_GARNET_BLOCK = registerBlock("raw_pink_garnet_block",
            new Block(FabricBlockSettings.copyOf(Blocks.IRON_BLOCK)));

    //adding blocks for assignment
    public static final Block DEEPSLATE_PINK_GARNET_ORE = registerBlock("deepslate_pink_garnet_ore",
            new Block(FabricBlockSettings.copyOf(Blocks.DEEPSLATE_EMERALD_ORE)));

    public static final Block END_STONE_PINK_GARNET_ORE = registerBlock("end_stone_pink_garnet_ore",
            new Block(FabricBlockSettings.copyOf(Blocks.END_STONE)));

    public static final Block NETHER_PINK_GARNET_ORE = registerBlock("nether_pink_garnet_ore",
            new Block(FabricBlockSettings.copyOf(Blocks.NETHER_GOLD_ORE)));

    public static final Block PINK_GARNET_ORE = registerBlock("pink_garnet_ore",
            new Block(FabricBlockSettings.copyOf(Blocks.IRON_ORE)));

    //register associated item
    private static Item registerBlockItem(String name, Block block){
        return Registry.register(Registries.ITEM, new Identifier(MCCourseMod.MOD_ID, name),
                new BlockItem(block, new FabricItemSettings()));
    }

    //register the actual block
    private static Block registerBlock(String name, Block block){
        registerBlockItem(name, block);
        return Registry.register(Registries.BLOCK, new Identifier(MCCourseMod.MOD_ID, name), block);
    }

    public static void registerModBlocks(){
        MCCourseMod.LOGGER.info("Registering ModBlocks for " + MCCourseMod.MOD_ID);
    }
}

