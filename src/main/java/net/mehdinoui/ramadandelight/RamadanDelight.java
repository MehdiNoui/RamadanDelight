package net.mehdinoui.ramadandelight;

import com.mojang.logging.LogUtils;
import net.mehdinoui.ramadandelight.common.registry.ModBlocks;
import net.mehdinoui.ramadandelight.common.registry.ModCreativeTab;
import net.mehdinoui.ramadandelight.common.registry.ModItems;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.block.ComposterBlock;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.crafting.CompoundIngredient;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraft.world.entity.animal.Chicken;
import org.slf4j.Logger;

import java.util.Arrays;


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

            });
        }
    }

    @Mod.EventBusSubscriber(modid = MOD_ID)
    public static class newSubscriber {
        public newSubscriber() {
            MinecraftForge.EVENT_BUS.register(this);
        }
    }

}
