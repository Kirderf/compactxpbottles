package com.kirderf.compactxpbottles.entity;

import com.kirderf.compactxpbottles.items.CustomExperienceBottle;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.ExperienceOrb;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.projectile.ThrownExperienceBottle;
import net.minecraft.world.item.alchemy.PotionUtils;
import net.minecraft.world.item.alchemy.Potions;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.HitResult;


public class CustomExperienceBottleEntity extends ThrownExperienceBottle {
    private int xpMultiplier;

    public CustomExperienceBottleEntity(Level LevelIn, LivingEntity throwerIn, int xpMultiplier) {
        super(LevelIn, throwerIn);
        this.xpMultiplier = xpMultiplier;
    }

    public CustomExperienceBottleEntity(Level LevelIn, double x, double y, double z, CustomExperienceBottle item) {
        super(LevelIn, x, y, z);
        this.xpMultiplier = item.getXpMultiplier();
    }

 @Override
 protected void onHit(HitResult p_37521_) {
     super.onHit(p_37521_);
     if (this.level instanceof ServerLevel) {
         this.level.levelEvent(2002, this.blockPosition(), PotionUtils.getColor(Potions.WATER));
         int i = (3 + this.level.random.nextInt(5) + this.level.random.nextInt(5)) * this.xpMultiplier;
         ExperienceOrb.award((ServerLevel)this.level, this.position(), i);
         this.discard();
     }

 }

}
