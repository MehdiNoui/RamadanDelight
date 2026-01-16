package net.mehdinoui.ramadandelight.common.registry;

import net.mehdinoui.ramadandelight.RamadanDelight;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class ModSoundEvents {
    // --- Deferred Register ---
    public static final DeferredRegister<SoundEvent> SOUNDS =
            DeferredRegister.create(Registries.SOUND_EVENT, RamadanDelight.MOD_ID);

    // --- Helper Methods ---
    public static void register(IEventBus eventBus) {
        SOUNDS.register(eventBus);
    }

    // Drum
    public static final RegistryObject<SoundEvent> DRUM_BEAT = SOUNDS.register("drum_beat",
            () -> SoundEvent.createVariableRangeEvent(new ResourceLocation(RamadanDelight.MOD_ID, "drum_beat")));
}