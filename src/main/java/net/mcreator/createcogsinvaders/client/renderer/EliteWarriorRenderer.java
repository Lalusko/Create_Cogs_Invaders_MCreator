
package net.mcreator.createcogsinvaders.client.renderer;

import software.bernie.geckolib.renderer.GeoEntityRenderer;
import software.bernie.geckolib.cache.object.BakedGeoModel;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.MultiBufferSource;

import net.mcreator.createcogsinvaders.entity.model.EliteWarriorModel;
import net.mcreator.createcogsinvaders.entity.layer.EliteWarriorLayer;
import net.mcreator.createcogsinvaders.entity.EliteWarriorEntity;

import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.blaze3d.vertex.PoseStack;

public class EliteWarriorRenderer extends GeoEntityRenderer<EliteWarriorEntity> {
	public EliteWarriorRenderer(EntityRendererProvider.Context renderManager) {
		super(renderManager, new EliteWarriorModel());
		this.shadowRadius = 0.5f;
		this.addRenderLayer(new EliteWarriorLayer(this));
	}

	@Override
	public RenderType getRenderType(EliteWarriorEntity animatable, ResourceLocation texture, MultiBufferSource bufferSource, float partialTick) {
		return RenderType.entityTranslucent(getTextureLocation(animatable));
	}

	@Override
	public void preRender(PoseStack poseStack, EliteWarriorEntity entity, BakedGeoModel model, MultiBufferSource bufferSource, VertexConsumer buffer, boolean isReRender, float partialTick, int packedLight, int packedOverlay, float red, float green,
			float blue, float alpha) {
		float scale = 1f;
		this.scaleHeight = scale;
		this.scaleWidth = scale;
		super.preRender(poseStack, entity, model, bufferSource, buffer, isReRender, partialTick, packedLight, packedOverlay, red, green, blue, alpha);
	}

	@Override
	protected float getDeathMaxRotation(EliteWarriorEntity entityLivingBaseIn) {
		return 0.0F;
	}
}
