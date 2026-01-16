package net.mehdinoui.ramadandelight.common.registry;

import net.mehdinoui.ramadandelight.RamadanDelight;
import net.mehdinoui.ramadandelight.common.world.ConfigurableCountPlacement;
import net.mehdinoui.ramadandelight.common.world.ConfigurableRarityFilter;
import net.minecraft.core.BlockPos;
import net.minecraft.core.HolderGetter;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.levelgen.blockpredicates.BlockPredicate;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.placement.*;

import java.util.List;

public class ModPlacedFeatures {
    // --- Keys ---
    public static final ResourceKey<PlacedFeature> DATE_PALM_PLACED_KEY = ResourceKey.create(Registries.PLACED_FEATURE,
            new ResourceLocation(RamadanDelight.MOD_ID, "date_palm_tree"));

    public static final ResourceKey<PlacedFeature> CHICKPEA_PLACED_KEY = ResourceKey.create(Registries.PLACED_FEATURE,
            new ResourceLocation(RamadanDelight.MOD_ID, "patch_wild_chickpea"));

    public static final ResourceKey<PlacedFeature> PARSLEY_PLACED_KEY = ResourceKey.create(Registries.PLACED_FEATURE,
            new ResourceLocation(RamadanDelight.MOD_ID, "patch_wild_parsley"));

    // --- Register ---
    public static void bootstrap(BootstapContext<PlacedFeature> context) {
        HolderGetter<ConfiguredFeature<?, ?>> configured = context.lookup(Registries.CONFIGURED_FEATURE);

        context.register(
                DATE_PALM_PLACED_KEY,
                new PlacedFeature(
                        configured.getOrThrow(ModConfiguredFeatures.DATE_PALM_CONFIGURED_KEY),
                        List.of(
                                new ConfigurableRarityFilter("date_palm_tree"),
                                new ConfigurableCountPlacement("date_palm_count"),
                                InSquarePlacement.spread(),
                                PlacementUtils.HEIGHTMAP,
                                BlockPredicateFilter.forPredicate(BlockPredicate.wouldSurvive(ModBlocks.PALM_SAPLING.get().defaultBlockState(), BlockPos.ZERO)),
                                BiomeFilter.biome()
                        )
                )
        );
        context.register(
                CHICKPEA_PLACED_KEY,
                new PlacedFeature(
                        configured.getOrThrow(ModConfiguredFeatures.CHICKPEA_CONFIGURED_KEY),
                        List.of(
                                new ConfigurableRarityFilter("wild_chickpea"),
                                InSquarePlacement.spread(),
                                PlacementUtils.HEIGHTMAP,
                                BiomeFilter.biome()
                        )
                )
        );
        context.register(
                PARSLEY_PLACED_KEY,
                new PlacedFeature(
                        configured.getOrThrow(ModConfiguredFeatures.PARSLEY_CONFIGURED_KEY),
                        List.of(
                                new ConfigurableRarityFilter("wild_parsley"),
                                InSquarePlacement.spread(),
                                PlacementUtils.HEIGHTMAP,
                                BiomeFilter.biome()
                        )
                )
        );
    }
}