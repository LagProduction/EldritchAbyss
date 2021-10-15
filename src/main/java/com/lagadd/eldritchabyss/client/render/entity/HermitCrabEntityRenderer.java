package com.lagadd.eldritchabyss.client.render.entity;

import com.lagadd.eldritchabyss.client.render.model.HermitCrabEntityModel;
import com.lagadd.eldritchabyss.common.entites.HermitCrabEntity;
import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;

import net.minecraft.client.renderer.IRenderTypeBuffer;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.util.ResourceLocation;
import software.bernie.geckolib3.renderers.geo.GeoEntityRenderer;

	public class HermitCrabEntityRenderer extends GeoEntityRenderer<HermitCrabEntity> {
		
		public HermitCrabEntityRenderer(EntityRendererManager renderManager) 
		{
			super(renderManager, new HermitCrabEntityModel());
			this.shadowRadius = 0.0F;
		}

		@Override
		public RenderType getRenderType(HermitCrabEntity animatable, float partialTicks, MatrixStack stack,
				IRenderTypeBuffer renderTypeBuffer, IVertexBuilder vertexBuilder, int packedLightIn,
				ResourceLocation textureLocation) {
			return RenderType.entityTranslucent(getTextureLocation(animatable));
			
			}
	}