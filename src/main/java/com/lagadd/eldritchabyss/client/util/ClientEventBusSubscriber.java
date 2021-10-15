package com.lagadd.eldritchabyss.client.util;

import com.lagadd.eldritchabyss.EldritchAbyss;
import com.lagadd.eldritchabyss.client.render.entity.CausticSnishEntityRenderer;
import com.lagadd.eldritchabyss.client.render.entity.HermitCrabEntityRenderer;
import com.lagadd.eldritchabyss.client.render.entity.ReaverEntityRenderer;
import com.lagadd.eldritchabyss.client.render.entity.TorpedonEntityRenderer;
import com.lagadd.eldritchabyss.core.init.EntityTypesInit;

import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;

@OnlyIn(Dist.CLIENT)
@Mod.EventBusSubscriber(modid = EldritchAbyss.MOD_ID, bus = Bus.MOD, value = Dist.CLIENT)
public class ClientEventBusSubscriber {

	@SubscribeEvent
	public static void clientSetup(FMLClientSetupEvent event) {
		RenderingRegistry.registerEntityRenderingHandler(EntityTypesInit.HermitCrab.get(), HermitCrabEntityRenderer::new);
		RenderingRegistry.registerEntityRenderingHandler(EntityTypesInit.CausticSnish.get(), CausticSnishEntityRenderer::new);
		RenderingRegistry.registerEntityRenderingHandler(EntityTypesInit.Reaver.get(), ReaverEntityRenderer::new);
		RenderingRegistry.registerEntityRenderingHandler(EntityTypesInit.Torpedon.get(), TorpedonEntityRenderer::new);

	}
}