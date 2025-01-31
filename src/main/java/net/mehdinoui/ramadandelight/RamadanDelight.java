package net.mehdinoui.ramadandelight;

import com.mojang.logging.LogUtils;
import net.mehdinoui.ramadandelight.common.registry.ModBlocks;
import net.mehdinoui.ramadandelight.common.registry.ModCreativeTab;
import net.mehdinoui.ramadandelight.common.registry.ModItems;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.slf4j.Logger;



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
                /*ComposterBlock.COMPOSTABLES.put(ModItems.BELLPEPPER_SEEDS.get(), 0.3F);*/
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
