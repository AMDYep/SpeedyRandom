package io.github.amdyep.speedyrandom.mixin.both;

import io.github.amdyep.speedyrandom.core.SpeedyRandomSeedless;
import net.minecraft.entity.ai.brain.sensor.Sensor;
import net.minecraft.inventory.InventoryHelper;
import net.minecraft.network.login.ServerLoginNetHandler;
import net.minecraft.tileentity.DispenserTileEntity;
import net.minecraft.tileentity.EnchantingTableTileEntity;
import net.minecraft.util.datafix.fixes.ZombieProfToType;
import net.minecraft.util.math.MathHelper;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

import java.util.Random;

@Mixin({
        DispenserTileEntity.class, EnchantingTableTileEntity.class, InventoryHelper.class,
        MathHelper.class, Sensor.class, ServerLoginNetHandler.class,
        ZombieProfToType.class,
})
public class MixinMultipleClassesSeedless {
    @Redirect(method = "<clinit>", at = @At(value = "NEW", target = "()Ljava/util/Random;", remap = false))
    private static Random speedyrandom$redirect$clzInit() {
        return new SpeedyRandomSeedless();
    }
}
