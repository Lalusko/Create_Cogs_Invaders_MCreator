package net.mcreator.createcogsinvaders.entity.model;

import software.bernie.geckolib.model.GeoModel;

import net.minecraft.resources.ResourceLocation;

import net.mcreator.createcogsinvaders.entity.DroneExplorerEntity;

public class DroneExplorerModel extends GeoModel<DroneExplorerEntity> {
	@Override
	public ResourceLocation getAnimationResource(DroneExplorerEntity entity) {
		return new ResourceLocation("create_cogs_invaders", "animations/drone_explorer.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(DroneExplorerEntity entity) {
		return new ResourceLocation("create_cogs_invaders", "geo/drone_explorer.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(DroneExplorerEntity entity) {
		return new ResourceLocation("create_cogs_invaders", "textures/entities/" + entity.getTexture() + ".png");
	}

}
