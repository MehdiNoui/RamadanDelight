package net.mehdinoui.ramadandelight.data.recipe;

import net.mehdinoui.ramadandelight.RamadanDelight;
import net.mehdinoui.ramadandelight.common.registry.ModItems;
import net.minecraft.data.recipes.FinishedRecipe;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.ItemLike;
import net.minecraftforge.common.ToolActions;
import net.minecraftforge.registries.ForgeRegistries;
import vectorwing.farmersdelight.common.crafting.ingredient.ToolActionIngredient;
import vectorwing.farmersdelight.common.tag.ForgeTags;
import vectorwing.farmersdelight.data.builder.CuttingBoardRecipeBuilder;

import java.util.function.Consumer;

public class ModCuttingRecipes {
    public static void register(Consumer<FinishedRecipe> consumer) {
        // Cluster of dates
        CuttingBoardRecipeBuilder.cuttingRecipe(
                        Ingredient.of(ModItems.CLUSTER_OF_DATES.get()),
                        Ingredient.of(ForgeTags.TOOLS_KNIVES), ModItems.DATE.get(),8)
                .addResultWithChance(ModItems.DATES_BRANCH.get(),1)
                .build(consumer,new ResourceLocation(RamadanDelight.MOD_ID, "cutting/dates_from_cluster"));

        // Flowers
        CuttingBoardRecipeBuilder.cuttingRecipe(
                        Ingredient.of(ModItems.WILD_CHICKPEA.get()),
                        Ingredient.of(ForgeTags.TOOLS_KNIVES), ModItems.CHICKPEA.get(),2)
                .build(consumer,new ResourceLocation(RamadanDelight.MOD_ID, "cutting/wild_chickpea"));
        CuttingBoardRecipeBuilder.cuttingRecipe(
                        Ingredient.of(ModItems.WILD_PARSLEY.get()),
                        Ingredient.of(ForgeTags.TOOLS_KNIVES), ModItems.PARSLEY_SEEDS.get(),1)
                .addResultWithChance(Items.LIGHT_GRAY_DYE,0.5f,1)
                .build(consumer,new ResourceLocation(RamadanDelight.MOD_ID, "cutting/wild_parsley"));

        // Slices
        CuttingBoardRecipeBuilder.cuttingRecipe(
                        Ingredient.of(ModItems.QUICHE.get()),
                        Ingredient.of(ForgeTags.TOOLS_KNIVES), ModItems.QUICHE_SLICE.get(),4)
                .build(consumer,new ResourceLocation(RamadanDelight.MOD_ID, "cutting/quiche_slice"));

        // Mosaic Tiles
        CuttingBoardRecipeBuilder.cuttingRecipe(
                        Ingredient.of(ModItems.MOSAIC_TILES.get()),
                        new ToolActionIngredient(ToolActions.PICKAXE_DIG), Items.CALCITE, 4)
                .build(consumer,new ResourceLocation(RamadanDelight.MOD_ID, "cutting/calcite_from_mosaic_tiles"));

        // Stripping Log
        stripLogForBark(consumer, ModItems.PALM_LOG.get(), ModItems.STRIPPED_PALM_LOG.get(), "palm_log");
        stripLogForBark(consumer, ModItems.PALM_WOOD.get(), ModItems.STRIPPED_PALM_WOOD.get(), "palm_wood");

        // Salvaging
        salvagePlankFromFurniture(consumer, ModItems.PALM_PLANKS.get(), ModItems.PALM_DOOR.get(), ModItems.PALM_TRAPDOOR.get(), ModItems.PALM_SIGN.get(), ModItems.PALM_HANGING_SIGN.get());
    }
    // Helper Methods
    // Credits to FD'S Team
    private static void stripLogForBark(Consumer<FinishedRecipe> consumer, ItemLike log, ItemLike strippedLog, String resource) {
        CuttingBoardRecipeBuilder.cuttingRecipe(Ingredient.of(log), new ToolActionIngredient(ToolActions.AXE_STRIP), strippedLog)
                .addResult(vectorwing.farmersdelight.common.registry.ModItems.TREE_BARK.get())
                .addSound(ForgeRegistries.SOUND_EVENTS.getKey(SoundEvents.AXE_STRIP).toString())
                .build(consumer, new ResourceLocation(RamadanDelight.MOD_ID, "cutting/stripping_" + resource));
    }
    private static void salvagePlankFromFurniture(Consumer<FinishedRecipe> consumer, ItemLike plank, ItemLike door, ItemLike trapdoor, ItemLike sign, ItemLike hangingSign) {
        String plankName = ForgeRegistries.ITEMS.getKey(plank.asItem()).getPath();

        CuttingBoardRecipeBuilder.cuttingRecipe(Ingredient.of(door), new ToolActionIngredient(ToolActions.AXE_DIG), plank).build(consumer, new ResourceLocation(RamadanDelight.MOD_ID, "cutting/salvaging/" + plankName + "_door"));
        CuttingBoardRecipeBuilder.cuttingRecipe(Ingredient.of(trapdoor), new ToolActionIngredient(ToolActions.AXE_DIG), plank).build(consumer, new ResourceLocation(RamadanDelight.MOD_ID, "cutting/salvaging/" + plankName + "_trapdoor"));
        CuttingBoardRecipeBuilder.cuttingRecipe(Ingredient.of(sign), new ToolActionIngredient(ToolActions.AXE_DIG), plank).build(consumer, new ResourceLocation(RamadanDelight.MOD_ID, "cutting/salvaging/" + plankName + "_sign"));
        CuttingBoardRecipeBuilder.cuttingRecipe(Ingredient.of(hangingSign), new ToolActionIngredient(ToolActions.AXE_DIG), plank).build(consumer, new ResourceLocation(RamadanDelight.MOD_ID, "cutting/salvaging/" + plankName + "_hanging_sign"));
    }
}
