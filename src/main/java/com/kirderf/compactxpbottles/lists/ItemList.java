package com.kirderf.compactxpbottles.lists;


import com.kirderf.compactxpbottles.items.CustomExperienceBottle;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

import static com.kirderf.compactxpbottles.CompactXpBottles.MODID;

public class ItemList {

    private static final DeferredRegister.Items ITEMS_REGISTER = DeferredRegister.createItems(MODID);
    private static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TAB_DEFERRED_REGISTER = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, MODID);

    private static DeferredItem<CustomExperienceBottle> iconItem;

    public static DeferredRegister.Items getItemRegister() {
        ITEMS_REGISTER.register("EXPERIENCE_BOTTLE_X4".toLowerCase(), () -> new CustomExperienceBottle(4));
        ITEMS_REGISTER.register("EXPERIENCE_BOTTLE_X16".toLowerCase(), () -> new CustomExperienceBottle(16));
        ITEMS_REGISTER.register("EXPERIENCE_BOTTLE_X64".toLowerCase(), () -> new CustomExperienceBottle(64));
        ITEMS_REGISTER.register("EXPERIENCE_BOTTLE_X256".toLowerCase(), () -> new CustomExperienceBottle(256));
        ITEMS_REGISTER.register("EXPERIENCE_BOTTLE_X1K".toLowerCase(), () -> new CustomExperienceBottle(1024));
        iconItem = ITEMS_REGISTER.register("EXPERIENCE_BOTTLE_X4K".toLowerCase(), () -> new CustomExperienceBottle(4096));
        ITEMS_REGISTER.register("EXPERIENCE_BOTTLE_X16K".toLowerCase(), () -> new CustomExperienceBottle(16384));
        ITEMS_REGISTER.register("EXPERIENCE_BOTTLE_X64K".toLowerCase(), () -> new CustomExperienceBottle(65536));
        return ITEMS_REGISTER;
    }

    public static DeferredRegister<CreativeModeTab> getCreativeModeTabDeferredRegister() {
        CREATIVE_MODE_TAB_DEFERRED_REGISTER.register(MODID, () -> CreativeModeTab.builder()
                .title(Component.translatable("item_group." + MODID))
                .icon(() -> new ItemStack(iconItem.asItem()))
                .displayItems((params, output) -> ITEMS_REGISTER.getEntries().forEach(x -> output.accept(x.get())))
                .build());
        return CREATIVE_MODE_TAB_DEFERRED_REGISTER;
    }

}
