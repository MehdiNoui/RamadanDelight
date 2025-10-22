package net.mehdinoui.ramadandelight.datagen.tag;

import net.mehdinoui.ramadandelight.RamadanDelight;
import net.mehdinoui.ramadandelight.common.registry.ModBlocks;
import net.mehdinoui.ramadandelight.common.registry.ModItems;
import net.mehdinoui.ramadandelight.common.tag.RDForgeTags;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.ItemTagsProvider;
import net.minecraft.data.tags.TagsProvider;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.common.Tags;
import net.minecraftforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import vectorwing.farmersdelight.common.tag.ForgeTags;
import vectorwing.farmersdelight.common.tag.ModTags;

import java.util.concurrent.CompletableFuture;

public class ModItemTags extends ItemTagsProvider {

    public ModItemTags(PackOutput output, CompletableFuture<HolderLookup.Provider> provider,
                       CompletableFuture<TagsProvider.TagLookup<Block>> blockTagProvider,
                       @Nullable ExistingFileHelper existingFileHelper) {
        super(output, provider, blockTagProvider, RamadanDelight.MOD_ID, existingFileHelper);
    }

    @Override
    protected void addTags(@NotNull HolderLookup.Provider provider) {
        registerForgeTags();
        registerMinecraftTags();
        registerFarmersDelightTags();
    }

    protected void registerForgeTags() {
        // Palm Blocks Items
        tag(RDForgeTags.PALM_LOGS_ITEM).add(ModItems.PALM_LOG.get());
        tag(RDForgeTags.PALM_LOGS_ITEM).add(ModItems.PALM_WOOD.get());

        // Storage Blocks Items
        tag(RDForgeTags.STORAGE_BLOCKS_ITEM_CHICKPEA).add(ModItems.CHICKPEA_BAG.get());
        tag(RDForgeTags.STORAGE_BLOCKS_ITEM_PARSLEY).add(ModItems.PARSLEY_BAG.get());

        // Crops
        tag(Tags.Items.CROPS).addTag(RDForgeTags.CROPS_CHICKPEA);
        tag(RDForgeTags.CROPS_CHICKPEA).add(ModItems.CHICKPEA.get());

        tag(Tags.Items.CROPS).addTag(RDForgeTags.CROPS_PARSLEY);
        tag(RDForgeTags.CROPS_PARSLEY).add(ModItems.PARSLEY.get());

        // Fruits
        tag(RDForgeTags.FRUITS).addTag(RDForgeTags.FRUITS_DATE);
        tag(RDForgeTags.FRUITS_DATE).add(ModItems.DATE.get());

        // Grains
        tag(ForgeTags.GRAIN).addTag(RDForgeTags.GRAIN_CHICKPEA);
        tag(RDForgeTags.GRAIN_CHICKPEA).add(ModItems.CHICKPEA.get());

        // Seeds
        tag(Tags.Items.SEEDS).addTag(RDForgeTags.SEEDS_PARSLEY);
        tag(RDForgeTags.SEEDS_PARSLEY).add(ModItems.PARSLEY_SEEDS.get());

        // Tortilla / Bread
        tag(RDForgeTags.TORTILLA).add(ModItems.FLAT_BREAD.get());

        // Vegetables
        tag(ForgeTags.VEGETABLES).addTag(RDForgeTags.VEGETABLES_PARSLEY);
        tag(RDForgeTags.VEGETABLES_PARSLEY).add(ModItems.PARSLEY.get());
        // Glass Blocks
        tag(Tags.Items.GLASS_COLORLESS).add(ModItems.STAINED_GLASS_BLOCK.get());
        tag(Tags.Items.GLASS_BLUE).add(ModItems.BLUE_STAINED_GLASS_BLOCK.get());
        tag(Tags.Items.GLASS_GREEN).add(ModItems.GREEN_STAINED_GLASS_BLOCK.get());
        tag(Tags.Items.GLASS_ORANGE).add(ModItems.ORANGE_STAINED_GLASS_BLOCK.get());
        // Glass Panes
        tag(Tags.Items.GLASS_PANES_COLORLESS).add(ModItems.STAINED_GLASS_PANE.get());
        tag(Tags.Items.GLASS_PANES_BLUE).add(ModItems.BLUE_STAINED_GLASS_PANE.get());
        tag(Tags.Items.GLASS_PANES_GREEN).add(ModItems.GREEN_STAINED_GLASS_PANE.get());
        tag(Tags.Items.GLASS_PANES_ORANGE).add(ModItems.ORANGE_STAINED_GLASS_PANE.get());
    }

