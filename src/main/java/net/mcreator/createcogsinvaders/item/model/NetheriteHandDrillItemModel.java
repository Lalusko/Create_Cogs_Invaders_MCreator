package net.mcreator.createcogsinvaders.item.model;

import software.bernie.geckolib.model.GeoModel;

import net.minecraft.resources.ResourceLocation;

import net.mcreator.createcogsinvaders.item.NetheriteHandDrillItem;

public class NetheriteHandDrillItemModel extends GeoModel<NetheriteHandDrillItem> {
	@Override
	public ResourceLocation getAnimationResource(NetheriteHandDrillItem animatable) {
		return new ResourceLocation("create_cogs_invaders", "animations/hand_drill.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(NetheriteHandDrillItem animatable) {
		return new ResourceLocation("create_cogs_invaders", "geo/hand_drill.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(NetheriteHandDrillItem animatable) {
		return new ResourceLocation("create_cogs_invaders", "textures/item/netherite_hand_drill.png");
	}
}
