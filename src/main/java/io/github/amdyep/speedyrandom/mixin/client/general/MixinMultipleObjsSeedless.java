package io.github.amdyep.speedyrandom.mixin.client.general;

import io.github.amdyep.speedyrandom.core.SpeedyRandomSeedless;
import net.minecraft.client.audio.MusicTicker;
import net.minecraft.client.audio.SoundEventAccessor;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.gui.IngameGui;
import net.minecraft.client.gui.screen.EnchantmentScreen;
import net.minecraft.client.network.play.ClientPlayNetHandler;
import net.minecraft.client.particle.ParticleManager;
import net.minecraft.client.renderer.GameRenderer;
import net.minecraft.client.renderer.entity.EndermanRenderer;
import net.minecraft.client.renderer.entity.ItemRenderer;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

import java.util.Random;

@Mixin({
        ClientPlayNetHandler.class, EnchantmentScreen.class, EndermanRenderer.class,
        FontRenderer.class, GameRenderer.class, IngameGui.class,
        ItemRenderer.class, MusicTicker.class, ParticleManager.class,
        SoundEventAccessor.class
})
public class MixinMultipleObjsSeedless {
    @Redirect(method = "<init>*", at = @At(value = "NEW", target = "()Ljava/util/Random;"))
    private Random speedyrandom$redirect$objInit() {
        return new SpeedyRandomSeedless();
    }
}
