package com.jaquadro.minecraft.storagedrawersextra.data;

import com.jaquadro.minecraft.storagedrawersextra.StorageDrawersExtra;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.PackOutput;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.data.event.GatherDataEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import java.io.IOException;

@Mod.EventBusSubscriber(modid = StorageDrawersExtra.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class DataGenerators
{
    @SubscribeEvent
    public static void gatherData (GatherDataEvent event) {
        DataGenerator generator = event.getGenerator();
        PackOutput output = generator.getPackOutput();
        ExistingFileHelper helper = event.getExistingFileHelper();

        if (event.includeServer()) {
            generator.addProvider(true, new ModRecipeProvider(output));
        }
        if (event.includeClient()) {
            generator.addProvider(true, new ModBlockStateProvider(output, helper));
            generator.addProvider(true, new ModItemModelProvider(output, helper));
        }

        try {
            generator.run();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
