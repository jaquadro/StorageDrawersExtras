package com.jaquadro.minecraft.storagedrawersextra.core;

import com.jaquadro.minecraft.storagedrawers.StorageDrawers;
import com.jaquadro.minecraft.storagedrawers.api.storage.EnumBasicDrawer;
import com.jaquadro.minecraft.storagedrawers.config.ConfigManager;
import com.jaquadro.minecraft.storagedrawers.util.RecipeHelper;
import com.jaquadro.minecraft.storagedrawersextra.StorageDrawersExtra;
import com.jaquadro.minecraft.storagedrawersextra.block.EnumMod;
import com.jaquadro.minecraft.storagedrawersextra.block.EnumVariant;
import com.jaquadro.minecraft.storagedrawersextra.config.ConfigManagerExt;
import net.minecraft.block.Block;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.oredict.ShapedOreRecipe;

import javax.annotation.Nonnull;

public class ModRecipes
{
    @Nonnull
    public static ItemStack makeBasicDrawerItemStack (EnumBasicDrawer info, String material, int count) {
        @Nonnull ItemStack stack = new ItemStack(ModBlocks.extraDrawers, count, info.getMetadata());

        NBTTagCompound data = new NBTTagCompound();
        data.setString("material", material);
        stack.setTagCompound(data);

        return stack;
    }

    public void init () {
        ConfigManager config = StorageDrawers.config;
        ConfigManagerExt configExt = StorageDrawersExtra.config;

        for (EnumVariant variant : EnumVariant.values()) {
            if (variant == EnumVariant.DEFAULT)
                continue;

            EnumMod mod = variant.getMod();
            if (mod == null || !mod.isEnabled(configExt.getModToggleState(mod)))
                continue;

            @Nonnull ItemStack plankStack = ItemStack.EMPTY;
            if (variant.getPlankResource() != null) {
                Block block = Block.getBlockFromName(variant.getPlankResource().toString());
                if (block != null)
                    plankStack = new ItemStack(block, 1, variant.getPlankMeta());
            }

            @Nonnull ItemStack slabStack = ItemStack.EMPTY;
            if (variant.getSlabResource() != null) {
                Block block = Block.getBlockFromName(variant.getSlabResource().toString());
                if (block != null)
                    slabStack = new ItemStack(block, 1, variant.getSlabMeta());
            }

            String material = variant.getResource().toString();

            String ch = "chestWood";
            String st = "stickWood";
            ItemStack pl = plankStack;
            ItemStack sl = slabStack;

            if (config.isBlockEnabled(EnumBasicDrawer.FULL1.getUnlocalizedName()) && !plankStack.isEmpty()) {
                @Nonnull ItemStack result = makeBasicDrawerItemStack(EnumBasicDrawer.FULL1, material, config.getBlockRecipeOutput(EnumBasicDrawer.FULL1.getUnlocalizedName()));
                RecipeHelper.addShapedRecipe(result, 3, 3, pl, pl, pl, null, ch, null, pl, pl, pl);
            }
            if (config.isBlockEnabled(EnumBasicDrawer.FULL2.getUnlocalizedName()) && !plankStack.isEmpty()) {
                @Nonnull ItemStack result = makeBasicDrawerItemStack(EnumBasicDrawer.FULL2, material, config.getBlockRecipeOutput(EnumBasicDrawer.FULL2.getUnlocalizedName()));
                RecipeHelper.addShapedRecipe(result, 3, 3, pl, ch, pl, pl, pl, pl, pl, ch, pl);
            }
            if (config.isBlockEnabled(EnumBasicDrawer.FULL4.getUnlocalizedName()) && !plankStack.isEmpty()) {
                @Nonnull ItemStack result = makeBasicDrawerItemStack(EnumBasicDrawer.FULL4, material, config.getBlockRecipeOutput(EnumBasicDrawer.FULL4.getUnlocalizedName()));
                RecipeHelper.addShapedRecipe(result, 3, 3, ch, pl, ch, pl, pl, pl, ch, pl, ch);
            }
            if (config.isBlockEnabled(EnumBasicDrawer.HALF2.getUnlocalizedName()) && !slabStack.isEmpty()) {
                @Nonnull ItemStack result = makeBasicDrawerItemStack(EnumBasicDrawer.HALF2, material, config.getBlockRecipeOutput(EnumBasicDrawer.HALF2.getUnlocalizedName()));
                RecipeHelper.addShapedRecipe(result, 3, 3, sl, ch, sl, sl, sl, sl, sl, ch, sl);
            }
            if (config.isBlockEnabled(EnumBasicDrawer.HALF4.getUnlocalizedName()) && !slabStack.isEmpty()) {
                @Nonnull ItemStack result = makeBasicDrawerItemStack(EnumBasicDrawer.HALF4, material, config.getBlockRecipeOutput(EnumBasicDrawer.HALF4.getUnlocalizedName()));
                RecipeHelper.addShapedRecipe(result, 3, 3, ch, sl, ch, sl, sl, sl, ch, sl, ch);
            }
            if (config.isBlockEnabled("trim") && !plankStack.isEmpty()) {
                @Nonnull ItemStack result = new ItemStack(ModBlocks.extraTrim[variant.getGroupIndex()], config.getBlockRecipeOutput("trim"), variant.getGroupMeta());
                RecipeHelper.addShapedRecipe(result, 3, 3, st, pl, st, pl, pl, pl, st, pl, st);
            }
        }
    }
}
