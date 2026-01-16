package net.mehdinoui.ramadandelight.client.event;

import net.mehdinoui.ramadandelight.RamadanDelight;
import net.mehdinoui.ramadandelight.common.registry.ModItems;
import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.event.entity.player.ItemTooltipEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import java.util.List;

@Mod.EventBusSubscriber(modid = RamadanDelight.MOD_ID,
        value = Dist.CLIENT, bus = Mod.EventBusSubscriber.Bus.FORGE)
public class ModToolTipEvents {
    @SubscribeEvent
    public static void registerToolTips(ItemTooltipEvent event) {
        ItemStack stack = event.getItemStack();
        List<Component> tooltip = event.getToolTip();
        if (stack.is(ModItems.DATE_SYRUP.get())){
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
}
