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
            () -> CreativeModeTab.builder().icon(()-> new ItemStack(ModBlocks.FANOUS.get()))
                    .title(Component.translatable("creativetab.ramadandelight_tab"))
                    .displayItems((pParameters, pOutput) ->{
                                pOutput.accept(ModBlocks.PALM_LOG.get());
                                pOutput.accept(ModBlocks.PALM_WOOD.get());
                                pOutput.accept(ModBlocks.STRIPPED_PALM_LOG.get());
                                pOutput.accept(ModBlocks.STRIPPED_PALM_WOOD.get());
                                pOutput.accept(ModBlocks.PALM_PLANKS.get());
                                pOutput.accept(ModBlocks.PALM_STAIRS.get());
                                pOutput.accept(ModBlocks.PALM_SLAB.get());
                                pOutput.accept(ModBlocks.PALM_FENCE.get());
                                pOutput.accept(ModBlocks.PALM_FENCE_GATE.get());
                                pOutput.accept(ModBlocks.PALM_DOOR.get());
                                pOutput.accept(ModBlocks.PALM_TRAPDOOR.get());
                                pOutput.accept(ModBlocks.PALM_PRESSURE_PLATE.get());
                                pOutput.accept(ModBlocks.PALM_BUTTON.get());
                                pOutput.accept(ModBlocks.PALM_SIGN.get());
                                pOutput.accept(ModBlocks.PALM_HANGING_SIGN.get());
                                pOutput.accept(ModBlocks.PALM_LEAVES.get());
                                pOutput.accept(ModBlocks.PALM_SAPLING.get());

                                pOutput.accept(ModItems.DATES_BRANCH.get());
                                pOutput.accept(ModItems.DATE.get());
                                pOutput.accept(ModItems.CLUSTER_OF_DATES.get());

                                pOutput.accept(ModBlocks.MOSAIC_TILES.get());

                                pOutput.accept(ModItems.FANOUS.get());
                                pOutput.accept(ModItems.COPPER_FANOUS.get());
                                pOutput.accept(ModItems.REDSTONE_FANOUS.get());
                                pOutput.accept(ModItems.SOUL_FANOUS.get());

                                pOutput.accept(ModItems.DRUM.get());

                                pOutput.accept(ModBlocks.STAINED_GLASS_BLOCK.get());
                                pOutput.accept(ModBlocks.BLUE_STAINED_GLASS_BLOCK.get());
                                pOutput.accept(ModBlocks.GREEN_STAINED_GLASS_BLOCK.get());
                                pOutput.accept(ModBlocks.ORANGE_STAINED_GLASS_BLOCK.get());

                                pOutput.accept(ModBlocks.STAINED_GLASS_PANE.get());
                                pOutput.accept(ModBlocks.BLUE_STAINED_GLASS_PANE.get());
                                pOutput.accept(ModBlocks.GREEN_STAINED_GLASS_PANE.get());
                                pOutput.accept(ModBlocks.ORANGE_STAINED_GLASS_PANE.get());

                                pOutput.accept(ModBlocks.CHICKPEA_BAG.get());
                                pOutput.accept(ModBlocks.PARSLEY_BAG.get());

                                pOutput.accept(ModBlocks.WILD_CHICKPEA.get());
                                pOutput.accept(ModBlocks.WILD_PARSLEY.get());

                                pOutput.accept(ModItems.CHICKPEA.get());
                                pOutput.accept(ModItems.PARSLEY.get());
                                pOutput.accept(ModItems.PARSLEY_SEEDS.get());

                                pOutput.accept(ModItems.SMALL_DOUGH.get());
                                pOutput.accept(ModItems.BOUREK_SHEET.get());
                                pOutput.accept(ModItems.RAW_BOUREK.get());
                                pOutput.accept(ModItems.RAW_SAMOSA.get());

                                pOutput.accept(ModItems.DATE_SYRUP.get());
                                pOutput.accept(ModItems.DATE_STUFFED_COOKIE.get());
                                pOutput.accept(ModItems.MHALBIYA.get());
                                pOutput.accept(ModItems.KUNAFA.get());
                                pOutput.accept(ModItems.ZALABIYA.get());

                                pOutput.accept(ModItems.FLAT_BREAD.get());
                                pOutput.accept(ModItems.MANAKISH.get());
                                pOutput.accept(ModItems.BOUREK.get());
                                pOutput.accept(ModItems.SAMOSA.get());

                                pOutput.accept(ModItems.RAW_KEBAB.get());
                                pOutput.accept(ModItems.KEBAB.get());

                                pOutput.accept(ModItems.QUICHE.get());
                                pOutput.accept(ModItems.QUICHE_SLICE.get());

                                pOutput.accept(ModItems.HUMMUS_TAHINI.get());
                                pOutput.accept(ModItems.SAVORY_FILLING.get());
                                pOutput.accept(ModItems.SWEET_TAGINE.get());
                                pOutput.accept(ModItems.TABBOULEH.get());

                                pOutput.accept(ModItems.HARIRA.get());
                                pOutput.accept(ModItems.CHORBA.get());
                                pOutput.accept(ModItems.HALEEM.get());

                                pOutput.accept(ModItems.CHICKPEA_AND_RICE.get());
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
