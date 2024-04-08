package net.eatheraii.mccourse.effect;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;
import net.minecraft.util.math.Vec3d;

public class SlimyEffect extends StatusEffect {

    protected SlimyEffect(StatusEffectCategory category, int color) {
        super(category, color);
    }

    @Override
    public void applyUpdateEffect(LivingEntity entity, int amplifier) {
        //called every tick as long as canapply method returns true.
        //wants to make them a bit slower and when collides with wall, can climb up like a spider.
        if(entity.horizontalCollision) {
            Vec3d initialVec = entity.getVelocity();
            Vec3d climbVec = new Vec3d(initialVec.x, 0.20, initialVec.z);
                //^when they collide with a wall, we force the player to go up
            entity.setVelocity(climbVec.x *0.92, climbVec.y * 0.98, climbVec.z * 0.92);
        }

        super.applyUpdateEffect(entity, amplifier);
    }

    @Override
    public boolean canApplyUpdateEffect(int duration, int amplifier) {
        //as loing as this method returns true, the update effect method will be added
        return true;
    }
}
