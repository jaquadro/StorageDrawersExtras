package com.jaquadro.minecraft.storagedrawersextra;

import com.jaquadro.minecraft.storagedrawersextra.core.ModBlocks;
import com.jaquadro.minecraft.storagedrawersextra.core.ModItems;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod(StorageDrawersExtra.MOD_ID)
public class StorageDrawersExtra
{
    public static final String MOD_ID = "storagedrawersextra";

    public StorageDrawersExtra () {
        IEventBus bus = FMLJavaModLoadingContext.get().getModEventBus();

        ModBlocks.register(bus);
        ModItems.register(bus);

        bus.addListener(ModItems::creativeModeTabRegister);
    }
}
