package com.jaquadro.minecraft.storagedrawersextra.block;

import com.jaquadro.minecraft.storagedrawersextra.config.EnumToggle;
import net.minecraft.util.IStringSerializable;
import net.minecraftforge.fml.common.Loader;

public enum EnumMod implements IStringSerializable
{
    NATURA("natura"),
    BOP("BiomesOPlenty"),
    FORESTRY("forestry"),
    ;

    private String id;

    EnumMod (String modId) {
        this.id = modId;
    }

    @Override
    public String getName () {
        return id;
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
