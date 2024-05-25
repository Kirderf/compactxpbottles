package com.kirderf.compactxpbottles;

import com.kirderf.compactxpbottles.lists.ItemList;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.DispenserBlock;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


@Mod("compactxpbottles")
public class compactxpbottles {
    public static final String MODID = "compactxpbottles";
    public static compactxpbottles instance;
    private static final Logger logger = LogManager.getLogger(MODID);
    private static final DeferredRegister<Item> ITEMS_REGISTER = ItemList.getItemRegister();
    private static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TAB_DEFERRED_REGISTER = ItemList.getCreativeModeTabDeferredRegister();

    public compactxpbottles() {
        instance = this;
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();
        modEventBus.addListener(this::setupEvent);
        ITEMS_REGISTER.register(FMLJavaModLoadingContext.get().getModEventBus());
        CREATIVE_MODE_TAB_DEFERRED_REGISTER.register(FMLJavaModLoadingContext.get().getModEventBus());
    }

    private void setupEvent(final FMLCommonSetupEvent event) {
        DispenserBlock.registerProjectileBehavior(ItemList.EXPERIENCE_BOTTLE_X4.get());
        DispenserBlock.registerProjectileBehavior(ItemList.EXPERIENCE_BOTTLE_X16.get());
        DispenserBlock.registerProjectileBehavior(ItemList.EXPERIENCE_BOTTLE_X64.get());
        DispenserBlock.registerProjectileBehavior(ItemList.EXPERIENCE_BOTTLE_X256.get());
        DispenserBlock.registerProjectileBehavior(ItemList.EXPERIENCE_BOTTLE_X1K.get());
        DispenserBlock.registerProjectileBehavior(ItemList.EXPERIENCE_BOTTLE_X4K.get());
        DispenserBlock.registerProjectileBehavior(ItemList.EXPERIENCE_BOTTLE_X16K.get());
        DispenserBlock.registerProjectileBehavior(ItemList.EXPERIENCE_BOTTLE_X64K.get());
        logger.debug("Setup method registered");
    }
}