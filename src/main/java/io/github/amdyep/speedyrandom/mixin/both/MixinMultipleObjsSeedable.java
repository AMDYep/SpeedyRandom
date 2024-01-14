package io.github.amdyep.speedyrandom.mixin.both;

import io.github.amdyep.speedyrandom.core.SpeedyRandomSeedable;
import net.minecraft.block.Block;
import net.minecraft.entity.Entity;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

import java.util.Random;

@Mixin({Block.class, Entity.class, World.class})
public class MixinMultipleObjsSeedable {
    @Redirect(method = "<init>*", at = @At(value = "NEW", target = "()Ljava/util/Random;"))
    private Random speedyrandom$redirect$objInit() {
        return new SpeedyRandomSeedable();
    }
}
