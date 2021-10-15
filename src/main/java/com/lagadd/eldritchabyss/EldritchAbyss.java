package com.lagadd.eldritchabyss;
	  import org.apache.logging.log4j.LogManager;
	  import org.apache.logging.log4j.Logger;

import com.lagadd.eldritchabyss.client.render.entity.CausticSnishEntityRenderer;
import com.lagadd.eldritchabyss.client.render.entity.HermitCrabEntityRenderer;
import com.lagadd.eldritchabyss.client.render.entity.ReaverEntityRenderer;
import com.lagadd.eldritchabyss.client.render.entity.TorpedonEntityRenderer;
import com.lagadd.eldritchabyss.common.entites.CausticSnishEntity;
import com.lagadd.eldritchabyss.common.entites.HermitCrabEntity;
import com.lagadd.eldritchabyss.common.entites.ReaverEntity;
import com.lagadd.eldritchabyss.common.entites.TorpedonEntity;
import com.lagadd.eldritchabyss.core.init.BlockInit;
import com.lagadd.eldritchabyss.core.init.EntityTypesInit;
import com.lagadd.eldritchabyss.core.init.ItemInit;
import com.lagadd.eldritchabyss.core.itemgroup.EldritchAbyssItemGroup;

import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.event.entity.EntityAttributeCreationEvent;
	  import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.DeferredWorkQueue;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
	  import net.minecraftforge.fml.common.Mod;
	  import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;
	  import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
	  import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
	  import software.bernie.example.GeckoLibMod;
	  import software.bernie.geckolib3.GeckoLib;

	  @Mod("eldritchabyss")
	  @Mod.EventBusSubscriber(modid = EldritchAbyss.MOD_ID, bus = Bus.MOD)
	   	public class EldritchAbyss {

	    	public static final Logger LOGGER = LogManager.getLogger();
	    	public static final String MOD_ID = "eldritchabyss";

	    	public EldritchAbyss() {
	    		IEventBus bus = FMLJavaModLoadingContext.get().getModEventBus();
	          bus.addListener(this::commonSetup);
	        	bus.addListener(this::entityAttributesRegistration);
	          
	          GeckoLibMod.DISABLE_IN_DEV = true;
	          GeckoLib.initialize();

	  		EntityTypesInit.ENTITY_TYPES.register(bus);
	  		ItemInit.ITEMS.register(bus);
	    		
	    		MinecraftForge.EVENT_BUS.register(this);
	    	}
	    	@SubscribeEvent
	    	public static void onRegisterItems(final RegistryEvent.Register<Item> event) {
	    		BlockInit.BLOCKS.getEntries().stream().map(RegistryObject::get).forEach(block -> {
	    			event.getRegistry().register(new BlockItem(block, new Item.Properties().tab(EldritchAbyssItemGroup.ELDRITCHABYSS))
	    					.setRegistryName(block.getRegistryName()));
	    				});
	   }
	  	@SuppressWarnings("deprecation")
	  	public void commonSetup(final FMLCommonSetupEvent event) {
	  	DeferredWorkQueue.runLater(() -> {
	  		RenderingRegistry.registerEntityRenderingHandler(EntityTypesInit.HermitCrab.get(), manager -> new HermitCrabEntityRenderer(manager));
	  		RenderingRegistry.registerEntityRenderingHandler(EntityTypesInit.CausticSnish.get(), manager -> new CausticSnishEntityRenderer(manager));
	  		RenderingRegistry.registerEntityRenderingHandler(EntityTypesInit.Reaver.get(), manager -> new ReaverEntityRenderer(manager));
	  		RenderingRegistry.registerEntityRenderingHandler(EntityTypesInit.Torpedon.get(), manager -> new TorpedonEntityRenderer(manager));
	  	});
	  	}
	  	  	private void entityAttributesRegistration(EntityAttributeCreationEvent event) {
	          event.put(EntityTypesInit.HermitCrab.get(), HermitCrabEntity.registerAttributes().build());
	          event.put(EntityTypesInit.CausticSnish.get(), CausticSnishEntity.setAttributes().build());
	          event.put(EntityTypesInit.Reaver.get(), ReaverEntity.registerAttributes().build());
	          event.put(EntityTypesInit.Torpedon.get(), TorpedonEntity.registerAttributes().build());
	  	  	}
	  }
