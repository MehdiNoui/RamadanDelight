package net.mehdinoui.ramadandelight;

import net.minecraftforge.common.ForgeConfigSpec;

public class ModConfiguration {
    public static final ForgeConfigSpec.Builder BUILDER = new ForgeConfigSpec.Builder();
    public static final ForgeConfigSpec CONFIG;

    // Configurable values
    public static final ForgeConfigSpec.BooleanValue ENABLE_VILLAGER_TRADES;
    public static final ForgeConfigSpec.BooleanValue ENABLE_FARMER_VILLAGER_TRADES;
    public static final ForgeConfigSpec.BooleanValue ENABLE_MASON_VILLAGER_TRADES;
    public static final ForgeConfigSpec.BooleanValue ENABLE_WANDERING_TRADER_SELLS;

    // --- World Generation ---
    public static final ForgeConfigSpec.IntValue CHANCE_DATE_PALM_TREE;
    public static final ForgeConfigSpec.IntValue COUNT_DATE_PALM_TREE;
    public static final ForgeConfigSpec.IntValue CHANCE_WILD_CHICKPEA;
    public static final ForgeConfigSpec.IntValue CHANCE_WILD_PARSLEY;

    public static final ForgeConfigSpec.BooleanValue GENERATE_VILLAGE_STRUCTURES;

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

        BUILDER.push("Village Settings");
        GENERATE_VILLAGE_STRUCTURES = BUILDER
                .comment("Enable Ramadan Delight to add Palm Trees to Desert Villages")
                .define("enableVillageStructures", true);

        BUILDER.push("Worldgen Settings");

        CHANCE_DATE_PALM_TREE = BUILDER
                .comment("Chance of Date Palm Tree generating in the world. (0 to disable, higher = rarer)")
                .defineInRange("chanceDatePalm", 100, 0, 512);
        COUNT_DATE_PALM_TREE = BUILDER
                .comment("Count of Date Palm Trees generating per chunk (0 to disable, higher = rarer)")
                .defineInRange("countDatePalm", 1, 0, 16);

        CHANCE_WILD_CHICKPEA = BUILDER
                .comment("Chance of Wild Chickpea in the world. (0 to disable, higher = rarer)")
                .defineInRange("chanceChickpea", 110, 0, 512);
        CHANCE_WILD_PARSLEY = BUILDER
                .comment("Chance of Parsley generating in the world. (0 to disable, higher = rarer)")
                .defineInRange("chanceParsley", 130, 0, 512);

        BUILDER.pop();
        BUILDER.pop();

        CONFIG = BUILDER.build();
    }
}