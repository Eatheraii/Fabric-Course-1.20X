package net.eatheraii.mccourse.particle;

import net.minecraft.client.particle.*;
import net.minecraft.client.world.ClientWorld;
import net.minecraft.particle.DefaultParticleType;

public class PinkGarnetParticle extends SpriteBillboardParticle {

    public PinkGarnetParticle(ClientWorld world, double xCoord, double yCoord, double zCoord,
                                  SpriteProvider spriteSet, double xd, double yd, double zd) {

        super(world, xCoord, yCoord, zCoord, xd, yd, zd);

        //things we can set or change
        this.velocityMultiplier = 0.5f; //50% slower than the speed it gets.
        this.velocityX = xd;
        this.velocityY = yd;
        this.velocityZ = zd;
        //changing the velocity of ou particles ^

        this.scale += 0.75f; //change the scale
        this.maxAge = 10; //half a second how long before disappears
        this.setSpriteForAge(spriteSet);
        //^set the sprite for the age and pass our set in.

        this.red = 1f;
        this.green = 1f;
        this.blue = 1f;
        //^changing these provides a color overlay on our existing texture.
    }

    @Override
    public ParticleTextureSheet getType() {
        return ParticleTextureSheet.PARTICLE_SHEET_TRANSLUCENT;
    }

    //nested factory class
    public static class Factory implements ParticleFactory<DefaultParticleType> {
        private final SpriteProvider sprites;

        public Factory(SpriteProvider spriteProvider) {
            this.sprites = spriteProvider;
        }

        public Particle createParticle(DefaultParticleType particleType, ClientWorld clientWorld,
                                       double x, double y, double z, double xd, double yd, double zd){
            return new PinkGarnetParticle(clientWorld, x, y, z, this.sprites, xd, yd, zd);
        }

    }


}
