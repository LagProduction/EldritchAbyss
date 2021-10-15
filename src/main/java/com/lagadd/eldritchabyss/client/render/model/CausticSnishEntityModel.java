package com.lagadd.eldritchabyss.client.render.model;

import com.lagadd.eldritchabyss.common.entites.CausticSnishEntity;
import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;

import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.MathHelper;

public class CausticSnishEntityModel<T extends CausticSnishEntity> extends EntityModel<T> {
		private final ModelRenderer core;
		private final ModelRenderer fin_right;
		private final ModelRenderer fin_left;
		private final ModelRenderer tail;
		private final ModelRenderer fin_back_2;
		private final ModelRenderer fin_back_1;
		private final ModelRenderer head;
		private final ModelRenderer body_back;
		private final ModelRenderer left_fin;
		private final ModelRenderer right_fin;
		private final ModelRenderer body_front;

		public CausticSnishEntityModel() {
			texWidth = 64;
			texHeight = 64;

			core = new ModelRenderer(this);
			core.setPos(0.0F, 26.0F, 0.0F);
			

			fin_right = new ModelRenderer(this);
			fin_right.setPos(0.0F, 0.0F, 0.0F);
			core.addChild(fin_right);
			

			fin_left = new ModelRenderer(this);
			fin_left.setPos(0.0F, 0.0F, 0.0F);
			core.addChild(fin_left);
			

			tail = new ModelRenderer(this);
			tail.setPos(0.0F, -6.0F, 15.0F);
			core.addChild(tail);
			tail.texOffs(0, 10).addBox(0.0F, -5.5F, 0.0F, 0.0F, 11.0F, 14.0F, 0.0F, false);

			fin_back_2 = new ModelRenderer(this);
			fin_back_2.setPos(0.0F, -9.5F, 4.0F);
			core.addChild(fin_back_2);
			fin_back_2.texOffs(42, 2).addBox(0.0F, -8.0F, 0.0F, 0.0F, 22.0F, 11.0F, 0.0F, false);

			fin_back_1 = new ModelRenderer(this);
			fin_back_1.setPos(0.0F, -10.5F, 1.0F);
			core.addChild(fin_back_1);
			fin_back_1.texOffs(51, 29).addBox(0.0F, -7.0F, -3.0F, 0.0F, 22.0F, 6.0F, 0.0F, false);
			fin_back_1.texOffs(40, 0).addBox(0.0F, 1.0F, -5.0F, 0.0F, 7.0F, 2.0F, 0.0F, false);

			head = new ModelRenderer(this);
			head.setPos(0.0F, -6.0F, -4.0F);
			core.addChild(head);
			head.texOffs(18, 55).addBox(-1.0F, -3.0F, -3.0F, 2.0F, 6.0F, 3.0F, 0.0F, false);

			body_back = new ModelRenderer(this);
			body_back.setPos(0.0F, -6.0F, 4.0F);
			core.addChild(body_back);
			body_back.texOffs(18, 0).addBox(-1.0F, -2.5F, 0.0F, 2.0F, 5.0F, 6.0F, 0.0F, false);
			body_back.texOffs(0, 35).addBox(-1.5F, -3.5F, 0.0F, 3.0F, 7.0F, 11.0F, 0.0F, false);

			left_fin = new ModelRenderer(this);
			left_fin.setPos(0.5F, -7.5F, -5.0F);
			core.addChild(left_fin);
			setRotationAngle(left_fin, -1.5708F, 0.0F, -0.7854F);
			left_fin.texOffs(0, 0).addBox(0.0F, -19.0F, 0.0F, 9.0F, 20.0F, 0.0F, 0.0F, false);

			right_fin = new ModelRenderer(this);
			right_fin.setPos(-0.5F, -7.5F, -5.0F);
			core.addChild(right_fin);
			setRotationAngle(right_fin, -1.5708F, 0.0F, 0.7854F);
			right_fin.texOffs(0, 0).addBox(-9.0F, -19.0F, 0.0F, 9.0F, 20.0F, 0.0F, 0.0F, true);

			body_front = new ModelRenderer(this);
			body_front.setPos(0.0F, -6.0F, -4.0F);
			core.addChild(body_front);
			body_front.texOffs(18, 11).addBox(-1.0F, -2.5F, 1.0F, 2.0F, 2.0F, 6.0F, 0.0F, false);
			body_front.texOffs(17, 38).addBox(-1.0F, 0.0F, 1.5F, 2.0F, 3.0F, 5.0F, 0.0F, false);
			body_front.texOffs(28, 47).addBox(-1.5F, -4.5F, 0.0F, 3.0F, 9.0F, 8.0F, 0.0F, false);
		}
		@Override
		public void renderToBuffer(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha){
			core.render(matrixStack, buffer, packedLight, packedOverlay);
		}

		public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
			modelRenderer.xRot = x;
			modelRenderer.yRot = y;
			modelRenderer.zRot = z;
		}
		@Override
		   public void setupAnim(T p_225597_1_, float p_225597_2_, float p_225597_3_, float p_225597_4_, float p_225597_5_, float p_225597_6_) {
		      if (!p_225597_1_.isInWater()) {
		         this.body_back.xRot = p_225597_6_ * ((float)Math.PI / 180F);
		         this.body_front.yRot = p_225597_5_ * ((float)Math.PI / 180F);
		         if (Entity.getHorizontalDistanceSqr(p_225597_1_.getDeltaMovement()) > 1.0E-7D) {
		            this.body_front.xRot += -0.05F + -0.05F * MathHelper.cos(p_225597_4_ * 0.3F);
		            this.tail.xRot = -0.1F * MathHelper.cos(p_225597_4_ * 0.3F);
		            this.tail.xRot = -0.2F * MathHelper.cos(p_225597_4_ * 0.3F);
		      }
		   }
	}
}
