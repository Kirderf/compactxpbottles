package com.kirderf.compactxpbottles.lists;


import com.kirderf.compactxpbottles.compactxpbottles;
import com.kirderf.compactxpbottles.items.CustomExperienceBottleItem;
import com.kirderf.compactxpbottles.items.CustomExperienceBottleItem.ExtraProperties;
import net.minecraft.item.Item;

public class ItemList {
	public static Item x4experiencebottle = new CustomExperienceBottleItem(((ExtraProperties) new CustomExperienceBottleItem.ExtraProperties().group(compactxpbottles.KirderfCreativeTab)).xpMultiplier(4));
	public static Item x16experiencebottle = new CustomExperienceBottleItem(((ExtraProperties) new CustomExperienceBottleItem.ExtraProperties().group(compactxpbottles.KirderfCreativeTab)).xpMultiplier(16));
	public static Item x64experiencebottle = new CustomExperienceBottleItem(((ExtraProperties) new CustomExperienceBottleItem.ExtraProperties().group(compactxpbottles.KirderfCreativeTab)).xpMultiplier(64));
	public static Item x256experiencebottle = new CustomExperienceBottleItem(((ExtraProperties) new CustomExperienceBottleItem.ExtraProperties().group(compactxpbottles.KirderfCreativeTab)).xpMultiplier(256));
}
