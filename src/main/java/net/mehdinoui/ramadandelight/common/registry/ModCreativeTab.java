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
            () -> CreativeModeTab.builder().icon(()-> new ItemStack(ModItems.PARSLEY.get()))
                    .title(Component.translatable("creativetab.ramadandelight_tab"))
                    .displayItems((pParameters, pOutput) ->{
                                pOutput.accept(ModBlocks.MOSAIC_TILES.get());

                                pOutput.accept(ModItems.FANOUS.get());
                                pOutput.accept(ModItems.REDSTONE_FANOUS.get());
                                pOutput.accept(ModItems.SOUL_FANOUS.get());

                                pOutput.accept(ModItems.DRUM.get());

                                pOutput.accept(ModBlocks.WINDOW_BLOCK.get());
                                pOutput.accept(ModBlocks.BLUE_STAINED_WINDOW_BLOCK.get());
                                pOutput.accept(ModBlocks.GREEN_STAINED_WINDOW_BLOCK.get());
                                pOutput.accept(ModBlocks.ORANGE_STAINED_WINDOW_BLOCK.get());

                                pOutput.accept(ModBlocks.PARSLEY_BAG.get());

                                pOutput.accept(ModBlocks.WILD_PARSLEY.get());

                                pOutput.accept(ModItems.PARSLEY.get());
                                pOutput.accept(ModItems.PARSLEY_SEEDS.get());

                                pOutput.accept(ModItems.SMALL_DOUGH.get());
                                pOutput.accept(ModItems.BOUREK_SHEET.get());
                                pOutput.accept(ModItems.RAW_BOUREK.get());
                                pOutput.accept(ModItems.RAW_SAMOSA.get());

                                pOutput.accept(ModItems.FLAT_BREAD.get());
                                pOutput.accept(ModItems.MANAKISH.get());
                                pOutput.accept(ModItems.BOUREK.get());
                                pOutput.accept(ModItems.SAMOSA.get());

                                pOutput.accept(ModItems.RAW_KEBAB.get());
                                pOutput.accept(ModItems.KEBAB.get());

                                pOutput.accept(ModItems.QUICHE.get());
                                pOutput.accept(ModItems.QUICHE_SLICE.get());

                                pOutput.accept(ModItems.SAVORY_FILLING.get());
                                pOutput.accept(ModItems.TABBOULEH.get());

                                pOutput.accept(ModItems.HARIRA.get());
                                pOutput.accept(ModItems.CHORBA.get());
                                pOutput.accept(ModItems.HALEEM.get());

                                pOutput.accept(ModItems.SAYADIEH.get());
                                pOutput.accept(ModItems.TAGINE.get());

                                pOutput.accept(ModItems.MAKLOBA_BLOCK.get());
                                pOutput.accept(ModItems.MAKLOBA.get());
                                pOutput.accept(ModItems.BOUREK_BLOCK.get());
                    }
                    ).build());

    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TABS.register(eventBus);
    }
}
