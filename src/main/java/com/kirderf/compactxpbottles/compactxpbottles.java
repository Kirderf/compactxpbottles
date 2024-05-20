package com.kirderf.compactxpbottles;

import com.kirderf.compactxpbottles.dispenser.CustomDispenseBehavior;
import com.kirderf.compactxpbottles.lists.ItemList;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.DispenserBlock;
import net.minecraftforge.event.CreativeModeTabEvent;
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

    public compactxpbottles() {
        instance = this;
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();
        modEventBus.addListener(this::setupEvent);
        modEventBus.addListener(this::onCreativeModeTabRegister);
        ITEMS_REGISTER.register(FMLJavaModLoadingContext.get().getModEventBus());
    }

    private void setupEvent(final FMLCommonSetupEvent event) {
        DispenserBlock.registerBehavior(ItemList.EXPERIENCE_BOTTLE_X4.get(), new CustomDispenseBehavior());
        DispenserBlock.registerBehavior(ItemList.EXPERIENCE_BOTTLE_X16.get(), new CustomDispenseBehavior());
        DispenserBlock.registerBehavior(ItemList.EXPERIENCE_BOTTLE_X64.get(), new CustomDispenseBehavior());
        DispenserBlock.registerBehavior(ItemList.EXPERIENCE_BOTTLE_X256.get(), new CustomDispenseBehavior());
        DispenserBlock.registerBehavior(ItemList.EXPERIENCE_BOTTLE_X1K.get(), new CustomDispenseBehavior());
        DispenserBlock.registerBehavior(ItemList.EXPERIENCE_BOTTLE_X4K.get(), new CustomDispenseBehavior());
        DispenserBlock.registerBehavior(ItemList.EXPERIENCE_BOTTLE_X16K.get(), new CustomDispenseBehavior());
        DispenserBlock.registerBehavior(ItemList.EXPERIENCE_BOTTLE_X64K.get(), new CustomDispenseBehavior());
        logger.debug("Setup method registered");
    }

    private void onCreativeModeTabRegister(CreativeModeTabEvent.Register event) {
        event.registerCreativeModeTab(new ResourceLocation(MODID, MODID + "tab"), builder -> builder.icon(() -> new ItemStack(ItemList.EXPERIENCE_BOTTLE_X256.get()))
                .title(Component.literal("Compact xp bottles"))
                .displayItems((params, output) -> {
                    output.accept(new ItemStack(ItemList.EXPERIENCE_BOTTLE_X4.get()));
                    output.accept(new ItemStack(ItemList.EXPERIENCE_BOTTLE_X16.get()));
                    output.accept(new ItemStack(ItemList.EXPERIENCE_BOTTLE_X64.get()));
                    output.accept(new ItemStack(ItemList.EXPERIENCE_BOTTLE_X256.get()));
                    output.accept(new ItemStack(ItemList.EXPERIENCE_BOTTLE_X1K.get()));
                    output.accept(new ItemStack(ItemList.EXPERIENCE_BOTTLE_X4K.get()));
                    output.accept(new ItemStack(ItemList.EXPERIENCE_BOTTLE_X16K.get()));
                    output.accept(new ItemStack(ItemList.EXPERIENCE_BOTTLE_X64K.get()));
                }));
    }
}