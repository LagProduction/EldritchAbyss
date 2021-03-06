package com.lagadd.eldritchabyss.client.render.entity;

import com.lagadd.eldritchabyss.client.render.model.TorpedonEntityModel;
import com.lagadd.eldritchabyss.common.entites.TorpedonEntity;
import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;

import net.minecraft.client.renderer.IRenderTypeBuffer;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.util.ResourceLocation;
import software.bernie.geckolib3.renderers.geo.GeoEntityRenderer;

public class TorpedonEntityRenderer extends GeoEntityRenderer<TorpedonEntity> {
		
		public TorpedonEntityRenderer(EntityRendererManager renderManager) 
		{
			super(renderManager, new TorpedonEntityModel());
			this.shadowRadius = 0.0F;
		}

		@Override
		public RenderType getRenderType(TorpedonEntity animatable, float partialTicks, MatrixStack stack,
				IRenderTypeBuffer renderTypeBuffer, IVertexBuilder vertexBuilder, int packedLightIn,
				ResourceLocation textureLocation) {
			return RenderType.entityTranslucent(getTextureLocation(animatable));
			
			}
	}