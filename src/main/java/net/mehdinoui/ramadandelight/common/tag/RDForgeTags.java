package net.mehdinoui.ramadandelight.common.tag;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;

public class RDForgeTags {
    private static TagKey<Block> forgeBlockTag(String path) {
        return BlockTags.create(new ResourceLocation("forge", path));
    }
    private static TagKey<Item> forgeItemTag(String path) {
        return ItemTags.create(new ResourceLocation("forge", path));
    }
    private static TagKey<Block> rdBlockTag(String path){
        return BlockTags.create(new ResourceLocation("ramadandelight", path));
    }
    private static TagKey<Item> rdItemTag(String path){
        return ItemTags.create(new ResourceLocation("ramadandelight", path));
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
    // Palm Sapling Placeable On
    public static final TagKey<Block> PALM_PLACEABLE_ON = rdBlockTag("palm_placeable_on");


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
    public static final TagKey<Block> STORAGE_BLOCKS_CHICKPEA = forgeBlockTag("storage_blocks/chickpea");
    public static final TagKey<Block> STORAGE_BLOCKS_DATE = forgeBlockTag("storage_blocks/date");
    public static final TagKey<Block> STORAGE_BLOCKS_PARSLEY = forgeBlockTag("storage_blocks/parsley");

    // -- Items --
    // Crops
    public static final TagKey<Item> CROPS_CHICKPEA = forgeItemTag("crops/chickpea");
    public static final TagKey<Item> CROPS_PARSLEY = forgeItemTag("crops/parsley");
    // Grains
    public static final TagKey<Item> GRAIN_CHICKPEA = forgeItemTag("grain/chickpea");
    // Seeds
    public static final TagKey<Item> SEEDS_PARSLEY = forgeItemTag("seeds/parsley");
    // Storage Blocks Item
    public static final TagKey<Item> STORAGE_BLOCKS_ITEM_CHICKPEA = forgeItemTag("storage_blocks/chickpea");
    public static final TagKey<Item> STORAGE_BLOCKS_ITEM_DATE = forgeItemTag("storage_blocks/date");
    public static final TagKey<Item> STORAGE_BLOCKS_ITEM_PARSLEY = forgeItemTag("storage_blocks/parsley");
    // Tortilla
    public static final TagKey<Item> TORTILLA = forgeItemTag("tortilla");
    // Vegetables
    public static final TagKey<Item> VEGETABLES_PARSLEY= forgeItemTag("vegetables/parsley");
}