package net.mehdinoui.ramadandelight.data.tag;

import net.mehdinoui.ramadandelight.RamadanDelight;
import net.mehdinoui.ramadandelight.common.registry.ModBlocks;
import net.mehdinoui.ramadandelight.common.tag.RDCommonTags;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.common.Tags;
import net.neoforged.neoforge.common.data.BlockTagsProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import vectorwing.farmersdelight.common.tag.ModTags;

import java.util.concurrent.CompletableFuture;

public class BlockTags extends BlockTagsProvider {
    public BlockTags(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, @Nullable ExistingFileHelper existingFileHelper) {
        super(output, lookupProvider, RamadanDelight.MOD_ID, existingFileHelper);
    }

    @Override
    protected void addTags(@NotNull HolderLookup.Provider provider) {
        registerCommonTags();
        registerMinecraftTags();
        registerFarmersDelightTags();
        registerRamadanDelightTags();
    }

    protected void registerCommonTags() {
        // Storage Blocks
        tag(RDCommonTags.STORAGE_BLOCKS_CHICKPEA).add(ModBlocks.CHICKPEA_BAG.get());
        tag(RDCommonTags.STORAGE_BLOCKS_DATE).add(ModBlocks.DATE_CRATE.get());
        tag(RDCommonTags.STORAGE_BLOCKS_PARSLEY).add(ModBlocks.PARSLEY_BAG.get());
        tag(Tags.Blocks.STORAGE_BLOCKS)
                .addTag(RDCommonTags.STORAGE_BLOCKS_CHICKPEA)
                .addTag(RDCommonTags.STORAGE_BLOCKS_DATE)
                .addTag(RDCommonTags.STORAGE_BLOCKS_PARSLEY);
        // Dyed Blocks
        tag(Tags.Blocks.DYED_BLUE)
                .add(ModBlocks.BLUE_STAINED_GLASS_BLOCK.get())
                .add(ModBlocks.BLUE_STAINED_GLASS_PANE.get());
        tag(Tags.Blocks.DYED_GREEN)
                .add(ModBlocks.GREEN_STAINED_GLASS_BLOCK.get())
                .add(ModBlocks.GREEN_STAINED_GLASS_PANE.get());
        tag(Tags.Blocks.DYED_ORANGE)
                .add(ModBlocks.ORANGE_STAINED_GLASS_BLOCK.get())
                .add(ModBlocks.ORANGE_STAINED_GLASS_PANE.get());
        // Fences
        tag(Tags.Blocks.FENCES_WOODEN).add(ModBlocks.PALM_FENCE.get());
        tag(Tags.Blocks.FENCE_GATES_WOODEN).add(ModBlocks.PALM_FENCE_GATE.get());
        // Logs
        tag(Tags.Blocks.STRIPPED_LOGS).add(ModBlocks.STRIPPED_PALM_LOG.get());
        tag(Tags.Blocks.STRIPPED_WOODS).add(ModBlocks.STRIPPED_PALM_WOOD.get());
        // Glass Blocks
        tag(Tags.Blocks.GLASS_BLOCKS_COLORLESS).add(ModBlocks.STAINED_GLASS_BLOCK.get());
        tag(Tags.Blocks.GLASS_BLOCKS).add(ModBlocks.BLUE_STAINED_GLASS_BLOCK.get());
        tag(Tags.Blocks.GLASS_BLOCKS).add(ModBlocks.GREEN_STAINED_GLASS_BLOCK.get());
        tag(Tags.Blocks.GLASS_BLOCKS).add(ModBlocks.ORANGE_STAINED_GLASS_BLOCK.get());
        // Glass Panes
        tag(Tags.Blocks.GLASS_PANES_COLORLESS).add(ModBlocks.STAINED_GLASS_PANE.get());
        tag(Tags.Blocks.GLASS_PANES).add(ModBlocks.BLUE_STAINED_GLASS_PANE.get());
        tag(Tags.Blocks.GLASS_PANES).add(ModBlocks.GREEN_STAINED_GLASS_PANE.get());
        tag(Tags.Blocks.GLASS_PANES).add(ModBlocks.ORANGE_STAINED_GLASS_PANE.get());
        // Wooden Fences & Gates
        tag(Tags.Blocks.FENCES_WOODEN).add(ModBlocks.PALM_FENCE.get());
        tag(Tags.Blocks.FENCE_GATES_WOODEN).add(ModBlocks.PALM_FENCE_GATE.get());
    }
    protected void registerMinecraftTags() {
        // Logs & Leaves
        tag(net.minecraft.tags.BlockTags.LOGS).addTag(RDCommonTags.PALM_LOGS);
        tag(net.minecraft.tags.BlockTags.LOGS_THAT_BURN).addTag(RDCommonTags.PALM_LOGS);
        tag(net.minecraft.tags.BlockTags.LEAVES).add(ModBlocks.PALM_LEAVES.get());
        tag(net.minecraft.tags.BlockTags.OVERWORLD_NATURAL_LOGS).add(ModBlocks.PALM_LOG.get());
        tag(net.minecraft.tags.BlockTags.SNAPS_GOAT_HORN).addTag(RDCommonTags.PALM_LOGS);
        // Crops
        tag(net.minecraft.tags.BlockTags.CROPS).add(
                ModBlocks.CHICKPEA_CROP.get(),
                ModBlocks.PARSLEY_CROP.get()
        );
        tag(net.minecraft.tags.BlockTags.MAINTAINS_FARMLAND).add(
                ModBlocks.CHICKPEA_CROP.get(),
                ModBlocks.PARSLEY_CROP.get()
        );
        // Palm Wood
        tag(net.minecraft.tags.BlockTags.PLANKS).add(ModBlocks.PALM_PLANKS.get());
        tag(net.minecraft.tags.BlockTags.WOODEN_STAIRS).add(ModBlocks.PALM_STAIRS.get());
        tag(net.minecraft.tags.BlockTags.WOODEN_SLABS).add(ModBlocks.PALM_SLAB.get());
        tag(net.minecraft.tags.BlockTags.WOODEN_FENCES).add(ModBlocks.PALM_FENCE.get());
        tag(net.minecraft.tags.BlockTags.FENCE_GATES).add(ModBlocks.PALM_FENCE_GATE.get());
        tag(net.minecraft.tags.BlockTags.WOODEN_DOORS).add(ModBlocks.PALM_DOOR.get());
        tag(net.minecraft.tags.BlockTags.WOODEN_TRAPDOORS).add(ModBlocks.PALM_TRAPDOOR.get());
        tag(net.minecraft.tags.BlockTags.WOODEN_BUTTONS).add(ModBlocks.PALM_BUTTON.get());
        tag(net.minecraft.tags.BlockTags.WOODEN_PRESSURE_PLATES).add(ModBlocks.PALM_PRESSURE_PLATE.get());
        // Signs
        tag(net.minecraft.tags.BlockTags.SIGNS).add(ModBlocks.PALM_SIGN.get());
        tag(net.minecraft.tags.BlockTags.STANDING_SIGNS).add(ModBlocks.PALM_SIGN.get());
        tag(net.minecraft.tags.BlockTags.WALL_SIGNS).add(ModBlocks.PALM_WALL_SIGN.get());
        tag(net.minecraft.tags.BlockTags.CEILING_HANGING_SIGNS).add(ModBlocks.PALM_HANGING_SIGN.get());
        tag(net.minecraft.tags.BlockTags.WALL_HANGING_SIGNS).add(ModBlocks.PALM_WALL_HANGING_SIGN.get());
        // Miscellaneous
        tag(net.minecraft.tags.BlockTags.SAPLINGS).add(ModBlocks.PALM_SAPLING.get());
        tag(net.minecraft.tags.BlockTags.SMALL_FLOWERS).add(
                ModBlocks.WILD_CHICKPEA.get(),
                ModBlocks.WILD_PARSLEY.get()
        );
        // Mine-able tags
        tag(net.minecraft.tags.BlockTags.MINEABLE_WITH_AXE).add(
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
        tag(net.minecraft.tags.BlockTags.MINEABLE_WITH_PICKAXE).add(
                ModBlocks.FANOUS.get(),
                ModBlocks.COPPER_FANOUS.get(),
                ModBlocks.REDSTONE_FANOUS.get(),
                ModBlocks.SOUL_FANOUS.get(),
                ModBlocks.MOSAIC_TILES.get()
        );
        tag(net.minecraft.tags.BlockTags.MINEABLE_WITH_HOE).add(
                ModBlocks.DATES_BRANCH.get(),
                ModBlocks.PALM_LEAVES.get()
        );
        // Repellents
        tag(net.minecraft.tags.BlockTags.PIGLIN_REPELLENTS).add(ModBlocks.SOUL_FANOUS.get());
        tag(net.minecraft.tags.BlockTags.HOGLIN_REPELLENTS).add(ModBlocks.SOUL_FANOUS.get());
        // Tool level
        tag(net.minecraft.tags.BlockTags.NEEDS_STONE_TOOL).add(
                ModBlocks.FANOUS.get(),
                ModBlocks.COPPER_FANOUS.get(),
                ModBlocks.REDSTONE_FANOUS.get(),
                ModBlocks.SOUL_FANOUS.get(),
                ModBlocks.MOSAIC_TILES.get()
        );
    }
    protected void registerFarmersDelightTags() {
        // Mine-able With Knife
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
        tag(RDCommonTags.FANOUS_BLOCKS).add(
                ModBlocks.FANOUS.get(),
                ModBlocks.COPPER_FANOUS.get(),
                ModBlocks.REDSTONE_FANOUS.get(),
                ModBlocks.SOUL_FANOUS.get()
        );
        tag(RDCommonTags.STAINED_GLASS_BLOCKS).add(
                ModBlocks.STAINED_GLASS_BLOCK.get(),
                ModBlocks.BLUE_STAINED_GLASS_BLOCK.get(),
                ModBlocks.GREEN_STAINED_GLASS_BLOCK.get(),
                ModBlocks.ORANGE_STAINED_GLASS_BLOCK.get()
        );
        tag(RDCommonTags.STAINED_GLASS_PANES_BLOCKS).add(
                ModBlocks.STAINED_GLASS_PANE.get(),
                ModBlocks.BLUE_STAINED_GLASS_PANE.get(),
                ModBlocks.GREEN_STAINED_GLASS_PANE.get(),
                ModBlocks.ORANGE_STAINED_GLASS_PANE.get()
        );
        tag(RDCommonTags.PALM_LOGS).add(
                ModBlocks.PALM_LOG.get(),
                ModBlocks.PALM_WOOD.get(),
                ModBlocks.STRIPPED_PALM_LOG.get(),
                ModBlocks.STRIPPED_PALM_WOOD.get()
        );
        tag(RDCommonTags.PALM_PLACEABLE_ON)
                .addTag(Tags.Blocks.SANDS)
                .addTag(net.minecraft.tags.BlockTags.DIRT);
    }
}