    protected void registerMinecraftTags() {
        // Boats
        tag(ItemTags.BOATS).add(ModItems.PALM_BOAT.get());
        tag(ItemTags.CHEST_BOATS).add(ModItems.PALM_CHEST_BOAT.get());
        // Fences and Gates
        tag(ItemTags.FENCES).add(ModItems.PALM_FENCE.get());
        tag(ItemTags.FENCE_GATES).add(ModItems.PALM_FENCE_GATE.get());
        // Hanging Signs
        tag(ItemTags.HANGING_SIGNS).add(ModItems.PALM_HANGING_SIGN.get());
        // Leaves, Logs, Planks
        tag(ItemTags.LEAVES).add(ModItems.PALM_LEAVES.get());
        tag(ItemTags.LOGS_THAT_BURN).add(ModItems.PALM_LOG.get());
        tag(ItemTags.PLANKS).add(ModItems.PALM_PLANKS.get());
        // Piglin Repellents
        tag(ItemTags.PIGLIN_REPELLENTS).add(ModItems.SOUL_FANOUS.get());
        // Saplings
        tag(ItemTags.SAPLINGS).add(ModItems.PALM_SAPLING.get());
        // Signs
        tag(ItemTags.SIGNS).add(ModItems.PALM_SIGN.get());
        // Small Flowers (wild crops)
        tag(ItemTags.SMALL_FLOWERS).add(ModItems.WILD_CHICKPEA.get(), ModItems.WILD_PARSLEY.get());
        // Villager Plantable Seeds
        tag(ItemTags.VILLAGER_PLANTABLE_SEEDS)
                .add(ModItems.CHICKPEA.get(), ModItems.PARSLEY_SEEDS.get());
        // Wooden components
        tag(ItemTags.WOODEN_BUTTONS).add(ModItems.PALM_BUTTON.get());
        tag(ItemTags.WOODEN_DOORS).add(ModItems.PALM_DOOR.get());
        tag(ItemTags.WOODEN_FENCES).add(ModItems.PALM_FENCE.get());
        tag(ItemTags.WOODEN_PRESSURE_PLATES).add(ModItems.PALM_PRESSURE_PLATE.get());
        tag(ItemTags.WOODEN_STAIRS).add(ModItems.PALM_STAIRS.get());
        tag(ItemTags.WOODEN_SLABS).add(ModItems.PALM_SLAB.get());
        tag(ItemTags.WOODEN_TRAPDOORS).add(ModItems.PALM_TRAPDOOR.get());
    }

    protected void registerFarmersDelightTags() {
        // Drinks
        tag(ModTags.DRINKS).add(ModItems.DATE_SYRUP.get());
        // Meals
        tag(ModTags.MEALS).add(
                ModItems.KUNAFA.get(),
                ModItems.LUQAIMAT.get(),
                ModItems.HUMMUS_TAHINI.get(),
                ModItems.SAVORY_FILLING.get(),
                ModItems.SWEET_TAGINE.get(),
                ModItems.TABBOULEH.get(),
                ModItems.HARIRA.get(),
                ModItems.CHORBA.get(),
                ModItems.HALEEM.get(),
                ModItems.CHICKPEA_AND_RICE.get(),
                ModItems.SAYADIEH.get(),
                ModItems.TAGINE.get(),
                ModItems.MAKLOBA.get()
        );
        // Feasts
        tag(ModTags.FEASTS).add(ModItems.MAKLOBA_BLOCK.get(), ModItems.BOUREK_BLOCK.get());
        // Wild Crops
        tag(ModTags.WILD_CROPS_ITEM).add(ModItems.WILD_CHICKPEA.get(), ModItems.WILD_PARSLEY.get());
    }
}
