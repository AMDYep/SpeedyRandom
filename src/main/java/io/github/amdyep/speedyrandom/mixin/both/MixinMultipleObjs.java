package io.github.amdyep.speedyrandom.mixin.both;

import io.github.amdyep.speedyrandom.core.SpeedyRandom;
import net.minecraft.block.Block;
import net.minecraft.entity.Entity;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.WeightedList;
import net.minecraft.world.Explosion;
import net.minecraft.world.World;
import net.minecraft.world.raid.Raid;
import net.minecraft.world.spawner.WanderingTraderSpawner;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

import java.util.Random;

@Mixin({
        Block.class, Entity.class, Explosion.class,
        MinecraftServer.class, Raid.class,
        WanderingTraderSpawner.class, WeightedList.class, World.class
})
public class MixinMultipleObjs {
    @Redirect(method = "<init>*", at = @At(value = "NEW", target = "()Ljava/util/Random;"))
    private Random speedyrandom$redirect$objInit() {
        return new SpeedyRandom();
    }
}
