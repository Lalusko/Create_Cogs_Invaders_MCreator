package net.mcreator.createcogsinvaders.entity.model;

import software.bernie.geckolib.model.GeoModel;

import net.minecraft.resources.ResourceLocation;

import net.mcreator.createcogsinvaders.entity.ChemistEntity;

public class ChemistModel extends GeoModel<ChemistEntity> {
	@Override
	public ResourceLocation getAnimationResource(ChemistEntity entity) {
		return new ResourceLocation("create_cogs_invaders", "animations/cog_chemist.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(ChemistEntity entity) {
		return new ResourceLocation("create_cogs_invaders", "geo/cog_chemist.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(ChemistEntity entity) {
		return new ResourceLocation("create_cogs_invaders", "textures/entities/" + entity.getTexture() + ".png");
	}

}
