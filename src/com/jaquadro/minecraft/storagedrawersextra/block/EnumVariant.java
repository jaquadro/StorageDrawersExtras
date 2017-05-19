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

    FORESTRY_LARCH(ID.FORESTRY, "larch", 30, "planks.0", 0, "slabs.0", 0),
    FORESTRY_TEAK(ID.FORESTRY, "teak", 31, "planks.0", 1, "slabs.0", 1),
    FORESTRY_ACACIA(ID.FORESTRY, "acacia", 32, "planks.0", 2, "slabs.0", 2),
    FORESTRY_LIME(ID.FORESTRY, "lime", 33, "planks.0", 3, "slabs.0", 3),
    FORESTRY_CHESTNUT(ID.FORESTRY, "chestnut", 34, "planks.0", 4, "slabs.0", 4),
    FORESTRY_WENGE(ID.FORESTRY, "wenge", 35, "planks.0", 5, "slabs.0", 5),
    FORESTRY_BAOBAB(ID.FORESTRY, "baobab", 36, "planks.0", 6, "slabs.0", 6),
    FORESTRY_SEQUOIA(ID.FORESTRY, "sequoia", 37, "planks.0", 7, "slabs.0", 7),
    FORESTRY_KAPOK(ID.FORESTRY, "kapok", 38, "planks.0", 8, "slabs.1", 0),
    FORESTRY_EBONY(ID.FORESTRY, "ebony", 39, "planks.0", 9, "slabs.1", 1),
    FORESTRY_MAHOGANY(ID.FORESTRY, "mahogany", 40, "planks.0", 10, "slabs.1", 2),
    FORESTRY_BALSA(ID.FORESTRY, "balsa", 41, "planks.0", 11, "slabs.1", 3),
    FORESTRY_WILLOW(ID.FORESTRY, "willow", 42, "planks.0", 12, "slabs.1", 4),
    FORESTRY_WALNUT(ID.FORESTRY, "walnut", 43, "planks.0", 13, "slabs.1", 5),
    FORESTRY_GREENHEART(ID.FORESTRY, "greenheart", 44, "planks.0", 14, "slabs.1", 6),
    FORESTRY_CHERRY(ID.FORESTRY, "cherry", 45, "planks.0", 15, "slabs.1", 7),
    FORESTRY_MAHOE(ID.FORESTRY, "mahoe", 46, "planks.1", 0, "slabs.2", 0),
    FORESTRY_POPLAR(ID.FORESTRY, "poplar", 47, "planks.1", 1, "slabs.2", 1),
    FORESTRY_PALM(ID.FORESTRY, "palm", 48, "planks.1", 2, "slabs.2", 2),
    FORESTRY_PAPAYA(ID.FORESTRY, "papaya", 49, "planks.1", 3, "slabs.2", 3),
    FORESTRY_PINE(ID.FORESTRY, "pine", 50, "planks.1", 4, "slabs.2", 4),
    FORESTRY_PLUM(ID.FORESTRY, "plum", 51, "planks.1", 5, "slabs.2", 5),
    FORESTRY_MAPLE(ID.FORESTRY, "maple", 52, "planks.1", 6, "slabs.2", 6),
    FORESTRY_CITRUS(ID.FORESTRY, "citrus", 53, "planks.1", 7, "slabs.2", 7),
    FORESTRY_GIGANTEUM(ID.FORESTRY, "giganteum", 54, "planks.1", 8, "slabs.3", 0),
    FORESTRY_IPE(ID.FORESTRY, "ipe", 55, "planks.1", 9, "slabs.3", 1),
    FORESTRY_PADAUK(ID.FORESTRY, "padauk", 56, "planks.1", 10, "slabs.3", 2),
    FORESTRY_COCOBOLO(ID.FORESTRY, "cocobolo", 57, "planks.1", 11, "slabs.3", 3),
    FORESTRY_ZEBRAWOOD(ID.FORESTRY, "zebrawood", 58, "planks.1", 12, "slabs.3", 4),

    IMMENG_TREATED(ID.IMMENG, "immeng_treated", 59, "treatedWood", 0, "treatedWoodSlab", 0),
    ;

    private static final Map<ResourceLocation, EnumVariant> RESOURCE_LOOKUP;
    private static final Map<Integer, EnumVariant> INDEX_LOOKUP;

    private final String domain;
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
        this.domain = domain;
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

    public EnumMod getMod () {
        return EnumMod.byId(domain);
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
        RESOURCE_LOOKUP = new HashMap<>();
        INDEX_LOOKUP = new HashMap<>();

        for (EnumVariant variant : values()) {
            RESOURCE_LOOKUP.put(variant.getResource(), variant);
            INDEX_LOOKUP.put(variant.getIndex(), variant);
        }
    }

    private static class ID {
        public static final String NATURA = "natura";
        public static final String BOP = "biomesoplenty";
        public static final String FORESTRY = "forestry";
        public static final String IMMENG = "immersiveengineering";
    }
}
