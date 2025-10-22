package net.mehdinoui.ramadandelight.datagen;

import net.mehdinoui.ramadandelight.RamadanDelight;
import net.mehdinoui.ramadandelight.datagen.recipe.*;
import net.mehdinoui.ramadandelight.datagen.tag.ModBlockTags;
import net.mehdinoui.ramadandelight.datagen.tag.ModItemTags;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.FinishedRecipe;
import net.minecraft.data.recipes.RecipeProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.data.event.GatherDataEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import java.util.concurrent.CompletableFuture;
import java.util.function.Consumer;

@Mod.EventBusSubscriber(modid = RamadanDelight.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class DataGenerators {
    @SubscribeEvent
    public static void gatherData(GatherDataEvent event) {
        DataGenerator generator = event.getGenerator();
        PackOutput packOutput = generator.getPackOutput();
        ExistingFileHelper existingFileHelper = event.getExistingFileHelper();
        CompletableFuture<HolderLookup.Provider> lookupProvider = event.getLookupProvider();
        ModBlockTags blockTags = new ModBlockTags(packOutput, lookupProvider, existingFileHelper);
        // Model
        generator.addProvider(event.includeClient(), new ModItemModelProvider(packOutput, existingFileHelper));
        generator.addProvider(event.includeClient(), new ModBlockStateProvider(packOutput, existingFileHelper));
        // Tags
        generator.addProvider(event.includeServer(), blockTags);
        generator.addProvider(event.includeServer(),
                new ModItemTags(packOutput, lookupProvider, blockTags.contentsGetter(), existingFileHelper));
        // Recipes
        generator.addProvider(event.includeServer(),
                new RecipeProvider(packOutput) {
                    @Override
                    protected void buildRecipes(Consumer<FinishedRecipe> consumer) {
                        ModBasicRecipes.register(consumer);
                        ModCuttingRecipes.register(consumer);
                    }
                });
        // WorldGen
        generator.addProvider(event.includeServer(), new ModWorldgenProvider(packOutput, lookupProvider));
    }
}