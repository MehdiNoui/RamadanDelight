package net.mehdinoui.ramadandelight.common.util;

import net.mehdinoui.ramadandelight.RamadanDelight;
import net.minecraft.world.level.block.state.properties.BlockSetType;
import net.minecraft.world.level.block.state.properties.WoodType;

public class RDWoodTypes {
    public static final WoodType PALM = WoodType.register(new WoodType(RamadanDelight.MOD_ID+":palm", BlockSetType.OAK));
}
