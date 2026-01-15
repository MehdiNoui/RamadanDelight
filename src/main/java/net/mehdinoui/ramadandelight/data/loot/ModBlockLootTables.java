package net.mehdinoui.ramadandelight.data.loot;

import net.mehdinoui.ramadandelight.common.registry.ModBlocks;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.storage.loot.LootTable;

import java.util.HashSet;
import java.util.Set;

public class ModBlockLootTables extends BlockLootSubProvider {
    public ModBlockLootTables(HolderLookup.Provider registries) {
        super(Set.of(), FeatureFlags.REGISTRY.allFlags(), registries);
    }

    private final Set<Block> generatedLootTables = new HashSet<>();

    @Override
    protected void add (Block block, LootTable.Builder builder){
        this.generatedLootTables.add(block);
        this.map.put(block.getLootTable(), builder);
    }

    @Override
    protected void generate () {
        this.dropSelf(ModBlocks.CHICKPEA_BAG.get());
        this.dropSelf(ModBlocks.DATE_CRATE.get());
        this.dropSelf(ModBlocks.PARSLEY_BAG.get());

        this.dropSelf(ModBlocks.DRUM_BLOCK.get());
        this.dropSelf(ModBlocks.FANOUS.get());
        this.dropSelf(ModBlocks.COPPER_FANOUS.get());
        this.dropSelf(ModBlocks.REDSTONE_FANOUS.get());
        this.dropSelf(ModBlocks.SOUL_FANOUS.get());
        this.dropSelf(ModBlocks.MOSAIC_TILES.get());

        this.dropSelf(ModBlocks.PALM_LOG.get());
        this.dropSelf(ModBlocks.STRIPPED_PALM_LOG.get());
        this.dropSelf(ModBlocks.PALM_WOOD.get());
        this.dropSelf(ModBlocks.STRIPPED_PALM_WOOD.get());

        this.dropSelf(ModBlocks.PALM_BUTTON.get());
        this.add(ModBlocks.PALM_DOOR.get(), block -> createDoorTable(block));
        this.dropSelf(ModBlocks.PALM_FENCE.get());
        this.dropSelf(ModBlocks.PALM_FENCE_GATE.get());
        this.dropSelf(ModBlocks.PALM_PLANKS.get());
        this.dropSelf(ModBlocks.PALM_PRESSURE_PLATE.get());
        this.dropSelf(ModBlocks.PALM_SAPLING.get());
        this.add(ModBlocks.PALM_SLAB.get(), block -> createSlabItemTable(block));
        this.dropSelf(ModBlocks.PALM_STAIRS.get());
        this.dropSelf(ModBlocks.PALM_TRAPDOOR.get());

        this.dropSelf(ModBlocks.PALM_SIGN.get());
        this.dropSelf(ModBlocks.PALM_HANGING_SIGN.get());
        this.add(ModBlocks.PALM_WALL_SIGN.get(), block ->
                createSingleItemTable(ModBlocks.PALM_SIGN.get()));
        this.add(ModBlocks.PALM_WALL_HANGING_SIGN.get(), block ->
                createSingleItemTable(ModBlocks.PALM_HANGING_SIGN.get()));

        this.add(ModBlocks.STAINED_GLASS_BLOCK.get(), block -> createSilkTouchOnlyTable(block));
        this.add(ModBlocks.BLUE_STAINED_GLASS_BLOCK.get(), block -> createSilkTouchOnlyTable(block));
        this.add(ModBlocks.GREEN_STAINED_GLASS_BLOCK.get(), block -> createSilkTouchOnlyTable(block));
        this.add(ModBlocks.ORANGE_STAINED_GLASS_BLOCK.get(), block -> createSilkTouchOnlyTable(block));
        this.add(ModBlocks.STAINED_GLASS_PANE.get(), block -> createSilkTouchOnlyTable(block));
        this.add(ModBlocks.BLUE_STAINED_GLASS_PANE.get(), block -> createSilkTouchOnlyTable(block));
        this.add(ModBlocks.GREEN_STAINED_GLASS_PANE.get(), block -> createSilkTouchOnlyTable(block));
        this.add(ModBlocks.ORANGE_STAINED_GLASS_PANE.get(), block -> createSilkTouchOnlyTable(block));
    }
    @Override
    protected Iterable<Block> getKnownBlocks() {
        return this.generatedLootTables;
    }
}