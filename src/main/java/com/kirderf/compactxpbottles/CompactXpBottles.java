package com.kirderf.compactxpbottles;

import com.kirderf.compactxpbottles.items.CustomExperienceBottle;
import com.kirderf.compactxpbottles.lists.ItemList;
import com.kirderf.compactxpbottles.throwables.CustomThrownExperienceBottle;
import net.minecraft.Util;
import net.minecraft.core.Position;
import net.minecraft.core.dispenser.AbstractProjectileDispenseBehavior;
import net.minecraft.world.entity.projectile.Projectile;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
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
        for (var item : ITEMS_REGISTER.getEntries()) {
            DispenserBlock.registerBehavior(item.get(), new AbstractProjectileDispenseBehavior() {
                protected Projectile getProjectile(Level level, Position pos, ItemStack itemStack) {
                    return Util.make(new CustomThrownExperienceBottle(level, pos.x(), pos.y(), pos.z(),((CustomExperienceBottle) item.get()).getXpMultiplier()), (p_123483_) -> {
                        p_123483_.setItem(itemStack);
                    });
                }
            });
        }
    }
}