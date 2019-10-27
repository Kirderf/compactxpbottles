package com.kirderf.compactxpbottles.entity;

import net.minecraft.entity.item.EntityExpBottle;
import net.minecraft.entity.item.EntityXPOrb;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.PotionTypes;
import net.minecraft.potion.PotionUtils;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.World;

public class EntityCustomExperienceBottle extends EntityExpBottle {
	int xpMultiPlyer;

	public EntityCustomExperienceBottle(World worldIn, EntityPlayer playerIn, int xpMultiplyer) {
		super(worldIn, playerIn);
		this.xpMultiPlyer = xpMultiplyer;
	}
	 
	@Override
	protected void onImpact(RayTraceResult result)
    {
        if (!this.world.isRemote)
        {
            this.world.playEvent(2002, new BlockPos(this), PotionUtils.getPotionColor(PotionTypes.WATER));
            int i = (3 + this.world.rand.nextInt(5) + this.world.rand.nextInt(5))*xpMultiPlyer;

            while (i > 0)
            {
                int j = EntityXPOrb.getXPSplit(i);
                i -= j;
                this.world.spawnEntity(new EntityXPOrb(this.world, this.posX, this.posY, this.posZ, j));
            }

            this.setDead();
        }
    }
}

