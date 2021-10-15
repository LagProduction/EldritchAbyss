package com.lagadd.eldritchabyss.client.render.entity;

import com.lagadd.eldritchabyss.client.render.model.ReaverEntityModel;
import com.lagadd.eldritchabyss.common.entites.ReaverEntity;
import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;

import net.minecraft.client.renderer.IRenderTypeBuffer;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.util.ResourceLocation;
import software.bernie.geckolib3.renderers.geo.GeoEntityRenderer;

public class ReaverEntityRenderer extends GeoEntityRenderer<ReaverEntity> {
		
		public ReaverEntityRenderer(EntityRendererManager renderManager) 
		{
			super(renderManager, new ReaverEntityModel());
			this.shadowRadius = 0.0F;
		}

		@Override
		public RenderType getRenderType(ReaverEntity animatable, float partialTicks, MatrixStack stack,
				IRenderTypeBuffer renderTypeBuffer, IVertexBuilder vertexBuilder, int packedLightIn,
				ResourceLocation textureLocation) {
			return RenderType.entityTranslucent(getTextureLocation(animatable));
			
			}
	}