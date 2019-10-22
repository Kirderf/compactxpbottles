package com.kirderf.horsesExtended;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.kirderf.horsesExtended.lists.FoodList;
import com.kirderf.horsesExtended.lists.ItemList;
import com.kirderf.horsesExtended.util.Reference;

import net.minecraft.item.Food;
import net.minecraft.item.Foods;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.Items;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod(Reference.MODID)
public class HorsesExtended {
	public static HorsesExtended instance;
	private static final Logger logger = LogManager.getLogger(Reference.MODID);

	public HorsesExtended() {
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
					ItemList.horseboost = new Item(new Item.Properties().food(FoodList.horseboost).group(ItemGroup.MISC))
					.setRegistryName(location("horseboost")));

			logger.info("Items Registered");
		}

		public static ResourceLocation location(String name) {
			return new ResourceLocation(Reference.MODID, name);
		}
	}
}
