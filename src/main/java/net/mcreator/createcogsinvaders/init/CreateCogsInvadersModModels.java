
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.createcogsinvaders.init;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.api.distmarker.Dist;

import net.mcreator.createcogsinvaders.client.model.Modelsturdy_pellet;
import net.mcreator.createcogsinvaders.client.model.Modelnugget_proyectile;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD, value = {Dist.CLIENT})
public class CreateCogsInvadersModModels {
	@SubscribeEvent
	public static void registerLayerDefinitions(EntityRenderersEvent.RegisterLayerDefinitions event) {
		event.registerLayerDefinition(Modelsturdy_pellet.LAYER_LOCATION, Modelsturdy_pellet::createBodyLayer);
		event.registerLayerDefinition(Modelnugget_proyectile.LAYER_LOCATION, Modelnugget_proyectile::createBodyLayer);
	}
}
