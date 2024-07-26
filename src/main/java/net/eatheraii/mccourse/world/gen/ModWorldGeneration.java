package net.eatheraii.mccourse.world.gen;

public class ModWorldGeneration {
    public static void generateModWorldGeneration(){
        //important ores is before trees
        ModOreGeneration.generateOres();

        ModTreeGeneration.generateTrees();
    }
}
