package com.lagadd.eldritchabyss.common.entites;

import net.minecraft.block.BlockState;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.MobEntity;
import net.minecraft.entity.ai.attributes.AttributeModifierMap;
import net.minecraft.entity.ai.attributes.Attributes;
import net.minecraft.entity.ai.goal.LookRandomlyGoal;
import net.minecraft.entity.ai.goal.NearestAttackableTargetGoal;
import net.minecraft.entity.passive.IronGolemEntity;
import net.minecraft.entity.passive.fish.AbstractFishEntity;
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

			public class HermitCrabEntity extends IronGolemEntity implements IAnimatable {
				private AnimationFactory factory = new AnimationFactory(this);

				private <E extends IAnimatable> PlayState predicate(AnimationEvent<E> event) 
				{
					if (event.isMoving()) {
						event.getController().setAnimation(new AnimationBuilder().addAnimation("walk", true));
						return PlayState.CONTINUE;
						
					}
					
					if (this.isAggressive()) {
						event.getController().setAnimation(new AnimationBuilder().addAnimation("attack", true));
						return PlayState.CONTINUE;
					}
					
					if (this.isAggressive()) {
						event.getController().setAnimation(new AnimationBuilder().addAnimation("attack 2", true));
						return PlayState.CONTINUE;
					}
						if (this.dead || this.getHealth() < 0.01 || this.isDeadOrDying()) {
							event.getController().setAnimation(new AnimationBuilder().addAnimation("death", true));
							return PlayState.CONTINUE;
					}
					event.getController().setAnimation(new AnimationBuilder().addAnimation("idle", true));
					return PlayState.CONTINUE;
					
						//if (tickCount > 0) {tickCount--;}
							//event.getController().setAnimation(new AnimationBuilder().addAnimation("catch fly", true));
							//return PlayState.CONTINUE;
						}
				
				public HermitCrabEntity(EntityType<? extends IronGolemEntity> p_i48567_1_, World p_i48567_2_) {
				      super(p_i48567_1_, p_i48567_2_);
				}
			public static AttributeModifierMap.MutableAttribute registerAttributes() 
			{
				return MobEntity.createMobAttributes()
						.add(Attributes.MAX_HEALTH, 15.0D)
						.add(Attributes.FOLLOW_RANGE, 36.0D)
						.add(Attributes.MOVEMENT_SPEED, 0.2F)
						.add(Attributes.ATTACK_DAMAGE, 3.0D)
						.add(Attributes.FOLLOW_RANGE, 40.0D)
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
				    //this.targetSelector.addGoal(4, new NearestAttackableTargetGoal<>(this, PlayerEntity.class, 10, true, false, this::isAngryAt));
					super.registerGoals();
				}
			   //protected SoundEvent getAmbientSound() {
			    //  return SoundEvents.;
			   //}

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