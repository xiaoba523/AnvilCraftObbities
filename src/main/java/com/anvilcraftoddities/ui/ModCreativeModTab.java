package com.anvilcraftoddities.ui;

 import com.anvilcraftoddities.Anvilcraftoddities;
 import com.anvilcraftoddities.item.ModItems;
 import net.minecraft.core.registries.Registries;
 import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.ItemStack;

import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;


public class ModCreativeModTab {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TAB =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, Anvilcraftoddities.MODID);


    public static final DeferredHolder<CreativeModeTab,CreativeModeTab> ANVILCRAFT_GEAR =
            CREATIVE_MODE_TAB.register("anvilcraftoddities_gear_tab",
                    () -> CreativeModeTab.builder()
                            .withTabsBefore(CreativeModeTabs.SPAWN_EGGS)
                            .title(Component.translatable("creativetab.Anvilcraftoddities.gears"))
                            .icon(() -> new ItemStack(ModItems.AMETHYST_HELMET.get()))
                            .displayItems((params,output) -> {
                                output.accept(ModItems.AMETHYST_HELMET.get());
                                output.accept(ModItems.AMETHYST_CHESTPLATE.get());
                                output.accept(ModItems.AMETHYST_LEGGINGS.get());
                                output.accept(ModItems.AMETHYST_BOOTS.get());
                                output.accept(ModItems.ROYAL_STEEL_HELMET.get());
                                output.accept(ModItems.ROYAL_STEEL_CHESTPLATE.get());
                                output.accept(ModItems.ROYAL_STEEL_LEGGINGS.get());
                                output.accept(ModItems.ROYAL_STEEL_BOOTS.get());
                                output.accept(ModItems.EMBER_METAL_HELMET.get());
                                output.accept(ModItems.EMBER_METAL_CHESTPLATE.get());
                                output.accept(ModItems.EMBER_METAL_LEGGINGS.get());
                                output.accept(ModItems.EMBER_METAL_BOOTS.get());




                            })
                            .build());

    public static void register(IEventBus eventBus){CREATIVE_MODE_TAB.register(eventBus);}

}
