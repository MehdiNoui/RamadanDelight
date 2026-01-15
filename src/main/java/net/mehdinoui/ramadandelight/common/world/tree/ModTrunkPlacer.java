package net.mehdinoui.ramadandelight.common.world.tree;

import net.mehdinoui.ramadandelight.RamadanDelight;
import net.mehdinoui.ramadandelight.common.world.tree.custom.PalmTrunkPlacer;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.level.levelgen.feature.trunkplacers.TrunkPlacerType;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ModTrunkPlacer {
    // --- Deferred Register ---
    public static final DeferredRegister<TrunkPlacerType<?>> TRUNK_PLACERS =
            DeferredRegister.create(Registries.TRUNK_PLACER_TYPE, RamadanDelight.MOD_ID);

    // --- Helper Methods ---
    public static void register(IEventBus eventBus) {
        TRUNK_PLACERS.register(eventBus);
    }

    // --- Register ---
    public static final DeferredHolder<TrunkPlacerType<?>, TrunkPlacerType<PalmTrunkPlacer>> PALM_TRUNK_PLACER =
            TRUNK_PLACERS.register("palm_trunk_placer", () -> new TrunkPlacerType<>(PalmTrunkPlacer.CODEC));
}