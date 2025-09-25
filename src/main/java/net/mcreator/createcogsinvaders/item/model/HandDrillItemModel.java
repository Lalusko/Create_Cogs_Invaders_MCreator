package net.mcreator.createcogsinvaders.item.model;

import software.bernie.geckolib.model.GeoModel;

import net.minecraft.resources.ResourceLocation;

import net.mcreator.createcogsinvaders.item.HandDrillItem;

public class HandDrillItemModel extends GeoModel<HandDrillItem> {
	@Override
	public ResourceLocation getAnimationResource(HandDrillItem animatable) {
		return new ResourceLocation("create_cogs_invaders", "animations/andesite_hand_drill.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(HandDrillItem animatable) {
		return new ResourceLocation("create_cogs_invaders", "geo/andesite_hand_drill.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(HandDrillItem animatable) {
		return new ResourceLocation("create_cogs_invaders", "textures/item/hand_drill.png");
	}
}
