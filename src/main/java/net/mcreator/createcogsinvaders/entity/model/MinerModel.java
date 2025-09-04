package net.mcreator.createcogsinvaders.entity.model;

import software.bernie.geckolib.model.GeoModel;

import net.minecraft.resources.ResourceLocation;

import net.mcreator.createcogsinvaders.entity.MinerEntity;

public class MinerModel extends GeoModel<MinerEntity> {
	@Override
	public ResourceLocation getAnimationResource(MinerEntity entity) {
		return new ResourceLocation("create_cogs_invaders", "animations/cog_miner.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(MinerEntity entity) {
		return new ResourceLocation("create_cogs_invaders", "geo/cog_miner.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(MinerEntity entity) {
		return new ResourceLocation("create_cogs_invaders", "textures/entities/" + entity.getTexture() + ".png");
	}

}
