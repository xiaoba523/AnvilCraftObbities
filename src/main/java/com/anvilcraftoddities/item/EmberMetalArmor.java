package com.anvilcraftoddities.item;

import dev.dubhe.anvilcraft.item.IFireReforging;
import dev.dubhe.anvilcraft.item.IInherentEnchantment;
import net.minecraft.core.Holder;
import net.minecraft.core.HolderLookup;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.item.enchantment.ItemEnchantments;

import java.util.List;
import java.util.Map;

public class EmberMetalArmor extends ArmorItem implements IInherentEnchantment, IFireReforging {


    public EmberMetalArmor(Holder<ArmorMaterial> material, Type type, Properties properties) {
        super(material, type, properties);
    }

    @Override
    public void appendHoverText(
            ItemStack pStack, TooltipContext pContext, List<Component> pTooltipComponents, TooltipFlag pTooltipFlag) {
        super.appendHoverText(pStack, pContext, pTooltipComponents, pTooltipFlag);
        if (pContext.level() != null) {
            pTooltipComponents.addAll(this.getInherentEnchantmentsTooltip(pContext.level()));
        }
    }

    @Override
    public Map<ResourceKey<Enchantment>, Integer> getInherentEnchantments() {
        return Map.of(Enchantments.UNBREAKING, 5);
    }

    @Override
    public ItemEnchantments getAllEnchantments(ItemStack stack, HolderLookup.RegistryLookup<Enchantment> lookup) {
        ItemEnchantments.Mutable enchantments = new ItemEnchantments.Mutable(super.getAllEnchantments(stack, lookup));

        for (var entry : getInherentEnchantments().entrySet()) {
            Holder.Reference<Enchantment> holder = lookup.getOrThrow(entry.getKey());
            enchantments.set(holder, entry.getValue());
        }

        return enchantments.toImmutable();
    }
}
