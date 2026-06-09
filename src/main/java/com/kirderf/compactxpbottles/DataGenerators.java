package com.kirderf.compactxpbottles;

import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.data.event.GatherDataEvent;

import static com.kirderf.compactxpbottles.CompactXpBottles.MODID;

@EventBusSubscriber(modid = MODID)
public class DataGenerators {
    @SubscribeEvent
    public static void gatherData(GatherDataEvent event) {
        event.getGenerator().addProvider(
                event.includeServer(),
                new ModRecipeProvider(event.getGenerator().getPackOutput(), event.getLookupProvider())
        );
    }
}
