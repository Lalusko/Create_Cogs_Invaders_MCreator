
package net.mcreator.createcogsinvaders.client.renderer;

import software.bernie.geckolib.renderer.GeoEntityRenderer;
import software.bernie.geckolib.cache.object.BakedGeoModel;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.MultiBufferSource;

import net.mcreator.createcogsinvaders.entity.model.SentryPistolModel;
import net.mcreator.createcogsinvaders.entity.layer.SentryPistolLayer;
import net.mcreator.createcogsinvaders.entity.SentryPistolEntity;

import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.blaze3d.vertex.PoseStack;

public class SentryPistolRenderer extends GeoEntityRenderer<SentryPistolEntity> {
	public SentryPistolRenderer(EntityRendererProvider.Context renderManager) {
		super(renderManager, new SentryPistolModel());
		this.shadowRadius = 0.5f;
		this.addRenderLayer(new SentryPistolLayer(this));
	}

	@Override
	public RenderType getRenderType(SentryPistolEntity animatable, ResourceLocation texture, MultiBufferSource bufferSource, float partialTick) {
		return RenderType.entityTranslucent(getTextureLocation(animatable));
	}

	@Override
	public void preRender(PoseStack poseStack, SentryPistolEntity entity, BakedGeoModel model, MultiBufferSource bufferSource, VertexConsumer buffer, boolean isReRender, float partialTick, int packedLight, int packedOverlay, float red, float green,
			float blue, float alpha) {
		float scale = 1f;
		this.scaleHeight = scale;
		this.scaleWidth = scale;
		super.preRender(poseStack, entity, model, bufferSource, buffer, isReRender, partialTick, packedLight, packedOverlay, red, green, blue, alpha);
	}

	@Override
	protected float getDeathMaxRotation(SentryPistolEntity entityLivingBaseIn) {
		return 0.0F;
	}
}
