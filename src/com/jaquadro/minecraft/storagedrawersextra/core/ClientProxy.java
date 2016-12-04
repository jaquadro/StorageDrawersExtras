package com.jaquadro.minecraft.storagedrawersextra.core;

import com.jaquadro.minecraft.storagedrawersextra.StorageDrawersExtra;

public class ClientProxy extends CommonProxy
{
    @Override
    public void initDynamic () {
        StorageDrawersExtra.blocks.initDynamic();
    }

    @Override
    public void initClient () {
        StorageDrawersExtra.blocks.initClient();
    }

    @Override
    public void registerRenderers () {

    }
}
