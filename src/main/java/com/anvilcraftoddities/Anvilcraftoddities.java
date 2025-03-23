package com.anvilcraftoddities;


import com.anvilcraftoddities.item.ModItems;
import com.anvilcraftoddities.ui.ModCreativeModTab;

import net.neoforged.bus.api.IEventBus;

import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.Mod;

@Mod(Anvilcraftoddities.MODID)
public class Anvilcraftoddities {
    public static final String MODID = "anvilcraftoddities";
    public Anvilcraftoddities(IEventBus modEventBus, ModContainer modContainer) {
        ModCreativeModTab.register(modEventBus);
        ModItems.register(modEventBus);




    }

}
