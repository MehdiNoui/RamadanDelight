package net.mehdinoui.ramadandelight.client.event;

import net.mehdinoui.ramadandelight.RamadanDelight;
import net.mehdinoui.ramadandelight.client.entity.ModModelLayers;
import net.mehdinoui.ramadandelight.client.entity.RDBoatRenderer;
import net.mehdinoui.ramadandelight.common.registry.ModEntities;
import net.mehdinoui.ramadandelight.common.registry.ModItems;
import net.mehdinoui.ramadandelight.common.util.RDWoodTypes;
import net.minecraft.ChatFormatting;
import net.minecraft.client.model.BoatModel;
import net.minecraft.client.model.ChestBoatModel;
import net.minecraft.client.renderer.Sheets;
import net.minecraft.client.renderer.blockentity.HangingSignRenderer;
import net.minecraft.client.renderer.blockentity.SignRenderer;
import net.minecraft.client.renderer.entity.EntityRenderers;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.ItemStack;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.fml.event.lifecycle.FMLClientSetupEvent;
import net.neoforged.neoforge.client.event.EntityRenderersEvent;
import net.neoforged.neoforge.event.entity.player.ItemTooltipEvent;

import java.util.List;


@EventBusSubscriber(modid = RamadanDelight.MOD_ID, value = Dist.CLIENT)
public class ModClientEvents {
    @SubscribeEvent
    public static void registerToolTips(ItemTooltipEvent event) {
        ItemStack stack = event.getItemStack();
        List<Component> tooltip = event.getToolTip();
        if (stack.is(ModItems.DATE_SYRUP)){
            Component header = Component.translatable("potion.whenDrank").withStyle(ChatFormatting.DARK_PURPLE);
            Component effectDesc = Component.translatable("tooltip.ramadandelight.date_syrup_desc")
                    .withStyle(ChatFormatting.BLUE);

             boolean headerExists = tooltip.stream()
                    .anyMatch(c -> c.getString().equals(header.getString()));

            if (!headerExists) {
                tooltip.add(Component.empty());
                tooltip.add(header);
            }
            tooltip.add(effectDesc);
        }
    }
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