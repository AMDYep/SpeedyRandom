package io.github.amdyep.speedyrandom;

import net.minecraftforge.fml.ExtensionPoint;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import org.apache.commons.lang3.tuple.Pair;

@Mod("speedyrandom")
public class SpeedyRandomMod {
    public SpeedyRandomMod() {
        ModLoadingContext.get().registerExtensionPoint(
                ExtensionPoint.DISPLAYTEST,
                () -> Pair.of(
                        () -> "ANY",
                        (remote, server) -> true
                )
        );
    }
}
