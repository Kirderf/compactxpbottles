package com.kirderf.compactxpbottles.items;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import com.kirderf.compactxpbottles.entity.CustomExperienceBottleEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ExperienceBottleItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

import net.minecraft.sounds.SoundEvents;
import net.minecraft.stats.Stats;


public class CustomExperienceBottle extends ExperienceBottleItem {
    private int xpMultiplier;

    public CustomExperienceBottle(ExtraProperties properties) {
        super(properties);
        this.xpMultiplier = properties.xpMultiplier;
    }

    public int getXpMultiplier() {
        return this.xpMultiplier;
    }
    @Override
    public InteractionResultHolder<ItemStack> use(Level p_41196_, Player p_41197_, InteractionHand p_41198_) {
        ItemStack itemstack = p_41197_.getItemInHand(p_41198_);
        p_41196_.playSound((Player)null, p_41197_.getX(), p_41197_.getY(), p_41197_.getZ(), SoundEvents.EXPERIENCE_BOTTLE_THROW, SoundSource.NEUTRAL, 0.5F, 0.4F / (p_41196_.getRandom().nextFloat() * 0.4F + 0.8F));
        if (!p_41196_.isClientSide) {
            CustomExperienceBottleEntity thrownexperiencebottle = new CustomExperienceBottleEntity(p_41196_, p_41197_, xpMultiplier);
            thrownexperiencebottle.setItem(itemstack);
            thrownexperiencebottle.shootFromRotation(p_41197_, p_41197_.getXRot(), p_41197_.getYRot(), -20.0F, 0.7F, 1.0F);
            p_41196_.addFreshEntity(thrownexperiencebottle);
        }

        p_41197_.awardStat(Stats.ITEM_USED.get(this));
        if (!p_41197_.getAbilities().instabuild) {
            itemstack.shrink(1);
        }

        return InteractionResultHolder.sidedSuccess(itemstack, p_41196_.isClientSide());
    }
    public static class ExtraProperties extends Item.Properties {
        private int xpMultiplier;
        public ExtraProperties xpMultiplier(int xpMultiplier) {
            this.xpMultiplier = xpMultiplier;
            return this;
        }
    }
}

