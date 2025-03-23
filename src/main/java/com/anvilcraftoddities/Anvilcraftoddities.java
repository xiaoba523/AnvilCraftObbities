package com.anvilcraftoddities;


import com.anvilcraftoddities.item.ModItems;
import com.anvilcraftoddities.tooltip.ItemTooltips;
import com.anvilcraftoddities.ui.ModCreativeModTab;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.Mod;
import net.neoforged.neoforge.common.NeoForge;
import net.neoforged.neoforge.event.entity.player.ItemTooltipEvent;
import org.jetbrains.annotations.NotNull;

@Mod(Anvilcraftoddities.MODID)
public class Anvilcraftoddities {
    public static final String MODID = "anvilcraftoddities";
    public Anvilcraftoddities(IEventBus modEventBus, ModContainer modContainer) {
        ModCreativeModTab.register(modEventBus);
        ModItems.register(modEventBus);

        NeoForge.EVENT_BUS.addListener(Anvilcraftoddities::addItemTooltips);

    }

    public static void addItemTooltips(@NotNull ItemTooltipEvent event) {
        ItemTooltips.addTooltip(event.getItemStack(), event.getToolTip());
    }

}
