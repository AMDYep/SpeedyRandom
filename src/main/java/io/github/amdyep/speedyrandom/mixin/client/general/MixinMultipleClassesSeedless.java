package io.github.amdyep.speedyrandom.mixin.client.general;

import io.github.amdyep.speedyrandom.core.SpeedyRandomSeedless;
import net.minecraft.client.gui.fonts.Font;
import net.minecraft.client.particle.SpellParticle;
import net.minecraft.client.util.Splashes;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

import java.util.Random;

@Mixin({Font.class, SpellParticle.class, Splashes.class})
public class MixinMultipleClassesSeedless {
    @Redirect(method = "<clinit>", at = @At(value = "NEW", target = "()Ljava/util/Random;", remap = false))
    private static Random speedyrandom$redirect$clzInit() {
        return new SpeedyRandomSeedless();
    }
}
