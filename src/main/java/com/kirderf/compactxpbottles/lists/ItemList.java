package com.kirderf.compactxpbottles.lists;


import com.kirderf.compactxpbottles.compactxpbottles;
import com.kirderf.compactxpbottles.items.CustomExperienceBottle;
import com.kirderf.compactxpbottles.items.CustomExperienceBottle.ExtraProperties;
import net.minecraft.world.item.Item;

public class ItemList {
	public static final Item x4experiencebottle = new CustomExperienceBottle((ExtraProperties) new ExtraProperties().xpMultiplier(4).tab(compactxpbottles.KirderfCreativeTab));
	public static final Item x16experiencebottle = new CustomExperienceBottle((ExtraProperties) new ExtraProperties().xpMultiplier(16).tab(compactxpbottles.KirderfCreativeTab));
	public static final Item x64experiencebottle = new CustomExperienceBottle((ExtraProperties) new ExtraProperties().xpMultiplier(64).tab(compactxpbottles.KirderfCreativeTab));
	public static final Item x256experiencebottle = new CustomExperienceBottle((ExtraProperties) new ExtraProperties().xpMultiplier(256).tab(compactxpbottles.KirderfCreativeTab));
	public static final Item x512experiencebottle = new CustomExperienceBottle((ExtraProperties) new ExtraProperties().xpMultiplier(512).tab(compactxpbottles.KirderfCreativeTab));
	public static final Item x1kexperiencebottle = new CustomExperienceBottle((ExtraProperties) new ExtraProperties().xpMultiplier(1024).tab(compactxpbottles.KirderfCreativeTab));
	public static final Item x2kexperiencebottle = new CustomExperienceBottle((ExtraProperties) new ExtraProperties().xpMultiplier(2048).tab(compactxpbottles.KirderfCreativeTab));
	public static final Item x4kexperiencebottle = new CustomExperienceBottle((ExtraProperties) new ExtraProperties().xpMultiplier(4096).tab(compactxpbottles.KirderfCreativeTab));
}
