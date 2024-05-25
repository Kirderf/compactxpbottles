package com.kirderf.compactxpbottles.entity;

import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.ExperienceOrb;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.projectile.ThrownExperienceBottle;
import net.minecraft.world.item.alchemy.PotionContents;
import net.minecraft.world.item.alchemy.Potions;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.HitResult;
import org.jetbrains.annotations.NotNull;


public class CustomExperienceBottleEntity extends ThrownExperienceBottle {
    private int xpMultiplier;

    public CustomExperienceBottleEntity(Level LevelIn, LivingEntity throwerIn, int xpMultiplier) {
        super(LevelIn, throwerIn);
        this.xpMultiplier = xpMultiplier;
    }

    public CustomExperienceBottleEntity(Level p_37513_, double p_37514_, double p_37515_, double p_37516_, int xpMultiplier) {
        super(p_37513_, p_37514_, p_37515_, p_37516_);
        this.xpMultiplier = xpMultiplier;
    }

    @Override
    protected void onHit(@NotNull HitResult p_37521_) {
        super.onHit(p_37521_);
        if (this.level() instanceof ServerLevel) {
            this.level().levelEvent(2002, this.blockPosition(), PotionContents.getColor(Potions.WATER));
            int $$1 = 3 + this.level().random.nextInt(5) + this.level().random.nextInt(5);
            ExperienceOrb.award((ServerLevel) this.level(), this.position(), $$1 * this.xpMultiplier);
            this.discard();
        }

    }


}
