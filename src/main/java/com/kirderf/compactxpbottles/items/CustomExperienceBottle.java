package com.kirderf.compactxpbottles.items;

import com.kirderf.compactxpbottles.entity.CustomExperienceBottleEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.stats.Stats;
import net.minecraft.util.*;
import net.minecraft.world.World;

public class CustomExperienceBottle extends Item {
    private int xpMultiplier;

    public CustomExperienceBottle(ExtraProperties properties) {
        super(properties);
        this.xpMultiplier = properties.xpMultiplier;
    }

    public int getXpMultiplier() {
        return this.xpMultiplier;
    }

    @Override
    public ActionResult<ItemStack> onItemRightClick(World worldIn, PlayerEntity playerIn, Hand handIn) {
        ItemStack itemstack = playerIn.getHeldItem(handIn);
        if (!playerIn.abilities.isCreativeMode) {
            itemstack.shrink(1);
        }

        worldIn.playSound( playerIn, playerIn.lastTickPosX, playerIn.lastTickPosY, playerIn.lastTickPosZ,
                SoundEvents.ENTITY_EXPERIENCE_BOTTLE_THROW, SoundCategory.NEUTRAL, 0.5F,
                0.4F / (random.nextFloat() * 0.4F + 0.8F));
        if (!worldIn.isRemote) {
            CustomExperienceBottleEntity experiencebottleentity = new CustomExperienceBottleEntity(worldIn, playerIn, xpMultiplier);
            experiencebottleentity.func_213884_b(itemstack);
            experiencebottleentity.shoot(playerIn, playerIn.rotationPitch, playerIn.rotationYaw, -20.0F, 0.7F, 1.0F);
            worldIn.addEntity(experiencebottleentity);
        }

        playerIn.addStat(Stats.ITEM_USED.get(this));
        return new ActionResult<>(ActionResultType.SUCCESS, itemstack);
    }

    public static class ExtraProperties extends Item.Properties {
        private int xpMultiplier;
        public ExtraProperties xpMultiplier(int xpMultiplier) {
            this.xpMultiplier = xpMultiplier;
            return this;
        }
    }
}

