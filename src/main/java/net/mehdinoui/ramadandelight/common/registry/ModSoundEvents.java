package net.mehdinoui.ramadandelight.common.registry;

import net.mehdinoui.ramadandelight.RamadanDelight;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;


public class ModSoundEvents {
    // --- Deferred Register ---
    public static final DeferredRegister<SoundEvent> SOUNDS =
            DeferredRegister.create(Registries.SOUND_EVENT, RamadanDelight.MOD_ID);

    // --- Helper Methods ---
    public static void register(IEventBus eventBus) {
        SOUNDS.register(eventBus);
    }

    // Drum
    public static final DeferredHolder<SoundEvent, SoundEvent> DRUM_BEAT = SOUNDS.register("drum_beat",
            () -> SoundEvent.createVariableRangeEvent(
                    ResourceLocation.fromNamespaceAndPath(RamadanDelight.MOD_ID, "drum_beat")));
}
