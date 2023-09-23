package net.eatheraii.mccourse.util;

import net.eatheraii.mccourse.MCCourseMod;
import net.eatheraii.mccourse.item.ModItems;
import net.minecraft.client.item.ModelPredicateProviderRegistry;
import net.minecraft.util.Identifier;

public class ModModelPredicateProvider {

    public static void registerModels(){
        ModelPredicateProviderRegistry.register(ModItems.DATA_TABLET, new Identifier(MCCourseMod.MOD_ID, "on"),
                (stack, world, entity, seed) -> stack.hasNbt() ? 1f : 0f);
    }
}
