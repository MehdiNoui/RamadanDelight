package net.mehdinoui.ramadandelight.common.registry;

import net.mehdinoui.ramadandelight.RamadanDelight;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ModSounds{
    // --- Deferred Register ---
    public static final DeferredRegister<SoundEvent> SOUNDS = DeferredRegister.create(ForgeRegistries.SOUND_EVENTS,RamadanDelight.MOD_ID);

    // --- Helper Methods ---
    public static void register(IEventBus eventBus){
        SOUNDS.register(eventBus);
    }
    public static RegistryObject<SoundEvent> registerSound(String name){
        return SOUNDS.register(name, ()-> SoundEvent.createVariableRangeEvent(new ResourceLocation(RamadanDelight.MOD_ID, name)));
    }

    // Drum
    public static final RegistryObject<SoundEvent> Drum = registerSound("beat");
}
