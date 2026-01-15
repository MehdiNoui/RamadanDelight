package net.mehdinoui.ramadandelight.data;

import net.mehdinoui.ramadandelight.common.registry.ModItems;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.common.data.DataMapProvider;
import net.neoforged.neoforge.registries.datamaps.builtin.Compostable;
import net.neoforged.neoforge.registries.datamaps.builtin.NeoForgeDataMaps;

import java.util.concurrent.CompletableFuture;

public class ModCompostablesDataMap extends DataMapProvider {
    public ModCompostablesDataMap(PackOutput packOutput, CompletableFuture<HolderLookup.Provider> lookupProvider) {
        super(packOutput, lookupProvider);
    }

    @Override
    protected void gather(HolderLookup.Provider provider) {
        var builder = builder(NeoForgeDataMaps.COMPOSTABLES);

        // 30% Chance
        builder.add(ModItems.PARSLEY_SEEDS.asItem().builtInRegistryHolder(), new Compostable(0.3F), false);
        builder.add(ModItems.PALM_SAPLING.asItem().builtInRegistryHolder(), new Compostable(0.3F), false);
        builder.add(ModItems.PALM_LEAVES.asItem().builtInRegistryHolder(), new Compostable(0.3F), false);
        builder.add(ModItems.DATES_BRANCH.asItem().builtInRegistryHolder(), new Compostable(0.3F), false);
        builder.add(ModItems.DATE.asItem().builtInRegistryHolder(), new Compostable(0.3F), false);
        builder.add(ModItems.CHICKPEA.asItem().builtInRegistryHolder(), new Compostable(0.3F), false);

        // 65% Chance
        builder.add(ModItems.PARSLEY.asItem().builtInRegistryHolder(), new Compostable(0.65F), false);
        builder.add(ModItems.WILD_PARSLEY.asItem().builtInRegistryHolder(), new Compostable(0.65F), false);
        builder.add(ModItems.WILD_CHICKPEA.asItem().builtInRegistryHolder(), new Compostable(0.65F), false);

        // 85% Chance
        builder.add(ModItems.DATE_STUFFED_COOKIE.asItem().builtInRegistryHolder(), new Compostable(0.85F), false);

        // 100% Chance
        builder.add(ModItems.QUICHE.asItem().builtInRegistryHolder(), new Compostable(1.0F), false);
        builder.add(ModItems.BOUREK.asItem().builtInRegistryHolder(), new Compostable(1.0F), false);
        builder.add(ModItems.CLUSTER_OF_DATES.asItem().builtInRegistryHolder(), new Compostable(1.0F), false);
    }
}