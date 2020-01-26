package com.kirderf.compactxpbottles;

import com.kirderf.compactxpbottles.core.Runner;
import com.kirderf.compactxpbottles.creativetab.KirderfCreativeTab;
import com.kirderf.compactxpbottles.lists.ItemList;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.DeferredWorkQueue;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.ObjectHolder;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@SuppressWarnings("deprecation")
@Mod("compactxpbottles")
public class compactxpbottles {

    public static compactxpbottles instance;
    private static final Logger logger = LogManager.getLogger("compactxpbottles");
    public static final String MODID = "compactxpbottles";
    public static ItemGroup KirderfCreativeTab = new KirderfCreativeTab("compactxpbottles");


    public compactxpbottles() {

        instance = this;
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::setupEvent);
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::clientRegisteries);
        MinecraftForge.EVENT_BUS.register(this);

    }

    private void setupEvent(final FMLCommonSetupEvent event) {
        DeferredWorkQueue.runLater(new Runner());
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
                    ItemList.x4kexperiencebottle.setRegistryName(location("x4kexperiencebottle")),
                    ItemList.x8kexperiencebottle.setRegistryName(location("x8kexperiencebottle")),
                    ItemList.x16kexperiencebottle.setRegistryName(location("x16kexperiencebottle"))

            );
            logger.info("Items registered");
        }

        public static ResourceLocation location(String name) {
            return new ResourceLocation("compactxpbottles", name);

        }
    }
}