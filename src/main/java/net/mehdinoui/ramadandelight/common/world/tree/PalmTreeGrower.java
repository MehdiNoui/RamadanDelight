package net.mehdinoui.ramadandelight.common.world.tree;

import net.mehdinoui.ramadandelight.common.registry.ModConfiguredFeatures;
import net.minecraft.world.level.block.grower.TreeGrower;

import java.util.Optional;

public class PalmTreeGrower {
    public static final TreeGrower PALM = new TreeGrower(
            "palm",
            Optional.empty(), // megaTree
            Optional.of(ModConfiguredFeatures.PALM_KEY), // secondaryTree
            Optional.empty() // flowers
    );
}