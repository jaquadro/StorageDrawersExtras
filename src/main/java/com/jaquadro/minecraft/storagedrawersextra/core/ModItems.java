package com.jaquadro.minecraft.storagedrawersextra.core;

import com.jaquadro.minecraft.storagedrawers.core.ModBlockVariants;
import com.jaquadro.minecraft.storagedrawers.core.ModBlocks;
import com.jaquadro.minecraft.storagedrawersextra.StorageDrawersExtra;
import com.jaquadro.minecraft.storagedrawersextra.block.VariantRegistry;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegisterEvent;

public class ModItems
{
    public static final DeferredRegister<Item> ITEM_REGISTER = DeferredRegister.create(ForgeRegistries.ITEMS, StorageDrawersExtra.MOD_ID);

    private static final ResourceKey<CreativeModeTab> MAIN = ResourceKey.create(Registries.CREATIVE_MODE_TAB, new ResourceLocation(StorageDrawersExtra.MOD_ID, "storagedrawersextra"));

    public static void register (IEventBus bus) {
        addVariants();
        ITEM_REGISTER.register(bus);
    }

    static void addVariants() {
        for (VariantRegistry variant : VariantRegistry.values())
            variant.registerItems(ITEM_REGISTER);
    }

    public static void creativeModeTabRegister(RegisterEvent event) {
        event.register(Registries.CREATIVE_MODE_TAB, helper -> {
            helper.register(MAIN, CreativeModeTab.builder().icon(() -> new ItemStack(ModBlocks.MANGROVE_FULL_DRAWERS_2.get()))
                .title(Component.translatable("itemGroup.storagedrawersextra"))
                .displayItems((params, output) -> {
                    ITEM_REGISTER.getEntries().forEach((reg) -> {
                        output.accept(new ItemStack(reg.get()));
                    });
                })
                .build());
        });
    }
}
