package net.mehdinoui.ramadandelight.data.recipe;

import net.mehdinoui.ramadandelight.RamadanDelight;
import net.mehdinoui.ramadandelight.common.registry.ModItems;
import net.minecraft.data.recipes.FinishedRecipe;
import net.minecraft.data.recipes.RecipeCategory;
import net.minecraft.data.recipes.SimpleCookingRecipeBuilder;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.ItemLike;

import java.util.function.Consumer;

import static net.minecraft.advancements.critereon.InventoryChangeTrigger.TriggerInstance.hasItems;

public class ModSmeltingRecipes {
    public static void register(Consumer<FinishedRecipe> consumer) {
        cookingTriplet(consumer,
                Ingredient.of(ModItems.RAW_BOUREK.get()),
                ModItems.BOUREK.get(),
                0.35F, 200,
                "bourek", ModItems.RAW_BOUREK.get());
        cookingTriplet(consumer,
                Ingredient.of(ModItems.SMALL_DOUGH.get()),
                ModItems.FLAT_BREAD.get(),
                0.15F, 100,
                "flat_bread", ModItems.SMALL_DOUGH.get());
        cookingTriplet(consumer,
                Ingredient.of(ModItems.RAW_KEBAB.get()),
                ModItems.KEBAB.get(),
                0.35F, 200,
                "kebab", ModItems.RAW_KEBAB.get());
        cookingTriplet(consumer,
                Ingredient.of(ModItems.RAW_SAMOSA.get()),
                ModItems.SAMOSA.get(),
                0.35F, 200,
                "samosa", ModItems.RAW_SAMOSA.get());
    }
    // Helper Method
    private static void cookingTriplet(
            Consumer<FinishedRecipe> consumer,
            Ingredient input,
            ItemLike result,
            float xp,
            int cookTime,
            String name,
            ItemLike unlockItem
    ) {
        SimpleCookingRecipeBuilder.smelting(input, RecipeCategory.FOOD, result, xp, cookTime)
                .unlockedBy("has_" + name, hasItems(unlockItem))
                .save(consumer, new ResourceLocation(RamadanDelight.MOD_ID, name + "_from_smelting"));

        SimpleCookingRecipeBuilder.smoking(input, RecipeCategory.FOOD, result, xp, cookTime / 2)
                .unlockedBy("has_" + name, hasItems(unlockItem))
                .save(consumer, new ResourceLocation(RamadanDelight.MOD_ID, name + "_from_smoking"));

        SimpleCookingRecipeBuilder.campfireCooking(input, RecipeCategory.FOOD, result, xp, cookTime * 3)
                .unlockedBy("has_" + name, hasItems(unlockItem))
                .save(consumer, new ResourceLocation(RamadanDelight.MOD_ID, name + "_from_campfire_cooking"));
    }
}
