package net.mcreator.createcogsinvaders.item.model;

import software.bernie.geckolib.model.GeoModel;

import net.minecraft.resources.ResourceLocation;

import net.mcreator.createcogsinvaders.item.TeslaGunItem;

public class TeslaGunItemModel extends GeoModel<TeslaGunItem> {
	@Override
	public ResourceLocation getAnimationResource(TeslaGunItem animatable) {
		return new ResourceLocation("create_cogs_invaders", "animations/teslagun.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(TeslaGunItem animatable) {
		return new ResourceLocation("create_cogs_invaders", "geo/teslagun.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(TeslaGunItem animatable) {
		return new ResourceLocation("create_cogs_invaders", "textures/item/tesla_gun.png");
	}
}
