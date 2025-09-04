package net.mcreator.createcogsinvaders.entity.model;

import software.bernie.geckolib.model.GeoModel;

import net.minecraft.resources.ResourceLocation;

import net.mcreator.createcogsinvaders.entity.EliteWarriorEntity;

public class EliteWarriorModel extends GeoModel<EliteWarriorEntity> {
	@Override
	public ResourceLocation getAnimationResource(EliteWarriorEntity entity) {
		return new ResourceLocation("create_cogs_invaders", "animations/cog_warrior.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(EliteWarriorEntity entity) {
		return new ResourceLocation("create_cogs_invaders", "geo/cog_warrior.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(EliteWarriorEntity entity) {
		return new ResourceLocation("create_cogs_invaders", "textures/entities/" + entity.getTexture() + ".png");
	}

}
