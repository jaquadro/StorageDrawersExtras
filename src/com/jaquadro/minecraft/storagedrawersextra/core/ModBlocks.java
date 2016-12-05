package com.jaquadro.minecraft.storagedrawersextra.core;

import com.jaquadro.minecraft.chameleon.Chameleon;
import com.jaquadro.minecraft.chameleon.resources.ModelRegistry;
import com.jaquadro.minecraft.storagedrawersextra.block.BlockExtraDrawers;
import com.jaquadro.minecraft.storagedrawersextra.block.BlockTrimExtra;
import com.jaquadro.minecraft.storagedrawersextra.block.EnumVariant;
import com.jaquadro.minecraft.storagedrawersextra.client.model.ExtraDrawerModel;
import com.jaquadro.minecraft.storagedrawersextra.client.model.ExtraTrimModel;
import com.jaquadro.minecraft.storagedrawersextra.item.ItemExtraDrawers;
import com.jaquadro.minecraft.storagedrawersextra.item.ItemTrimExtra;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import net.minecraftforge.oredict.OreDictionary;

public class ModBlocks
{
    public static BlockExtraDrawers extraDrawers;
    public static BlockTrimExtra[] extraTrim;

    public void init () {
        extraDrawers = new BlockExtraDrawers("extra_drawers");

        GameRegistry.register(extraDrawers);
        GameRegistry.register(new ItemExtraDrawers(extraDrawers).setRegistryName(extraDrawers.getRegistryName()));

        for (String key : new String[] { "drawerBasic" })
            OreDictionary.registerOre(key, new ItemStack(extraDrawers, 1, OreDictionary.WILDCARD_VALUE));

        extraTrim = new BlockTrimExtra[EnumVariant.groupCount()];
        for (int i = 0; i < extraTrim.length; i++) {
            extraTrim[i] = new BlockTrimExtra("extra_trim_" + i, i);

            GameRegistry.register(extraTrim[i]);
            GameRegistry.register(new ItemTrimExtra(extraTrim[i]).setRegistryName(extraTrim[i].getRegistryName()));
        }
    }

    @SideOnly(Side.CLIENT)
    public void initDynamic () {
        extraDrawers.initDynamic();
    }

    @SideOnly(Side.CLIENT)
    public void initClient () {
        ModelRegistry modelRegistry = Chameleon.instance.modelRegistry;

        modelRegistry.registerModel(new ExtraDrawerModel.Register());
        for (BlockTrimExtra block : extraTrim)
            modelRegistry.registerModel(new ExtraTrimModel.Register(block));
    }
}
