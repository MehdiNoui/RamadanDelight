package net.mehdinoui.ramadandelight.data.recipe;

import net.mehdinoui.ramadandelight.RamadanDelight;
import net.mehdinoui.ramadandelight.common.registry.ModItems;
import net.minecraft.data.recipes.RecipeOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;
import net.neoforged.neoforge.common.Tags;
import vectorwing.farmersdelight.client.recipebook.CookingPotRecipeBookTab;
import vectorwing.farmersdelight.common.tag.CommonTags;
import vectorwing.farmersdelight.data.builder.CookingPotRecipeBuilder;

import java.util.function.Consumer;
import java.util.stream.Stream;

import static vectorwing.farmersdelight.data.recipe.CookingRecipes.SMALL_EXP;
import static vectorwing.farmersdelight.data.recipe.CookingRecipes.MEDIUM_EXP;
import static vectorwing.farmersdelight.data.recipe.CookingRecipes.LARGE_EXP;

import static vectorwing.farmersdelight.data.recipe.CookingRecipes.FAST_COOKING;
import static vectorwing.farmersdelight.data.recipe.CookingRecipes.NORMAL_COOKING;
import static vectorwing.farmersdelight.data.recipe.CookingRecipes.SLOW_COOKING;

public class ModCookingRecipes {

    public static void register(RecipeOutput consumer) {
        cookDrinks(consumer);
        cookFeasts(consumer);
        cookingMeals(consumer);
        cookMiscellaneous(consumer);
    }

