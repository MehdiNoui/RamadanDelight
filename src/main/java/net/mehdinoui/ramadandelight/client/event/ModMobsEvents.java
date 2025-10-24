package net.mehdinoui.ramadandelight.client.event;

import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Sets;
import net.mehdinoui.ramadandelight.common.registry.ModItems;
import net.minecraft.world.entity.animal.Chicken;
import net.minecraft.world.entity.animal.Parrot;
import net.minecraft.world.entity.npc.Villager;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraftforge.common.crafting.CompoundIngredient;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;

import java.util.Arrays;
import java.util.Collections;
import java.util.Set;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD, modid = "ramadandelight")
public class ModMobsEvents {
    @SubscribeEvent
    public static void onCommonSetup(FMLCommonSetupEvent event) {
        // Chicken
        event.enqueueWork(() -> {
            Ingredient newChickenFood = Ingredient.of(ModItems.PARSLEY_SEEDS.get());
            Chicken.FOOD_ITEMS = new CompoundIngredient(Arrays.asList(Chicken.FOOD_ITEMS, newChickenFood)) {};
        });

        // Parrot
        Collections.addAll(Parrot.TAME_FOOD,
                ModItems.PARSLEY_SEEDS.get());

        // Villager
        Set<Item> newWantedItems = Sets.newHashSet(
                // Bread
                ModItems.FLAT_BREAD.get(),
                // Crops
                ModItems.CHICKPEA.get(),
                ModItems.PARSLEY.get(),
                ModItems.PARSLEY_SEEDS.get(),
                // Fruits
                ModItems.DATE.get());

        newWantedItems.addAll(Villager.WANTED_ITEMS);
        Villager.WANTED_ITEMS = ImmutableSet.copyOf(newWantedItems);
    }
}
