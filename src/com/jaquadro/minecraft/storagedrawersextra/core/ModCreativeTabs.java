package com.jaquadro.minecraft.storagedrawersextra.core;

import com.jaquadro.minecraft.storagedrawersextra.block.EnumMod;
import com.jaquadro.minecraft.storagedrawersextra.block.EnumVariant;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import javax.annotation.Nonnull;

public class ModCreativeTabs
{
    private ModCreativeTabs () { }

    public static final CreativeTabs tabStorageDrawers = new CreativeTabs("storagedrawers") {
        @Override
        @Nonnull
        @SideOnly(Side.CLIENT)
        public ItemStack getTabIconItem () {
            ItemStack stack = super.getIconItemStack();

            EnumVariant material = EnumVariant.DEFAULT;
            for (EnumMod mod : EnumMod.values()) {
                if (mod.isLoaded()) {
                    material = mod.getDefaultMaterial();
                    break;
                }
            }

            NBTTagCompound tag = new NBTTagCompound();
            tag.setString("material", material.getResource().toString());
            stack.setTagCompound(tag);

            return stack;
        }
    };
}
