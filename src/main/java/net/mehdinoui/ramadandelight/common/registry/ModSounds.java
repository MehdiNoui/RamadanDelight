package net.mehdinoui.ramadandelight.common.registry;

import net.mehdinoui.ramadandelight.RamadanDelight;
import net.minecraft.client.resources.sounds.Sound;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ModSounds
{
    public static final DeferredRegister<SoundEvent> SOUNDS = DeferredRegister.create(ForgeRegistries.SOUND_EVENTS,RamadanDelight.MOD_ID);

    public static void register(IEventBus eventBus){
        SOUNDS.register(eventBus);
    }

    public static RegistryObject<SoundEvent> registerSound(String name){
        return SOUNDS.register(name, ()-> SoundEvent.createVariableRangeEvent(new ResourceLocation(RamadanDelight.MOD_ID, name)));
    }

    // Drum
    public static final RegistryObject<SoundEvent> Drum = registerSound("beat");

}
