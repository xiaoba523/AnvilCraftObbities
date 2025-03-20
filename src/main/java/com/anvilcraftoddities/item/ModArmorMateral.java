package com.anvilcraftoddities.item;

import com.anvilcraftoddities.Anvilcraftoddities;
import dev.dubhe.anvilcraft.init.ModItems;
import net.minecraft.Util;
import net.minecraft.core.Holder;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;

import java.util.EnumMap;
import java.util.List;
import java.util.function.Supplier;
import java.util.jar.Attributes;

public class ModArmorMateral {

    public static final Holder<ArmorMaterial> AMETHYST_ARMOR_MATERIAL = register("amethyst",
            Util.make(new EnumMap<>(ArmorItem.Type.class),attribut->{
                attribut.put(ArmorItem.Type.HELMET, 2);
                attribut.put(ArmorItem.Type.CHESTPLATE, 5);
                attribut.put(ArmorItem.Type.LEGGINGS, 4);
                attribut.put(ArmorItem.Type.BOOTS, 2);
                attribut.put(ArmorItem.Type.BODY, 4);
            }),30,0f,0f,()-> Items.AMETHYST_SHARD);

    public static final Holder<ArmorMaterial> ROYAL_STELL_MATEREIAL = register("royal_stell",
            Util.make(new EnumMap<>(ArmorItem.Type.class),attribut->{
                attribut.put(ArmorItem.Type.HELMET, 3);
                attribut.put(ArmorItem.Type.CHESTPLATE, 8);
                attribut.put(ArmorItem.Type.LEGGINGS, 6);
                attribut.put(ArmorItem.Type.BOOTS, 3);
                attribut.put(ArmorItem.Type.BODY, 11);
            }),20,2f,0.1f,()-> ModItems.ROYAL_STEEL_INGOT.get());




    private static Holder<ArmorMaterial> register(String name, EnumMap<ArmorItem.Type, Integer> typeProtection,
                                                  int enchantablility, float toughness, float knockbackResistance,
                                                  Supplier<Item> ingredientItem){
        ResourceLocation location = ResourceLocation.fromNamespaceAndPath(Anvilcraftoddities.MODID,name);
        Holder<SoundEvent> equipSound =  SoundEvents.ARMOR_EQUIP_NETHERITE;
        Supplier<Ingredient> ingredient =() -> Ingredient.of(ingredientItem.get());
        List<ArmorMaterial.Layer> layers = List.of(new ArmorMaterial.Layer(location));


        EnumMap<ArmorItem.Type,Integer> typeMap = new EnumMap<>(ArmorItem.Type.class);
        for (ArmorItem.Type type : ArmorItem.Type.values()){
            typeMap.put(type,typeProtection.get(type));
        }

        return Registry.registerForHolder(BuiltInRegistries.ARMOR_MATERIAL,location,
                new ArmorMaterial(typeProtection,enchantablility,equipSound,ingredient,layers,toughness,knockbackResistance));
    }
}
