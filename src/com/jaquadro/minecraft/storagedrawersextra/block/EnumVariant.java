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

    BOP_SACREDOAK(ID.BOP, "sacredoak", 14, "planks_0", 0, "wood_slab_0", 0),
    BOP_CHERRY(ID.BOP, "cherry", 15, "planks_0", 1, "wood_slab_0", 1),
    BOP_DARK(ID.BOP, "dark", 16, "planks_0", 2, "wood_slab_0", 2),
    BOP_FIR(ID.BOP, "fir", 17, "planks_0", 3, "wood_slab_0", 3),
    BOP_ETHEREAL(ID.BOP, "ethereal", 18, "planks_0", 4, "wood_slab_0", 4),
    BOP_MAGIC(ID.BOP, "magic", 19, "planks_0", 5, "wood_slab_0", 5),
    BOP_MANGROVE(ID.BOP, "mangrove", 20, "planks_0", 6, "wood_slab_0", 6),
    BOP_PALM(ID.BOP, "palm", 21, "planks_0", 7, "wood_slab_0", 7),
    BOP_REDWOOD(ID.BOP, "redwood", 22, "planks_0", 8, "wood_slab_1", 0),
    BOP_WILLOW(ID.BOP, "willow", 23, "planks_0", 9, "wood_slab_1", 1),
    BOP_PINE(ID.BOP, "pine", 24, "planks_0", 10, "wood_slab_1", 2),
    BOP_HELLBARK(ID.BOP, "hellbark", 25, "planks_0", 11, "wood_slab_1", 3),
    BOP_JACARANDA(ID.BOP, "jacaranda", 26, "planks_0", 12, "wood_slab_1", 4),
    BOP_MAHOGANY(ID.BOP, "mahogany", 27, "planks_0", 13, "wood_slab_1", 5),
    BOP_EBONY(ID.BOP, "ebony", 28, "planks_0", 14, "wood_slab_1", 6),
    BOP_EUCALYPTUS(ID.BOP, "eucalyptus", 29, "planks_0", 15, "wood_slab_1", 7),
    ;

    private static final Map<ResourceLocation, EnumVariant> RESOURCE_LOOKUP;
    private static final Map<Integer, EnumVariant> INDEX_LOOKUP;

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

    @Nonnull
    public String getPath () {
        return resource.getResourcePath();
    }

    @Override
    @Nonnull
    public String getName () {
        return resource.toString();
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

    public int getIndex () {
        return index;
    }

    public int getGroupIndex () {
        return index / 16;
    }

    public int getGroupMeta () {
        return index % 16;
    }

    @Nonnull
    public static EnumVariant byResource (String resource) {
        EnumVariant varient = RESOURCE_LOOKUP.get(new ResourceLocation(resource));
        return varient != null ? varient : DEFAULT;
    }

    @Nonnull
    public static EnumVariant byGroupMeta (int group, int meta) {
        EnumVariant variant = INDEX_LOOKUP.get(group * 16 + meta);
        return variant != null ? variant : DEFAULT;
    }

    public static int groupCount () {
        return (values().length - 1) / 16 + 1;
    }

    static {
        RESOURCE_LOOKUP = new HashMap<ResourceLocation, EnumVariant>();
        INDEX_LOOKUP = new HashMap<Integer, EnumVariant>();

        for (EnumVariant variant : values()) {
            RESOURCE_LOOKUP.put(variant.getResource(), variant);
            INDEX_LOOKUP.put(variant.getIndex(), variant);
        }
    }

    private static class ID {
        public static final String NATURA = "Natura";
        public static final String BOP = "BiomesOPlenty";
    }
}
