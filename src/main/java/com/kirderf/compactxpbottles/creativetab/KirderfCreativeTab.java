package com.kirderf.compactxpbottles.creativetab;

import com.kirderf.compactxpbottles.lists.ItemList;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import org.jetbrains.annotations.NotNull;

public class KirderfCreativeTab extends CreativeModeTab {
    public KirderfCreativeTab(String label) {
        super(label);
    }

    @Override
    public @NotNull ItemStack makeIcon() {
        return new ItemStack(ItemList.x256experiencebottle);
    }
}
