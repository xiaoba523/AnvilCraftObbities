package com.anvilcraftoddities.item;


import com.anvilcraftoddities.Anvilcraftoddities;

import dev.dubhe.anvilcraft.item.ModTiers;
import net.minecraft.world.item.ArmorItem;

import net.minecraft.world.item.Item;

import net.minecraft.world.item.Tiers;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;


public class ModItems {

    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(Anvilcraftoddities.MODID);


//紫水晶盔甲
    public static final DeferredItem<ArmorItem> AMETHYST_HELMET = ITEMS.register("amethyst_helmet",
            () -> new ArmorItem(
                    ModArmorMateral.AMETHYST_ARMOR_MATERIAL,
                    ArmorItem.Type.HELMET,
                    new Item.Properties().durability(ArmorItem.Type.HELMET.getDurability(8))
            ));
    public static final DeferredItem<ArmorItem> AMETHYST_CHESTPLATE = ITEMS.register("amethyst_chestplate",
            () -> new ArmorItem(
                    ModArmorMateral.AMETHYST_ARMOR_MATERIAL,
                    ArmorItem.Type.CHESTPLATE,
                    new Item.Properties().durability(ArmorItem.Type.CHESTPLATE.getDurability(8))
            ));
    public static final DeferredItem<ArmorItem> AMETHYST_LEGGINGS = ITEMS.register("amethyst_leggings",
            () -> new ArmorItem(
                    ModArmorMateral.AMETHYST_ARMOR_MATERIAL,
                    ArmorItem.Type.LEGGINGS,
                    new Item.Properties().durability(ArmorItem.Type.LEGGINGS.getDurability(8))
            ));
    public static final DeferredItem<ArmorItem> AMETHYST_BOOTS = ITEMS.register("amethyst_boots",
            () -> new ArmorItem(
                    ModArmorMateral.AMETHYST_ARMOR_MATERIAL,
                    ArmorItem.Type.BOOTS,
                    new Item.Properties().durability(ArmorItem.Type.BOOTS.getDurability(8))
            ));

//皇家钢盔甲
    public static final DeferredItem<ArmorItem> ROYAL_STEEL_HELMET = ITEMS.register("royal_steel_helmet",()->
        new RoyalSteelArmor(
                ModArmorMateral.ROYAL_STELL_MATEREIAL,
                ArmorItem.Type.HELMET,
                new Item.Properties().durability(ArmorItem.Type.HELMET.getDurability(35))
        ));
    public static final DeferredItem<ArmorItem> ROYAL_STEEL_CHESTPLATE = ITEMS.register("royal_steel_chestplate",()->
            new RoyalSteelArmor(
                    ModArmorMateral.ROYAL_STELL_MATEREIAL,
                    ArmorItem.Type.CHESTPLATE,
                    new Item.Properties().durability(ArmorItem.Type.CHESTPLATE.getDurability(35))
            ));
    public static final DeferredItem<ArmorItem> ROYAL_STEEL_LEGGINGS = ITEMS.register("royal_steel_leggings",()->
            new RoyalSteelArmor(
                    ModArmorMateral.ROYAL_STELL_MATEREIAL,
                    ArmorItem.Type.LEGGINGS,
                    new Item.Properties().durability(ArmorItem.Type.LEGGINGS.getDurability(35))
            ));
    public static final DeferredItem<ArmorItem> ROYAL_STEEL_BOOTS = ITEMS.register("royal_steel_boots",()->
            new RoyalSteelArmor(
                    ModArmorMateral.ROYAL_STELL_MATEREIAL,
                    ArmorItem.Type.BOOTS,
                    new Item.Properties().durability(ArmorItem.Type.BOOTS.getDurability(35))
            ));


//余烬盔甲
    public static final DeferredItem<ArmorItem> EMBER_METAL_HELMET = ITEMS.register("ember_metal_helmet",()->
        new EmberMetalArmor(
                ModArmorMateral.EMBER_METAL_MATEREIAL,
                ArmorItem.Type.HELMET,
                new Item.Properties().durability(ArmorItem.Type.HELMET.getDurability(40)).fireResistant()
        ));
    public static final DeferredItem<ArmorItem> EMBER_METAL_CHESTPLATE = ITEMS.register("ember_metal_chestplate",()->
            new EmberMetalArmor(
                    ModArmorMateral.EMBER_METAL_MATEREIAL,
                    ArmorItem.Type.CHESTPLATE,
                    new Item.Properties().durability(ArmorItem.Type.CHESTPLATE.getDurability(40)).fireResistant()
            ));
    public static final DeferredItem<ArmorItem> EMBER_METAL_LEGGINGS = ITEMS.register("ember_metal_leggings",()->
            new EmberMetalArmor(
                    ModArmorMateral.EMBER_METAL_MATEREIAL,
                    ArmorItem.Type.LEGGINGS,
                    new Item.Properties().durability(ArmorItem.Type.LEGGINGS.getDurability(40)).fireResistant()
            ));
    public static final DeferredItem<ArmorItem> EMBER_METAL_BOOTS = ITEMS.register("ember_metal_boots",()->
            new EmberMetalArmor(
                    ModArmorMateral.EMBER_METAL_MATEREIAL,
                    ArmorItem.Type.BOOTS,
                    new Item.Properties().durability(ArmorItem.Type.BOOTS.getDurability(40)).fireResistant()
            ));



//工具
    public static final DeferredItem<AmethystMultiToolItem> AMETHYST_MULTI_TOOL = ITEMS.register("amethyst_multi_tool",
        () -> new AmethystMultiToolItem(

                new Item.Properties().durability(751)
        )
    );
    public static final DeferredItem<RoyalMultiToolItem> ROYAL_MULTI_TOOL = ITEMS.register("royal_multi_tool",
            () -> new RoyalMultiToolItem(

                    new Item.Properties().durability(1561)
            )
    );
    public static final DeferredItem<EmberMultiToolItem> EMBER_MULTI_TOOL = ITEMS.register("ember_multi_tool",
            () -> new EmberMultiToolItem(
                    new Item.Properties().durability(3122).fireResistant()
            )
    );



    public static void register(IEventBus eventBus){
        ITEMS.register(eventBus);
    }
}
