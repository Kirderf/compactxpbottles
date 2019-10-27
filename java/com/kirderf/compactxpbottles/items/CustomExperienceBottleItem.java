package com.kirderf.compactxpbottles.items;

import com.kirderf.compactxpbottles.compactxpbottles;
import com.kirderf.compactxpbottles.entity.EntityCustomExperienceBottle;
import com.kirderf.compactxpbottles.lists.ItemList;
import com.kirderf.compactxpbottles.util.IHasModel;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.SoundEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.stats.StatList;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.util.SoundCategory;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class CustomExperienceBottleItem extends Item implements IHasModel{
	public CustomExperienceBottleItem(String name ,int xpMultiplyer) {
		this.setUnlocalizedName(name);
		this.setCreativeTab(CreativeTabs.MISC);
		this.setXpMultiplyer(xpMultiplyer);
		this.setRegistryName(name);
		ItemList.ITEMS.add(this);
	}

	public int xpMultiplyer = 1;

	public int getXpMultiplyer() {
		return this.xpMultiplyer;
	}
	public void setXpMultiplyer(int value) {
		this.xpMultiplyer = value;
	}
	
	
	
	/**
	 * Returns true if this item has an enchantment glint. By default, this returns
	 * <code>stack.isItemEnchanted()</code>, but other items can override it (for
	 * instance, written books always return true).
	 * 
	 * Note that if you override this method, you generally want to also call the
	 * super version (on {@link Item}) to get the glint for enchanted items. Of
	 * course, that is unnecessary if the overwritten version always returns true.
	 */
	@SideOnly(Side.CLIENT)
	public boolean hasEffect(ItemStack stack) {
		return true;
	}

	/**
	 * Called when the equipped item is right clicked.
	 */
	public ActionResult<ItemStack> onItemRightClick(World worldIn, EntityPlayer playerIn, EnumHand handIn) {
		ItemStack itemstack = playerIn.getHeldItem(handIn);

		if (!playerIn.capabilities.isCreativeMode) {
			itemstack.shrink(1);
		}

		worldIn.playSound((EntityPlayer) null, playerIn.posX, playerIn.posY, playerIn.posZ,
				SoundEvents.ENTITY_EXPERIENCE_BOTTLE_THROW, SoundCategory.NEUTRAL, 0.5F,
				0.4F / (itemRand.nextFloat() * 0.4F + 0.8F));

		if (!worldIn.isRemote) {
			EntityCustomExperienceBottle entityexpbottle = new EntityCustomExperienceBottle(worldIn, playerIn, xpMultiplyer);
			entityexpbottle.shoot(playerIn, playerIn.rotationPitch, playerIn.rotationYaw, -20.0F, 0.7F, 1.0F);
			worldIn.spawnEntity(entityexpbottle);
		}

		playerIn.addStat(StatList.getObjectUseStats(this));
		return new ActionResult<ItemStack>(EnumActionResult.SUCCESS, itemstack);
	}
	@Override
	public void registerModels() {
		compactxpbottles.proxy.registerItemRenderer(this, 0, "inventory");
		
	}
}
