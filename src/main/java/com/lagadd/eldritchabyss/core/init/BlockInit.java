package com.lagadd.eldritchabyss.core.init;

import com.lagadd.eldritchabyss.EldritchAbyss;

import net.minecraft.block.Block;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class BlockInit {
	public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS,
			EldritchAbyss.MOD_ID);
}
