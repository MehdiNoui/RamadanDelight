package net.mehdinoui.ramadandelight.datagen.recipe;

import net.mehdinoui.ramadandelight.RamadanDelight;
import net.mehdinoui.ramadandelight.common.registry.ModItems;
import net.mehdinoui.ramadandelight.common.tag.RDForgeTags;
import net.minecraft.data.recipes.FinishedRecipe;
import net.minecraft.data.recipes.RecipeCategory;
import net.minecraft.data.recipes.ShapedRecipeBuilder;
import net.minecraft.data.recipes.ShapelessRecipeBuilder;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraftforge.common.Tags;
import vectorwing.farmersdelight.common.tag.ForgeTags;

import java.util.function.Consumer;
import java.util.stream.Stream;

import static net.minecraft.advancements.critereon.InventoryChangeTrigger.TriggerInstance.hasItems;

public class ModBasicRecipes {
    public static void register(Consumer<FinishedRecipe> consumer) {
        compatRecipes(consumer);
        palmRecipes(consumer);
        shapefulRecipes(consumer);
        shapelessRecipes(consumer);
    }
    public static void palmRecipes(Consumer<FinishedRecipe> consumer) {
        // Palm Planks (Shapeless)
        ShapelessRecipeBuilder.shapeless(RecipeCategory.BUILDING_BLOCKS, ModItems.PALM_PLANKS.get(), 4)
                .requires(RDForgeTags.PALM_LOGS_ITEM)
                .unlockedBy("has_palm_log", hasItems(ModItems.PALM_LOG.get(), ModItems.PALM_WOOD.get()))
                .save(consumer, new ResourceLocation(RamadanDelight.MOD_ID, "palm_planks"));

        // Palm Wood (Shaped)
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, ModItems.PALM_WOOD.get(), 3)
                .pattern("##")
                .pattern("##")
                .define('#', ModItems.PALM_LOG.get())
                .unlockedBy("has_palm_log", hasItems(ModItems.PALM_LOG.get()))
                .save(consumer, new ResourceLocation(RamadanDelight.MOD_ID, "palm_wood"));

