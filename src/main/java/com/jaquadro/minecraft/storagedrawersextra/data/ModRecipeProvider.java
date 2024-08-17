package com.jaquadro.minecraft.storagedrawersextra.data;

import com.jaquadro.minecraft.storagedrawersextra.StorageDrawersExtra;
import com.jaquadro.minecraft.storagedrawersextra.block.VariantRegistry;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.FinishedRecipe;
import net.minecraft.data.recipes.RecipeCategory;
import net.minecraft.data.recipes.RecipeProvider;
import net.minecraft.data.recipes.ShapedRecipeBuilder;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.common.Tags;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.function.Consumer;

public class ModRecipeProvider extends RecipeProvider
{
    public ModRecipeProvider(PackOutput output) {
        super(output);
    }

    @Override
    protected void buildRecipes (Consumer<FinishedRecipe> consumer) {
        for (VariantRegistry variant : VariantRegistry.values()) {
            if (variant.getMod() == null || !variant.getMod().isLoaded())
                continue;

            makeTrim(variant, consumer);
            makeDrawer1(variant, true, consumer);
            makeDrawer2(variant, true, consumer);
            makeDrawer4(variant, true, consumer);
            makeDrawer1(variant, false, consumer);
            makeDrawer2(variant, false, consumer);
            makeDrawer4(variant, false, consumer);
        }
    }

    private void makeTrim(VariantRegistry variant, Consumer<FinishedRecipe> consumer) {
        if (variant.getPlankResource() == null)
            return;

        Item plank = ForgeRegistries.ITEMS.getValue(variant.getPlankResource());
        if (plank == null)
            return;

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, variant.getData().blockTrim.get(), 4)
            .pattern("x/x")
            .pattern("/x/")
            .pattern("x/x")
            .define('x', plank).define('/', Tags.Items.RODS_WOODEN)
            .group(StorageDrawersExtra.MOD_ID)
            .unlockedBy("has_item", has(plank))
            .save(consumer);
    }

    private void makeDrawer1(VariantRegistry variant, boolean half, Consumer<FinishedRecipe> consumer) {
        ResourceLocation woodResource = half ? variant.getSlabResource() : variant.getPlankResource();
        if (woodResource == null)
            return;

        Item plank = ForgeRegistries.ITEMS.getValue(woodResource);
        if (plank == null)
            return;

        Block block = half ? variant.getData().blockHalf1.get() : variant.getData().blockFull1.get();
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, block, 1)
            .pattern("///")
            .pattern(" x ")
            .pattern("///")
            .define('x', Tags.Items.CHESTS_WOODEN).define('/', plank)
            .group(StorageDrawersExtra.MOD_ID)
            .unlockedBy("has_item", has(Tags.Items.CHESTS_WOODEN))
            .save(consumer);
    }

    private void makeDrawer2(VariantRegistry variant, boolean half, Consumer<FinishedRecipe> consumer) {
        ResourceLocation woodResource = half ? variant.getSlabResource() : variant.getPlankResource();
        if (woodResource == null)
            return;

        Item plank = ForgeRegistries.ITEMS.getValue(woodResource);
        if (plank == null)
            return;

        Block block = half ? variant.getData().blockHalf2.get() : variant.getData().blockFull2.get();
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, block, 2)
            .pattern("/x/")
            .pattern("///")
            .pattern("/x/")
            .define('x', Tags.Items.CHESTS_WOODEN).define('/', plank)
            .group(StorageDrawersExtra.MOD_ID)
            .unlockedBy("has_item", has(Tags.Items.CHESTS_WOODEN))
            .save(consumer);
    }

    private void makeDrawer4(VariantRegistry variant, boolean half, Consumer<FinishedRecipe> consumer) {
        ResourceLocation woodResource = half ? variant.getSlabResource() : variant.getPlankResource();
        if (woodResource == null)
            return;

        Item plank = ForgeRegistries.ITEMS.getValue(woodResource);
        if (plank == null)
            return;

        Block block = half ? variant.getData().blockHalf4.get() : variant.getData().blockFull4.get();
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, block, 4)
            .pattern("x/x")
            .pattern("///")
            .pattern("x/x")
            .define('x', Tags.Items.CHESTS_WOODEN).define('/', plank)
            .group(StorageDrawersExtra.MOD_ID)
            .unlockedBy("has_item", has(Tags.Items.CHESTS_WOODEN))
            .save(consumer);
    }
}
