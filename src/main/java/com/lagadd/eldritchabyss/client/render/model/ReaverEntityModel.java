package com.lagadd.eldritchabyss.client.render.model;

import com.lagadd.eldritchabyss.EldritchAbyss;
import com.lagadd.eldritchabyss.common.entites.ReaverEntity;

import net.minecraft.util.ResourceLocation;
import software.bernie.geckolib3.model.AnimatedGeoModel;

	public class ReaverEntityModel extends AnimatedGeoModel <ReaverEntity> {
		
	@Override
	public ResourceLocation getAnimationFileLocation(ReaverEntity entity) 
	{
		return new ResourceLocation(EldritchAbyss.MOD_ID, "animations/reaveranimations/animation.json");
	}

	@Override
	public ResourceLocation getModelLocation(ReaverEntity entity)
	{
		return new ResourceLocation(EldritchAbyss.MOD_ID, "geo/reaver.geo.json");
	}

	@Override
	public ResourceLocation getTextureLocation(ReaverEntity entity)
	{
		return new ResourceLocation(EldritchAbyss.MOD_ID, "textures/entity/reaver/reaver.png");
	}
}

