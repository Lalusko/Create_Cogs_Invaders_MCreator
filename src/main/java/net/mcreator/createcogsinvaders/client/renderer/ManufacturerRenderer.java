
package net.mcreator.createcogsinvaders.client.renderer;

import software.bernie.geckolib.renderer.GeoEntityRenderer;
import software.bernie.geckolib.cache.object.BakedGeoModel;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.MultiBufferSource;

import net.mcreator.createcogsinvaders.entity.model.ManufacturerModel;
import net.mcreator.createcogsinvaders.entity.layer.ManufacturerLayer;
import net.mcreator.createcogsinvaders.entity.ManufacturerEntity;

import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.blaze3d.vertex.PoseStack;

public class ManufacturerRenderer extends GeoEntityRenderer<ManufacturerEntity> {
	public ManufacturerRenderer(EntityRendererProvider.Context renderManager) {
		super(renderManager, new ManufacturerModel());
		this.shadowRadius = 0.5f;
		this.addRenderLayer(new ManufacturerLayer(this));
	}

	@Override
	public RenderType getRenderType(ManufacturerEntity animatable, ResourceLocation texture, MultiBufferSource bufferSource, float partialTick) {
		return RenderType.entityTranslucent(getTextureLocation(animatable));
	}

	@Override
	public void preRender(PoseStack poseStack, ManufacturerEntity entity, BakedGeoModel model, MultiBufferSource bufferSource, VertexConsumer buffer, boolean isReRender, float partialTick, int packedLight, int packedOverlay, float red, float green,
			float blue, float alpha) {
		float scale = 1f;
		this.scaleHeight = scale;
		this.scaleWidth = scale;
		super.preRender(poseStack, entity, model, bufferSource, buffer, isReRender, partialTick, packedLight, packedOverlay, red, green, blue, alpha);
	}

	@Override
	protected float getDeathMaxRotation(ManufacturerEntity entityLivingBaseIn) {
		return 0.0F;
	}
}
