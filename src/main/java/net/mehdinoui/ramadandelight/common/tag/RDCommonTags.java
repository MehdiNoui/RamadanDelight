package net.mehdinoui.ramadandelight.common.tag;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;

public class RDCommonTags {
    private static TagKey<Block> commonBlockTag(String path) {
        return BlockTags.create(ResourceLocation.fromNamespaceAndPath("c", path));
    }
    private static TagKey<Item> commonItemTag(String path) {
        return ItemTags.create(ResourceLocation.fromNamespaceAndPath("c", path));
    }
    private static TagKey<Block> rdBlockTag(String path){
        return BlockTags.create(ResourceLocation.fromNamespaceAndPath("ramadandelight", path));
    }
    private static TagKey<Item> rdItemTag(String path){
        return ItemTags.create(ResourceLocation.fromNamespaceAndPath("ramadandelight", path));
    }

    // ------ Ramadan Delight Tags ------
    // -- Blocks --
    // Fanous
    public static final TagKey<Block> FANOUS_BLOCKS = rdBlockTag("fanous");
    // Stained Glass
    public static final TagKey<Block> STAINED_GLASS_BLOCKS = rdBlockTag("stained_glass_blocks");
    // Stained Glass Panes
    public static final TagKey<Block> STAINED_GLASS_PANES_BLOCKS = rdBlockTag("stained_glass_panes");
    // Palm Logs
    public static final TagKey<Block> PALM_LOGS = rdBlockTag("palm_logs");

    // -- Items --
    // Fanous
    public static final TagKey<Item> FANOUS_ITEM = rdItemTag("fanous");
    // Stained Glass
    public static final TagKey<Item> STAINED_GLASS_BLOCKS_ITEM = rdItemTag("stained_glass_blocks");
    // Stained Glass Panes
    public static final TagKey<Item> STAINED_GLASS_PANES_ITEM = rdItemTag("stained_glass_panes");
    // Palm Logs
    public static final TagKey<Item> PALM_LOGS_ITEM = rdItemTag("palm_logs");


    // ------ Forge Tags ------
    // -- Blocks --
    // Storage Blocks
    public static final TagKey<Block> STORAGE_BLOCKS_CHICKPEA = commonBlockTag("storage_blocks/chickpea");
    public static final TagKey<Block> STORAGE_BLOCKS_DATE = commonBlockTag("storage_blocks/date");
    public static final TagKey<Block> STORAGE_BLOCKS_PARSLEY = commonBlockTag("storage_blocks/parsley");

    // -- Items --
    // Crops
    public static final TagKey<Item> CROPS_CHICKPEA = commonItemTag("crops/chickpea");
    public static final TagKey<Item> CROPS_PARSLEY = commonItemTag("crops/parsley");
    // Grains
    public static final TagKey<Item> GRAIN_CHICKPEA = commonItemTag("grain/chickpea");
    // Seeds
    public static final TagKey<Item> SEEDS_PARSLEY = commonItemTag("seeds/parsley");
    // Storage Blocks Item
    public static final TagKey<Item> STORAGE_BLOCKS_ITEM_CHICKPEA = commonItemTag("storage_blocks/chickpea");
    public static final TagKey<Item> STORAGE_BLOCKS_ITEM_DATE = commonItemTag("storage_blocks/date");
    public static final TagKey<Item> STORAGE_BLOCKS_ITEM_PARSLEY = commonItemTag("storage_blocks/parsley");
    // Tortilla
    public static final TagKey<Item> TORTILLA = commonItemTag("tortilla");
    // Vegetables
    public static final TagKey<Item> VEGETABLES_PARSLEY= commonItemTag("vegetables/parsley");
}