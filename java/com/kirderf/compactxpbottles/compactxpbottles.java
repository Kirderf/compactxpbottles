package com.kirderf.compactxpbottles;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.kirderf.compactxpbottles.lists.ItemList;
import com.kirderf.compactxpbottles.proxy.CommonProxy;
import com.kirderf.compactxpbottles.util.IHasModel;
import com.kirderf.compactxpbottles.util.Reference;

import net.minecraft.item.Item;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

@Mod(modid = Reference.MODID, version = Reference.VERSION, acceptedMinecraftVersions = Reference.ACCEPTED_VERSIONS, name = "Compact Experience Bottles")
public class compactxpbottles {
	public static compactxpbottles instance;
	private static final Logger logger = LogManager.getLogger("compactxpbottles");

	public compactxpbottles() {
		instance = this;

		MinecraftForge.EVENT_BUS.register(this);
	}

	@SidedProxy(clientSide = Reference.CLIENT_PROXY_CLASS, serverSide = Reference.COMMON_PROXY_CLASS)
	public static CommonProxy proxy;

	@EventHandler
	public void preInit(FMLPreInitializationEvent event) {
	}

	@EventHandler
	public void Init(FMLInitializationEvent event) {
	}

	@EventHandler
	public void postInit(FMLPostInitializationEvent event) {
	}

	@EventBusSubscriber
	public static class RegistryEvents {
		@SubscribeEvent
		public static void onItemRegister(RegistryEvent.Register<Item> event) {

			event.getRegistry().registerAll(ItemList.x4experiencebottle, ItemList.x16experiencebottle,
					ItemList.x64experiencebottle, ItemList.x256experiencebottle);

			logger.info("Items Registered");
		}

		@SubscribeEvent
		public static void onModelRegister(ModelRegistryEvent event) {
			for(Item item : ItemList.ITEMS) {
				if(item instanceof IHasModel) {
					((IHasModel)item).registerModels();
				}
			}
			logger.info("ItemModels Registered");
		}
	}
}