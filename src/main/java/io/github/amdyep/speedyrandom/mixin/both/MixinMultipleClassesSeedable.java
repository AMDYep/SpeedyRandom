package io.github.amdyep.speedyrandom.mixin.both;

import io.github.amdyep.speedyrandom.core.SpeedyRandomSeedable;
import net.minecraft.item.Item;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

import java.util.Random;

@Mixin({Item.class})
public class MixinMultipleClassesSeedable {
    @Redirect(method = "<clinit>", at = @At(value = "NEW", target = "()Ljava/util/Random;", remap = false))
    private static Random speedyrandom$redirect$clzInit() {
        return new SpeedyRandomSeedable();
    }
}
