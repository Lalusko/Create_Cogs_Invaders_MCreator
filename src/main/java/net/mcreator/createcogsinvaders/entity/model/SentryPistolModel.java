package net.mcreator.createcogsinvaders.entity.model;

import software.bernie.geckolib.model.GeoModel;

import net.minecraft.resources.ResourceLocation;

import net.mcreator.createcogsinvaders.entity.SentryPistolEntity;

public class SentryPistolModel extends GeoModel<SentryPistolEntity> {
	@Override
	public ResourceLocation getAnimationResource(SentryPistolEntity entity) {
		return new ResourceLocation("create_cogs_invaders", "animations/cog_pistol.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(SentryPistolEntity entity) {
		return new ResourceLocation("create_cogs_invaders", "geo/cog_pistol.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(SentryPistolEntity entity) {
		return new ResourceLocation("create_cogs_invaders", "textures/entities/" + entity.getTexture() + ".png");
	}

}
