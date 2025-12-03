package com.kirderf.compactxpbottles.items;

import com.kirderf.compactxpbottles.throwables.CustomThrownExperienceBottle;
import net.minecraft.core.Direction;
import net.minecraft.core.Position;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.stats.Stats;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.Projectile;
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
    public InteractionResult use(Level level, Player player, InteractionHand interactionHand) {
        ItemStack itemstack = player.getItemInHand(interactionHand);
        level.playSound((Entity) null, player.getX(), player.getY(), player.getZ(), SoundEvents.EXPERIENCE_BOTTLE_THROW, SoundSource.NEUTRAL, 0.5F, 0.4F / (level.getRandom().nextFloat() * 0.4F + 0.8F));
        if (level instanceof ServerLevel serverlevel) {
            Projectile.spawnProjectileFromRotation((level1, player1, itemStack1) ->
                    new CustomThrownExperienceBottle(level1, player1, itemStack1, xpMultiplier), serverlevel, itemstack, player, -20.0F, 0.7F, 1.0F);
        }

        player.awardStat(Stats.ITEM_USED.get(this));
        itemstack.consume(1, player);
        return InteractionResult.SUCCESS;
    }

    @Override
    public Projectile asProjectile(Level level, Position pos, ItemStack stack, Direction direction) {
        var thrownExperienceBottle = new CustomThrownExperienceBottle(level, pos.x(), pos.y(), pos.z(), stack, this.xpMultiplier);
        thrownExperienceBottle.setItem(stack);
        return thrownExperienceBottle;
    }
}

