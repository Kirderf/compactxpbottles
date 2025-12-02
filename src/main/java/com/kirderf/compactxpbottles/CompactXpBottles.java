package com.kirderf.compactxpbottles;

import com.kirderf.compactxpbottles.lists.ItemList;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.DispenserBlock;
import net.neoforged.fml.ModLoadingContext;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent;
import net.neoforged.neoforge.registries.DeferredRegister;


@Mod("compactxpbottles")
public class CompactXpBottles {
    public static final String MODID = "compactxpbottles";
    public static CompactXpBottles instance;
    private static final DeferredRegister<Item> ITEMS_REGISTER = ItemList.getItemRegister();
    private static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TAB_DEFERRED_REGISTER = ItemList.getCreativeModeTabDeferredRegister();

    public CompactXpBottles() {
        instance = this;
        var modEventBus = ModLoadingContext.get().getActiveContainer().getEventBus();
        if (modEventBus == null) return;
        modEventBus.addListener(this::setupEvent);
        ITEMS_REGISTER.register(modEventBus);
        CREATIVE_MODE_TAB_DEFERRED_REGISTER.register(modEventBus);

    }

    private void setupEvent(final FMLCommonSetupEvent event) {
        for (var itemDeferredHolder : ITEMS_REGISTER.getEntries()) {
            DispenserBlock.registerProjectileBehavior(itemDeferredHolder.get());
        }
    }
}