package com.kirderf.compactxpbottles.creativetab;

import com.kirderf.compactxpbottles.lists.ItemList;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;

public class KirderfCreativeTab extends CreativeModeTab {
    public KirderfCreativeTab(String label) {
        super(label);
    }

    @Override
    public ItemStack makeIcon() {
        return new ItemStack(ItemList.x256experiencebottle);
    }
}
