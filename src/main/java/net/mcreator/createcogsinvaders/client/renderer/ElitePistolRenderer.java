
package net.mcreator.createcogsinvaders.client.renderer;

import software.bernie.geckolib.renderer.GeoEntityRenderer;
import software.bernie.geckolib.cache.object.BakedGeoModel;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.MultiBufferSource;

import net.mcreator.createcogsinvaders.entity.model.ElitePistolModel;
import net.mcreator.createcogsinvaders.entity.layer.ElitePistolLayer;
import net.mcreator.createcogsinvaders.entity.ElitePistolEntity;

import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.blaze3d.vertex.PoseStack;

public class ElitePistolRenderer extends GeoEntityRenderer<ElitePistolEntity> {
	public ElitePistolRenderer(EntityRendererProvider.Context renderManager) {
		super(renderManager, new ElitePistolModel());
		this.shadowRadius = 0.5f;
		this.addRenderLayer(new ElitePistolLayer(this));
	}

	@Override
	public RenderType getRenderType(ElitePistolEntity animatable, ResourceLocation texture, MultiBufferSource bufferSource, float partialTick) {
		return RenderType.entityTranslucent(getTextureLocation(animatable));
	}

	@Override
	public void preRender(PoseStack poseStack, ElitePistolEntity entity, BakedGeoModel model, MultiBufferSource bufferSource, VertexConsumer buffer, boolean isReRender, float partialTick, int packedLight, int packedOverlay, float red, float green,
			float blue, float alpha) {
		float scale = 1f;
		this.scaleHeight = scale;
		this.scaleWidth = scale;
		super.preRender(poseStack, entity, model, bufferSource, buffer, isReRender, partialTick, packedLight, packedOverlay, red, green, blue, alpha);
	}

	@Override
	protected float getDeathMaxRotation(ElitePistolEntity entityLivingBaseIn) {
		return 0.0F;
	}
}
