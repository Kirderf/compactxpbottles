package com.kirderf.compactxpbottles.lists;


import com.kirderf.compactxpbottles.compactxpbottles;
import com.kirderf.compactxpbottles.items.CustomExperienceBottle;
import com.kirderf.compactxpbottles.items.CustomExperienceBottle.ExtraProperties;
import net.minecraft.world.item.Item;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import org.jetbrains.annotations.NotNull;

import static com.kirderf.compactxpbottles.compactxpbottles.MODID;

public class ItemList {

    private static final DeferredRegister<Item> ITEMS_REGISTER = DeferredRegister.create(ForgeRegistries.ITEMS, MODID);

    public static final RegistryObject<Item> EXPERIENCE_BOTTLE_X4 = ITEMS_REGISTER.register("EXPERIENCE_BOTTLE_X4".toLowerCase(),() -> createCustomExperienceBottle(4));
    public static final RegistryObject<Item> EXPERIENCE_BOTTLE_X16 = ITEMS_REGISTER.register("EXPERIENCE_BOTTLE_X16".toLowerCase(),() -> createCustomExperienceBottle(16));
    public static final RegistryObject<Item> EXPERIENCE_BOTTLE_X64 = ITEMS_REGISTER.register("EXPERIENCE_BOTTLE_X64".toLowerCase(),() -> createCustomExperienceBottle(64));
    public static final RegistryObject<Item> EXPERIENCE_BOTTLE_X256 = ITEMS_REGISTER.register("EXPERIENCE_BOTTLE_X256".toLowerCase(),() -> createCustomExperienceBottle(256));
    public static final RegistryObject<Item> EXPERIENCE_BOTTLE_X1K = ITEMS_REGISTER.register("EXPERIENCE_BOTTLE_X1K".toLowerCase(),() -> createCustomExperienceBottle(1024));
    public static final RegistryObject<Item> EXPERIENCE_BOTTLE_X4K = ITEMS_REGISTER.register("EXPERIENCE_BOTTLE_X4K".toLowerCase(),() -> createCustomExperienceBottle(4096));
    public static final RegistryObject<Item> EXPERIENCE_BOTTLE_X16K = ITEMS_REGISTER.register("EXPERIENCE_BOTTLE_X16K".toLowerCase(),() -> createCustomExperienceBottle(16384));
    public static final RegistryObject<Item> EXPERIENCE_BOTTLE_X64K = ITEMS_REGISTER.register("EXPERIENCE_BOTTLE_X64K".toLowerCase(),() -> createCustomExperienceBottle(65536));

    private static @NotNull CustomExperienceBottle createCustomExperienceBottle( int xpMultiplier) {
        return new CustomExperienceBottle((ExtraProperties) new ExtraProperties().xpMultiplier(xpMultiplier).tab(compactxpbottles.KirderfCreativeTab));
    }

    public static DeferredRegister<Item> getItemRegister() {
        return ITEMS_REGISTER;
    }

}
