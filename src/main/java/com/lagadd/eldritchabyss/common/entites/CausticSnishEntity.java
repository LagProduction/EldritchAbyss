package com.lagadd.eldritchabyss.common.entites;

	import net.minecraft.entity.EntityType;
	import net.minecraft.entity.MobEntity;
	import net.minecraft.entity.ai.attributes.AttributeModifierMap;
	import net.minecraft.entity.ai.attributes.Attributes;
	import net.minecraft.entity.ai.goal.LookRandomlyGoal;
import net.minecraft.entity.passive.DolphinEntity;
	import net.minecraft.entity.player.PlayerEntity;
	import net.minecraft.item.ItemStack;
	import net.minecraft.item.Items;
	import net.minecraft.util.DamageSource;
	import net.minecraft.util.SoundEvent;
	import net.minecraft.util.SoundEvents;
	import net.minecraft.world.World;

		public class CausticSnishEntity extends DolphinEntity {

			public CausticSnishEntity(EntityType<? extends DolphinEntity> type, World worldIn) {
				super(type, worldIn);
			}

			public static AttributeModifierMap.MutableAttribute setAttributes() {
				return MobEntity.createMobAttributes()
						.add(Attributes.MAX_HEALTH, 10.0f)
						.add(Attributes.MOVEMENT_SPEED, 0.4f);
			}
			
			@Override
			protected void registerGoals() {
				super.registerGoals();
				
				this.goalSelector.addGoal(1, new LookRandomlyGoal(this));
			}
			
			@Override
			protected int getExperienceReward(PlayerEntity player) {
				return 3;
			 }

			//   protected void saveToBucketTag(ItemStack p_204211_1_) {
			 //     super.saveToBucketTag(p_204211_1_);
			  //    CompoundNBT compoundnbt = p_204211_1_.getOrCreateTag();
			   //   compoundnbt.getInt("BucketVariantTag" /*this.getVariant()*/);
			//   }

			   protected ItemStack getBucketItemStack() {
			     return new ItemStack(Items.TROPICAL_FISH_BUCKET);
			   }

			   protected SoundEvent getAmbientSound() {
			      return SoundEvents.TROPICAL_FISH_AMBIENT;
			   }

			   protected SoundEvent getDeathSound() {
			      return SoundEvents.TROPICAL_FISH_DEATH;
			   }

			   protected SoundEvent getHurtSound(DamageSource p_184601_1_) {
			      return SoundEvents.TROPICAL_FISH_HURT;
			   }

			   protected SoundEvent getFlopSound() {
			      return SoundEvents.TROPICAL_FISH_FLOP;
			   }
	/*
			   @OnlyIn(Dist.CLIENT)
			   private static int getBaseColorIdx(int p_204216_0_) {
			      return (p_204216_0_ & 16711680) >> 16;
			   }*/
		}
