package com.kirderf.compactxpbottles.entity;

import com.kirderf.compactxpbottles.items.CustomExperienceBottle;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.item.ExperienceBottleEntity;
import net.minecraft.entity.item.ExperienceOrbEntity;
import net.minecraft.potion.PotionUtils;
import net.minecraft.potion.Potions;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.World;

public class CustomExperienceBottleEntity extends ExperienceBottleEntity {
    private int xpMultiplier;

    public CustomExperienceBottleEntity(World worldIn, LivingEntity throwerIn, int xpMultiplier) {
        super(worldIn, throwerIn);
        this.xpMultiplier = xpMultiplier;
    }

    public CustomExperienceBottleEntity(World worldIn, double x, double y, double z, CustomExperienceBottle item) {
        super(worldIn, x, y, z);
        this.xpMultiplier = item.getXpMultiplier();
    }

    @Override
    protected void onImpact(RayTraceResult result) {
        if (!this.world.isRemote) {
            this.world.playEvent(2002, new BlockPos(this), PotionUtils.getPotionColor(Potions.WATER));

            int i = (3 + this.world.rand.nextInt(5) + this.world.rand.nextInt(5)) * this.xpMultiplier;

            while (i > 0) {
                int j = ExperienceOrbEntity.getXPSplit(i);
                i -= j;
                this.world.addEntity(new ExperienceOrbEntity(this.world, this.lastTickPosX, this.lastTickPosY, this.lastTickPosZ, j));
            }

            this.remove();
        }
    }
}
