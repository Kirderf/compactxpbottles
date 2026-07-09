package com.kirderf.compactxpbottles.throwables;

import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.ExperienceOrb;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.projectile.ThrownExperienceBottle;
import net.minecraft.world.item.alchemy.PotionUtils;
import net.minecraft.world.item.alchemy.Potions;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.HitResult;

public class CustomThrownExperienceBottle extends ThrownExperienceBottle {
    private final int xpMultiplier;

    public CustomThrownExperienceBottle(EntityType<? extends ThrownExperienceBottle> entityType, Level level, int xpMultiplier) {
        super(entityType, level);
        this.xpMultiplier = xpMultiplier;
    }

    public CustomThrownExperienceBottle(Level level, LivingEntity shooter, int xpMultiplier) {
        super(level, shooter);
        this.xpMultiplier = xpMultiplier;
    }

    public CustomThrownExperienceBottle(Level level, double x, double y, double z, int xpMultiplier) {
        super(level, x, y, z);
        this.xpMultiplier = xpMultiplier;
    }

    @Override
    protected void onHit(HitResult hitResult) {
        super.onHit(hitResult);
        Level var3 = this.level();
        if (var3 instanceof ServerLevel level) {
            level.levelEvent(2002, this.blockPosition(), PotionUtils.getColor(Potions.WATER));
            int xpCount = 3 + this.random.nextInt(5) + this.random.nextInt(5);
            ExperienceOrb.award((ServerLevel)this.level(), this.position(), xpCount);
            this.discard();
        }

    }
}
