package com.jaquadro.minecraft.storagedrawersextra;

import com.jaquadro.minecraft.storagedrawersextra.core.CommonProxy;
import com.jaquadro.minecraft.storagedrawersextra.core.ModBlocks;
import com.jaquadro.minecraft.storagedrawersextra.core.ModRecipes;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

@Mod(modid = StorageDrawersExtra.MOD_ID, name = StorageDrawersExtra.MOD_NAME, version = StorageDrawersExtra.MOD_VERSION,
    dependencies = "required-after:StorageDrawers;required-after:Chameleon;after:waila;",
    acceptedMinecraftVersions = "[1.9,1.11)")
public class StorageDrawersExtra
{
    public static final String MOD_ID = "storagedrawersextra";
    public static final String MOD_NAME = "Storage Drawers Extras";
    public static final String MOD_VERSION = "@VERSION@";
    public static final String SOURCE_PATH = "com.jaquadro.minecraft.storagedrawersextra.";

    public static final ModBlocks blocks = new ModBlocks();
    public static final ModRecipes recipes = new ModRecipes();

    @Mod.Instance(MOD_ID)
    public static StorageDrawersExtra instance;

    @SidedProxy(clientSide = SOURCE_PATH + "core.ClientProxy", serverSide = SOURCE_PATH + "core.CommonProxy")
    public static CommonProxy proxy;

    @Mod.EventHandler
    public void preInit (FMLPreInitializationEvent event) {
        blocks.init();

        proxy.initDynamic();
        proxy.initClient();
        proxy.registerRenderers();
    }

    @Mod.EventHandler
    public void postInit (FMLPostInitializationEvent event) {
        recipes.init();
    }
}
