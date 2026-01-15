package net.mehdinoui.ramadandelight.data;

import net.mehdinoui.ramadandelight.RamadanDelight;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.RecipeOutput;
import net.minecraft.data.recipes.RecipeProvider;
import net.mehdinoui.ramadandelight.data.recipe.*;
import net.mehdinoui.ramadandelight.data.tag.*;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.neoforged.neoforge.data.event.GatherDataEvent;
import org.jetbrains.annotations.NotNull;

import java.util.concurrent.CompletableFuture;

@EventBusSubscriber(modid = RamadanDelight.MOD_ID)
public class DataGenerators {
    @SubscribeEvent
    public static void gatherData(GatherDataEvent event) {
        DataGenerator generator = event.getGenerator();
        PackOutput packOutput = generator.getPackOutput();
        ExistingFileHelper existingFileHelper = event.getExistingFileHelper();
        CompletableFuture<HolderLookup.Provider> lookupProvider = event.getLookupProvider();

        // Tags
        BlockTags blockTags = new BlockTags(packOutput, lookupProvider, existingFileHelper);
        ItemTags itemTags = new ItemTags(packOutput, lookupProvider, blockTags.contentsGetter(), existingFileHelper);
        generator.addProvider(event.includeServer(), blockTags);
        generator.addProvider(event.includeServer(), itemTags);

        // Compostables (DataMapProvider)
        generator.addProvider(event.includeServer(),
                new ModCompostablesDataMap(packOutput, lookupProvider));

        // Model
        generator.addProvider(event.includeClient(), new ModItemModelProvider(packOutput, existingFileHelper));
        generator.addProvider(event.includeClient(), new ModBlockStateProvider(packOutput, existingFileHelper));

        // Loot Tables
        generator.addProvider(event.includeServer(), ModLootProvider.create(packOutput, lookupProvider));

        // Recipes
        generator.addProvider(event.includeServer(),
                new RecipeProvider(packOutput, lookupProvider) {
                    @Override
                    protected void buildRecipes(@NotNull RecipeOutput consumer) {
                        ModBasicRecipes.register(consumer);
                        ModCookingRecipes.register(consumer);
                        ModCuttingRecipes.register(consumer);
                        ModSmeltingRecipes.register(consumer);
                        ModStoneCuttingRecipes.register(consumer);
                    }
                });

        // World-Gen
        generator.addProvider(event.includeServer(), new ModWorldGenProvider(packOutput, lookupProvider));
    }
}