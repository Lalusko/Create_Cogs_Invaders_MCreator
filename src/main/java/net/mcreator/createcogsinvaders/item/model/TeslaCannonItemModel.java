package net.mcreator.createcogsinvaders.item.model;

import software.bernie.geckolib.model.GeoModel;

import net.minecraft.resources.ResourceLocation;

import net.mcreator.createcogsinvaders.item.TeslaCannonItem;

public class TeslaCannonItemModel extends GeoModel<TeslaCannonItem> {
	@Override
	public ResourceLocation getAnimationResource(TeslaCannonItem animatable) {
		return new ResourceLocation("create_cogs_invaders", "animations/tesla_cannon.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(TeslaCannonItem animatable) {
		return new ResourceLocation("create_cogs_invaders", "geo/tesla_cannon.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(TeslaCannonItem animatable) {
		return new ResourceLocation("create_cogs_invaders", "textures/item/tesla_cannon.png");
	}
}
