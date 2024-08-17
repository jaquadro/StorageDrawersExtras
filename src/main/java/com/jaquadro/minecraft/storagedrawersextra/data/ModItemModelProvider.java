package com.jaquadro.minecraft.storagedrawersextra.data;

import com.jaquadro.minecraft.storagedrawersextra.StorageDrawersExtra;
import com.jaquadro.minecraft.storagedrawersextra.block.VariantRegistry;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.PackOutput;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.common.data.ExistingFileHelper;

public class ModItemModelProvider extends ItemModelProvider
{
    public ModItemModelProvider(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, StorageDrawersExtra.MOD_ID, existingFileHelper);
    }

    @Override
    protected void registerModels () {
        for (VariantRegistry variant : VariantRegistry.values()) {
            if (variant.getMod() == null || !variant.getMod().isLoaded())
                continue;

            withExistingParent(variant.getTrimItemName(), modLoc(variant.getTrimModelName()));
            withExistingParent(variant.getItemModelName(1, false), modLoc(variant.getDrawerModelName(1, false)));
            withExistingParent(variant.getItemModelName(2, false), modLoc(variant.getDrawerModelName(2, false)));
            withExistingParent(variant.getItemModelName(4, false), modLoc(variant.getDrawerModelName(4, false)));
            withExistingParent(variant.getItemModelName(1, true), modLoc(variant.getDrawerModelName(1, true)));
            withExistingParent(variant.getItemModelName(2, true), modLoc(variant.getDrawerModelName(2, true)));
            withExistingParent(variant.getItemModelName(4, true), modLoc(variant.getDrawerModelName(4, true)));
        }
    }
}
