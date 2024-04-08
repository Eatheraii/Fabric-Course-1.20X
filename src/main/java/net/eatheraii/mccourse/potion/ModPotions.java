package net.eatheraii.mccourse.potion;

import net.eatheraii.mccourse.MCCourseMod;
import net.eatheraii.mccourse.effect.ModEffects;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.potion.Potion;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModPotions {

    public static final Potion SLIMEY_POTION = registerPotion("slimy_potion",
            new Potion(new StatusEffectInstance(ModEffects.SLIMY, 200, 0)));
            //duration and amplifier are the numeric inputs

    private static Potion registerPotion(String name, Potion potion){
        return Registry.register(Registries.POTION, new Identifier(MCCourseMod.MOD_ID, name), potion);
    }

    public static void registerPotions(){
        MCCourseMod.LOGGER.info("Registering Potions for " + MCCourseMod.MOD_ID);
    }
}
