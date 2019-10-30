package com.kirderf.compactxpbottles.entity;

import net.minecraft.entity.item.ExperienceBottleEntity;
import net.minecraft.entity.item.ExperienceOrbEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.potion.PotionUtils;
import net.minecraft.potion.Potions;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.World;

public class CustomExperienceBottleEntity extends ExperienceBottleEntity {
	private int xpMultiPlyer;

	public CustomExperienceBottleEntity(World worldIn, PlayerEntity playerIn, int xpMultiplyer) {
		super(worldIn, playerIn);
		this.xpMultiPlyer = xpMultiplyer;
	}
	 
	@Override
	protected void onImpact(RayTraceResult result) {
		if (!this.world.isRemote) {
			this.world.playEvent(2002, new BlockPos(this), PotionUtils.getPotionColor(Potions.WATER));
			int i = (3 + this.world.rand.nextInt(5) + this.world.rand.nextInt(5))*xpMultiPlyer;

			while (i > 0) {
				int j = ExperienceOrbEntity.getXPSplit(i);
				i -= j;
				this.world.addEntity(new ExperienceOrbEntity(this.world, this.posX, this.posY, this.posZ, j));
			}

			this.remove();
		}

	}
}

