package com.kirderf.compactxpbottles;

import com.kirderf.compactxpbottles.lists.ItemList;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;

public class KirderfCreativeTab extends ItemGroup {
	public KirderfCreativeTab(String label) {
		super(label);
	}

	public KirderfCreativeTab(int index, String label) {
		super(index,label);
	}

	@Override
	public ItemStack createIcon() {
		return new ItemStack(ItemList.x4experiencebottle);
	}
}
