package com.kirderf.compactxpbottles.items;

import com.kirderf.compactxpbottles.entity.CustomExperienceBottleEntity;
import net.minecraft.core.Direction;
import net.minecraft.core.Position;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.stats.Stats;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.Projectile;
import net.minecraft.world.entity.projectile.ThrownExperienceBottle;
import net.minecraft.world.item.ExperienceBottleItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.NotNull;


public class CustomExperienceBottle extends ExperienceBottleItem {
    private int xpMultiplier;

    public CustomExperienceBottle(ExtraProperties properties) {
        super(properties);
        this.xpMultiplier = properties.xpMultiplier;
    }

    public static class ExtraProperties extends Item.Properties {
        private int xpMultiplier;

        public ExtraProperties xpMultiplier(int xpMultiplier) {
            this.xpMultiplier = xpMultiplier;
            return this;
        }
    }

    public InteractionResultHolder<ItemStack> use(Level level, Player player, @NotNull InteractionHand hand) {
        ItemStack $$3 = player.getItemInHand(hand);
        level.playSound(null, player.getX(), player.getY(), player.getZ(), SoundEvents.EXPERIENCE_BOTTLE_THROW, SoundSource.NEUTRAL, 0.5F, 0.4F / (level.getRandom().nextFloat() * 0.4F + 0.8F));
        if (!level.isClientSide) {
            CustomExperienceBottleEntity $$4 = new CustomExperienceBottleEntity(level, player, this.xpMultiplier);
            $$4.setItem($$3);
            $$4.shootFromRotation(player, player.getXRot(), player.getYRot(), -20.0F, 0.7F, 1.0F);
            level.addFreshEntity($$4);
        }

        player.awardStat(Stats.ITEM_USED.get(this));
        $$3.consume(1, player);
        return InteractionResultHolder.sidedSuccess($$3, level.isClientSide());
    }

    public @NotNull Projectile asProjectile(@NotNull Level level, Position position, @NotNull ItemStack itemStack, @NotNull Direction direction) {
        CustomExperienceBottleEntity $$4 = new CustomExperienceBottleEntity(level, position.x(), position.y(), position.z(), this.xpMultiplier);
        $$4.setItem(itemStack);
        return $$4;
    }
}

