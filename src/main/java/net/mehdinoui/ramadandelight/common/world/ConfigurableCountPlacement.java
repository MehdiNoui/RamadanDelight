package net.mehdinoui.ramadandelight.common.world;

import com.mojang.serialization.Codec;
import com.mojang.serialization.MapCodec;
import net.mehdinoui.ramadandelight.ModConfiguration;
import net.mehdinoui.ramadandelight.common.registry.ModPlacementModifiers;
import net.minecraft.core.BlockPos;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.levelgen.placement.PlacementModifierType;
import net.minecraft.world.level.levelgen.placement.RepeatingPlacement;
import org.jetbrains.annotations.NotNull;

public class ConfigurableCountPlacement extends RepeatingPlacement {
    public static final MapCodec<ConfigurableCountPlacement> CODEC =
            Codec.STRING.fieldOf("config_key")
                    .xmap(ConfigurableCountPlacement::new, ConfigurableCountPlacement::getConfigKey);
    private final String configKey;

    public ConfigurableCountPlacement(String configKey) {
        this.configKey = configKey;
    }
    public String getConfigKey() {
        return this.configKey;
    }
    @Override
    protected int count(@NotNull RandomSource random, @NotNull BlockPos pos) {
        return getConfigCount(this.configKey);
    }

    private int getConfigCount(String key) {
        return switch (key) {
            case "date_palm_count" -> ModConfiguration.COUNT_DATE_PALM_TREE.get();
            default -> 0;
        };
    }

    @Override
    public @NotNull PlacementModifierType<?> type() {
        return ModPlacementModifiers.CONFIGURABLE_COUNT.get();
    }
}