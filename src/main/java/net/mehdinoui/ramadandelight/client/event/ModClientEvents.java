package net.mehdinoui.ramadandelight.client.event;

import net.mehdinoui.ramadandelight.RamadanDelight;
import net.mehdinoui.ramadandelight.client.entity.ModModelLayers;
import net.mehdinoui.ramadandelight.client.entity.RDBoatRenderer;
import net.mehdinoui.ramadandelight.common.registry.ModEntities;
import net.mehdinoui.ramadandelight.common.util.RDWoodTypes;
import net.minecraft.client.model.BoatModel;
import net.minecraft.client.model.ChestBoatModel;
import net.minecraft.client.renderer.Sheets;
import net.minecraft.client.renderer.blockentity.HangingSignRenderer;
import net.minecraft.client.renderer.blockentity.SignRenderer;
import net.minecraft.client.renderer.entity.EntityRenderers;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.fml.event.lifecycle.FMLClientSetupEvent;
import net.neoforged.neoforge.client.event.EntityRenderersEvent;


@EventBusSubscriber(modid = RamadanDelight.MOD_ID, value = Dist.CLIENT)
public class ModClientEvents {
    @SubscribeEvent
    public static void registerLayer(EntityRenderersEvent.RegisterLayerDefinitions event) {
        event.registerLayerDefinition(ModModelLayers.PALM_BOAT_LAYER, BoatModel::createBodyModel);
        event.registerLayerDefinition(ModModelLayers.PALM_CHEST_BOAT_LAYER, ChestBoatModel::createBodyModel);
    }
    @SubscribeEvent
    public static void registerBER(EntityRenderersEvent.RegisterRenderers event) {
        event.registerBlockEntityRenderer(ModEntities.MOD_SIGN.get(), SignRenderer::new);
        event.registerBlockEntityRenderer(ModEntities.MOD_HANGING_SIGN.get(), HangingSignRenderer::new);
    }
    @SubscribeEvent
    public static void onClientSetup(FMLClientSetupEvent event) {
        Sheets.addWoodType(RDWoodTypes.PALM);

        EntityRenderers.register(ModEntities.MOD_BOAT.get(), pContext -> new RDBoatRenderer(pContext,false));
        EntityRenderers.register(ModEntities.MOD_CHEST_BOAT.get(), pContext -> new RDBoatRenderer(pContext,true));
    }
}