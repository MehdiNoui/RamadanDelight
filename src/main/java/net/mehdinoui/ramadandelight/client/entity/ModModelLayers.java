package net.mehdinoui.ramadandelight.client.entity;

import net.mehdinoui.ramadandelight.RamadanDelight;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.resources.ResourceLocation;

public class ModModelLayers {
    public static final ModelLayerLocation PALM_BOAT_LAYER = new ModelLayerLocation(
            ResourceLocation.fromNamespaceAndPath(RamadanDelight.MOD_ID, "boat/palm"), "main");
    public static final ModelLayerLocation PALM_CHEST_BOAT_LAYER = new ModelLayerLocation(
            ResourceLocation.fromNamespaceAndPath(RamadanDelight.MOD_ID, "chest_boat/palm"), "main");

}
