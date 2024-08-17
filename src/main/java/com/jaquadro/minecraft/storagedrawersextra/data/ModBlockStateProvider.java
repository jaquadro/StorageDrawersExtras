package com.jaquadro.minecraft.storagedrawersextra.data;

import com.jaquadro.minecraft.storagedrawers.StorageDrawers;
import com.jaquadro.minecraft.storagedrawers.block.BlockDrawers;
import com.jaquadro.minecraft.storagedrawers.block.BlockStandardDrawers;
import com.jaquadro.minecraft.storagedrawersextra.StorageDrawersExtra;
import com.jaquadro.minecraft.storagedrawersextra.block.VariantRegistry;
import net.minecraft.core.Direction;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.client.model.generators.*;
import net.minecraftforge.common.data.ExistingFileHelper;

public class ModBlockStateProvider extends BlockStateProvider
{
    public ModBlockStateProvider (PackOutput output, ExistingFileHelper exFileHelper) {
        super(output, StorageDrawersExtra.MOD_ID, exFileHelper);
    }

    @Override
    protected void registerStatesAndModels () {
        for (VariantRegistry variant : VariantRegistry.values())
            registerVariant(variant);
    }

    void registerVariant(VariantRegistry variant) {
        BlockModelBuilder blockTrim = models().cubeAll(variant.getTrimModelName(), modLoc(variant.getTextureName("side")));
        simpleBlock(variant.getData().blockTrim.get(), blockTrim);

        standardDrawer(variant, variant.getData().blockFull1.get(),
            new ResourceLocation(StorageDrawersExtra.MOD_ID, variant.getTextureName("side")),
            new ResourceLocation(StorageDrawersExtra.MOD_ID, variant.getTextureName("front_1")),
            new ResourceLocation(StorageDrawersExtra.MOD_ID, variant.getTextureName("trim")),
            1, false);
        standardDrawer(variant, variant.getData().blockFull2.get(),
            new ResourceLocation(StorageDrawersExtra.MOD_ID, variant.getTextureName("side")),
            new ResourceLocation(StorageDrawersExtra.MOD_ID, variant.getTextureName("front_2")),
            new ResourceLocation(StorageDrawersExtra.MOD_ID, variant.getTextureName("trim")),
            2, false);
        standardDrawer(variant, variant.getData().blockFull4.get(),
            new ResourceLocation(StorageDrawersExtra.MOD_ID, variant.getTextureName("side")),
            new ResourceLocation(StorageDrawersExtra.MOD_ID, variant.getTextureName("front_4")),
            new ResourceLocation(StorageDrawersExtra.MOD_ID, variant.getTextureName("trim")),
            4, false);

        standardDrawer(variant, variant.getData().blockHalf1.get(),
            new ResourceLocation(StorageDrawersExtra.MOD_ID, variant.getTextureName("side")),
            new ResourceLocation(StorageDrawersExtra.MOD_ID, variant.getTextureName("front_1")),
            new ResourceLocation(StorageDrawersExtra.MOD_ID, variant.getTextureName("side_h")),
            new ResourceLocation(StorageDrawersExtra.MOD_ID, variant.getTextureName("side")),
            new ResourceLocation(StorageDrawersExtra.MOD_ID, variant.getTextureName("trim")),
            1, true);
        standardDrawer(variant, variant.getData().blockHalf2.get(),
            new ResourceLocation(StorageDrawersExtra.MOD_ID, variant.getTextureName("side")),
            new ResourceLocation(StorageDrawersExtra.MOD_ID, variant.getTextureName("front_2")),
            new ResourceLocation(StorageDrawersExtra.MOD_ID, variant.getTextureName("side_h")),
            new ResourceLocation(StorageDrawersExtra.MOD_ID, variant.getTextureName("side")),
            new ResourceLocation(StorageDrawersExtra.MOD_ID, variant.getTextureName("trim")),
            2, true);
        standardDrawer(variant, variant.getData().blockHalf4.get(),
            new ResourceLocation(StorageDrawersExtra.MOD_ID, variant.getTextureName("side")),
            new ResourceLocation(StorageDrawersExtra.MOD_ID, variant.getTextureName("front_4")),
            new ResourceLocation(StorageDrawersExtra.MOD_ID, variant.getTextureName("side_h")),
            new ResourceLocation(StorageDrawersExtra.MOD_ID, variant.getTextureName("side")),
            new ResourceLocation(StorageDrawersExtra.MOD_ID, variant.getTextureName("trim")),
            4, true);
    }

    void standardDrawer(VariantRegistry variant, BlockStandardDrawers block, ResourceLocation side, ResourceLocation front, ResourceLocation trim, int size, boolean half) {
        standardDrawer(variant, block, side, front, side, side, trim, size, half);
    }

    void standardDrawer(VariantRegistry variant, BlockStandardDrawers block, ResourceLocation side, ResourceLocation front, ResourceLocation top, ResourceLocation back, ResourceLocation trim, int size, boolean half) {
        String parentType = half ? "half" : "full";
        ResourceLocation parent = new ResourceLocation(StorageDrawers.MOD_ID, "block/" + parentType + "_drawers_orientable");

        ModelFile model = models()
            .withExistingParent(variant.getDrawerModelName(size, half), parent)
            .texture("particle", front)
            .texture("east", side)
            .texture("west", side)
            .texture("north", front)
            .texture("up", top)
            .texture("down", top)
            .texture("south", back)
            .texture("trim", trim);

        drawerState(block, model);
    }

    void drawerState(BlockStandardDrawers block, ModelFile model) {
        VariantBlockStateBuilder builder = getVariantBuilder(block);
        builder.partialState().with(BlockDrawers.FACING, Direction.NORTH).addModels(new ConfiguredModel(model));
        builder.partialState().with(BlockDrawers.FACING, Direction.EAST).addModels(new ConfiguredModel(model, 0, 90, false));
        builder.partialState().with(BlockDrawers.FACING, Direction.SOUTH).addModels(new ConfiguredModel(model, 0, 180, false));
        builder.partialState().with(BlockDrawers.FACING, Direction.WEST).addModels(new ConfiguredModel(model, 0, 270, false));
    }
}
