package net.mehdinoui.ramadandelight.datagen.recipe;

import net.mehdinoui.ramadandelight.RamadanDelight;
import net.mehdinoui.ramadandelight.common.registry.ModItems;
import net.minecraft.data.recipes.FinishedRecipe;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraftforge.common.Tags;
import vectorwing.farmersdelight.client.recipebook.CookingPotRecipeBookTab;
import vectorwing.farmersdelight.common.tag.ForgeTags;
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

    public static void register(Consumer<FinishedRecipe> consumer) {
        cookDrinks(consumer);
        cookFeasts(consumer);
        cookingMeals(consumer);
        cookMiscellaneous(consumer);
    }

    private static void cookDrinks(Consumer<FinishedRecipe> consumer) {
        CookingPotRecipeBuilder.cookingPotRecipe(ModItems.DATE_SYRUP.get(), 1, NORMAL_COOKING, LARGE_EXP)
                .addIngredient(ModItems.DATE.get())
                .addIngredient(ModItems.DATE.get())
                .addIngredient(Items.SUGAR)
                .unlockedByItems("has_date", ModItems.DATE.get())
                .setRecipeBookTab(CookingPotRecipeBookTab.DRINKS)
                .build(consumer, new ResourceLocation(RamadanDelight.MOD_ID, "cooking/date_syrup"));
    }
    private static void cookingMeals(Consumer<FinishedRecipe> consumer) {
        CookingPotRecipeBuilder.cookingPotRecipe(ModItems.CHORBA.get(), 1, NORMAL_COOKING, MEDIUM_EXP, Items.BOWL)
                .addIngredient(ModItems.PARSLEY.get())
                .addIngredient(ForgeTags.RAW_MUTTON)
                .addIngredient(ForgeTags.CROPS_TOMATO)
                .addIngredient(ModItems.CHICKPEA.get())
                .unlockedByItems("has_parsley", ModItems.PARSLEY.get())
                .setRecipeBookTab(CookingPotRecipeBookTab.MEALS)
                .build(consumer, new ResourceLocation(RamadanDelight.MOD_ID, "cooking/chorba"));

        CookingPotRecipeBuilder.cookingPotRecipe(ModItems.HALEEM.get(), 1, NORMAL_COOKING, MEDIUM_EXP, Items.BOWL)
                .addIngredient(ModItems.PARSLEY.get())
                .addIngredient(ForgeTags.COOKED_BEEF)
                .addIngredient(ForgeTags.GRAIN_WHEAT)
                .unlockedByItems("has_parsley", ModItems.PARSLEY.get())
                .setRecipeBookTab(CookingPotRecipeBookTab.MEALS)
                .build(consumer, new ResourceLocation(RamadanDelight.MOD_ID, "cooking/haleem"));

        CookingPotRecipeBuilder.cookingPotRecipe(ModItems.HARIRA.get(), 1, NORMAL_COOKING, MEDIUM_EXP, Items.BOWL)
                .addIngredient(ModItems.PARSLEY.get())
                .addIngredient(ForgeTags.RAW_BEEF)
                .addIngredient(vectorwing.farmersdelight.common.registry.ModItems.TOMATO_SAUCE.get())
                .addIngredient(Items.CARROT)
                .unlockedByItems("has_parsley", ModItems.PARSLEY.get())
                .setRecipeBookTab(CookingPotRecipeBookTab.MEALS)
                .build(consumer, new ResourceLocation(RamadanDelight.MOD_ID, "cooking/harira"));

        CookingPotRecipeBuilder.cookingPotRecipe(ModItems.HUMMUS_TAHINI.get(), 1, NORMAL_COOKING, MEDIUM_EXP)
                .addIngredient(ModItems.CHICKPEA.get())
                .addIngredient(ModItems.CHICKPEA.get())
                .addIngredient(ForgeTags.GRAIN_WHEAT)
                .unlockedByItems("has_chickpea", ModItems.CHICKPEA.get())
                .setRecipeBookTab(CookingPotRecipeBookTab.MEALS)
                .build(consumer, new ResourceLocation(RamadanDelight.MOD_ID, "cooking/hummus"));

        CookingPotRecipeBuilder.cookingPotRecipe(ModItems.SAVORY_FILLING.get(), 1, NORMAL_COOKING, SMALL_EXP, Items.BOWL)
                .addIngredient(ModItems.PARSLEY.get())
                .addIngredient(ForgeTags.EGGS)
                .addIngredient(ForgeTags.CROPS_ONION)
                .addIngredient(Ingredient.fromValues(Stream.of(
                        new Ingredient.TagValue(ForgeTags.RAW_MUTTON),
                        new Ingredient.TagValue(ForgeTags.RAW_CHICKEN),
                        new Ingredient.TagValue(ForgeTags.RAW_BEEF)
                )))
                .unlockedByItems("has_parsley", ModItems.PARSLEY.get())
                .setRecipeBookTab(CookingPotRecipeBookTab.MISC)
                .build(consumer, new ResourceLocation(RamadanDelight.MOD_ID, "cooking/savory_filling"));

        CookingPotRecipeBuilder.cookingPotRecipe(ModItems.SAYADIEH.get(), 1, NORMAL_COOKING, MEDIUM_EXP, Items.BOWL)
                .addIngredient(ForgeTags.RAW_FISHES_COD)
                .addIngredient(Items.CARROT)
                .addIngredient(vectorwing.farmersdelight.common.registry.ModItems.RICE.get())
                .unlockedByItems("has_rice", vectorwing.farmersdelight.common.registry.ModItems.RICE.get())
                .setRecipeBookTab(CookingPotRecipeBookTab.MEALS)
                .build(consumer, new ResourceLocation(RamadanDelight.MOD_ID, "cooking/sayadieh"));

        CookingPotRecipeBuilder.cookingPotRecipe(ModItems.TAGINE.get(), 1, NORMAL_COOKING, MEDIUM_EXP, Items.BOWL)
                .addIngredient(ForgeTags.RAW_CHICKEN)
                .addIngredient(Items.CARROT)
                .addIngredient(ForgeTags.VEGETABLES_POTATO)
                .addIngredient(ModItems.CHICKPEA.get())
                .addIngredient(ModItems.PARSLEY.get())
                .unlockedByItems("has_chicken", Items.CHICKEN)
                .setRecipeBookTab(CookingPotRecipeBookTab.MEALS)
                .build(consumer, new ResourceLocation(RamadanDelight.MOD_ID, "cooking/tagine"));
    }
    private static void cookMiscellaneous(Consumer<FinishedRecipe> consumer) {
        CookingPotRecipeBuilder.cookingPotRecipe(ModItems.LUQAIMAT.get(), 1, NORMAL_COOKING, MEDIUM_EXP)
                .addIngredient(ModItems.SMALL_DOUGH.get())
                .addIngredient(ModItems.SMALL_DOUGH.get())
                .addIngredient(ModItems.SMALL_DOUGH.get())
                .addIngredient(Ingredient.of(Items.HONEY_BOTTLE, ModItems.DATE_SYRUP.get()))
                .unlockedByItems("has_small_dough", ModItems.SMALL_DOUGH.get())
                .setRecipeBookTab(CookingPotRecipeBookTab.MISC)
                .build(consumer, new ResourceLocation(RamadanDelight.MOD_ID, "cooking/luqaimat"));

        CookingPotRecipeBuilder.cookingPotRecipe(ModItems.MHALBIYA.get(), 1, NORMAL_COOKING, MEDIUM_EXP, Items.BOWL)
                .addIngredient(Items.SWEET_BERRIES)
                .addIngredient(ForgeTags.MILK)
                .addIngredient(Items.SUGAR)
                .unlockedByItems("has_milk", Items.MILK_BUCKET)
                .setRecipeBookTab(CookingPotRecipeBookTab.MISC)
                .build(consumer, new ResourceLocation(RamadanDelight.MOD_ID, "cooking/mhalbiya"));

        CookingPotRecipeBuilder.cookingPotRecipe(ModItems.SWEET_TAGINE.get(), 1, NORMAL_COOKING, MEDIUM_EXP, Items.BOWL)
                .addIngredient(ForgeTags.COOKED_BEEF)
                .addIngredient(Items.APPLE)
                .addIngredient(ForgeTags.BERRIES)
                .addIngredient(Items.SUGAR)
                .unlockedByItems("has_cooked_beef", Items.COOKED_BEEF)
                .setRecipeBookTab(CookingPotRecipeBookTab.MISC)
                .build(consumer, new ResourceLocation(RamadanDelight.MOD_ID, "cooking/sweet_tagine"));

        CookingPotRecipeBuilder.cookingPotRecipe(ModItems.ZALABIYA.get(), 2, NORMAL_COOKING, MEDIUM_EXP)
                .addIngredient(ForgeTags.DOUGH)
                .addIngredient(Items.SUGAR)
                .addIngredient(Ingredient.of(Items.HONEY_BOTTLE, ModItems.DATE_SYRUP.get()))
                .unlockedByItems("has_dough", Items.WHEAT)
                .setRecipeBookTab(CookingPotRecipeBookTab.MISC)
                .build(consumer, new ResourceLocation(RamadanDelight.MOD_ID, "cooking/zalabiya"));
    }
    private static void cookFeasts(Consumer<FinishedRecipe> consumer) {
        CookingPotRecipeBuilder.cookingPotRecipe(ModItems.MAKLOBA_BLOCK.get(), 1, SLOW_COOKING, LARGE_EXP, Items.BOWL)
                .addIngredient(Items.CARROT)
                .addIngredient(ForgeTags.RAW_MUTTON)
                .addIngredient(ForgeTags.RAW_MUTTON)
                .addIngredient(ForgeTags.CROPS_TOMATO)
                .addIngredient(vectorwing.farmersdelight.common.registry.ModItems.RICE.get())
                .addIngredient(vectorwing.farmersdelight.common.registry.ModItems.RICE.get())
                .unlockedByItems("has_mutton", Items.MUTTON)
                .setRecipeBookTab(CookingPotRecipeBookTab.MEALS)
                .build(consumer, new ResourceLocation(RamadanDelight.MOD_ID, "cooking/makloba"));
    }
}