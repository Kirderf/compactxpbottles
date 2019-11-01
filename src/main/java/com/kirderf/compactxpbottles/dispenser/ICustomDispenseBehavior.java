package com.kirderf.compactxpbottles.dispenser;

import com.kirderf.compactxpbottles.entity.CustomExperienceBottleEntity;
import com.kirderf.compactxpbottles.lists.ItemList;

import net.minecraft.block.DispenserBlock;
import net.minecraft.dispenser.IDispenseItemBehavior;
import net.minecraft.dispenser.IPosition;
import net.minecraft.entity.IProjectile;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Util;
import net.minecraft.world.World;

public interface ICustomDispenseBehavior extends IDispenseItemBehavior{
	static void init() {
		 DispenserBlock.registerDispenseBehavior(ItemList.x4experiencebottle, new BottleDispenseBehavior() {
	         /**
	          * Return the projectile entity spawned by this dispense behavior.
	          */
	         protected IProjectile getProjectileEntity(World worldIn, IPosition position, ItemStack stackIn) {
	            return Util.make(new CustomExperienceBottleEntity(worldIn, position.getX(), position.getY(), position.getZ()), (p_218410_1_) -> {
	               p_218410_1_.func_213884_b(stackIn);
	            });
	         }

	         protected float getProjectileInaccuracy() {
	            return super.getProjectileInaccuracy() * 0.5F;
	         }

	         protected float getProjectileVelocity() {
	            return super.getProjectileVelocity() * 1.25F;
	         }
	      });
		 DispenserBlock.registerDispenseBehavior(ItemList.x16experiencebottle, new BottleDispenseBehavior() {
	         /**
	          * Return the projectile entity spawned by this dispense behavior.
	          */
	         protected IProjectile getProjectileEntity(World worldIn, IPosition position, ItemStack stackIn) {
	            return Util.make(new CustomExperienceBottleEntity(worldIn, position.getX(), position.getY(), position.getZ()), (p_218410_1_) -> {
	               p_218410_1_.func_213884_b(stackIn);
	            });
	         }

	         protected float getProjectileInaccuracy() {
	            return super.getProjectileInaccuracy() * 0.5F;
	         }

	         protected float getProjectileVelocity() {
	            return super.getProjectileVelocity() * 1.25F;
	         }
	      });
		 DispenserBlock.registerDispenseBehavior(ItemList.x64experiencebottle, new BottleDispenseBehavior() {
	         /**
	          * Return the projectile entity spawned by this dispense behavior.
	          */
	         protected IProjectile getProjectileEntity(World worldIn, IPosition position, ItemStack stackIn) {
	            return Util.make(new CustomExperienceBottleEntity(worldIn, position.getX(), position.getY(), position.getZ()), (p_218410_1_) -> {
	               p_218410_1_.func_213884_b(stackIn);
	            });
	         }

	         protected float getProjectileInaccuracy() {
	            return super.getProjectileInaccuracy() * 0.5F;
	         }

	         protected float getProjectileVelocity() {
	            return super.getProjectileVelocity() * 1.25F;
	         }
	      });
		 DispenserBlock.registerDispenseBehavior(ItemList.x256experiencebottle, new BottleDispenseBehavior() {
	         /**
	          * Return the projectile entity spawned by this dispense behavior.
	          */
	         protected IProjectile getProjectileEntity(World worldIn, IPosition position, ItemStack stackIn) {
	            return Util.make(new CustomExperienceBottleEntity(worldIn, position.getX(), position.getY(), position.getZ()), (p_218410_1_) -> {
	               p_218410_1_.func_213884_b(stackIn);
	            });
	         }

	         protected float getProjectileInaccuracy() {
	            return super.getProjectileInaccuracy() * 0.5F;
	         }

	         protected float getProjectileVelocity() {
	            return super.getProjectileVelocity() * 1.25F;
	         }
	      });

	   }
	}
