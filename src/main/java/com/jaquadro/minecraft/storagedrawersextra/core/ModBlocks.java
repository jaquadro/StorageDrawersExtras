package com.jaquadro.minecraft.storagedrawersextra.core;

import com.jaquadro.minecraft.storagedrawersextra.StorageDrawersExtra;
import com.jaquadro.minecraft.storagedrawersextra.block.VariantRegistry;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public final class ModBlocks
{
    public static final DeferredRegister<Block> BLOCK_REGISTER = DeferredRegister.create(ForgeRegistries.BLOCKS, StorageDrawersExtra.MOD_ID);

    public static void register(IEventBus bus) {
        addVariants();
        BLOCK_REGISTER.register(bus);
    }

    static void addVariants() {
        for (VariantRegistry variant : VariantRegistry.values())
            variant.registerBlocks(BLOCK_REGISTER);
    }
}