    private static void cookDrinks(RecipeOutput consumer) {
        CookingPotRecipeBuilder.cookingPotRecipe(ModItems.DATE_SYRUP.get(), 1, NORMAL_COOKING, LARGE_EXP)
                .addIngredient(ModItems.DATE.get())
                .addIngredient(ModItems.DATE.get())
                .addIngredient(Items.SUGAR)
                .unlockedByItems("has_date", ModItems.DATE.get())
                .setRecipeBookTab(CookingPotRecipeBookTab.DRINKS)
                .build(consumer, String.valueOf(ResourceLocation.fromNamespaceAndPath(RamadanDelight.MOD_ID, "cooking/date_syrup")));
    }
    private static void cookingMeals(RecipeOutput consumer) {
        CookingPotRecipeBuilder.cookingPotRecipe(ModItems.CHORBA.get(), 1, NORMAL_COOKING, MEDIUM_EXP, Items.BOWL)
                .addIngredient(ModItems.PARSLEY.get())
                .addIngredient(CommonTags.FOODS_RAW_MUTTON)
                .addIngredient(CommonTags.CROPS_TOMATO)
                .addIngredient(ModItems.CHICKPEA.get())
                .unlockedByItems("has_parsley", ModItems.PARSLEY.get())
                .setRecipeBookTab(CookingPotRecipeBookTab.MEALS)
                .build(consumer, String.valueOf(ResourceLocation.fromNamespaceAndPath(RamadanDelight.MOD_ID, "cooking/chorba")));

        CookingPotRecipeBuilder.cookingPotRecipe(ModItems.HALEEM.get(), 1, NORMAL_COOKING, MEDIUM_EXP, Items.BOWL)
                .addIngredient(ModItems.PARSLEY.get())
                .addIngredient(CommonTags.FOODS_COOKED_BEEF)
                .addIngredient(Tags.Items.CROPS_WHEAT)
                .unlockedByItems("has_parsley", ModItems.PARSLEY.get())
                .setRecipeBookTab(CookingPotRecipeBookTab.MEALS)
                .build(consumer, String.valueOf(ResourceLocation.fromNamespaceAndPath(RamadanDelight.MOD_ID, "cooking/haleem")));

        CookingPotRecipeBuilder.cookingPotRecipe(ModItems.HARIRA.get(), 1, NORMAL_COOKING, MEDIUM_EXP, Items.BOWL)
                .addIngredient(ModItems.PARSLEY.get())
                .addIngredient(CommonTags.FOODS_RAW_BEEF)
                .addIngredient(vectorwing.farmersdelight.common.registry.ModItems.TOMATO_SAUCE.get())
                .addIngredient(Items.CARROT)
                .unlockedByItems("has_parsley", ModItems.PARSLEY.get())
                .setRecipeBookTab(CookingPotRecipeBookTab.MEALS)
                .build(consumer, String.valueOf(ResourceLocation.fromNamespaceAndPath(RamadanDelight.MOD_ID, "cooking/harira")));

        CookingPotRecipeBuilder.cookingPotRecipe(ModItems.HUMMUS_TAHINI.get(), 1, NORMAL_COOKING, MEDIUM_EXP)
                .addIngredient(ModItems.CHICKPEA.get())
                .addIngredient(ModItems.CHICKPEA.get())
                .addIngredient(Tags.Items.CROPS_WHEAT)
                .unlockedByItems("has_chickpea", ModItems.CHICKPEA.get())
                .setRecipeBookTab(CookingPotRecipeBookTab.MEALS)
                .build(consumer, String.valueOf(ResourceLocation.fromNamespaceAndPath(RamadanDelight.MOD_ID, "cooking/hummus")));

        CookingPotRecipeBuilder.cookingPotRecipe(ModItems.SAVORY_FILLING.get(), 1, NORMAL_COOKING, SMALL_EXP, Items.BOWL)
                .addIngredient(ModItems.PARSLEY.get())
                .addIngredient(Tags.Items.EGGS)
                .addIngredient(CommonTags.CROPS_ONION)
                .addIngredient(Ingredient.fromValues(Stream.of(
                        new Ingredient.TagValue(CommonTags.FOODS_RAW_MUTTON),
                        new Ingredient.TagValue(CommonTags.FOODS_RAW_CHICKEN),
                        new Ingredient.TagValue(CommonTags.FOODS_RAW_BEEF)
                )))
                .unlockedByItems("has_parsley", ModItems.PARSLEY.get())
                .setRecipeBookTab(CookingPotRecipeBookTab.MISC)
                .build(consumer, String.valueOf(ResourceLocation.fromNamespaceAndPath(RamadanDelight.MOD_ID, "cooking/savory_filling")));

        CookingPotRecipeBuilder.cookingPotRecipe(ModItems.SAYADIEH.get(), 1, NORMAL_COOKING, MEDIUM_EXP, Items.BOWL)
                .addIngredient(CommonTags.FOODS_RAW_COD)
                .addIngredient(Items.CARROT)
                .addIngredient(vectorwing.farmersdelight.common.registry.ModItems.RICE.get())
                .unlockedByItems("has_rice", vectorwing.farmersdelight.common.registry.ModItems.RICE.get())
                .setRecipeBookTab(CookingPotRecipeBookTab.MEALS)
                .build(consumer, String.valueOf(ResourceLocation.fromNamespaceAndPath(RamadanDelight.MOD_ID, "cooking/sayadieh")));

        CookingPotRecipeBuilder.cookingPotRecipe(ModItems.TAGINE.get(), 1, NORMAL_COOKING, MEDIUM_EXP, Items.BOWL)
                .addIngredient(CommonTags.FOODS_RAW_CHICKEN)
                .addIngredient(Items.CARROT)
                .addIngredient(Tags.Items.CROPS_POTATO)
                .addIngredient(ModItems.CHICKPEA.get())
                .addIngredient(ModItems.PARSLEY.get())
                .unlockedByItems("has_chicken", Items.CHICKEN)
                .setRecipeBookTab(CookingPotRecipeBookTab.MEALS)
                .build(consumer, String.valueOf(ResourceLocation.fromNamespaceAndPath(RamadanDelight.MOD_ID, "cooking/tagine")));
    }
    private static void cookMiscellaneous(RecipeOutput consumer) {
        CookingPotRecipeBuilder.cookingPotRecipe(ModItems.LUQAIMAT.get(), 1, NORMAL_COOKING, MEDIUM_EXP)
                .addIngredient(ModItems.SMALL_DOUGH.get())
                .addIngredient(ModItems.SMALL_DOUGH.get())
                .addIngredient(ModItems.SMALL_DOUGH.get())
                .addIngredient(Ingredient.of(Items.HONEY_BOTTLE, ModItems.DATE_SYRUP.get()))
                .unlockedByItems("has_small_dough", ModItems.SMALL_DOUGH.get())
                .setRecipeBookTab(CookingPotRecipeBookTab.MISC)
                .build(consumer, String.valueOf(ResourceLocation.fromNamespaceAndPath(RamadanDelight.MOD_ID, "cooking/luqaimat")));

        CookingPotRecipeBuilder.cookingPotRecipe(ModItems.MAHALABIA.get(), 1, NORMAL_COOKING, MEDIUM_EXP, Items.BOWL)
                .addIngredient(Items.SWEET_BERRIES)
                .addIngredient(CommonTags.FOODS_MILK)
                .addIngredient(Items.SUGAR)
                .unlockedByItems("has_milk", Items.MILK_BUCKET)
                .setRecipeBookTab(CookingPotRecipeBookTab.MISC)
                .build(consumer, String.valueOf(ResourceLocation.fromNamespaceAndPath(RamadanDelight.MOD_ID, "cooking/mahalabia")));

        CookingPotRecipeBuilder.cookingPotRecipe(ModItems.SWEET_TAGINE.get(), 1, NORMAL_COOKING, MEDIUM_EXP, Items.BOWL)
                .addIngredient(CommonTags.FOODS_COOKED_BEEF)
                .addIngredient(Items.APPLE)
                .addIngredient(Tags.Items.FOODS_BERRY)
                .addIngredient(Items.SUGAR)
                .unlockedByItems("has_cooked_beef", Items.COOKED_BEEF)
                .setRecipeBookTab(CookingPotRecipeBookTab.MISC)
                .build(consumer, String.valueOf(ResourceLocation.fromNamespaceAndPath(RamadanDelight.MOD_ID, "cooking/sweet_tagine")));

        CookingPotRecipeBuilder.cookingPotRecipe(ModItems.ZALABIYEH.get(), 2, NORMAL_COOKING, MEDIUM_EXP)
                .addIngredient(CommonTags.FOODS_DOUGH)
                .addIngredient(Items.SUGAR)
                .addIngredient(Ingredient.of(Items.HONEY_BOTTLE, ModItems.DATE_SYRUP.get()))
                .unlockedByItems("has_dough", Items.WHEAT)
                .setRecipeBookTab(CookingPotRecipeBookTab.MISC)
                .build(consumer, String.valueOf(ResourceLocation.fromNamespaceAndPath(RamadanDelight.MOD_ID, "cooking/zalabiyeh")));
    }
    private static void cookFeasts(RecipeOutput consumer) {
        CookingPotRecipeBuilder.cookingPotRecipe(ModItems.MAQLUBA_BLOCK.get(), 1, SLOW_COOKING, LARGE_EXP, Items.BOWL)
                .addIngredient(Items.CARROT)
                .addIngredient(CommonTags.FOODS_RAW_MUTTON)
                .addIngredient(CommonTags.FOODS_RAW_MUTTON)
                .addIngredient(CommonTags.CROPS_TOMATO)
                .addIngredient(vectorwing.farmersdelight.common.registry.ModItems.RICE.get())
                .addIngredient(vectorwing.farmersdelight.common.registry.ModItems.RICE.get())
                .unlockedByItems("has_mutton", Items.MUTTON)
                .setRecipeBookTab(CookingPotRecipeBookTab.MEALS)
                .build(consumer, String.valueOf(ResourceLocation.fromNamespaceAndPath(RamadanDelight.MOD_ID, "cooking/maqluba")));
    }
}