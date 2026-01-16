package net.mehdinoui.ramadandelight.common.event;

import net.mehdinoui.ramadandelight.common.registry.ModItems;
import net.minecraft.world.level.block.ComposterBlock;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD, modid = "ramadandelight")
public class ModComposterEvents {
    @SubscribeEvent
    public static void onCommonSetup(FMLCommonSetupEvent event) {
        event.enqueueWork(() -> {
            //30%
            ComposterBlock.COMPOSTABLES.put(ModItems.PARSLEY_SEEDS.get(), 0.3F);
            ComposterBlock.COMPOSTABLES.put(ModItems.PALM_SAPLING.get(), 0.3F);
            ComposterBlock.COMPOSTABLES.put(ModItems.PALM_LEAVES.get(), 0.3F);
            ComposterBlock.COMPOSTABLES.put(ModItems.DATES_BRANCH.get(), 0.3F);
            ComposterBlock.COMPOSTABLES.put(ModItems.DATE.get(), 0.3F);
            ComposterBlock.COMPOSTABLES.put(ModItems.CHICKPEA.get(), 0.3F);
            //65%
            ComposterBlock.COMPOSTABLES.put(ModItems.PARSLEY.get(), 0.65F);
            ComposterBlock.COMPOSTABLES.put(ModItems.WILD_PARSLEY.get(), 0.65F);
            ComposterBlock.COMPOSTABLES.put(ModItems.WILD_CHICKPEA.get(), 0.65F);
            //85%
            ComposterBlock.COMPOSTABLES.put(ModItems.DATE_STUFFED_COOKIE.get(), 0.85F);
            //100%
            ComposterBlock.COMPOSTABLES.put(ModItems.QUICHE.get(), 1F);
            ComposterBlock.COMPOSTABLES.put(ModItems.BOUREK.get(), 1F);
            ComposterBlock.COMPOSTABLES.put(ModItems.CLUSTER_OF_DATES.get(), 1F);
        });
    }
}
