package net.mcreator.createcogsinvaders.entity.model;

import software.bernie.geckolib.model.GeoModel;

import net.minecraft.resources.ResourceLocation;

import net.mcreator.createcogsinvaders.entity.ElitePistolEntity;

public class ElitePistolModel extends GeoModel<ElitePistolEntity> {
	@Override
	public ResourceLocation getAnimationResource(ElitePistolEntity entity) {
		return new ResourceLocation("create_cogs_invaders", "animations/cog_pistol.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(ElitePistolEntity entity) {
		return new ResourceLocation("create_cogs_invaders", "geo/cog_pistol.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(ElitePistolEntity entity) {
		return new ResourceLocation("create_cogs_invaders", "textures/entities/" + entity.getTexture() + ".png");
	}

}
