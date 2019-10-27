package com.kirderf.compactxpbottles.lists;


import java.util.ArrayList;

import com.kirderf.compactxpbottles.items.CustomExperienceBottleItem;

import net.minecraft.item.Item;

public class ItemList {
	public static ArrayList<Item> ITEMS = new ArrayList<Item>();
	
	public static Item x4experiencebottle = new CustomExperienceBottleItem("x4experiencebottle", 4);
	public static Item x16experiencebottle = new CustomExperienceBottleItem("x16experiencebottle", 16);
	public static Item x64experiencebottle = new CustomExperienceBottleItem("x64experiencebottle", 64);
	public static Item x256experiencebottle = new CustomExperienceBottleItem("x256experiencebottle", 256);
}
