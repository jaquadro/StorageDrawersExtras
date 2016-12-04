package com.jaquadro.minecraft.storagedrawersextra.block;

import com.jaquadro.minecraft.storagedrawersextra.StorageDrawersExtra;
import net.minecraft.util.IStringSerializable;
import net.minecraft.util.ResourceLocation;

import javax.annotation.Nonnull;

import java.util.HashMap;
import java.util.Map;

public enum EnumVariant implements IStringSerializable
{
    DEFAULT(StorageDrawersExtra.MOD_ID, "default", 0, null, 0),
    NATURA_EUCALYPTUS(ID.NATURA, "eucalyptus", 1, "overworld_planks", 5, "overworld_slab2", 0),
    NATURA_SAKURA(ID.NATURA, "sakura", 2, "overworld_planks", 7, "overworld_slab2", 2),
    NATURA_GHOSTWOOD(ID.NATURA, "ghostwood", 3, "nether_planks", 0, "nether_slab", 0),
    NATURA_REDWOOD(ID.NATURA, "redwood", 4, "overworld_planks", 8, "overworld_slab2", 3),
    NATURA_BLOODWOOD(ID.NATURA, "bloodwood", 5, "nether_planks", 1, "nether_slab", 1),
    NATURA_HOPSEED(ID.NATURA, "hopseed", 6, "overworld_planks", 6, "overworld_slab2", 1),
    NATURA_MAPLE(ID.NATURA, "maple", 7, "overworld_planks", 0, "overworld_slab", 0),
    NATURA_SILVERBELL(ID.NATURA, "silverbell", 8, "overworld_planks", 1, "overworld_slab", 1),
    NATURA_PURPLEHEART(ID.NATURA, "purpleheart", 9, "overworld_planks", 2, "overworld_slab", 2),
    NATURA_TIGERWOOD(ID.NATURA, "tigerwood", 10, "overworld_planks", 3, "overworld_slab", 3),
    NATURA_WILLOW(ID.NATURA, "willow", 11, "overworld_planks", 4, "overworld_slab", 4),
    NATURA_DARKWOOD(ID.NATURA, "darkwood", 12, "nether_planks", 2, "nether_slab", 2),
    NATURA_FUSEWOOD(ID.NATURA, "fusewood", 13, "nether_planks", 3, "nether_slab", 3),
    ;

    private static final Map<ResourceLocation, EnumVariant> RESOURCE_LOOKUP;

    private final ResourceLocation resource;
    private final ResourceLocation plankResource;
    private final ResourceLocation slabResource;
    private final int index;
    private final int plankMeta;
    private final int slabMeta;

    EnumVariant (String domain, String name, int index, String blockId, int blockMeta) {
        this(domain, name, index, blockId, blockMeta, null, 0);
    }

    EnumVariant (String domain, String name, int index, String plankId, int plankMeta, String slabId, int slabMeta) {
        this.plankResource = plankId != null ? new ResourceLocation(domain, plankId) : null;
        this.slabResource = slabId != null ? new ResourceLocation(domain, slabId) : null;
        this.plankMeta = plankMeta;
        this.slabMeta = slabMeta;
        this.resource = new ResourceLocation(domain, name);
        this.index = index;
    }

    @Nonnull
    public String getDomain () {
        return resource.getResourceDomain();
    }

    @Override
    @Nonnull
    public String getName () {
        return resource.getResourcePath();
    }

    @Nonnull
    public ResourceLocation getResource () {
        return resource;
    }

    public ResourceLocation getPlankResource () {
        return plankResource;
    }

    public int getPlankMeta () {
        return plankMeta;
    }

    public ResourceLocation getSlabResource () {
        return slabResource;
    }

    public int getSlabMeta () {
        return slabMeta;
    }

    @Nonnull
    public static EnumVariant byResource (String resource) {
        EnumVariant varient = RESOURCE_LOOKUP.get(new ResourceLocation(resource));
        return varient != null ? varient : DEFAULT;
    }

    static {
        RESOURCE_LOOKUP = new HashMap<ResourceLocation, EnumVariant>();
        for (EnumVariant variant : values())
            RESOURCE_LOOKUP.put(variant.getResource(), variant);
    }

    private static class ID {
        public static final String NATURA = "Natura";
    }
}
