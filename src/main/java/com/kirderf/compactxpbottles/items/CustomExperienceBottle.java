package com.kirderf.compactxpbottles.items;

import com.kirderf.compactxpbottles.throwables.CustomThrownExperienceBottle;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.stats.Stats;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.ThrownExperienceBottle;
import net.minecraft.world.item.ExperienceBottleItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;


public class CustomExperienceBottle extends ExperienceBottleItem {
    private final int xpMultiplier;

    public CustomExperienceBottle(Item.Properties properties, int xpMultiplier) {
        super(properties);
        this.xpMultiplier = xpMultiplier;
    }

    @Override
    public boolean isFoil(ItemStack stack) {
        return xpMultiplier >= 1024;
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand hand) {
        ItemStack itemStack = player.getItemInHand(hand);
        level.playSound(null, player.getX(), player.getY(), player.getZ(), SoundEvents.EXPERIENCE_BOTTLE_THROW, SoundSource.NEUTRAL, 0.5F, 0.4F / (level.getRandom().nextFloat() * 0.4F + 0.8F));
        if (level instanceof ServerLevel serverLevel) {
            ThrownExperienceBottle thrownexperiencebottle = new CustomThrownExperienceBottle(serverLevel, player, xpMultiplier);
            thrownexperiencebottle.setItem(itemStack);
            thrownexperiencebottle.shootFromRotation(player, player.getXRot(), player.getYRot(), -20.0F, 0.7F, 1.0F);
            serverLevel.addFreshEntity(thrownexperiencebottle);
        }

        player.awardStat(Stats.ITEM_USED.get(this));
        if (!player.getAbilities().instabuild) {
            itemStack.shrink(1);
        }
        return InteractionResultHolder.sidedSuccess(itemStack, level.isClientSide());
    }
}

