package com.kirderf.compactxpbottles.dispenser;

import com.kirderf.compactxpbottles.entity.CustomExperienceBottleEntity;
import com.kirderf.compactxpbottles.items.CustomExperienceBottleItem;
import com.kirderf.compactxpbottles.lists.ItemList;
import net.minecraft.block.DispenserBlock;
import net.minecraft.dispenser.IPosition;
import net.minecraft.dispenser.ProjectileDispenseBehavior;
import net.minecraft.entity.IProjectile;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class CustumDispenseBehavior extends ProjectileDispenseBehavior{

	public static void init() {
		DispenserBlock.registerDispenseBehavior(ItemList.x4experiencebottle,  new CustumDispenseBehavior());
		DispenserBlock.registerDispenseBehavior(ItemList.x16experiencebottle, new CustumDispenseBehavior());
		DispenserBlock.registerDispenseBehavior(ItemList.x64experiencebottle, new CustumDispenseBehavior());
		DispenserBlock.registerDispenseBehavior(ItemList.x256experiencebottle, new CustumDispenseBehavior());
	}
	@Override
	protected IProjectile getProjectileEntity(World worldIn, IPosition position, ItemStack stackIn) {
		return new CustomExperienceBottleEntity(worldIn,position.getX(),position.getY(),position.getZ(), (CustomExperienceBottleItem) stackIn.getItem().asItem());
		
	}
	
}

