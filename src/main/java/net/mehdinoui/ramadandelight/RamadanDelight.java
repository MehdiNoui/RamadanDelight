package net.mehdinoui.ramadandelight;

import com.mojang.logging.LogUtils;
import net.mehdinoui.ramadandelight.common.registry.ModBlocks;
import net.mehdinoui.ramadandelight.common.registry.ModCreativeTab;
import net.mehdinoui.ramadandelight.common.registry.ModItems;
import net.minecraft.world.entity.npc.VillagerProfession;
import net.minecraft.world.entity.npc.VillagerTrades;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.trading.MerchantOffer;
import net.minecraft.world.entity.animal.Pig;
import net.minecraft.world.entity.animal.Chicken;
import net.minecraft.world.level.block.ComposterBlock;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.crafting.CompoundIngredient;
import net.minecraftforge.event.village.VillagerTradesEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
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

        modEventBus.addListener(this::commonSetup);
    }

    private void commonSetup(final FMLCommonSetupEvent event)
    {
        event.enqueueWork(() -> {});
    }

    @Mod.EventBusSubscriber(modid = MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
    public static class ModEventSubscriber {
        @SubscribeEvent
        public static void onCommonSetup(FMLCommonSetupEvent event) {
            event.enqueueWork(() -> {
                //30%
                ComposterBlock.COMPOSTABLES.put(ModItems.PARSLEY_SEEDS.get(), 0.3F);
                //65%
                ComposterBlock.COMPOSTABLES.put(ModItems.PARSLEY.get(), 0.65F);
                ComposterBlock.COMPOSTABLES.put(ModBlocks.WILD_PARSLEY.get(), 0.65F);
                //100%
                ComposterBlock.COMPOSTABLES.put(ModItems.QUICHE.get(), 1F);
                ComposterBlock.COMPOSTABLES.put(ModItems.BOUREK.get(), 1F);

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
            if (event.getType() == VillagerProfession.FARMER) {
                List<VillagerTrades.ItemListing> level1Trades = event.getTrades().get(1);

                level1Trades.add((entity, random) -> new MerchantOffer(
                        new ItemStack(ModItems.PARSLEY.get(), 26), // Soybean in quantity
                        new ItemStack(Items.EMERALD, 1), // Resulting Emeralds
                        12, // Max uses
                        3, // Villager XP
                        0.05f // Price multiplier
                ));
            }
        }
    }


}
