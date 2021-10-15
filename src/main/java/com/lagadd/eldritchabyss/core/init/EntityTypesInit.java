package com.lagadd.eldritchabyss.core.init;

import com.lagadd.eldritchabyss.EldritchAbyss;
import com.lagadd.eldritchabyss.common.entites.CausticSnishEntity;
import com.lagadd.eldritchabyss.common.entites.HermitCrabEntity;
import com.lagadd.eldritchabyss.common.entites.ReaverEntity;
import com.lagadd.eldritchabyss.common.entites.TorpedonEntity;

import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.EntityType;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class EntityTypesInit {

	public static final DeferredRegister<EntityType<?>> ENTITY_TYPES = DeferredRegister.create(ForgeRegistries.ENTITIES,
			com.lagadd.eldritchabyss.EldritchAbyss.MOD_ID);
	
	public static final RegistryObject<EntityType<HermitCrabEntity>> HermitCrab = ENTITY_TYPES.register("hermitcrab",
			() -> EntityType.Builder.<HermitCrabEntity>of(HermitCrabEntity::new, EntityClassification.AMBIENT)
		    .sized(0.3f,1.6f)
		    .build(new ResourceLocation(EldritchAbyss.MOD_ID, "hermitcrab").toString()));

			public static final RegistryObject<EntityType<ReaverEntity>> Reaver = ENTITY_TYPES.register("reaver",
					() -> EntityType.Builder.<ReaverEntity>of(ReaverEntity::new, EntityClassification.AMBIENT)
				    .sized(3.0f,2.0f)
				    .build(new ResourceLocation(EldritchAbyss.MOD_ID, "reaver").toString()));
			
			public static final RegistryObject<EntityType<TorpedonEntity>> Torpedon = ENTITY_TYPES.register("torpedon",
					() -> EntityType.Builder.<TorpedonEntity>of(TorpedonEntity::new, EntityClassification.AMBIENT)
				    .sized(0.5f,0.5f)
				    .build(new ResourceLocation(EldritchAbyss.MOD_ID, "torpedon").toString()));
			
	public static final RegistryObject<EntityType<CausticSnishEntity>> CausticSnish = ENTITY_TYPES.register("causticsnish",
			() -> EntityType.Builder.<CausticSnishEntity>of(CausticSnishEntity::new, EntityClassification.AMBIENT)
		    .sized(0.9f,1.6f)
		    .build(new ResourceLocation(com.lagadd.eldritchabyss.EldritchAbyss.MOD_ID, "causticsnish").toString()));
	

}