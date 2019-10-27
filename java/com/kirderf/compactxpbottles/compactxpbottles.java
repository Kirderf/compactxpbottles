package com.kirderf.compactxpbottles;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.kirderf.compactxpbottles.lists.ItemList;

import net.minecraft.item.Item;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod("compactxpbottles")
public class compactxpbottles {
	public static compactxpbottles instance;
	private static final Logger logger = LogManager.getLogger("compactxpbottles");

	public compactxpbottles() {
		instance = this;
		FMLJavaModLoadingContext.get().getModEventBus().addListener(this::setup);
		FMLJavaModLoadingContext.get().getModEventBus().addListener(this::clientRegisteries);

		MinecraftForge.EVENT_BUS.register(this);
	}

	private void setup(final FMLCommonSetupEvent event) {
		logger.info("Setup method registered");
	}

	private void clientRegisteries(final FMLClientSetupEvent event) {
		logger.info("clientRegisteries method registered");

	}

	@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
	public static class RegistryEvents {
		@SubscribeEvent
		public static void RegistryItems(final RegistryEvent.Register<Item> event) {

			event.getRegistry().registerAll(
					ItemList.x4experiencebottle.setRegistryName(location("x4experiencebottle")),
					ItemList.x16experiencebottle.setRegistryName(location("x16experiencebottle")),
					ItemList.x64experiencebottle.setRegistryName(location("x64experiencebottle")),
					ItemList.x256experiencebottle.setRegistryName(location("x256experiencebottle")));

			logger.info("Items Registered");
		}

		public static ResourceLocation location(String name) {
			return new ResourceLocation("compactxpbottles", name);

		}
	}
}