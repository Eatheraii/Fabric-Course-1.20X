package net.eatheraii.mccourse.datagen;

import net.eatheraii.mccourse.MCCourseMod;
import net.minecraft.data.DataOutput;
import net.minecraft.data.server.tag.TagProvider;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.PaintingVariantTags;
import net.minecraft.util.Identifier;

import java.util.concurrent.CompletableFuture;

public class ModPaintingVariantTagProvider extends TagProvider {

    public ModPaintingVariantTagProvider(DataOutput output, CompletableFuture registryLookupFuture) {
        super(output, RegistryKeys.PAINTING_VARIANT, registryLookupFuture);
    }

    @Override
    protected void configure(RegistryWrapper.WrapperLookup lookup) {
        getOrCreateTagBuilder(PaintingVariantTags.PLACEABLE)
                .addOptional(new Identifier(MCCourseMod.MOD_ID, "saw_them"))
                .addOptional(new Identifier(MCCourseMod.MOD_ID, "shrimp"))
                .addOptional(new Identifier(MCCourseMod.MOD_ID, "world"));
    }
}
