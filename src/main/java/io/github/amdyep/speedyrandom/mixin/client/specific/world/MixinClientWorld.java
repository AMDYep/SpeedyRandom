package io.github.amdyep.speedyrandom.mixin.client.specific.world;

import net.minecraft.client.world.ClientWorld;
import net.minecraft.profiler.IProfiler;
import net.minecraft.util.RegistryKey;
import net.minecraft.world.DimensionType;
import net.minecraft.world.World;
import net.minecraft.world.storage.ISpawnWorldInfo;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

import java.util.Random;
import java.util.function.Supplier;

@Mixin(ClientWorld.class)
public abstract class MixinClientWorld extends World {
    protected MixinClientWorld(ISpawnWorldInfo p1, RegistryKey<World> p2, DimensionType p3, Supplier<IProfiler> p4, boolean p5, boolean p6, long p7) {
        super(p1, p2, p3, p4, p5, p6, p7);
    }

    @Redirect(method = "animateTick", at = @At(value = "NEW", target = "()Ljava/util/Random;"))
    private Random speedyrandom$animateTick() {
        return random;
    }
}
