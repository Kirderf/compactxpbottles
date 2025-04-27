package com.kirderf.compactxpbottles.items;

import com.kirderf.compactxpbottles.entity.CustomExperienceBottleEntity;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.stats.Stats;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ExperienceBottleItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;


public class CustomExperienceBottle extends ExperienceBottleItem {
    private final int xpMultiplier;

    public CustomExperienceBottle(ExtraProperties properties) {
        super(properties);
        this.xpMultiplier = properties.xpMultiplier;
    }

    public int getXpMultiplier() {
        return xpMultiplier;
    }
    public InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand hand) {
        ItemStack item = player.getItemInHand(hand);
        level.playSound(null, player.getX(), player.getY(), player.getZ(), SoundEvents.EXPERIENCE_BOTTLE_THROW, SoundSource.NEUTRAL, 0.5F, 0.4F / (level.getRandom().nextFloat() * 0.4F + 0.8F));
        if (!level.isClientSide) {
            CustomExperienceBottleEntity thrownexperiencebottle = new CustomExperienceBottleEntity(level, player, this.getXpMultiplier());
            thrownexperiencebottle.setItem(item);
            thrownexperiencebottle.shootFromRotation(player, player.getXRot(), player.getYRot(), -20.0F, 0.7F, 1.0F);
            level.addFreshEntity(thrownexperiencebottle);
        }

        player.awardStat(Stats.ITEM_USED.get(this));
        if (!player.getAbilities().instabuild) {
            item.shrink(1);
        }
        return InteractionResultHolder.sidedSuccess(item, level.isClientSide());
    }

    public static class ExtraProperties extends Item.Properties {
        private int xpMultiplier;

        public ExtraProperties xpMultiplier(int xpMultiplier) {
            this.xpMultiplier = xpMultiplier;
            return this;
        }
    }
}

