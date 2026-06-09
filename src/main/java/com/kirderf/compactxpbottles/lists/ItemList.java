package com.kirderf.compactxpbottles.lists;


import com.kirderf.compactxpbottles.items.CustomExperienceBottle;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import static com.kirderf.compactxpbottles.CompactXpBottles.MODID;

public class ItemList {

    private static final DeferredRegister.Items ITEMS_REGISTER = DeferredRegister.createItems(MODID);
    private static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TAB_DEFERRED_REGISTER = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, MODID);

    private static DeferredItem<CustomExperienceBottle> iconItem;

    public static final List<Map.Entry<String, Integer>> BOTTLES = List.of(
            Map.entry("experience_bottle_x4",     4),
            Map.entry("experience_bottle_x16",    16),
            Map.entry("experience_bottle_x64",    64),
            Map.entry("experience_bottle_x256",   256),
            Map.entry("experience_bottle_x1k",    1024),
            Map.entry("experience_bottle_x4k",    4096),
            Map.entry("experience_bottle_x16k",   16384),
            Map.entry("experience_bottle_x64k",   65536)
    );

    public static final Map<String, DeferredItem<CustomExperienceBottle>> BOTTLE_ITEMS = new LinkedHashMap<>();


    public static DeferredRegister.Items getItemRegister() {
        for (var entry : BOTTLES) {
            var item = ITEMS_REGISTER.registerItem(entry.getKey(),
                    (properties) -> new CustomExperienceBottle(properties, entry.getValue()));

            BOTTLE_ITEMS.put(entry.getKey(), item);

            if (entry.getKey().equals("experience_bottle_x4k")) {
                iconItem = item;
            }
        }

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
