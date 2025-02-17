package net.mehdinoui.ramadandelight;

import net.minecraftforge.common.ForgeConfigSpec;

public class Configuration {
    public static final ForgeConfigSpec.Builder BUILDER = new ForgeConfigSpec.Builder();
    public static final ForgeConfigSpec CONFIG;

    // Configurable values
    public static final ForgeConfigSpec.BooleanValue ENABLE_VILLAGER_TRADES;

    static {
        BUILDER.push("Villager Settings");
        ENABLE_VILLAGER_TRADES = BUILDER
                .comment("Enable Ramadan delight villager trades")
                .define("enableVillagerTrades", true);
        BUILDER.pop();

        CONFIG = BUILDER.build();
    }
}
