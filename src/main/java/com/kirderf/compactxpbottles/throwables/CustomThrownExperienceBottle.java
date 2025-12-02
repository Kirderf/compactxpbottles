package com.kirderf.compactxpbottles.throwables;

import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.ExperienceOrb;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.projectile.ThrownExperienceBottle;
import net.minecraft.world.item.alchemy.PotionContents;
import net.minecraft.world.item.alchemy.Potions;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.HitResult;

public class CustomThrownExperienceBottle extends ThrownExperienceBottle{
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
    protected void onHit(HitResult result) {
        super.onHit(result);
        if (this.level() instanceof ServerLevel) {
            this.level().levelEvent(2002, this.blockPosition(), PotionContents.getColor(Potions.WATER));
            int i = 3 + this.level().random.nextInt(5) + this.level().random.nextInt(5);
            ExperienceOrb.award((ServerLevel) this.level(), this.position(), i * this.xpMultiplier);
            this.discard();
        }

    }
}
