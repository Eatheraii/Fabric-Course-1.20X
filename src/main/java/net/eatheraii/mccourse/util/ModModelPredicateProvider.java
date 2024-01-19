package net.eatheraii.mccourse.util;

import net.eatheraii.mccourse.MCCourseMod;
import net.eatheraii.mccourse.item.ModItems;
import net.minecraft.client.item.ModelPredicateProviderRegistry;
import net.minecraft.item.BundleItem;
import net.minecraft.item.Item;
import net.minecraft.item.Items;
import net.minecraft.util.Identifier;

public class ModModelPredicateProvider {

    public static void registerModels(){
        ModelPredicateProviderRegistry.register(ModItems.DATA_TABLET, new Identifier(MCCourseMod.MOD_ID, "on"),
                (stack, world, entity, seed) -> stack.hasNbt() ? 1f : 0f);
        registerBow(ModItems.PINK_GARNET_BOW);
    }

    //if dont register pull and pulling
    private static void registerBow(Item bow) {
        ModelPredicateProviderRegistry.register(Items.BOW, new Identifier("pull"), (stack, world, entity, seed) -> {
            if (entity == null) {
                return 0.0f;
            }
            if (entity.getActiveItem() != stack) {
                return 0.0f;
            }
            return (float)(stack.getMaxUseTime() - entity.getItemUseTimeLeft()) / 20.0f;
        });
        ModelPredicateProviderRegistry.register(Items.BOW, new Identifier("pulling"), (stack, world, entity, seed) -> entity != null && entity.isUsingItem() && entity.getActiveItem() == stack ? 1.0f : 0.0f);

    }
}
