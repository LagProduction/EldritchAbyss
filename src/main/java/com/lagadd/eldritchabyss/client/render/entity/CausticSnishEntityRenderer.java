package com.lagadd.eldritchabyss.client.render.entity;

import com.lagadd.eldritchabyss.EldritchAbyss;
import com.lagadd.eldritchabyss.client.render.model.CausticSnishEntityModel;
import com.lagadd.eldritchabyss.common.entites.CausticSnishEntity;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.util.ResourceLocation;

public class CausticSnishEntityRenderer extends MobRenderer<CausticSnishEntity, CausticSnishEntityModel<CausticSnishEntity>> {
	
	
	public static final ResourceLocation TEXTURE = new ResourceLocation(EldritchAbyss.MOD_ID, "textures/entity/causticsnish/snishskin.png");
	
	public CausticSnishEntityRenderer(EntityRendererManager manager) {
		super(manager, new CausticSnishEntityModel<>(), 0.0f);
	}
	@Override
	public ResourceLocation getTextureLocation(CausticSnishEntity p_110775_1_) {
		return TEXTURE;
	}
}
