package io.github.amdyep.speedyrandom.mixin.client.specific.renderer.entity;

import io.github.amdyep.speedyrandom.core.SpeedyRandomSeedless;
import net.minecraft.client.renderer.entity.LightningBoltRenderer;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

import java.util.Random;

@Mixin(LightningBoltRenderer.class)
public class MixinLightningBoltRenderer {
    @Unique
    private static final Random SPEEDYRANDOM$TL_RANDOM = new SpeedyRandomSeedless();

    @Redirect(
            method = "render(Lnet/minecraft/entity/effect/LightningBoltEntity;FFLcom/mojang/blaze3d/matrix/MatrixStack;Lnet/minecraft/client/renderer/IRenderTypeBuffer;I)V",
            at = @At(value = "NEW", target = "(J)Ljava/util/Random;")
    )
    private Random speedyrandom$redirect$render(long seed) {
        return SPEEDYRANDOM$TL_RANDOM;
    }
}
