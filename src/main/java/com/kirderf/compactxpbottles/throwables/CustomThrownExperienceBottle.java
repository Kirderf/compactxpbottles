package com.kirderf.compactxpbottles.throwables;

import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.ExperienceOrb;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.projectile.ThrownExperienceBottle;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.alchemy.PotionContents;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.HitResult;
import net.minecraft.world.phys.Vec3;

public class CustomThrownExperienceBottle extends ThrownExperienceBottle {
    private final int xpMultiplier;

    public CustomThrownExperienceBottle(EntityType<? extends ThrownExperienceBottle> entityType, Level level, int xpMultiplier) {
        super(entityType, level);
        this.xpMultiplier = xpMultiplier;
    }

    public CustomThrownExperienceBottle(Level level, LivingEntity shooter, ItemStack itemStack, int xpMultiplier) {
        super(level, shooter, itemStack);
        this.xpMultiplier = xpMultiplier;
    }

    public CustomThrownExperienceBottle(Level level, double x, double y, double z, ItemStack itemStack, int xpMultiplier) {
        super(level, x, y, z, itemStack);
        this.xpMultiplier = xpMultiplier;
    }

    @Override
    protected void onHit(HitResult result) {
        super.onHit(result);
        if (this.level() instanceof ServerLevel serverlevel) {
            this.level().levelEvent(2002, this.blockPosition(), PotionContents.BASE_POTION_COLOR);
            int i = 3 + this.level().random.nextInt(5) + this.level().random.nextInt(5);
            if (result instanceof BlockHitResult blockhitresult) {
                Vec3 vec3 = blockhitresult.getDirection().getUnitVec3();
                ExperienceOrb.awardWithDirection(serverlevel, result.getLocation(), vec3, i * this.xpMultiplier);
            } else {
                ExperienceOrb.awardWithDirection(serverlevel, result.getLocation(), this.getDeltaMovement().scale((double) -1.0F), i * this.xpMultiplier);
            }

            this.discard();
        }

    }
}
