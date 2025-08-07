package com.jaquadro.minecraft.storagedrawersextra.core;

import com.jaquadro.minecraft.storagedrawersextra.StorageDrawersExtra;
import com.jaquadro.minecraft.storagedrawersextra.block.VariantRegistry;
import com.texelsaurus.minecraft.chameleon.registry.ForgeRegistry;
import com.texelsaurus.minecraft.chameleon.registry.ForgeRegistryContext;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.eventbus.api.IEventBus;

public final class ModBlocks
{
    public static final ForgeRegistry<Block> BLOCK_REGISTER = new ForgeRegistry<>(BuiltInRegistries.BLOCK, StorageDrawersExtra.MOD_ID);

    public static void register(IEventBus bus) {
        addVariants();
        BLOCK_REGISTER.init(new ForgeRegistryContext(bus));
    }

    static void addVariants() {
        for (VariantRegistry variant : VariantRegistry.values())
            variant.registerBlocks(BLOCK_REGISTER);
    }
}
