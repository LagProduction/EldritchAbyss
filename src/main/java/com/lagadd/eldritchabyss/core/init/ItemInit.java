package com.lagadd.eldritchabyss.core.init;

import com.lagadd.eldritchabyss.EldritchAbyss;
import com.lagadd.eldritchabyss.core.itemgroup.EldritchAbyssItemGroup;

import net.minecraft.item.Item;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ItemInit {
	public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS,
			EldritchAbyss.MOD_ID);

    public static final RegistryObject<Item> GOBLINJAWS = ITEMS.register( "goblinjaws_item",
            () -> new Item( new Item.Properties().tab( EldritchAbyssItemGroup.ELDRITCHABYSS ) ) );

}