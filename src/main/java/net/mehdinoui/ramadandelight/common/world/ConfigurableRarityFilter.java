package net.mehdinoui.ramadandelight.common.world;

import com.mojang.serialization.Codec;
import net.mehdinoui.ramadandelight.ModConfiguration;
import net.mehdinoui.ramadandelight.common.registry.ModPlacementModifiers;
import net.minecraft.core.BlockPos;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.levelgen.placement.PlacementContext;
import net.minecraft.world.level.levelgen.placement.PlacementFilter;
import net.minecraft.world.level.levelgen.placement.PlacementModifierType;
import org.jetbrains.annotations.NotNull;

public class ConfigurableRarityFilter extends PlacementFilter {
    public static final Codec<ConfigurableRarityFilter> CODEC = Codec.STRING
            .fieldOf("config_key")
            .xmap(ConfigurableRarityFilter::new, ConfigurableRarityFilter::getConfigKey)
            .codec();
    private final String configKey;

    public ConfigurableRarityFilter(String configKey) {
        this.configKey = configKey;
    }

    public String getConfigKey() {
        return this.configKey;
    }

    @Override
    protected boolean shouldPlace(@NotNull PlacementContext ctx, @NotNull RandomSource random, @NotNull BlockPos pos) {
        int chance = getConfigValue(this.configKey);
        if (chance <= 0) {
            return false;
        }
        if (chance == 1) {
            return true;
        }
        return random.nextInt(chance) == 0;
    }

    private int getConfigValue(String key) {
        return switch (key) {
            case "date_palm_tree" -> ModConfiguration.CHANCE_DATE_PALM_TREE.get();
            case "wild_chickpea" -> ModConfiguration.CHANCE_WILD_CHICKPEA.get();
            case "wild_parsley" -> ModConfiguration.CHANCE_WILD_PARSLEY.get();
            default -> 0;
        };
    }

    @Override
    public @NotNull PlacementModifierType<?> type() {
        return ModPlacementModifiers.CONFIGURABLE_RARITY_FILTER.get();
    }
}