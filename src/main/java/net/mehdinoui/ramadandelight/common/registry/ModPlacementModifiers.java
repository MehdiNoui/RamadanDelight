package net.mehdinoui.ramadandelight.common.registry;

import net.mehdinoui.ramadandelight.RamadanDelight;
import net.mehdinoui.ramadandelight.common.world.ConfigurableCountPlacement;
import net.mehdinoui.ramadandelight.common.world.ConfigurableRarityFilter;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.level.levelgen.placement.PlacementModifierType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class ModPlacementModifiers {
    // --- Deferred Register ---
    public static final DeferredRegister<PlacementModifierType<?>> PLACEMENT_MODIFIERS =
            DeferredRegister.create(Registries.PLACEMENT_MODIFIER_TYPE, RamadanDelight.MOD_ID);

    // --- Helper Methods ---
    public static void register(IEventBus eventBus) {
        PLACEMENT_MODIFIERS.register(eventBus);
    }

    // --- Modifiers Registry ---
    public static final RegistryObject<PlacementModifierType<ConfigurableRarityFilter>> CONFIGURABLE_RARITY_FILTER =
            PLACEMENT_MODIFIERS.register("configurable_rarity_filter", () -> () -> ConfigurableRarityFilter.CODEC);
    public static final RegistryObject<PlacementModifierType<ConfigurableCountPlacement>> CONFIGURABLE_COUNT =
            PLACEMENT_MODIFIERS.register("configurable_count", () -> () -> ConfigurableCountPlacement.CODEC);
}