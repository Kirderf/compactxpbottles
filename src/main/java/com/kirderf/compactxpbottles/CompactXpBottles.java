package com.kirderf.compactxpbottles;

import com.kirderf.compactxpbottles.lists.ItemList;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.DispenserBlock;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;


@Mod("compactxpbottles")
public class CompactXpBottles {
    public static final String MODID = "compactxpbottles";
    public static CompactXpBottles instance;
    private static final DeferredRegister<Item> ITEMS_REGISTER = ItemList.getItemRegister();
    private static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TAB_DEFERRED_REGISTER = ItemList.getCreativeModeTabDeferredRegister();

    public CompactXpBottles(FMLJavaModLoadingContext context) {
        instance = this;
        var modEventBus = context.getModEventBus();
        modEventBus.addListener(this::setupEvent);
        ITEMS_REGISTER.register(modEventBus);
        CREATIVE_MODE_TAB_DEFERRED_REGISTER.register(modEventBus);

        // Register DataGenerators to the mod-specific event bus
        modEventBus.register(DataGenerators.class);
        System.out.println("DataGenerators registered to mod-specific event bus.");
    }

    private void setupEvent(final FMLCommonSetupEvent event) {
        for (var itemDeferredHolder : ITEMS_REGISTER.getEntries()) {
            itemDeferredHolder.getHolder().ifPresent(item ->
                    DispenserBlock.registerBehavior(item.get(), (source, stack) -> stack)
            );
        }
    }
}