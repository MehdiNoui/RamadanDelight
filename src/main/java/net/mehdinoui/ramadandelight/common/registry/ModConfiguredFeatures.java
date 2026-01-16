package net.mehdinoui.ramadandelight.common.registry;

import net.mehdinoui.ramadandelight.RamadanDelight;
import net.mehdinoui.ramadandelight.common.world.tree.custom.PalmFoliagePlacer;
import net.mehdinoui.ramadandelight.common.world.tree.custom.PalmTrunkPlacer;
import net.minecraft.core.Holder;
import net.minecraft.core.Vec3i;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.util.valueproviders.ConstantInt;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.blockpredicates.BlockPredicate;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.SimpleBlockConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.TreeConfiguration;
import net.minecraft.world.level.levelgen.feature.featuresize.TwoLayersFeatureSize;
import net.minecraft.world.level.levelgen.feature.stateproviders.BlockStateProvider;
import net.minecraft.world.level.levelgen.feature.stateproviders.SimpleStateProvider;
import net.minecraft.world.level.levelgen.placement.BlockPredicateFilter;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;
import vectorwing.farmersdelight.common.registry.ModBiomeFeatures;
import vectorwing.farmersdelight.common.world.configuration.WildCropConfiguration;

import java.util.List;

public class ModConfiguredFeatures {
    // --- Keys ---
    public static final ResourceKey<ConfiguredFeature<?, ?>> DATE_PALM_CONFIGURED_KEY = ResourceKey.create(Registries.CONFIGURED_FEATURE,
            new ResourceLocation(RamadanDelight.MOD_ID, "date_palm_tree"));
    public static final ResourceKey<ConfiguredFeature<?, ?>> CHICKPEA_CONFIGURED_KEY = ResourceKey.create(Registries.CONFIGURED_FEATURE,
            new ResourceLocation(RamadanDelight.MOD_ID, "patch_wild_chickpea"));
    public static final ResourceKey<ConfiguredFeature<?, ?>> PARSLEY_CONFIGURED_KEY = ResourceKey.create(Registries.CONFIGURED_FEATURE,
            new ResourceLocation(RamadanDelight.MOD_ID, "patch_wild_parsley"));

    // --- Register ---
    public static void bootstrap(BootstapContext<ConfiguredFeature<?, ?>> context) {
        BlockPredicate onDirt = BlockPredicate.matchesTag(new Vec3i(0, -1, 0), BlockTags.DIRT);

        context.register(DATE_PALM_CONFIGURED_KEY, new ConfiguredFeature<>(
                Feature.TREE,
                new TreeConfiguration.TreeConfigurationBuilder(
                        BlockStateProvider.simple(ModBlocks.PALM_LOG.get()),
                        new PalmTrunkPlacer(7, 5, 3),
                        BlockStateProvider.simple(ModBlocks.PALM_LEAVES.get()),
                        new PalmFoliagePlacer(ConstantInt.of(3), ConstantInt.of(2), 3),
                        new TwoLayersFeatureSize(1, 0, 1)
                ).build()
        ));

        context.register(CHICKPEA_CONFIGURED_KEY, new ConfiguredFeature<>(
                ModBiomeFeatures.WILD_CROP.get(),
                new WildCropConfiguration(64, 6, 3,
                        patchEntry(ModBlocks.WILD_CHICKPEA.get().defaultBlockState(), onDirt),
                        patchEntry(Blocks.GRASS.defaultBlockState(), onDirt),
                        coarseDirtFloor()
                )
        ));

        context.register(PARSLEY_CONFIGURED_KEY, new ConfiguredFeature<>(
                ModBiomeFeatures.WILD_CROP.get(),
                new WildCropConfiguration(64, 6, 3,
                        patchEntry(ModBlocks.WILD_PARSLEY.get().defaultBlockState(), onDirt),
                        patchEntry(Blocks.GRASS.defaultBlockState(), onDirt),
                        coarseDirtFloor()
                )
        ));
    }

    // --- Helpers ---
    private static Holder<PlacedFeature> patchEntry(BlockState block, BlockPredicate plantedOn) {
        return Holder.direct(new PlacedFeature(
                Holder.direct(new ConfiguredFeature<>(
                        Feature.SIMPLE_BLOCK,
                        new SimpleBlockConfiguration(SimpleStateProvider.simple(block))
                )),
                List.of(BlockPredicateFilter.forPredicate(
                        BlockPredicate.allOf(
                                BlockPredicate.ONLY_IN_AIR_PREDICATE,
                                plantedOn
                        )
                ))
        ));
    }

    private static Holder<PlacedFeature> coarseDirtFloor() {
        return Holder.direct(new PlacedFeature(
                Holder.direct(new ConfiguredFeature<>(
                        Feature.SIMPLE_BLOCK,
                        new SimpleBlockConfiguration(SimpleStateProvider.simple(Blocks.COARSE_DIRT.defaultBlockState()))
                )),
                List.of(BlockPredicateFilter.forPredicate(
                        BlockPredicate.allOf(
                                BlockPredicate.matchesTag(BlockTags.DIRT),
                                BlockPredicate.replaceable(new Vec3i(0, 1, 0))
                        )
                ))
        ));
    }
}