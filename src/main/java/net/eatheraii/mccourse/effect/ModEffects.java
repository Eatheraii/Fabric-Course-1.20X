package net.eatheraii.mccourse.effect;

import net.eatheraii.mccourse.MCCourseMod;
import net.minecraft.entity.attribute.EntityAttributeModifier;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModEffects {
    public static final StatusEffect SLIMY = registerStatusEffect("slimy",
            new SlimyEffect(StatusEffectCategory.NEUTRAL, 0x36ebab).addAttributeModifier(EntityAttributes.GENERIC_MOVEMENT_SPEED,
                    "7107DE5E-7CE8-4030-940E-514C1F160890", -0.25f,
                    EntityAttributeModifier.Operation.MULTIPLY_TOTAL));
    //multiply the speed of our entity by -25% essentially. Don't worry about the UUID, it just works I guess.

    private static StatusEffect registerStatusEffect(String name, StatusEffect statusEffect){
        return Registry.register(Registries.STATUS_EFFECT, new Identifier(MCCourseMod.MOD_ID, name), statusEffect);
    }

    public static void registerEffects(){
        MCCourseMod.LOGGER.info("Registering Mod Effects for " + MCCourseMod.MOD_ID);
    }
}
