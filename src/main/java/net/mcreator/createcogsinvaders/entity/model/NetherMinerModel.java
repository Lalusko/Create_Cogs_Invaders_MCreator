package net.mcreator.createcogsinvaders.entity.model;

import software.bernie.geckolib.model.GeoModel;

import net.minecraft.resources.ResourceLocation;

import net.mcreator.createcogsinvaders.entity.NetherMinerEntity;

public class NetherMinerModel extends GeoModel<NetherMinerEntity> {
	@Override
	public ResourceLocation getAnimationResource(NetherMinerEntity entity) {
		return new ResourceLocation("create_cogs_invaders", "animations/nether_miner.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(NetherMinerEntity entity) {
		return new ResourceLocation("create_cogs_invaders", "geo/nether_miner.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(NetherMinerEntity entity) {
		return new ResourceLocation("create_cogs_invaders", "textures/entities/" + entity.getTexture() + ".png");
	}

}
