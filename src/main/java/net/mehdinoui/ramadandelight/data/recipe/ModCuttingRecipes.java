package net.mehdinoui.ramadandelight.data.recipe;

import net.mehdinoui.ramadandelight.RamadanDelight;
import net.mehdinoui.ramadandelight.common.registry.ModItems;
import net.minecraft.data.recipes.RecipeOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.ItemLike;
import net.neoforged.neoforge.common.ItemAbilities;
import vectorwing.farmersdelight.common.tag.CommonTags;
import vectorwing.farmersdelight.common.crafting.ingredient.ItemAbilityIngredient;
import vectorwing.farmersdelight.data.builder.CuttingBoardRecipeBuilder;

public class ModCuttingRecipes {
    public static void register(RecipeOutput consumer) {
        // Cluster of dates
        CuttingBoardRecipeBuilder.cuttingRecipe(
                        Ingredient.of(ModItems.CLUSTER_OF_DATES.get()),
                        Ingredient.of(CommonTags.TOOLS_KNIFE), ModItems.DATE.get(), 8)
                .addResultWithChance(ModItems.DATES_BRANCH.get(), 1.0F)
                .build(consumer, ResourceLocation.fromNamespaceAndPath(RamadanDelight.MOD_ID, "cutting/dates_from_cluster"));

        // Flowers
        CuttingBoardRecipeBuilder.cuttingRecipe(
                        Ingredient.of(ModItems.WILD_CHICKPEA.get()),
                        Ingredient.of(CommonTags.TOOLS_KNIFE), ModItems.CHICKPEA.get(), 2)
                .build(consumer, ResourceLocation.fromNamespaceAndPath(RamadanDelight.MOD_ID, "cutting/wild_chickpea"));

        CuttingBoardRecipeBuilder.cuttingRecipe(
                        Ingredient.of(ModItems.WILD_PARSLEY.get()),
                        Ingredient.of(CommonTags.TOOLS_KNIFE), ModItems.PARSLEY.get(), 1)
                        .addResult(ModItems.PARSLEY_SEEDS.get(), 1)
                        .addResultWithChance(Items.LIGHT_GRAY_DYE, 0.5F)
                .build(consumer, ResourceLocation.fromNamespaceAndPath(RamadanDelight.MOD_ID, "cutting/wild_parsley"));

        // Slices
        CuttingBoardRecipeBuilder.cuttingRecipe(
                        Ingredient.of(ModItems.QUICHE.get()),
                        Ingredient.of(CommonTags.TOOLS_KNIFE), ModItems.QUICHE_SLICE.get(), 4)
                .build(consumer, ResourceLocation.fromNamespaceAndPath(RamadanDelight.MOD_ID, "cutting/quiche_slice"));

        // Mosaic Tiles
        CuttingBoardRecipeBuilder.cuttingRecipe(
                        Ingredient.of(ModItems.MOSAIC_TILES.get()),
                        new ItemAbilityIngredient(ItemAbilities.PICKAXE_DIG).toVanilla(), Items.CALCITE, 4)
                .build(consumer, ResourceLocation.fromNamespaceAndPath(RamadanDelight.MOD_ID, "cutting/calcite_from_mosaic_tiles"));

        // Stripping Log
        stripLogForBark(consumer, ModItems.PALM_LOG.get(), ModItems.STRIPPED_PALM_LOG.get());
        stripLogForBark(consumer, ModItems.PALM_WOOD.get(), ModItems.STRIPPED_PALM_WOOD.get());

        // Salvaging
        salvagePlankFromFurniture(consumer, ModItems.PALM_PLANKS.get(), ModItems.PALM_DOOR.get(), ModItems.PALM_TRAPDOOR.get(), ModItems.PALM_SIGN.get(), ModItems.PALM_HANGING_SIGN.get());
    }

    private static void stripLogForBark(RecipeOutput output, ItemLike log, ItemLike strippedLog) {
        CuttingBoardRecipeBuilder.cuttingRecipe(Ingredient.of(log), new ItemAbilityIngredient(ItemAbilities.AXE_STRIP).toVanilla(), strippedLog)
                .addResult(vectorwing.farmersdelight.common.registry.ModItems.TREE_BARK.get())
                .addSound(SoundEvents.AXE_STRIP)
                .build(output);
    }

    private static void salvagePlankFromFurniture(RecipeOutput output, ItemLike plank, ItemLike door, ItemLike trapdoor, ItemLike sign, ItemLike hangingSign) {
        CuttingBoardRecipeBuilder.cuttingRecipe(Ingredient.of(door), new ItemAbilityIngredient(ItemAbilities.AXE_DIG).toVanilla(), plank).build(output);
        CuttingBoardRecipeBuilder.cuttingRecipe(Ingredient.of(trapdoor), new ItemAbilityIngredient(ItemAbilities.AXE_DIG).toVanilla(), plank).build(output);
        CuttingBoardRecipeBuilder.cuttingRecipe(Ingredient.of(sign), new ItemAbilityIngredient(ItemAbilities.AXE_DIG).toVanilla(), plank).build(output);
        CuttingBoardRecipeBuilder.cuttingRecipe(Ingredient.of(hangingSign), new ItemAbilityIngredient(ItemAbilities.AXE_DIG).toVanilla(), plank).build(output);
    }
}