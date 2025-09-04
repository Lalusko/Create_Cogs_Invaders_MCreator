package net.mcreator.createcogsinvaders.entity.model;

import software.bernie.geckolib.model.GeoModel;

import net.minecraft.resources.ResourceLocation;

import net.mcreator.createcogsinvaders.entity.SentryWarriorEntity;

public class SentryWarriorModel extends GeoModel<SentryWarriorEntity> {
	@Override
	public ResourceLocation getAnimationResource(SentryWarriorEntity entity) {
		return new ResourceLocation("create_cogs_invaders", "animations/cog_warrior.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(SentryWarriorEntity entity) {
		return new ResourceLocation("create_cogs_invaders", "geo/cog_warrior.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(SentryWarriorEntity entity) {
		return new ResourceLocation("create_cogs_invaders", "textures/entities/" + entity.getTexture() + ".png");
	}

}
