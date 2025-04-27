package com.kirderf.compactxpbottles;

import com.kirderf.compactxpbottles.entity.CustomExperienceBottleEntity;
import com.kirderf.compactxpbottles.items.CustomExperienceBottle;
import com.kirderf.compactxpbottles.lists.ItemList;
import net.minecraft.core.Position;
import net.minecraft.core.dispenser.AbstractProjectileDispenseBehavior;
import net.minecraft.world.entity.projectile.Projectile;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.DispenserBlock;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;
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

        for (RegistryObject<Item> item : ITEMS_REGISTER.getEntries()) {
            DispenserBlock.registerBehavior(item.get(), new AbstractProjectileDispenseBehavior() {
                        @Override
                        protected Projectile getProjectile(Level level, Position position, ItemStack stack) {
                            return new CustomExperienceBottleEntity(level, position.x(), position.y(), position.z(), ((CustomExperienceBottle) item.get()).getXpMultiplier());
                        }
                    }
            );
        }
        logger.debug("Setup method registered");
    }
}