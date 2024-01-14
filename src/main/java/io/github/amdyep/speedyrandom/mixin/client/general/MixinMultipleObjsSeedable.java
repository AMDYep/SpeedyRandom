package io.github.amdyep.speedyrandom.mixin.client.general;

import io.github.amdyep.speedyrandom.core.SpeedyRandomSeedable;
import net.minecraft.client.particle.Particle;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

import java.util.Random;

@Mixin({Particle.class})
public class MixinMultipleObjsSeedable {
    @Redirect(method = "<init>*", at = @At(value = "NEW", target = "()Ljava/util/Random;"))
    private Random speedyrandom$redirect$objInit() {
        return new SpeedyRandomSeedable();
    }
}
