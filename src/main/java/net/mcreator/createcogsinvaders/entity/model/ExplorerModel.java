package net.mcreator.createcogsinvaders.entity.model;

import software.bernie.geckolib.model.GeoModel;

import net.minecraft.resources.ResourceLocation;

import net.mcreator.createcogsinvaders.entity.ExplorerEntity;

public class ExplorerModel extends GeoModel<ExplorerEntity> {
	@Override
	public ResourceLocation getAnimationResource(ExplorerEntity entity) {
		return new ResourceLocation("create_cogs_invaders", "animations/cog_explorer.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(ExplorerEntity entity) {
		return new ResourceLocation("create_cogs_invaders", "geo/cog_explorer.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(ExplorerEntity entity) {
		return new ResourceLocation("create_cogs_invaders", "textures/entities/" + entity.getTexture() + ".png");
	}

}
