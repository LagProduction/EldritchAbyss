package com.lagadd.eldritchabyss.core.itemgroup;

import com.lagadd.eldritchabyss.core.init.ItemInit;

import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;

public class EldritchAbyssItemGroup extends ItemGroup {

	public static final EldritchAbyssItemGroup ELDRITCHABYSS = new EldritchAbyssItemGroup(ItemGroup.TABS.length,
			"eldritchabyss");

	public EldritchAbyssItemGroup(int index, String label) {
		super(index, label);
	}
	@Override
	public ItemStack makeIcon() {
		return new ItemStack(ItemInit.GOBLINJAWS.get());
	}
}
