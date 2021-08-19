package com.manueh.winxclubreborn.common.blocks;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.material.Material;

public class MagicPowderGenerator extends Block {

    public MagicPowderGenerator() {
        super(Properties.of(Material.METAL).sound(SoundType.METAL).strength(2.0F));
    }
}
