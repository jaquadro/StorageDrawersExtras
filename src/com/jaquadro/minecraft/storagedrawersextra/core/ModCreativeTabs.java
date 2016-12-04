package com.jaquadro.minecraft.storagedrawersextra.core;

import com.jaquadro.minecraft.storagedrawersextra.block.EnumVariant;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class ModCreativeTabs
{
    private ModCreativeTabs () { }

    public static final CreativeTabs tabStorageDrawers = new CreativeTabs("storagedrawersextra") {

        @Override
        @SideOnly(Side.CLIENT)
        public ItemStack getIconItemStack () {
            ItemStack stack = super.getIconItemStack();

            NBTTagCompound tag = new NBTTagCompound();
            tag.setString("material", EnumVariant.NATURA_WILLOW.getResource().toString());
            stack.setTagCompound(tag);

            return stack;
        }

        @Override
        public Item getTabIconItem () {
            return Item.getItemFromBlock(ModBlocks.extraDrawers);
        }

        @Override
        public int getIconItemDamage () {
            return 1;
        }
    };
}
