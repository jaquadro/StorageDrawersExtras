package com.jaquadro.minecraft.storagedrawersextra.core;

import com.jaquadro.minecraft.chameleon.Chameleon;
import com.jaquadro.minecraft.chameleon.resources.ModelRegistry;
import com.jaquadro.minecraft.storagedrawersextra.block.BlockExtraDrawers;
import com.jaquadro.minecraft.storagedrawersextra.client.model.ExtraDrawerModel;
import com.jaquadro.minecraft.storagedrawersextra.item.ItemExtraDrawers;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import net.minecraftforge.oredict.OreDictionary;

public class ModBlocks
{
    public static BlockExtraDrawers extraDrawers;

    public void init () {
        extraDrawers = new BlockExtraDrawers("extra_drawers");

        GameRegistry.register(extraDrawers);
        GameRegistry.register(new ItemExtraDrawers(extraDrawers).setRegistryName(extraDrawers.getRegistryName()));

        for (String key : new String[] { "drawerBasic" })
            OreDictionary.registerOre(key, new ItemStack(extraDrawers, 1, OreDictionary.WILDCARD_VALUE));
    }

    @SideOnly(Side.CLIENT)
    public void initDynamic () {
        extraDrawers.initDynamic();
    }

    @SideOnly(Side.CLIENT)
    public void initClient () {
        ModelRegistry modelRegistry = Chameleon.instance.modelRegistry;

        modelRegistry.registerModel(new ExtraDrawerModel.Register());
    }
}