        // Palm Slab (Shaped)
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, ModItems.PALM_SLAB.get(), 6)
                .pattern("###")
                .define('#', ModItems.PALM_PLANKS.get())
                .unlockedBy("has_palm_planks", hasItems(ModItems.PALM_PLANKS.get()))
                .save(consumer, new ResourceLocation(RamadanDelight.MOD_ID, "palm_slab"));

        // Palm Stairs (Shaped)
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, ModItems.PALM_STAIRS.get(), 4)
                .pattern("#  ")
                .pattern("## ")
                .pattern("###")
                .define('#', ModItems.PALM_PLANKS.get())
                .unlockedBy("has_palm_planks", hasItems(ModItems.PALM_PLANKS.get()))
                .save(consumer, new ResourceLocation(RamadanDelight.MOD_ID, "palm_stairs"));

        // Palm Trapdoor (Shaped)
        ShapedRecipeBuilder.shaped(RecipeCategory.REDSTONE, ModItems.PALM_TRAPDOOR.get(), 2)
                .pattern("###")
                .pattern("###")
                .define('#', ModItems.PALM_PLANKS.get())
                .unlockedBy("has_palm_planks", hasItems(ModItems.PALM_PLANKS.get()))
                .save(consumer, new ResourceLocation(RamadanDelight.MOD_ID, "palm_trapdoor"));

        // Palm Door (Shaped)
        ShapedRecipeBuilder.shaped(RecipeCategory.REDSTONE, ModItems.PALM_DOOR.get(), 3)
                .pattern("##")
                .pattern("##")
                .pattern("##")
                .define('#', ModItems.PALM_PLANKS.get())
                .unlockedBy("has_palm_planks", hasItems(ModItems.PALM_PLANKS.get()))
                .save(consumer, new ResourceLocation(RamadanDelight.MOD_ID, "palm_door"));

        // Palm Fence (Shaped)
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.PALM_FENCE.get(), 3)
                .pattern("W#W")
                .pattern("W#W")
                .define('W', ModItems.PALM_PLANKS.get())
                .define('#', Items.STICK)
                .unlockedBy("has_palm_planks", hasItems(ModItems.PALM_PLANKS.get()))
                .save(consumer, new ResourceLocation(RamadanDelight.MOD_ID, "palm_fence"));

        // Palm Fence Gate (Shaped)
        ShapedRecipeBuilder.shaped(RecipeCategory.REDSTONE, ModItems.PALM_FENCE_GATE.get(), 1)
                .pattern("#W#")
                .pattern("#W#")
                .define('W', ModItems.PALM_PLANKS.get())
                .define('#', Items.STICK)
                .unlockedBy("has_palm_planks", hasItems(ModItems.PALM_PLANKS.get()))
                .save(consumer, new ResourceLocation(RamadanDelight.MOD_ID, "palm_fence_gate"));

        // Palm Pressure Plate (Shaped)
        ShapedRecipeBuilder.shaped(RecipeCategory.REDSTONE, ModItems.PALM_PRESSURE_PLATE.get(), 1)
                .pattern("##")
                .define('#', ModItems.PALM_PLANKS.get())
                .unlockedBy("has_palm_planks", hasItems(ModItems.PALM_PLANKS.get()))
                .save(consumer, new ResourceLocation(RamadanDelight.MOD_ID, "palm_pressure_plate"));

        // Palm Button (Shapeless)
        ShapelessRecipeBuilder.shapeless(RecipeCategory.REDSTONE, ModItems.PALM_BUTTON.get(), 1)
                .requires(ModItems.PALM_PLANKS.get())
                .unlockedBy("has_palm_planks", hasItems(ModItems.PALM_PLANKS.get()))
                .save(consumer, new ResourceLocation(RamadanDelight.MOD_ID, "palm_button"));

        // Palm Sign (Shaped)
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.PALM_SIGN.get(), 3)
                .pattern("###")
                .pattern("###")
                .pattern(" X ")
                .define('#', ModItems.PALM_PLANKS.get())
                .define('X', Items.STICK)
                .unlockedBy("has_palm_planks", hasItems(ModItems.PALM_PLANKS.get()))
                .save(consumer, new ResourceLocation(RamadanDelight.MOD_ID, "palm_sign"));

        // Palm Hanging Sign (Shaped)
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.PALM_HANGING_SIGN.get(), 6)
                .pattern("X X")
                .pattern("###")
                .pattern("###")
                .define('#', ModItems.STRIPPED_PALM_LOG.get())
                .define('X', Items.CHAIN)
                .unlockedBy("has_stripped_palm_log", hasItems(ModItems.STRIPPED_PALM_LOG.get()))
                .save(consumer, new ResourceLocation(RamadanDelight.MOD_ID, "palm_hanging_sign"));

        // Palm Boat (Shaped)
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.PALM_BOAT.get(), 1)
                .pattern("# #")
                .pattern("###")
                .define('#', ModItems.PALM_PLANKS.get())
                .unlockedBy("has_palm_planks", hasItems(ModItems.PALM_PLANKS.get()))
                .save(consumer, new ResourceLocation(RamadanDelight.MOD_ID, "palm_boat"));

        // Palm Chest Boat (Shapeless)
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.PALM_CHEST_BOAT.get(), 1)
                .requires(ItemTags.create(new ResourceLocation("forge", "chests/wooden"))) // Tag: "forge:chests/wooden"
                .requires(ModItems.PALM_BOAT.get())
                .unlockedBy("has_palm_boat", hasItems(ModItems.PALM_BOAT.get()))
                .save(consumer, new ResourceLocation(RamadanDelight.MOD_ID, "palm_chest_boat"));
    }
    public static void shapefulRecipes(Consumer<FinishedRecipe> consumer) {
        // Bags
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, ModItems.CHICKPEA_BAG.get(), 1)
                .pattern("###")
                .pattern("###")
                .pattern("###")
                .define('#', ModItems.CHICKPEA.get())
                .unlockedBy("has_chickpea", hasItems(ModItems.CHICKPEA.get()))
                .save(consumer, new ResourceLocation(RamadanDelight.MOD_ID,"chickpea_bag"));
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, ModItems.PARSLEY_BAG.get(), 1)
                .pattern("###")
                .pattern("###")
                .pattern("###")
                .define('#', ModItems.PARSLEY.get())
                .unlockedBy("has_parsley", hasItems(ModItems.PARSLEY.get()))
                .save(consumer, new ResourceLocation(RamadanDelight.MOD_ID,"parsley_bag"));

        // Fanous (M for Material, G for glass and T for Torch)
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, ModItems.FANOUS.get(), 1)
                .pattern("MGM")
                .pattern("GTG")
                .pattern("MGM")
                .define('M', Tags.Items.NUGGETS_IRON)
                .define('G', ModItems.STAINED_GLASS_BLOCK.get())
                .define('T', Items.TORCH)
                .unlockedBy("has_stained_glass_block", hasItems(ModItems.STAINED_GLASS_BLOCK.get()))
                .save(consumer, new ResourceLocation(RamadanDelight.MOD_ID,"fanous"));
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, ModItems.COPPER_FANOUS.get(), 1)
                .pattern("MGM")
                .pattern("GTG")
                .pattern("MGM")
                .define('M', Tags.Items.INGOTS_COPPER)
                .define('G', ModItems.GREEN_STAINED_GLASS_BLOCK.get())
                .define('T', Items.TORCH)
                .unlockedBy("has_stained_glass_block", hasItems(ModItems.GREEN_STAINED_GLASS_BLOCK.get()))
                .save(consumer, new ResourceLocation(RamadanDelight.MOD_ID,"copper_fanous"));
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, ModItems.REDSTONE_FANOUS.get(), 1)
                .pattern("MGM")
                .pattern("GTG")
                .pattern("MGM")
                .define('M', Tags.Items.NUGGETS_IRON)
                .define('G', ModItems.ORANGE_STAINED_GLASS_BLOCK.get())
                .define('T', Items.REDSTONE_TORCH)
                .unlockedBy("has_stained_glass_block", hasItems(ModItems.ORANGE_STAINED_GLASS_BLOCK.get()))
                .save(consumer, new ResourceLocation(RamadanDelight.MOD_ID,"redstone_fanous"));
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, ModItems.SOUL_FANOUS.get(), 1)
                .pattern("MGM")
                .pattern("GTG")
                .pattern("MGM")
                .define('M', Tags.Items.NUGGETS_IRON)
                .define('G', ModItems.BLUE_STAINED_GLASS_BLOCK.get())
                .define('T', Items.SOUL_TORCH)
                .unlockedBy("has_stained_glass_block", hasItems(ModItems.BLUE_STAINED_GLASS_BLOCK.get()))
                .save(consumer, new ResourceLocation(RamadanDelight.MOD_ID,"soul_fanous"));

        // Food
        ShapedRecipeBuilder.shaped(RecipeCategory.FOOD, ModItems.DATE_STUFFED_COOKIE.get(), 8)
                .pattern("DGD")
                .define('G', ForgeTags.GRAIN)
                .define('D', ModItems.DATE.get())
                .unlockedBy("has_date", hasItems(ModItems.DATE.get()))
                .save(consumer, new ResourceLocation(RamadanDelight.MOD_ID,"date_stuffed_cookie"));
        ShapedRecipeBuilder.shaped(RecipeCategory.FOOD, ModItems.QUICHE.get(), 1)
                .pattern("ABC")
                .pattern("DEF")
                .define('A', ModItems.PARSLEY.get())
                .define('B', ForgeTags.MILK)
                .define('C', vectorwing.farmersdelight.common.registry.ModItems.TOMATO_SAUCE.get())
                .define('D', Ingredient.fromValues(Stream.of(
                        new Ingredient.TagValue(ForgeTags.COOKED_MUTTON),
                        new Ingredient.TagValue(ForgeTags.COOKED_CHICKEN),
                        new Ingredient.TagValue(ForgeTags.COOKED_BEEF)
                )))
                .define('E', vectorwing.farmersdelight.common.registry.ModItems.PIE_CRUST.get())
                .define('F', Items.BAKED_POTATO)
                .unlockedBy("has_pie_crust", hasItems(vectorwing.farmersdelight.common.registry.ModItems.PIE_CRUST.get()))
                .save(consumer, new ResourceLocation(RamadanDelight.MOD_ID,"quiche"));
        ShapedRecipeBuilder.shaped(RecipeCategory.FOOD, ModItems.QUICHE.get(), 1)
                .pattern("##")
                .pattern("##")
                .define('#', ModItems.QUICHE_SLICE.get())
                .unlockedBy("has_slice", hasItems( ModItems.QUICHE_SLICE.get()))
                .save(consumer, new ResourceLocation(RamadanDelight.MOD_ID,"quiche_from_slice"));

        // Misc
        ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, ModItems.DRUM.get(), 1)
                .pattern("SPS")
                .pattern("WWW")
                .define('W', ItemTags.PLANKS)
                .define('S', Tags.Items.STRING)
                .define('P', Items.PAPER)
                .unlockedBy("has_paper", hasItems(Items.PAPER))
                .save(consumer, new ResourceLocation(RamadanDelight.MOD_ID,"drum"));

        // Stained Glass Blocks
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, ModItems.STAINED_GLASS_BLOCK.get(), 1)
                .pattern("GIG")
                .define('G', Tags.Items.GLASS)
                .define('I', Items.IRON_INGOT)
                .unlockedBy("has_iron", hasItems(Items.IRON_INGOT))
                .save(consumer, new ResourceLocation(RamadanDelight.MOD_ID,"stained_glass_block"));
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, ModItems.BLUE_STAINED_GLASS_BLOCK.get(), 8)
                .pattern("GGG")
                .pattern("GDG")
                .pattern("GGG")
                .define('G', ModItems.STAINED_GLASS_BLOCK.get())
                .define('D', Items.BLUE_DYE)
                .unlockedBy("has_stained_glass", hasItems(ModItems.STAINED_GLASS_BLOCK.get()))
                .save(consumer, new ResourceLocation(RamadanDelight.MOD_ID,"blue_stained_glass_block"));
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, ModItems.GREEN_STAINED_GLASS_BLOCK.get(), 8)
                .pattern("GGG")
                .pattern("GDG")
                .pattern("GGG")
                .define('G', ModItems.STAINED_GLASS_BLOCK.get())
                .define('D', Items.GREEN_DYE)
                .unlockedBy("has_stained_glass", hasItems(ModItems.STAINED_GLASS_BLOCK.get()))
                .save(consumer, new ResourceLocation(RamadanDelight.MOD_ID,"green_stained_glass_block"));
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, ModItems.ORANGE_STAINED_GLASS_BLOCK.get(), 8)
                .pattern("GGG")
                .pattern("GDG")
                .pattern("GGG")
                .define('G', ModItems.STAINED_GLASS_BLOCK.get())
                .define('D', Items.ORANGE_DYE)
                .unlockedBy("has_stained_glass", hasItems(ModItems.STAINED_GLASS_BLOCK.get()))
                .save(consumer, new ResourceLocation(RamadanDelight.MOD_ID,"orange_stained_glass_block"));

        // Stained Glass Panes
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, ModItems.STAINED_GLASS_PANE.get(), 16)
                .pattern("GGG")
                .pattern("GGG")
                .define('G', ModItems.STAINED_GLASS_BLOCK.get())
                .unlockedBy("has_stained_glass_block", hasItems(ModItems.STAINED_GLASS_BLOCK.get()))
                .save(consumer, new ResourceLocation(RamadanDelight.MOD_ID,"stained_glass_pane"));
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, ModItems.BLUE_STAINED_GLASS_PANE.get(), 16)
                .pattern("GGG")
                .pattern("GGG")
                .define('G', ModItems.BLUE_STAINED_GLASS_BLOCK.get())
                .unlockedBy("has_blue_stained_glass_block", hasItems(ModItems.BLUE_STAINED_GLASS_BLOCK.get()))
                .save(consumer, new ResourceLocation(RamadanDelight.MOD_ID,"blue_stained_glass_pane"));
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, ModItems.GREEN_STAINED_GLASS_PANE.get(), 16)
                .pattern("GGG")
                .pattern("GGG")
                .define('G', ModItems.GREEN_STAINED_GLASS_BLOCK.get())
                .unlockedBy("has_green_stained_glass_block", hasItems(ModItems.GREEN_STAINED_GLASS_BLOCK.get()))
                .save(consumer, new ResourceLocation(RamadanDelight.MOD_ID,"green_stained_glass_pane"));
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, ModItems.ORANGE_STAINED_GLASS_PANE.get(), 16)
                .pattern("GGG")
                .pattern("GGG")
                .define('G', ModItems.ORANGE_STAINED_GLASS_BLOCK.get())
                .unlockedBy("has_orange_stained_glass_block", hasItems(ModItems.ORANGE_STAINED_GLASS_BLOCK.get()))
                .save(consumer, new ResourceLocation(RamadanDelight.MOD_ID,"orange_stained_glass_pane"));

    }
    public static void shapelessRecipes(Consumer<FinishedRecipe> consumer) {
        // Building Blocks
        ShapelessRecipeBuilder.shapeless(RecipeCategory.BUILDING_BLOCKS, ModItems.MOSAIC_TILES.get(), 4)
                .requires(Items.CALCITE)
                .requires(Items.CALCITE)
                .requires(Items.CALCITE)
                .requires(Items.CALCITE)
                .unlockedBy("has_calcite", hasItems(Items.CALCITE))
                .save(consumer, new ResourceLocation(RamadanDelight.MOD_ID, "mosaic_tiles"));

        // From bag
        ShapelessRecipeBuilder.shapeless(RecipeCategory.FOOD, ModItems.CHICKPEA.get(), 9)
                .requires(ModItems.CHICKPEA_BAG.get())
                .unlockedBy("has_chickpea_bag", hasItems(ModItems.CHICKPEA_BAG.get()))
                .save(consumer, new ResourceLocation(RamadanDelight.MOD_ID, "chickpea_from_bag"));
        ShapelessRecipeBuilder.shapeless(RecipeCategory.FOOD, ModItems.PARSLEY.get(), 9)
                .requires(ModItems.PARSLEY_BAG.get())
                .unlockedBy("has_parsley_bag", hasItems(ModItems.PARSLEY_BAG.get()))
                .save(consumer, new ResourceLocation(RamadanDelight.MOD_ID, "parsley_from_bag"));

        // Dates
        ShapelessRecipeBuilder.shapeless(RecipeCategory.FOOD, ModItems.DATE.get(), 8)
                .requires(ModItems.CLUSTER_OF_DATES.get())
                .unlockedBy("has_cluster_of_dates", hasItems(ModItems.CLUSTER_OF_DATES.get()))
                .save(consumer, new ResourceLocation(RamadanDelight.MOD_ID,"date_from_cluster"));
        ShapelessRecipeBuilder.shapeless(RecipeCategory.FOOD, Items.SUGAR, 3)
                .requires(ModItems.DATE_SYRUP.get())
                .unlockedBy("has_date_syrup", hasItems(ModItems.DATE_SYRUP.get()))
                .save(consumer, new ResourceLocation(RamadanDelight.MOD_ID,"sugar_from_date_syrup"));
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, Items.STICK, 3)
                .requires(ModItems.DATES_BRANCH.get())
                .unlockedBy("has_dates_branch", hasItems(ModItems.DATES_BRANCH.get()))
                .save(consumer, new ResourceLocation(RamadanDelight.MOD_ID,"sticks_from_dates_branch"));

        // Wild Crops
        ShapelessRecipeBuilder.shapeless(RecipeCategory.FOOD, ModItems.CHICKPEA.get())
                .requires(ModItems.WILD_CHICKPEA.get())
                .unlockedBy("has_wild_chickpea", hasItems(ModItems.WILD_CHICKPEA.get()))
                .save(consumer, new ResourceLocation(RamadanDelight.MOD_ID,"chickpea_from_wild"));
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, Items.LIGHT_GRAY_DYE)
                .requires(ModItems.WILD_PARSLEY.get())
                .unlockedBy("has_wild_parsley", hasItems(ModItems.WILD_PARSLEY.get()))
                .save(consumer, new ResourceLocation(RamadanDelight.MOD_ID,"light_gray_dye_from_wild_parsley"));

        // Misc
        ShapelessRecipeBuilder.shapeless(RecipeCategory.FOOD, ModItems.SMALL_DOUGH.get())
                .requires(Items.WATER_BUCKET)
                .requires(ForgeTags.GRAIN_WHEAT)
                .unlockedBy("has_wheat", hasItems(Items.WHEAT))
                .save(consumer, new ResourceLocation(RamadanDelight.MOD_ID,"small_dough_from_wheat"));
        ShapelessRecipeBuilder.shapeless(RecipeCategory.FOOD, ModItems.SMALL_DOUGH.get(), 2)
                .requires(ForgeTags.DOUGH)
                .unlockedBy("has_dough", hasItems(Items.WHEAT))
                .save(consumer, new ResourceLocation(RamadanDelight.MOD_ID,"small_dough_from_dough"));
        ShapelessRecipeBuilder.shapeless(RecipeCategory.FOOD, ModItems.BOUREK_SHEET.get(), 3)
                .requires(ForgeTags.DOUGH)
                .requires(Items.WATER_BUCKET)
                .unlockedBy("has_dough", hasItems(Items.WHEAT))
                .save(consumer, new ResourceLocation(RamadanDelight.MOD_ID,"bourek_sheet"));
        ShapelessRecipeBuilder.shapeless(RecipeCategory.FOOD, ModItems.RAW_BOUREK.get(), 2)
                .requires(ModItems.BOUREK_SHEET.get())
                .requires(ModItems.BOUREK_SHEET.get())
                .requires(ModItems.SAVORY_FILLING.get())
                .unlockedBy("has_savory_filling", hasItems(ModItems.SAVORY_FILLING.get()))
                .save(consumer, new ResourceLocation(RamadanDelight.MOD_ID,"raw_bourek"));
        ShapelessRecipeBuilder.shapeless(RecipeCategory.FOOD, ModItems.RAW_SAMOSA.get(), 3)
                .requires(ModItems.SMALL_DOUGH.get())
                .requires(ModItems.SMALL_DOUGH.get())
                .requires(ModItems.SMALL_DOUGH.get())
                .requires(ModItems.SAVORY_FILLING.get())
                .unlockedBy("has_savory_filling", hasItems(ModItems.SAVORY_FILLING.get()))
                .save(consumer, new ResourceLocation(RamadanDelight.MOD_ID,"raw_samosa"));
        ShapelessRecipeBuilder.shapeless(RecipeCategory.FOOD, ModItems.RAW_KEBAB.get())
                .requires(Items.STICK)
                .requires(vectorwing.farmersdelight.common.registry.ModItems.MINCED_BEEF.get())
                .unlockedBy("has_minced_beef", hasItems(vectorwing.farmersdelight.common.registry.ModItems.MINCED_BEEF.get()))
                .save(consumer, new ResourceLocation(RamadanDelight.MOD_ID,"raw_kebab"));

        // Food Feasts Items
        ShapelessRecipeBuilder.shapeless(RecipeCategory.FOOD, ModItems.BOUREK_BLOCK.get())
                .requires(ModItems.BOUREK.get())
                .requires(ModItems.BOUREK.get())
                .requires(ModItems.BOUREK.get())
                .requires(ModItems.BOUREK.get())
                .requires(ModItems.BOUREK.get())
                .requires(ModItems.BOUREK.get())
                .requires(ModItems.BOUREK.get())
                .requires(ModItems.BOUREK.get())
                .requires(Items.BOWL)
                .unlockedBy("has_bourek", hasItems(ModItems.BOUREK.get()))
                .save(consumer, new ResourceLocation(RamadanDelight.MOD_ID,"bourek_block"));

        // Food Items
        ShapelessRecipeBuilder.shapeless(RecipeCategory.FOOD, ModItems.KUNAFA.get())
                .requires(ForgeTags.DOUGH)
                .requires(ForgeTags.MILK)
                .requires(Items.SUGAR)
                .requires(Ingredient.of(Items.HONEY_BOTTLE, ModItems.DATE_SYRUP.get()))
                .unlockedBy("has_sweet_ingredient", hasItems(ModItems.DATE_SYRUP.get(), Items.HONEY_BOTTLE))
                .save(consumer, new ResourceLocation(RamadanDelight.MOD_ID,"kunafa"));
        ShapelessRecipeBuilder.shapeless(RecipeCategory.FOOD, ModItems.MUSAKHAN.get())
                .requires(ModItems.FLAT_BREAD.get())
                .requires(ModItems.PARSLEY.get())
                .requires(ForgeTags.COOKED_CHICKEN)
                .requires(ForgeTags.CROPS_ONION)
                .unlockedBy("has_parsley", hasItems(ModItems.PARSLEY.get()))
                .save(consumer, new ResourceLocation(RamadanDelight.MOD_ID,"musakhan"));

        // Bowled Food Items
        ShapelessRecipeBuilder.shapeless(RecipeCategory.FOOD, ModItems.CHICKPEA_AND_RICE.get())
                .requires(ModItems.CHICKPEA.get())
                .requires(vectorwing.farmersdelight.common.registry.ModItems.TOMATO_SAUCE.get())
                .requires(vectorwing.farmersdelight.common.registry.ModItems.COOKED_RICE.get())
                .requires(Items.BOWL)
                .unlockedBy("has_chickpea", hasItems(ModItems.CHICKPEA.get()))
                .save(consumer, new ResourceLocation(RamadanDelight.MOD_ID,"chickpea_and_rice"));
        ShapelessRecipeBuilder.shapeless(RecipeCategory.FOOD, ModItems.TABBOULEH.get())
                .requires(ModItems.PARSLEY.get())
                .requires(ForgeTags.CROPS_TOMATO)
                .requires(ForgeTags.CROPS_ONION)
                .requires(Items.BOWL)
                .unlockedBy("has_parsley", hasItems(ModItems.PARSLEY.get()))
                .save(consumer, new ResourceLocation(RamadanDelight.MOD_ID,"tabbouleh"));

        // Wild Flowers
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, Items.WHITE_DYE,1)
                .requires(ModItems.WILD_PARSLEY.get())
                .unlockedBy("has_wild_parsley", hasItems(ModItems.WILD_PARSLEY.get()))
                .save(consumer, new ResourceLocation(RamadanDelight.MOD_ID,"dye_from_wild_parsley"));
    }
    public static void compatRecipes(Consumer<FinishedRecipe> consumer) {
        ShapelessRecipeBuilder.shapeless(RecipeCategory.FOOD, vectorwing.farmersdelight.common.registry.ModItems.MUTTON_WRAP.get())
                .requires(ModItems.FLAT_BREAD.get())
                .requires(ForgeTags.COOKED_MUTTON)
                .requires(ForgeTags.SALAD_INGREDIENTS)
                .requires(ForgeTags.CROPS_ONION)
                .unlockedBy("has_flat_bread", hasItems(ModItems.FLAT_BREAD.get()))
                .save(consumer, new ResourceLocation(RamadanDelight.MOD_ID, "mutton_wrap_from_rd"));
    }
}