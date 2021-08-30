package com.manueh.winxclubreborn.datagen;

import com.manueh.winxclubreborn.Main;
import net.minecraft.data.DataGenerator;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.GatherDataEvent;


@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD, modid = Main.MODID)
public class DataGenerators {

    @SubscribeEvent
    public static void gatherData(GatherDataEvent event) {
        DataGenerator generator = event.getGenerator();
        if (event.includeServer()) {
            generator.addProvider(new Recipes(generator));
        }

        if (event.includeClient()) {
          //  generator.addProvider(new BlockStates(generator, event.getExistingFileHelper()));
            generator.addProvider(new Items(generator, event.getExistingFileHelper()));
        }
    }
}
