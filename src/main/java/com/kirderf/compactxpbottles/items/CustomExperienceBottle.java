package com.kirderf.compactxpbottles.items;

import com.kirderf.compactxpbottles.throwables.CustomThrownExperienceBottle;
import net.minecraft.core.Direction;
import net.minecraft.core.Position;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.stats.Stats;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.Projectile;
import net.minecraft.world.item.ExperienceBottleItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;


public class CustomExperienceBottle extends ExperienceBottleItem {
    private final int xpMultiplier;

    public CustomExperienceBottle(int xpMultiplier) {
        super(new Item.Properties());
        this.xpMultiplier = xpMultiplier;
    }

    @Override
    public boolean isFoil(ItemStack stack) {
        return xpMultiplier >= 1024;
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand hand) {
        ItemStack item = player.getItemInHand(hand);
        level.playSound(null, player.getX(), player.getY(), player.getZ(), SoundEvents.EXPERIENCE_BOTTLE_THROW, SoundSource.NEUTRAL, 0.5F, 0.4F / (level.getRandom().nextFloat() * 0.4F + 0.8F));
        if (!level.isClientSide) {
            var thrownExperienceBottle = new CustomThrownExperienceBottle(level, player, this.xpMultiplier);
            thrownExperienceBottle.setItem(item);
            thrownExperienceBottle.shootFromRotation(player, player.getXRot(), player.getYRot(), -20.0F, 0.7F, 1.0F);
            level.addFreshEntity(thrownExperienceBottle);
        }

        player.awardStat(Stats.ITEM_USED.get(this));
        item.consume(1, player);
        return InteractionResultHolder.sidedSuccess(item, level.isClientSide());
    }

    @Override
    public Projectile asProjectile(Level level, Position pos, ItemStack stack, Direction direction) {
        var thrownExperienceBottle = new CustomThrownExperienceBottle(level, pos.x(), pos.y(), pos.z(), this.xpMultiplier);
        thrownExperienceBottle.setItem(stack);
        return thrownExperienceBottle;
    }
}

