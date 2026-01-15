package net.mehdinoui.ramadandelight;

import net.mehdinoui.ramadandelight.common.registry.*;
import net.mehdinoui.ramadandelight.common.world.ModVillageStructures;
import net.mehdinoui.ramadandelight.common.world.tree.ModFoliagePlacer;
import net.mehdinoui.ramadandelight.common.world.tree.ModTrunkPlacer;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.config.ModConfig;

import static net.neoforged.neoforge.common.NeoForge.EVENT_BUS;

@Mod(RamadanDelight.MOD_ID)
public class RamadanDelight {
    public static final String MOD_ID = "ramadandelight";
    public RamadanDelight(IEventBus modEventBus, ModContainer modContainer) {
        ModCreativeTab.register(modEventBus);
        ModItems.register(modEventBus);
        ModBlocks.register(modEventBus);
        ModPlacementModifiers.register(modEventBus);
        ModSoundEvents.register(modEventBus);
        ModEntities.register(modEventBus);

        ModTrunkPlacer.register(modEventBus);
        ModFoliagePlacer.register(modEventBus);

        modContainer.registerConfig(ModConfig.Type.COMMON, ModConfiguration.CONFIG);
        EVENT_BUS.addListener(ModVillageStructures::addNewVillageBuilding);
    }
}
