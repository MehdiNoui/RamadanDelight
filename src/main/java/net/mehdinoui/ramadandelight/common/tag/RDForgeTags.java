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

    // -- Blocks --
    // Palm Logs Blocks
    public static final TagKey<Block> PALM_LOGS = forgeBlockTag("palm_logs");
    // Storage Blocks
    public static final TagKey<Block> STORAGE_BLOCKS_CHICKPEA = forgeBlockTag("storage_blocks/chickpea");
    public static final TagKey<Block> STORAGE_BLOCKS_PARSLEY = forgeBlockTag("storage_blocks/parsley");

    // -- Items --
    // Crops
    public static final TagKey<Item> CROPS_CHICKPEA = forgeItemTag("crops/chickpea");
    public static final TagKey<Item> CROPS_PARSLEY = forgeItemTag("crops/parsley");
    // Fruits
    public static final TagKey<Item> FRUITS = forgeItemTag("fruits");
    public static final TagKey<Item> FRUITS_DATE = forgeItemTag("fruits/date");
    // Grains
    public static final TagKey<Item> GRAIN_CHICKPEA = forgeItemTag("grain/chickpea");
    // Palm Logs Items
    public static final TagKey<Item> PALM_LOGS_ITEM  = forgeItemTag("palm_logs");
    // Seeds
    public static final TagKey<Item> SEEDS_PARSLEY = forgeItemTag("seeds/parsley");
    // Storage Item Blocks
    public static final TagKey<Item> STORAGE_BLOCKS_ITEM_CHICKPEA = forgeItemTag("storage_blocks/chickpea");
    public static final TagKey<Item> STORAGE_BLOCKS_ITEM_PARSLEY = forgeItemTag("storage_blocks/parsley");
    // Tortilla
    public static final TagKey<Item> TORTILLA = forgeItemTag("tortilla");
    // Vegetables
    public static final TagKey<Item> VEGETABLES_PARSLEY= forgeItemTag("vegetables/parsley");
}