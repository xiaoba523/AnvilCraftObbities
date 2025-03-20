package com.anvilcraftoddities.item;


import com.anvilcraftoddities.Anvilcraftoddities;
import net.minecraft.world.item.ArmorItem;

import net.minecraft.world.item.Item;

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
    public static final DeferredItem<ArmorItem> ROYAL_STEEL_BOOTS = ITEMS.register("royal_steel_boots",
            () -> new ArmorItem(
                    ModArmorMateral.ROYAL_STELL_MATEREIAL,
                    ArmorItem.Type.BOOTS,
                    new Item.Properties().durability(ArmorItem.Type.BOOTS.getDurability(25))
            ));


    public static void register(IEventBus eventBus){
        ITEMS.register(eventBus);
    }
}
