package com.anvilcraftoddities.tooltip;

import com.anvilcraftoddities.item.ModItems;
import dev.dubhe.anvilcraft.api.tooltip.ItemTooltipManager;
import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;

import java.util.ArrayList;
import java.util.List;

public class ItemTooltips {

    private static final ArrayList<Item> NEED_TOOLTIP_ITEM = new ArrayList<>();

    static {
        NEED_TOOLTIP_ITEM.add(ModItems.AMETHYST_MULTI_TOOL.asItem());
        NEED_TOOLTIP_ITEM.add(ModItems.ROYAL_MULTI_TOOL.asItem());
        NEED_TOOLTIP_ITEM.add(ModItems.EMBER_MULTI_TOOL.asItem());
    }

    public static void addTooltip(ItemStack stack, List<Component> tooltip) {
        Item item = stack.getItem();
        if (NEED_TOOLTIP_ITEM.contains(item)) {
            tooltip.add(1, getItemTooltip(item));
        }
    }

    private static Component getItemTooltip(Item item) {
        return Component.translatable(ItemTooltipManager.getTranslationKey(item)).withStyle(ChatFormatting.GRAY);
    }
}
