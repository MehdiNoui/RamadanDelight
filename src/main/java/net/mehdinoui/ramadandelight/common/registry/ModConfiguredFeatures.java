package net.mehdinoui.ramadandelight.common.registry;

import net.mehdinoui.ramadandelight.RamadanDelight;
import net.mehdinoui.ramadandelight.common.world.tree.custom.PalmFoliagePlacer;
import net.mehdinoui.ramadandelight.common.world.tree.custom.PalmTrunkPlacer;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.valueproviders.ConstantInt;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.TreeConfiguration;
import net.minecraft.world.level.levelgen.feature.featuresize.TwoLayersFeatureSize;
import net.minecraft.world.level.levelgen.feature.stateproviders.BlockStateProvider;

public class ModConfiguredFeatures {
    // --- Keys ---
    public static final ResourceKey<ConfiguredFeature<?, ?>> PALM_KEY = ResourceKey.create(Registries.CONFIGURED_FEATURE,
            ResourceLocation.fromNamespaceAndPath(RamadanDelight.MOD_ID, "palm_tree"));

    // --- Register ---
    public static void bootstrap(BootstrapContext<ConfiguredFeature<?, ?>> context) {
        context.register(PALM_KEY, new ConfiguredFeature<>(
                Feature.TREE,
                new TreeConfiguration.TreeConfigurationBuilder(
                        BlockStateProvider.simple(ModBlocks.PALM_LOG.get()),
                        new PalmTrunkPlacer(7, 5, 3),
                        BlockStateProvider.simple(ModBlocks.PALM_LEAVES.get()),
                        new PalmFoliagePlacer(ConstantInt.of(3), ConstantInt.of(2), 3),
                        new TwoLayersFeatureSize(1, 0, 1)
                ).build()
        ));
    }
}