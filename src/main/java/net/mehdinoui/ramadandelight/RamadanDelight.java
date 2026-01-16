package net.mehdinoui.ramadandelight;

import net.mehdinoui.ramadandelight.common.registry.*;
import net.mehdinoui.ramadandelight.common.world.ModVillageStructures;
import net.mehdinoui.ramadandelight.common.world.tree.ModFoliagePlacer;
import net.mehdinoui.ramadandelight.common.world.tree.ModTrunkPlacer;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod(RamadanDelight.MOD_ID)
public class RamadanDelight {
    public static final String MOD_ID = "ramadandelight";
    public RamadanDelight() {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();

        ModCreativeTab.register(modEventBus);
        ModItems.register(modEventBus);
        ModBlocks.register(modEventBus);
        ModSoundEvents.register(modEventBus);
        ModEntities.register(modEventBus);
        ModPlacementModifiers.register(modEventBus);

        ModTrunkPlacer.register(modEventBus);
        ModFoliagePlacer.register(modEventBus);

        ModLoadingContext.get().registerConfig(ModConfig.Type.COMMON, ModConfiguration.CONFIG);

        MinecraftForge.EVENT_BUS.addListener(ModVillageStructures::addNewVillageBuilding);
        MinecraftForge.EVENT_BUS.register(this);
    }
}
