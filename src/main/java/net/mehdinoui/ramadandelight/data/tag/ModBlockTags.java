package net.mehdinoui.ramadandelight.data.tag;

import net.mehdinoui.ramadandelight.RamadanDelight;
import net.mehdinoui.ramadandelight.common.registry.ModBlocks;
import net.mehdinoui.ramadandelight.common.tag.RDForgeTags;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.tags.BlockTags;
import net.minecraftforge.common.Tags;
import net.minecraftforge.common.data.BlockTagsProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import vectorwing.farmersdelight.common.tag.ModTags;

import java.util.concurrent.CompletableFuture;

public class ModBlockTags extends BlockTagsProvider {
    public ModBlockTags(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, @Nullable ExistingFileHelper existingFileHelper) {
        super(output, lookupProvider, RamadanDelight.MOD_ID, existingFileHelper);
    }

    @Override
    protected void addTags(@NotNull HolderLookup.Provider provider) {
        registerForgeTags();
        registerMinecraftTags();
        registerFarmersDelightTags();
        registerRamadanDelightTags();
    }

    protected void registerForgeTags() {
        // Storage Blocks
        tag(RDForgeTags.STORAGE_BLOCKS_CHICKPEA).add(ModBlocks.CHICKPEA_BAG.get());
        tag(RDForgeTags.STORAGE_BLOCKS_DATE).add(ModBlocks.DATE_CRATE.get());
        tag(RDForgeTags.STORAGE_BLOCKS_PARSLEY).add(ModBlocks.PARSLEY_BAG.get());
        // Glass Blocks
        tag(Tags.Blocks.GLASS_COLORLESS).add(ModBlocks.STAINED_GLASS_BLOCK.get());
        tag(Tags.Blocks.GLASS_BLUE).add(ModBlocks.BLUE_STAINED_GLASS_BLOCK.get());
        tag(Tags.Blocks.GLASS_GREEN).add(ModBlocks.GREEN_STAINED_GLASS_BLOCK.get());
        tag(Tags.Blocks.GLASS_ORANGE).add(ModBlocks.ORANGE_STAINED_GLASS_BLOCK.get());
        // Glass Panes
        tag(Tags.Blocks.GLASS_PANES_COLORLESS).add(ModBlocks.STAINED_GLASS_PANE.get());
        tag(Tags.Blocks.GLASS_PANES_BLUE).add(ModBlocks.BLUE_STAINED_GLASS_PANE.get());
        tag(Tags.Blocks.GLASS_PANES_GREEN).add(ModBlocks.GREEN_STAINED_GLASS_PANE.get());
        tag(Tags.Blocks.GLASS_PANES_ORANGE).add(ModBlocks.ORANGE_STAINED_GLASS_PANE.get());
        // Stained Glasses
        tag(Tags.Blocks.STAINED_GLASS).add(
                ModBlocks.BLUE_STAINED_GLASS_BLOCK.get(),
                ModBlocks.GREEN_STAINED_GLASS_BLOCK.get(),
                ModBlocks.ORANGE_STAINED_GLASS_BLOCK.get()
        );
        tag(Tags.Blocks.STAINED_GLASS_PANES).add(
                ModBlocks.BLUE_STAINED_GLASS_PANE.get(),
                ModBlocks.GREEN_STAINED_GLASS_PANE.get(),
                ModBlocks.ORANGE_STAINED_GLASS_PANE.get()
        );
        // General silica-based glass grouping
        tag(Tags.Blocks.GLASS_SILICA).add(
                ModBlocks.STAINED_GLASS_BLOCK.get(),
                ModBlocks.BLUE_STAINED_GLASS_BLOCK.get(),
                ModBlocks.GREEN_STAINED_GLASS_BLOCK.get(),
                ModBlocks.ORANGE_STAINED_GLASS_BLOCK.get()
        );
        // Wooden Fences & Gates
        tag(Tags.Blocks.FENCES_WOODEN).add(ModBlocks.PALM_FENCE.get());
        tag(Tags.Blocks.FENCE_GATES_WOODEN).add(ModBlocks.PALM_FENCE_GATE.get());

    }
    protected void registerMinecraftTags() {
        // Logs & Leaves
        tag(BlockTags.LOGS).add(ModBlocks.PALM_LOG.get());
        tag(BlockTags.LOGS_THAT_BURN).add(ModBlocks.PALM_LOG.get());
        tag(BlockTags.LEAVES).add(ModBlocks.PALM_LEAVES.get());
        // Crops
        tag(BlockTags.CROPS).add(
                ModBlocks.CHICKPEA_CROP.get(),
                ModBlocks.PARSLEY_CROP.get()
        );
        tag(BlockTags.MAINTAINS_FARMLAND).add(
                ModBlocks.CHICKPEA_CROP.get(),
                ModBlocks.PARSLEY_CROP.get()
        );
        // Palm Wood
        tag(BlockTags.PLANKS).add(ModBlocks.PALM_PLANKS.get());
        tag(BlockTags.WOODEN_STAIRS).add(ModBlocks.PALM_STAIRS.get());
        tag(BlockTags.WOODEN_SLABS).add(ModBlocks.PALM_SLAB.get());
        tag(BlockTags.WOODEN_FENCES).add(ModBlocks.PALM_FENCE.get());
        tag(BlockTags.FENCE_GATES).add(ModBlocks.PALM_FENCE_GATE.get());
        tag(BlockTags.WOODEN_DOORS).add(ModBlocks.PALM_DOOR.get());
        tag(BlockTags.WOODEN_TRAPDOORS).add(ModBlocks.PALM_TRAPDOOR.get());
        tag(BlockTags.WOODEN_BUTTONS).add(ModBlocks.PALM_BUTTON.get());
        tag(BlockTags.WOODEN_PRESSURE_PLATES).add(ModBlocks.PALM_PRESSURE_PLATE.get());
        // Miscellaneous
        tag(BlockTags.SAPLINGS).add(ModBlocks.PALM_SAPLING.get());
        tag(BlockTags.SMALL_FLOWERS).add(
                ModBlocks.WILD_CHICKPEA.get(),
                ModBlocks.WILD_PARSLEY.get()
        );
        // Mineable tags
        tag(BlockTags.MINEABLE_WITH_AXE).add(
                ModBlocks.DATE_CRATE.get(),
                ModBlocks.DRUM_BLOCK.get(),
                ModBlocks.PALM_LOG.get(),
                ModBlocks.PALM_WOOD.get(),
                ModBlocks.STRIPPED_PALM_LOG.get(),
                ModBlocks.STRIPPED_PALM_WOOD.get(),
                ModBlocks.PALM_PLANKS.get(),
                ModBlocks.PALM_STAIRS.get(),
                ModBlocks.PALM_SLAB.get(),
                ModBlocks.PALM_FENCE.get(),
                ModBlocks.PALM_FENCE_GATE.get(),
                ModBlocks.PALM_DOOR.get(),
                ModBlocks.PALM_TRAPDOOR.get(),
                ModBlocks.PALM_BUTTON.get(),
                ModBlocks.PALM_PRESSURE_PLATE.get(),
                ModBlocks.PALM_SIGN.get(),
                ModBlocks.PALM_WALL_SIGN.get(),
                ModBlocks.PALM_HANGING_SIGN.get(),
                ModBlocks.PALM_WALL_HANGING_SIGN.get()
        );
        tag(BlockTags.MINEABLE_WITH_PICKAXE).add(
                ModBlocks.FANOUS.get(),
                ModBlocks.COPPER_FANOUS.get(),
                ModBlocks.REDSTONE_FANOUS.get(),
                ModBlocks.SOUL_FANOUS.get(),
                ModBlocks.MOSAIC_TILES.get()
        );
        tag(BlockTags.MINEABLE_WITH_HOE).add(
                ModBlocks.DATES_BRANCH.get(),
                ModBlocks.PALM_LEAVES.get()
        );
        // Repellents
        tag(BlockTags.PIGLIN_REPELLENTS).add(ModBlocks.SOUL_FANOUS.get());
        tag(BlockTags.HOGLIN_REPELLENTS).add(ModBlocks.SOUL_FANOUS.get());
        // Tool level
        tag(BlockTags.NEEDS_STONE_TOOL).add(
                ModBlocks.FANOUS.get(),
                ModBlocks.COPPER_FANOUS.get(),
                ModBlocks.REDSTONE_FANOUS.get(),
                ModBlocks.SOUL_FANOUS.get(),
                ModBlocks.MOSAIC_TILES.get()
        );
    }
    protected void registerFarmersDelightTags() {
        // Mineable With Knife
        tag(ModTags.MINEABLE_WITH_KNIFE).add(ModBlocks.QUICHE.get());
        // Straw Blocks
        tag(ModTags.STRAW_BLOCKS).add(
                ModBlocks.CHICKPEA_BAG.get(),
                ModBlocks.PARSLEY_BAG.get()
        );
        // Wild Crops
        tag(ModTags.WILD_CROPS).add(
                ModBlocks.WILD_CHICKPEA.get(),
                ModBlocks.WILD_PARSLEY.get()
        );
    }
    protected void registerRamadanDelightTags() {
        tag(RDForgeTags.FANOUS_BLOCKS).add(
                ModBlocks.FANOUS.get(),
                ModBlocks.COPPER_FANOUS.get(),
                ModBlocks.REDSTONE_FANOUS.get(),
                ModBlocks.SOUL_FANOUS.get()
        );
        tag(RDForgeTags.STAINED_GLASS_BLOCKS).add(
                ModBlocks.STAINED_GLASS_BLOCK.get(),
                ModBlocks.BLUE_STAINED_GLASS_BLOCK.get(),
                ModBlocks.GREEN_STAINED_GLASS_BLOCK.get(),
                ModBlocks.ORANGE_STAINED_GLASS_BLOCK.get()
        );
        tag(RDForgeTags.STAINED_GLASS_PANES_BLOCKS).add(
                ModBlocks.STAINED_GLASS_PANE.get(),
                ModBlocks.BLUE_STAINED_GLASS_PANE.get(),
                ModBlocks.GREEN_STAINED_GLASS_PANE.get(),
                ModBlocks.ORANGE_STAINED_GLASS_PANE.get()
        );
        tag(RDForgeTags.PALM_LOGS).add(
                ModBlocks.PALM_LOG.get(),
                ModBlocks.PALM_WOOD.get(),
                ModBlocks.STRIPPED_PALM_LOG.get(),
                ModBlocks.STRIPPED_PALM_WOOD.get()
        );
        tag(RDForgeTags.PALM_PLACEABLE_ON)
                .addTag(Tags.Blocks.SAND)
                .addTag(net.minecraft.tags.BlockTags.DIRT);
    }
}
