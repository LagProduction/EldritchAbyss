package com.lagadd.eldritchabyss.client.render.model;

import com.lagadd.eldritchabyss.EldritchAbyss;
import com.lagadd.eldritchabyss.common.entites.TorpedonEntity;

import net.minecraft.util.ResourceLocation;
import software.bernie.geckolib3.model.AnimatedGeoModel;

	public class TorpedonEntityModel extends AnimatedGeoModel <TorpedonEntity> {
		
	@Override
	public ResourceLocation getAnimationFileLocation(TorpedonEntity entity) 
	{
		return new ResourceLocation(EldritchAbyss.MOD_ID, "animations/torpedonanimation/animation.json");
	}

	@Override
	public ResourceLocation getModelLocation(TorpedonEntity entity)
	{
		return new ResourceLocation(EldritchAbyss.MOD_ID, "geo/torpedon.geo.json");
	}

	@Override
	public ResourceLocation getTextureLocation(TorpedonEntity entity)
	{
		return new ResourceLocation(EldritchAbyss.MOD_ID, "textures/entity/torpedon/torpedon.png");
	}
}

