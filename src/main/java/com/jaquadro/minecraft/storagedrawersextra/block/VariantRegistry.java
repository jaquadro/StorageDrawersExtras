package com.jaquadro.minecraft.storagedrawersextra.block;

import com.jaquadro.minecraft.storagedrawers.block.BlockStandardDrawers;
import com.jaquadro.minecraft.storagedrawers.block.BlockTrim;
import com.jaquadro.minecraft.storagedrawers.core.ModBlockVariants;
import com.jaquadro.minecraft.storagedrawers.core.ModBlocks;
import com.jaquadro.minecraft.storagedrawersextra.StorageDrawersExtra;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public enum VariantRegistry
{
    BIOMESOPLENTY_FIR(MODID.BIOMESOPLENTY, "fir", "fir_planks", "fir_slab"),
    BIOMESOPLENTY_REDWOOD(MODID.BIOMESOPLENTY, "redwood", "redwood_planks", "redwood_slab"),
    BIOMESOPLENTY_MAHOGANY(MODID.BIOMESOPLENTY, "mahogany", "mahogany_planks", "mahogany_slab"),
    BIOMESOPLENTY_JACARANDA(MODID.BIOMESOPLENTY, "jacaranda", "jacaranda_planks", "jacaranda_slab"),
    BIOMESOPLENTY_PALM(MODID.BIOMESOPLENTY, "palm", "palm_planks", "palm_slab"),
    BIOMESOPLENTY_WILLOW(MODID.BIOMESOPLENTY, "willow", "willow_planks", "willow_slab"),
    //BIOMESOPLENTY_DEAD(MODID.BIOMESOPLENTY, "dead", "dead_planks", "dead_slab"),
    BIOMESOPLENTY_MAGIC(MODID.BIOMESOPLENTY, "magic", "magic_planks", "magic_slab"),
    //BIOMESOPLENTY_UMBRAN(MODID.BIOMESOPLENTY, "umbran", "umbran_planks", "umbran_slab"),
    BIOMESOPLENTY_HELLBARK(MODID.BIOMESOPLENTY, "hellbark", "hellbark_planks", "hellbark_slab"),
    ;

    private final String modid;
    private final String name;
    private final ResourceLocation plankResource;
    private final ResourceLocation slabResource;
    private final ModBlockVariants.VariantData data;

    VariantRegistry(String modid, String name, String plankName, String slabName) {
        this.modid = modid;
        this.name = name;
        this.plankResource = plankName != null ? new ResourceLocation(modid, plankName) : null;
        this.slabResource = slabName != null ? new ResourceLocation(modid, slabName) : null;
        this.data = new ModBlockVariants.VariantData(new ResourceLocation(StorageDrawersExtra.MOD_ID, modid + "_" + name));
    }

    public String getModid() {
        return modid;
    }

    public String getName() {
        return name;
    }

    public EnumMod getMod() {
        return EnumMod.byId(modid);
    }

    public ResourceLocation getPlankResource() {
        return plankResource;
    }

    public ResourceLocation getSlabResource() {
        return slabResource;
    }

    public ModBlockVariants.VariantData getData() {
        return data;
    }

    public String getTrimModelName () {
        return "block/" + modid + "_" + name + "_trim";
    }

    public String getTrimItemName () {
        return "item/" + modid + "_" + name + "_trim";
    }

    public String getDrawerModelName (int size, boolean half) {
        String type = half ? "half" : "full";
        return "block/" + modid + "_" + name + "_" + type + "_drawers_" + size;
    }

    public String getItemModelName (int size, boolean half) {
        String type = half ? "half" : "full";
        return "item/" + modid + "_" + name + "_" + type + "_drawers_" + size;
    }

    public String getTextureName (String textureVariant) {
        return "block/" + modid + "/drawers_" + name + "_" + textureVariant;
    }

    public void registerBlocks(DeferredRegister<Block> register) {
        ModBlockVariants.registerVariant(register, data);
    }

    public void registerItems(DeferredRegister<Item> register) {
        ModBlockVariants.registerVariantItem(register, data);
    }

    private static class MODID {
        public static final String BIOMESOPLENTY = "biomesoplenty";
    }
}
