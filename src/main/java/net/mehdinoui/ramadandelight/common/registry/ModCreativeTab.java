package net.mehdinoui.ramadandelight.common.registry;

import net.mehdinoui.ramadandelight.RamadanDelight;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class ModCreativeTab {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, RamadanDelight.MOD_ID);

    public static final RegistryObject<CreativeModeTab> RamadanDelight_TAB = CREATIVE_MODE_TABS.register("veggiesdelight_tab",
            () -> CreativeModeTab.builder().icon(()-> new ItemStack(ModItems.TEST.get()))
                    .title(Component.translatable("creativetab.veggiesdelight_tab"))
                    .displayItems((pParameters, pOutput) ->{

                    }
                    ).build());

    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TABS.register(eventBus);
    }
}
