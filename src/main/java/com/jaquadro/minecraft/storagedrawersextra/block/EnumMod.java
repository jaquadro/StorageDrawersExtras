package com.jaquadro.minecraft.storagedrawersextra.block;

import com.jaquadro.minecraft.storagedrawersextra.config.EnumToggle;
import net.minecraft.util.StringRepresentable;
import net.minecraftforge.fml.ModList;

import javax.annotation.Nonnull;

public enum EnumMod implements StringRepresentable
{
    BOP("biomesoplenty", VariantRegistry.BIOMESOPLENTY_FIR),
    BIOMESWEVEGONE("biomeswevegone", VariantRegistry.BIOMESWEVEGONE_ASPEN),
    IMMENG("immersiveengineering", VariantRegistry.IMMENG_TREATED)
    ;

    private String id;
    private VariantRegistry defaultMaterial;

    EnumMod (String modId, VariantRegistry defaultMaterial) {
        this.id = modId;
        this.defaultMaterial = defaultMaterial;
    }

    @Override
    @Nonnull
    public String getSerializedName() {
        return id;
    }

    public VariantRegistry getDefaultMaterial() {
        return defaultMaterial;
    }

    public boolean isLoaded() {
        return ModList.get().isLoaded(id);
    }

    public boolean isEnabled (EnumToggle toggle) {
        switch (toggle) {
            case ENABLED:
                return true;
            case DISABLED:
                return false;
            case AUTO:
            default:
                return isLoaded();
        }
    }

    public static EnumMod byId (String id) {
        for (EnumMod mod : values()) {
            if (mod.getSerializedName().equals(id))
                return mod;
        }

        return null;
    }
}
