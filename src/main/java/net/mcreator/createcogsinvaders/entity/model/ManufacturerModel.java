package net.mcreator.createcogsinvaders.entity.model;

import software.bernie.geckolib.model.GeoModel;

import net.minecraft.resources.ResourceLocation;

import net.mcreator.createcogsinvaders.entity.ManufacturerEntity;

public class ManufacturerModel extends GeoModel<ManufacturerEntity> {
	@Override
	public ResourceLocation getAnimationResource(ManufacturerEntity entity) {
		return new ResourceLocation("create_cogs_invaders", "animations/cog_manufacturer.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(ManufacturerEntity entity) {
		return new ResourceLocation("create_cogs_invaders", "geo/cog_manufacturer.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(ManufacturerEntity entity) {
		return new ResourceLocation("create_cogs_invaders", "textures/entities/" + entity.getTexture() + ".png");
	}

}
