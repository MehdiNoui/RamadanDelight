package net.mehdinoui.ramadandelight.data.recipe;

import net.mehdinoui.ramadandelight.RamadanDelight;
import net.mehdinoui.ramadandelight.common.registry.ModItems;
import net.minecraft.data.recipes.FinishedRecipe;
import net.minecraft.data.recipes.RecipeCategory;
import net.minecraft.data.recipes.SingleItemRecipeBuilder;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;

import java.util.function.Consumer;

import static net.minecraft.advancements.critereon.InventoryChangeTrigger.TriggerInstance.hasItems;

public class ModStoneCuttingRecipes {
    public static void register(Consumer<FinishedRecipe> consumer) {
        SingleItemRecipeBuilder.stonecutting(
                        Ingredient.of(Items.CALCITE),
                        RecipeCategory.BUILDING_BLOCKS,
                        ModItems.MOSAIC_TILES.get(),
                        1)
                .unlockedBy("has_calcite", hasItems(Items.CALCITE))
                .save(consumer, new ResourceLocation(RamadanDelight.MOD_ID, "stonecutting/mosaic_tiles"));
    }
}
