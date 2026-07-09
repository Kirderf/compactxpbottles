package com.kirderf.compactxpbottles;


import net.minecraft.data.DataGenerator;
import net.minecraft.data.PackOutput;
import net.minecraftforge.data.event.GatherDataEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import static com.kirderf.compactxpbottles.CompactXpBottles.MODID;

@Mod.EventBusSubscriber(modid = MODID)
public class DataGenerators {
    @SubscribeEvent
    public static void gatherData(GatherDataEvent event) {
        System.out.println("GatherDataEvent triggered in DataGenerators.");
        DataGenerator generator = event.getGenerator();
        PackOutput output = generator.getPackOutput();

        // Register the ModRecipeProvider
        generator.addProvider(true, new ModRecipeProvider(output));
        System.out.println("ModRecipeProvider registered.");

        System.out.println("DataGenerators gatherData executed.");
    }
}
