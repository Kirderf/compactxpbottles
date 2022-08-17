package com.kirderf.compactxpbottles;

import com.kirderf.compactxpbottles.creativetab.KirderfCreativeTab;
import com.kirderf.compactxpbottles.dispenser.CustomDispenseBehavior;
import com.kirderf.compactxpbottles.lists.ItemList;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.DispenserBlock;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.ObjectHolder;

import java.util.logging.Logger;


@Mod("compactxpbottles")
public class compactxpbottles {

    public static compactxpbottles instance;
    private static final Logger logger = Logger.getLogger("compactxpbottles");
    public static final String MODID = "compactxpbottles";
    public static CreativeModeTab KirderfCreativeTab = new KirderfCreativeTab("compactxpbottles");


    public compactxpbottles() {

        instance = this;
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::setupEvent);
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::clientRegisteries);
        MinecraftForge.EVENT_BUS.register(this);

    }

    private void setupEvent(final FMLCommonSetupEvent event) {
        DispenserBlock.registerBehavior(ItemList.x4experiencebottle, new CustomDispenseBehavior());
        DispenserBlock.registerBehavior(ItemList.x16experiencebottle, new CustomDispenseBehavior());
        DispenserBlock.registerBehavior(ItemList.x64experiencebottle, new CustomDispenseBehavior());
        DispenserBlock.registerBehavior(ItemList.x256experiencebottle, new CustomDispenseBehavior());
        DispenserBlock.registerBehavior(ItemList.x512experiencebottle, new CustomDispenseBehavior());
        DispenserBlock.registerBehavior(ItemList.x2kexperiencebottle, new CustomDispenseBehavior());
        DispenserBlock.registerBehavior(ItemList.x4kexperiencebottle, new CustomDispenseBehavior());
        logger.info("Setup method registered");
    }

    private void clientRegisteries(final FMLClientSetupEvent event) {
        logger.info("ClientRegisteries method registered");
    }


    @Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
    @ObjectHolder(compactxpbottles.MODID)
    public static class RegistryEvents {
        @SubscribeEvent
        public static void RegistryItems(final RegistryEvent.Register<Item> event) {
            event.getRegistry().registerAll(
                    ItemList.x4experiencebottle.setRegistryName(location("x4experiencebottle")),
                    ItemList.x16experiencebottle.setRegistryName(location("x16experiencebottle")),
                    ItemList.x64experiencebottle.setRegistryName(location("x64experiencebottle")),
                    ItemList.x256experiencebottle.setRegistryName(location("x256experiencebottle")),
                    ItemList.x512experiencebottle.setRegistryName(location("x512experiencebottle")),
                    ItemList.x1kexperiencebottle.setRegistryName(location("x1kexperiencebottle")),
                    ItemList.x2kexperiencebottle.setRegistryName(location("x2kexperiencebottle")),
                    ItemList.x4kexperiencebottle.setRegistryName(location("x4kexperiencebottle"))

            );
            logger.info("Items registered");
        }
        public static ResourceLocation location(String name) {
            return new ResourceLocation("compactxpbottles", name);

        }
    }
}