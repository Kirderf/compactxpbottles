package com.kirderf.compactxpbottles.creativetab;

import com.kirderf.compactxpbottles.lists.ItemList;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;

public class KirderfCreativeTab extends ItemGroup {
    public KirderfCreativeTab(String label) {
        super(label);
    }

    @Override
    public ItemStack createIcon() {
        return new ItemStack(ItemList.x256experiencebottle);
    }
}
