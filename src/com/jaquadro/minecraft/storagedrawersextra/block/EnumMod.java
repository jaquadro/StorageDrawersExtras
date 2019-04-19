package com.jaquadro.minecraft.storagedrawersextra.block;

import com.jaquadro.minecraft.storagedrawersextra.config.EnumToggle;
import net.minecraft.util.IStringSerializable;
import net.minecraftforge.fml.common.Loader;

import javax.annotation.Nonnull;

public enum EnumMod implements IStringSerializable
{
    NATURA("natura", EnumVariant.NATURA_WILLOW),
    BOP("biomesoplenty", EnumVariant.BOP_WILLOW),
    FORESTRY("forestry", EnumVariant.FORESTRY_WILLOW),
    IMMENG("immersiveengineering", EnumVariant.IMMENG_TREATED),
    AETHER("aether", EnumVariant.AETHER_SKYROOT) {
    	public boolean isLoaded() {
    		return Loader.isModLoaded("aether") || Loader.isModLoaded("aether_legacy");
    	}
    }
    ;

    private String id;
    private EnumVariant defaultMaterial;

    EnumMod (String modId, EnumVariant defaultMaterial) {
        this.id = modId;
        this.defaultMaterial = defaultMaterial;
    }

    @Override
    @Nonnull
    public String getName () {
        return id;
    }

    public EnumVariant getDefaultMaterial () {
        return defaultMaterial;
    }

    public boolean isLoaded () {
        return Loader.isModLoaded(id);
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
            if (mod.getName().equals(id))
                return mod;
        }

        return null;
    }
}
