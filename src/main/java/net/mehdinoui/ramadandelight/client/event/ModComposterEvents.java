package net.mehdinoui.ramadandelight.client.event;

import net.mehdinoui.ramadandelight.common.registry.ModBlocks;
import net.mehdinoui.ramadandelight.common.registry.ModItems;
import net.minecraft.world.entity.animal.Chicken;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.block.ComposterBlock;
import net.minecraftforge.common.crafting.CompoundIngredient;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;

import java.util.Arrays;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD, modid = "ramadandelight")
public class ModComposterEvents {
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
        });
    }
}
