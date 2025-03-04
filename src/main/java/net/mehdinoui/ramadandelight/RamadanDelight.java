package net.mehdinoui.ramadandelight;

import com.mojang.logging.LogUtils;
import net.mehdinoui.ramadandelight.common.registry.ModBlocks;
import net.mehdinoui.ramadandelight.common.registry.ModCreativeTab;
import net.mehdinoui.ramadandelight.common.registry.ModItems;
import net.mehdinoui.ramadandelight.common.registry.ModSounds;
import net.mehdinoui.ramadandelight.common.worldgen.tree.ModFoliagePlacer;
import net.mehdinoui.ramadandelight.common.worldgen.tree.ModTrunkPlacer;
import net.minecraft.world.entity.npc.VillagerProfession;
import net.minecraft.world.entity.npc.VillagerTrades;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.trading.MerchantOffer;
import net.minecraft.world.entity.animal.Chicken;
import net.minecraft.world.level.block.ComposterBlock;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.crafting.CompoundIngredient;
import net.minecraftforge.event.village.VillagerTradesEvent;
import net.minecraftforge.event.village.WandererTradesEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.slf4j.Logger;

import java.util.Arrays;
import java.util.List;


@Mod(RamadanDelight.MOD_ID)
public class RamadanDelight
{
    public static final String MOD_ID = "ramadandelight";
    private static final Logger LOGGER = LogUtils.getLogger();

    public RamadanDelight()
    {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();

        ModCreativeTab.register(modEventBus);
        ModItems.register(modEventBus);
        ModBlocks.register(modEventBus);
        ModSounds.register(modEventBus);

        ModTrunkPlacer.register(modEventBus);
        ModFoliagePlacer.register(modEventBus);

        ModLoadingContext.get().registerConfig(ModConfig.Type.COMMON, Configuration.CONFIG);


        modEventBus.addListener(this::commonSetup);
    }

    private void commonSetup(final FMLCommonSetupEvent event)
    {
        event.enqueueWork(() -> {
        });
    }

    @Mod.EventBusSubscriber(modid = MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
    public static class ModEventSubscriber {
        @SubscribeEvent
        public static void onCommonSetup(FMLCommonSetupEvent event) {
            event.enqueueWork(() -> {
                //30%
                ComposterBlock.COMPOSTABLES.put(ModItems.PARSLEY_SEEDS.get(), 0.3F);
                ComposterBlock.COMPOSTABLES.put(ModBlocks.PALM_SAPLING.get().asItem(), 0.3F);
                ComposterBlock.COMPOSTABLES.put(ModBlocks.PALM_LEAVES.get().asItem(), 0.3F);
                ComposterBlock.COMPOSTABLES.put(ModBlocks.DATES_BRANCH.get().asItem(), 0.3F);
                ComposterBlock.COMPOSTABLES.put(ModItems.DATE.get(), 0.3F);
                ComposterBlock.COMPOSTABLES.put(ModItems.CHICKPEA.get(), 0.3F);
                //65%
                ComposterBlock.COMPOSTABLES.put(ModItems.PARSLEY.get(), 0.65F);
                ComposterBlock.COMPOSTABLES.put(ModBlocks.WILD_PARSLEY.get().asItem(), 0.65F);
                ComposterBlock.COMPOSTABLES.put(ModBlocks.WILD_CHICKPEA.get().asItem(), 0.65F);
                //85%
                ComposterBlock.COMPOSTABLES.put(ModItems.DATE_STUFFED_COOKIE.get(), 0.85F);
                //100%
                ComposterBlock.COMPOSTABLES.put(ModItems.QUICHE.get(), 1F);
                ComposterBlock.COMPOSTABLES.put(ModItems.BOUREK.get(), 1F);
                ComposterBlock.COMPOSTABLES.put(ModItems.CLUSTER_OF_DATES.get(), 1F);

                Ingredient newChickenFood = Ingredient.of(ModItems.PARSLEY_SEEDS.get());
                Chicken.FOOD_ITEMS = new CompoundIngredient(Arrays.asList(Chicken.FOOD_ITEMS, newChickenFood))
                {
                };
            });
        }
    }

    @Mod.EventBusSubscriber(modid = MOD_ID)
    public static class newSubscriber {
        public newSubscriber() {
            MinecraftForge.EVENT_BUS.register(this);
        }

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
                    level2Trades.add((entity, random) -> new MerchantOffer(
                            new ItemStack(Items.EMERALD, 1),
                            new ItemStack(ModItems.DATE.get(), 4),
                            16, // Max uses
                            5, // Villager XP
                            0.05f // Price multiplier
                    ));
                    level3Trades.add((entity, random) -> new MerchantOffer(
                            new ItemStack(ModItems.CLUSTER_OF_DATES.get(), 1),
                            new ItemStack(Items.EMERALD, 1), // Resulting Emeralds
                            12, // Max uses
                            20, // Villager XP
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
    }
}
