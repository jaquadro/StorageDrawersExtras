package com.jaquadro.minecraft.storagedrawersextra.core;

import com.jaquadro.minecraft.storagedrawers.block.BlockStandardDrawers;
import com.jaquadro.minecraft.storagedrawers.item.ItemDrawers;
import com.jaquadro.minecraft.storagedrawersextra.StorageDrawersExtra;
import com.jaquadro.minecraft.storagedrawersextra.block.VariantRegistry;
import com.texelsaurus.minecraft.chameleon.registry.ForgeRegistry;
import com.texelsaurus.minecraft.chameleon.registry.ForgeRegistryContext;
import com.texelsaurus.minecraft.chameleon.registry.RegistryEntry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.RegisterEvent;

import java.util.function.Supplier;

public class ModItems
{
    public static final ForgeRegistry<Item> ITEM_REGISTER = new ForgeRegistry<>(BuiltInRegistries.ITEM, StorageDrawersExtra.MOD_ID);

    private static final ResourceKey<CreativeModeTab> MAIN = ResourceKey.create(Registries.CREATIVE_MODE_TAB, new ResourceLocation(StorageDrawersExtra.MOD_ID, "storagedrawersextra"));

    public static void register (IEventBus bus) {
        addVariants();
        ITEM_REGISTER.init(new ForgeRegistryContext(bus));
    }

    static void addVariants() {
        for (VariantRegistry variant : VariantRegistry.values())
            variant.registerItems(ITEM_REGISTER);
    }

    public static void creativeModeTabRegister(RegisterEvent event) {
        event.register(Registries.CREATIVE_MODE_TAB, helper -> {
            Supplier<ItemStack> iconSupplier = () -> {
                RegistryEntry<Item> iconItem = ITEM_REGISTER.getEntries().stream().filter((entry) -> {
                    if (entry.get() instanceof ItemDrawers item) {
                        if (item.getBlock() instanceof BlockStandardDrawers block)
                            return !block.isHalfDepth() && block.getDrawerCount() == 2;
                    }
                    return false;
                }).findFirst().orElse(null);
                return iconItem == null ? ItemStack.EMPTY : new ItemStack(iconItem.get());
            };

            helper.register(MAIN, CreativeModeTab.builder().icon(iconSupplier)
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
