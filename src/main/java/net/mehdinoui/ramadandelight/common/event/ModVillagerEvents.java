package net.mehdinoui.ramadandelight.common.event;

import net.mehdinoui.ramadandelight.Configuration;
import net.mehdinoui.ramadandelight.RamadanDelight;
import net.mehdinoui.ramadandelight.common.registry.ModBlocks;
import net.mehdinoui.ramadandelight.common.registry.ModItems;
import net.minecraft.world.entity.npc.VillagerProfession;
import net.minecraft.world.entity.npc.VillagerTrades;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.trading.MerchantOffer;
import net.minecraftforge.common.BasicItemListing;
import net.minecraftforge.event.village.VillagerTradesEvent;
import net.minecraftforge.event.village.WandererTradesEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import java.util.List;

@Mod.EventBusSubscriber(modid = RamadanDelight.MOD_ID)
public class ModVillagerEvents {
    @SubscribeEvent
    public static void onVillagerTrades(VillagerTradesEvent event) {
        if (Configuration.ENABLE_VILLAGER_TRADES.get()) {
            if (Configuration.ENABLE_FARMER_VILLAGER_TRADES.get() && event.getType() == VillagerProfession.FARMER) {
                List<VillagerTrades.ItemListing> level1Trades = event.getTrades().get(1);
                List<VillagerTrades.ItemListing> level2Trades = event.getTrades().get(2);
                List<VillagerTrades.ItemListing> level3Trades = event.getTrades().get(3);

                level1Trades.add((entity, random) -> new MerchantOffer(
                        new ItemStack(ModItems.PARSLEY.get(), 20), //YOU GET
                        new ItemStack(Items.EMERALD, 1), //I GET
                        16, // Max uses
                        2, // Villager XP
                        0.05f // Price multiplier
                ));
                level1Trades.add((entity, random) -> new MerchantOffer(
                        new ItemStack(ModItems.CHICKPEA.get(), 26), //YOU GET
                        new ItemStack(Items.EMERALD, 1), //I GET
                        16, // Max uses
                        2, // Villager XP
                        0.05f // Price multiplier
                ));
                level2Trades.add((entity, random) -> new MerchantOffer(
                        new ItemStack(Items.EMERALD, 1),
                        new ItemStack(ModItems.DATE.get(), 4),
                        16, // Max uses
                        5, // Villager XP
                        0.05f // Price multiplier
                ));
                level3Trades.add((entity, random) -> new MerchantOffer(
                        new ItemStack(ModItems.CLUSTER_OF_DATES.get(), 3),
                        new ItemStack(Items.EMERALD, 1), // Resulting Emeralds
                        12, // Max uses
                        20, // Villager XP
                        0.05f // Price multiplier
                ));
                level3Trades.add((entity, random) -> new MerchantOffer(
                        new ItemStack(ModItems.DATE_SYRUP.get(), 4),
                        new ItemStack(Items.EMERALD, 1 ), // Resulting Emeralds
                        12, // Max uses
                        20, // Villager XP
                        0.05f // Price multiplier
                ));
                level3Trades.add((entity, random) -> new MerchantOffer(
                        new ItemStack(Items.EMERALD, 3 ),
                        new ItemStack(ModItems.DATE_STUFFED_COOKIE.get(), 18),
                        12, // Max uses
                        10, // Villager XP
                        0.05f // Price multiplier
                ));
            }
            if (Configuration.ENABLE_MASON_VILLAGER_TRADES.get() && event.getType() == VillagerProfession.MASON) {
                List<VillagerTrades.ItemListing> level4Trades = event.getTrades().get(4);
                level4Trades.add((entity, random) -> new MerchantOffer(
                        new ItemStack(Items.EMERALD, 1),
                        new ItemStack(ModBlocks.MOSAIC_TILES.get(), 1),
                        12, // Max uses
                        15, // Villager XP
                        0.05f // Price multiplier
                ));
            }
        }
    }
    @SubscribeEvent
    public static void onWandererTrades(WandererTradesEvent event) {
        if (Configuration.ENABLE_WANDERING_TRADER_SELLS.get()) {
            List<VillagerTrades.ItemListing> trades = event.getGenericTrades();
            trades.add(new BasicItemListing(5, new ItemStack(ModBlocks.PALM_SAPLING.get()), 1, 1, 0.05f));
            trades.add(new BasicItemListing(5, new ItemStack(ModItems.DATES_BRANCH.get()), 1, 1, 0.05f));
            trades.add(new BasicItemListing(1, new ItemStack(ModItems.PARSLEY_SEEDS.get()), 12, 1, 0.05f));
            trades.add(new BasicItemListing(1, new ItemStack(ModItems.CHICKPEA.get()), 12, 1, 0.05f));
            trades.add(new BasicItemListing(1, new ItemStack(ModItems.DATE.get()), 12, 1, 0.05f));
            trades.add(new BasicItemListing(1, new ItemStack(ModItems.DATE.get()), 12, 1, 0.05f));

        }
    }
}
