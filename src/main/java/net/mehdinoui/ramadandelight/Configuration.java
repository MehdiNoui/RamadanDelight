package net.mehdinoui.ramadandelight;

import net.minecraftforge.common.ForgeConfigSpec;

public class Configuration {
    public static final ForgeConfigSpec.Builder BUILDER = new ForgeConfigSpec.Builder();
    public static final ForgeConfigSpec CONFIG;

    // Configurable values
    public static final ForgeConfigSpec.BooleanValue ENABLE_VILLAGER_TRADES;
    public static final ForgeConfigSpec.BooleanValue ENABLE_FARMER_VILLAGER_TRADES;
    public static final ForgeConfigSpec.BooleanValue ENABLE_MASON_VILLAGER_TRADES;
    public static final ForgeConfigSpec.BooleanValue ENABLE_WANDERING_TRADER_SELLS;

    static {
        BUILDER.push("Villager Settings");

        ENABLE_VILLAGER_TRADES = BUILDER
                .comment("Enable Ramadan Delight villager trades (all)")
                .define("enableVillagerTrades", true);

        ENABLE_FARMER_VILLAGER_TRADES = BUILDER
                .comment("Enable Ramadan Delight farmer villager trades (such as parsley, dates...)")
                .define("enableFarmerVillagerTrades", true);

        ENABLE_MASON_VILLAGER_TRADES = BUILDER
                .comment("Enable Ramadan Delight Mason villager trades (such as Mosaic Tiles)")
                .define("enableMasonVillagerTrades", true);

        ENABLE_WANDERING_TRADER_SELLS = BUILDER
                .comment("Enable Ramadan Delight Wandering Trader trades")
                .define("enableWanderingTrades", true);
        BUILDER.pop();

        BUILDER.pop();

        CONFIG = BUILDER.build();
    }
}
