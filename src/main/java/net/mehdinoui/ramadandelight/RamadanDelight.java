package net.mehdinoui.ramadandelight;

import com.mojang.logging.LogUtils;
import net.mehdinoui.ramadandelight.common.registry.*;
import net.mehdinoui.ramadandelight.common.worldgen.tree.ModFoliagePlacer;
import net.mehdinoui.ramadandelight.common.worldgen.tree.ModTrunkPlacer;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
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
        ModSounds.register(modEventBus);
        ModEntities.register(modEventBus);

        ModTrunkPlacer.register(modEventBus);
        ModFoliagePlacer.register(modEventBus);

        ModLoadingContext.get().registerConfig(ModConfig.Type.COMMON, Configuration.CONFIG);
    }
}
