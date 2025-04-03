package com.anvilcraftoddities.item;

import dev.dubhe.anvilcraft.item.IInherentEnchantment;
import net.minecraft.core.BlockPos;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.DiggerItem;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.ItemStack;

import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.item.enchantment.ItemEnchantments;
import net.minecraft.core.Holder;
import net.minecraft.core.HolderLookup;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceKey;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.CampfireBlock;
import net.minecraft.world.level.block.RotatedPillarBlock;
import net.minecraft.world.level.block.state.BlockState;

import java.util.List;
import java.util.Map;

public class RoyalMultiToolItem extends DiggerItem implements IInherentEnchantment {
    public RoyalMultiToolItem(Tier tier, Properties properties) {
        super(tier, BlockTags.MINEABLE_WITH_PICKAXE, properties);
    }
    @Override
    public InteractionResult useOn(UseOnContext context) {
        Level level = context.getLevel();
        BlockPos pos = context.getClickedPos();
        BlockState state = level.getBlockState(pos);
        ItemStack stack = context.getItemInHand();

        // 斧头功能 - 原木去皮
        if (state.is(BlockTags.LOGS)) {
            BlockState strippedState = getStrippedVariant(state)
                    .setValue(RotatedPillarBlock.AXIS, state.getValue(RotatedPillarBlock.AXIS));

            if (!level.isClientSide) {
                level.setBlock(pos, strippedState, 3);
                stack.hurtAndBreak(1, context.getPlayer(), EquipmentSlot.MAINHAND);
            }
            return InteractionResult.sidedSuccess(level.isClientSide);
        }

        // 斧头功能 - 熄灭营火
        if (state.getBlock() instanceof CampfireBlock && state.getValue(CampfireBlock.LIT)) {
            if (!level.isClientSide) {
                level.setBlock(pos, state.setValue(CampfireBlock.LIT, false), 3);
                stack.hurtAndBreak(1, context.getPlayer(), EquipmentSlot.MAINHAND);
            }
            return InteractionResult.sidedSuccess(level.isClientSide);
        }

        // 铲子功能 - 路径创建
        if (state.is(BlockTags.DIRT) && level.getBlockState(pos.above()).isAir()) {
            if (!level.isClientSide) {
                level.setBlock(pos, Blocks.DIRT_PATH.defaultBlockState(), 3);
                stack.hurtAndBreak(1, context.getPlayer(), EquipmentSlot.MAINHAND);
            }
            return InteractionResult.sidedSuccess(level.isClientSide);
        }

        return super.useOn(context);
    }

    // 获取去皮后的方块变种
    private BlockState getStrippedVariant(BlockState original) {
        if (original.is(Blocks.OAK_LOG)) return Blocks.STRIPPED_OAK_LOG.defaultBlockState();
        if (original.is(Blocks.SPRUCE_LOG)) return Blocks.STRIPPED_SPRUCE_LOG.defaultBlockState();
        if (original.is(Blocks.BIRCH_LOG)) return Blocks.STRIPPED_BIRCH_LOG.defaultBlockState();
        if (original.is(Blocks.JUNGLE_LOG)) return Blocks.STRIPPED_JUNGLE_LOG.defaultBlockState();
        if (original.is(Blocks.ACACIA_LOG)) return Blocks.STRIPPED_ACACIA_LOG.defaultBlockState();
        if (original.is(Blocks.DARK_OAK_LOG)) return Blocks.STRIPPED_DARK_OAK_LOG.defaultBlockState();
        if (original.is(Blocks.MANGROVE_LOG)) return Blocks.STRIPPED_MANGROVE_LOG.defaultBlockState();
        if (original.is(Blocks.CHERRY_LOG)) return Blocks.STRIPPED_CHERRY_LOG.defaultBlockState();
        if (original.is(Blocks.CRIMSON_STEM)) return Blocks.STRIPPED_CRIMSON_STEM.defaultBlockState();
        if (original.is(Blocks.WARPED_STEM)) return Blocks.STRIPPED_WARPED_STEM.defaultBlockState();
        return original;
    }
    @Override
    public boolean isCorrectToolForDrops(ItemStack stack, BlockState state) {
        return state.is(BlockTags.MINEABLE_WITH_PICKAXE) ||
                state.is(BlockTags.MINEABLE_WITH_AXE) ||
                state.is(BlockTags.MINEABLE_WITH_SHOVEL);
    }

    @Override
    public float getDestroySpeed(ItemStack stack, BlockState state) {
        if (state.is(BlockTags.MINEABLE_WITH_PICKAXE) ||
                state.is(BlockTags.MINEABLE_WITH_AXE) ||
                state.is(BlockTags.MINEABLE_WITH_SHOVEL)) {
            return getTier().getSpeed();
        }
        return super.getDestroySpeed(stack, state);
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
        return Map.of(Enchantments.UNBREAKING, 3);
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
