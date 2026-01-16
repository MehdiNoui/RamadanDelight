package net.mehdinoui.ramadandelight.common.registry;

import net.mehdinoui.ramadandelight.RamadanDelight;
import net.minecraft.core.HolderSet;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.levelgen.GenerationStep;
import net.minecraftforge.common.Tags;
import net.minecraftforge.common.world.BiomeModifier;
import net.minecraftforge.common.world.ForgeBiomeModifiers;
import net.minecraftforge.registries.ForgeRegistries;

public class ModBiomeModifiers {
    // --- Keys ---
    public static final ResourceKey<BiomeModifier> ADD_TREE_PALM = ResourceKey.create(ForgeRegistries.Keys.BIOME_MODIFIERS,
            new ResourceLocation(RamadanDelight.MOD_ID, "add_tree_palm"));

    // --- Register ---
    public static void bootstrap(BootstapContext<BiomeModifier> context) {
        var biomes = context.lookup(Registries.BIOME);
        var placedFeatures = context.lookup(Registries.PLACED_FEATURE);

        context.register(ADD_TREE_PALM,
                new ForgeBiomeModifiers.AddFeaturesBiomeModifier(
                        biomes.getOrThrow(Tags.Biomes.IS_DESERT),
                        HolderSet.direct(placedFeatures.getOrThrow(ModPlacedFeatures.DATE_PALM_PLACED_KEY)),
                        GenerationStep.Decoration.VEGETAL_DECORATION));
    }
}