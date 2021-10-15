package com.lagadd.eldritchabyss.common.entites;

import net.minecraft.block.BlockState;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.MobEntity;
import net.minecraft.entity.ai.attributes.AttributeModifierMap;
import net.minecraft.entity.ai.attributes.Attributes;
import net.minecraft.entity.ai.goal.LeapAtTargetGoal;
import net.minecraft.entity.ai.goal.LookRandomlyGoal;
import net.minecraft.entity.ai.goal.NearestAttackableTargetGoal;
import net.minecraft.entity.passive.WaterMobEntity;
import net.minecraft.entity.passive.fish.AbstractFishEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.DamageSource;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.SoundEvents;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import software.bernie.geckolib3.core.IAnimatable;
import software.bernie.geckolib3.core.PlayState;
import software.bernie.geckolib3.core.builder.AnimationBuilder;
import software.bernie.geckolib3.core.controller.AnimationController;
import software.bernie.geckolib3.core.event.predicate.AnimationEvent;
import software.bernie.geckolib3.core.manager.AnimationData;
import software.bernie.geckolib3.core.manager.AnimationFactory;

			public class ReaverEntity extends WaterMobEntity implements IAnimatable {
				private AnimationFactory factory = new AnimationFactory(this);

				private <E extends IAnimatable> PlayState predicate(AnimationEvent<E> event) 
				{
					if (event.isMoving() && this.isOnGround()) {
						event.getController().setAnimation(new AnimationBuilder().addAnimation("run", true));
						return PlayState.CONTINUE;
					}
					if (event.isMoving() && this.isInWater()) {
						event.getController().setAnimation(new AnimationBuilder().addAnimation("swim", true));
						return PlayState.CONTINUE;
					}
					if (event.isMoving() && this.isFallFlying()) {
						event.getController().setAnimation(new AnimationBuilder().addAnimation("airborn", true));
						return PlayState.CONTINUE;
					}
					//if (event.isMoving() && this.fallDistance(2)) {
						//event.getController().setAnimation(new AnimationBuilder().addAnimation("landing", true));
						//return PlayState.CONTINUE;
					if (this.isAggressive()) {
						event.getController().setAnimation(new AnimationBuilder().addAnimation("bite", true));
						return PlayState.CONTINUE;
					}
					return null;
				}
				
				public ReaverEntity(EntityType<? extends WaterMobEntity> p_i48567_1_, World p_i48567_2_) {
				      super(p_i48567_1_, p_i48567_2_);
				}
			public static AttributeModifierMap.MutableAttribute registerAttributes() 
			{
				return MobEntity.createMobAttributes()
						.add(Attributes.MAX_HEALTH, 15.0D)
						.add(Attributes.MOVEMENT_SPEED, 0.3F)
						.add(Attributes.ATTACK_DAMAGE, 10.0D)
						.add(Attributes.FOLLOW_RANGE, 10.0D)
						.add(Attributes.ARMOR, 6.0D);
			}
				@Override
				public void registerControllers(AnimationData data) 
				{
					data.addAnimationController(new AnimationController<>(this, "controller", 0, this::predicate));
				}

				@Override
				public AnimationFactory getFactory() 
				{
					return this.factory;
				}

				@Override
				protected void registerGoals() {
					this.goalSelector.addGoal(6, new LookRandomlyGoal(this));
				    this.targetSelector.addGoal(7, new NearestAttackableTargetGoal<>(this, AbstractFishEntity.class, false));
				    this.goalSelector.addGoal(4, new LeapAtTargetGoal(this, 0.4F));
				    this.targetSelector.addGoal(4, new NearestAttackableTargetGoal<>(this, PlayerEntity.class, false));
				  //  this.goalSelector.addGoal(3, new GoToWaterGoal(this, 1.0D));
				    super.registerGoals();
				}

			   protected SoundEvent getDeathSound() {
			      return SoundEvents.SLIME_DEATH_SMALL;
			   }

			   protected SoundEvent getHurtSound(DamageSource p_184601_1_) {
			      return SoundEvents.SLIME_HURT;
			   }
			   
			   protected void playStepSound(BlockPos p_180429_1_, BlockState p_180429_2_) {
			      this.playSound(SoundEvents.SLIME_BLOCK_STEP, 0.15F, 1.0F);
			}
			 }