
package net.mcreator.createcogsinvaders.client.renderer;

import software.bernie.geckolib.renderer.GeoEntityRenderer;
import software.bernie.geckolib.cache.object.BakedGeoModel;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.MultiBufferSource;

import net.mcreator.createcogsinvaders.entity.model.ExplorerModel;
import net.mcreator.createcogsinvaders.entity.layer.ExplorerLayer;
import net.mcreator.createcogsinvaders.entity.ExplorerEntity;

import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.blaze3d.vertex.PoseStack;

public class ExplorerRenderer extends GeoEntityRenderer<ExplorerEntity> {
	public ExplorerRenderer(EntityRendererProvider.Context renderManager) {
		super(renderManager, new ExplorerModel());
		this.shadowRadius = 0.5f;
		this.addRenderLayer(new ExplorerLayer(this));
	}

	@Override
	public RenderType getRenderType(ExplorerEntity animatable, ResourceLocation texture, MultiBufferSource bufferSource, float partialTick) {
		return RenderType.entityTranslucent(getTextureLocation(animatable));
	}

	@Override
	public void preRender(PoseStack poseStack, ExplorerEntity entity, BakedGeoModel model, MultiBufferSource bufferSource, VertexConsumer buffer, boolean isReRender, float partialTick, int packedLight, int packedOverlay, float red, float green,
			float blue, float alpha) {
		float scale = 1f;
		this.scaleHeight = scale;
		this.scaleWidth = scale;
		super.preRender(poseStack, entity, model, bufferSource, buffer, isReRender, partialTick, packedLight, packedOverlay, red, green, blue, alpha);
	}

	@Override
	protected float getDeathMaxRotation(ExplorerEntity entityLivingBaseIn) {
		return 0.0F;
	}
}
