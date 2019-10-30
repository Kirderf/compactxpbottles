package com.kirderf.compactxpbottles.lists;


import com.kirderf.compactxpbottles.items.CustomExperienceBottleItem;

import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;

public class ItemList {
	public static Item x4experiencebottle = new CustomExperienceBottleItem(new Item.Properties().group(ItemGroup.MISC)).setXpMultiplyer(4);
	public static Item x16experiencebottle = new CustomExperienceBottleItem(new Item.Properties().group(ItemGroup.MISC)).setXpMultiplyer(16);
	public static Item x64experiencebottle = new CustomExperienceBottleItem(new Item.Properties().group(ItemGroup.MISC)).setXpMultiplyer(64);
	public static Item x256experiencebottle = new CustomExperienceBottleItem(new Item.Properties().group(ItemGroup.MISC)).setXpMultiplyer(256);
}
