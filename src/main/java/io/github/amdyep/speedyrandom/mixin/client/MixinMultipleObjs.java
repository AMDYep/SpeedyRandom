package io.github.amdyep.speedyrandom.mixin.client;

import io.github.amdyep.speedyrandom.core.SpeedyRandom;
import net.minecraft.client.audio.MusicTicker;
import net.minecraft.client.audio.SoundEventAccessor;
import net.minecraft.client.gui.screen.EnchantmentScreen;
import net.minecraft.client.network.play.ClientPlayNetHandler;
import net.minecraft.client.particle.Particle;
import net.minecraft.client.particle.ParticleManager;
import net.minecraft.client.renderer.GameRenderer;
import net.minecraft.client.renderer.entity.EndermanRenderer;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

import java.util.Random;

@Mixin({
        MusicTicker.class, EndermanRenderer.class, GameRenderer.class,
        EnchantmentScreen.class, SoundEventAccessor.class,
        ClientPlayNetHandler.class, Particle.class, ParticleManager.class
})
public class MixinMultipleObjs {
    @Redirect(method = "<init>*", at = @At(value = "NEW", target = "()Ljava/util/Random;"))
    private Random speedyrandom$redirect$objInit() {
        return new SpeedyRandom();
    }
}
