package net.mehdinoui.ramadandelight.common.event;

import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Sets;
import net.mehdinoui.ramadandelight.RamadanDelight;
import net.mehdinoui.ramadandelight.common.registry.ModItems;
import net.minecraft.world.entity.npc.Villager;
import net.minecraft.world.item.Item;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent;

import java.util.HashMap;
import java.util.Set;

@EventBusSubscriber(modid = RamadanDelight.MOD_ID)
public class ModMobsEvents {
    @SubscribeEvent
    public static void onCommonSetup(FMLCommonSetupEvent event) {
        // Villager
        Set<Item> newWantedItems = Sets.newHashSet(
                // Bread
                ModItems.FLAT_BREAD.get(),
                // Crops
                ModItems.CHICKPEA.get(),
                ModItems.PARSLEY.get(),
                // Fruits
                ModItems.DATE.get());

        newWantedItems.addAll(Villager.WANTED_ITEMS);
        Villager.WANTED_ITEMS = ImmutableSet.copyOf(newWantedItems);

        HashMap<Item, Integer> newFoodPoints = new HashMap<>();

        newFoodPoints.put(ModItems.FLAT_BREAD.get(), 4);

        newFoodPoints.put(ModItems.CHICKPEA.get(), 1);
        newFoodPoints.put(ModItems.PARSLEY.get(), 1);
        newFoodPoints.put(ModItems.DATE.get(), 1);
        newFoodPoints.putAll(Villager.FOOD_POINTS);

        Villager.FOOD_POINTS = ImmutableMap.copyOf(newFoodPoints);
    }
}
