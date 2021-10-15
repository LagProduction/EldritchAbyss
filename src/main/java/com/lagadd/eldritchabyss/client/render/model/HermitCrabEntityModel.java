package com.lagadd.eldritchabyss.client.render.model;

import com.lagadd.eldritchabyss.EldritchAbyss;
import com.lagadd.eldritchabyss.common.entites.HermitCrabEntity;

import net.minecraft.util.ResourceLocation;
import software.bernie.geckolib3.model.AnimatedGeoModel;

	public class HermitCrabEntityModel extends AnimatedGeoModel <HermitCrabEntity> {
		
	@Override
	public ResourceLocation getAnimationFileLocation(HermitCrabEntity entity) 
	{
		return new ResourceLocation(EldritchAbyss.MOD_ID, "animations/hermitcrabanimations/animation.json");
	}

	@Override
	public ResourceLocation getModelLocation(HermitCrabEntity entity)
	{
		return new ResourceLocation(EldritchAbyss.MOD_ID, "geo/hermitcrab.geo.json");
	}

	@Override
	public ResourceLocation getTextureLocation(HermitCrabEntity entity)
	{
		return new ResourceLocation(EldritchAbyss.MOD_ID, "textures/entity/hermitcrab/hermitcrab.png");
	}
}

