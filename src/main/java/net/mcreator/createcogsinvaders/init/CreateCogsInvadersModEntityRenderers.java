
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.createcogsinvaders.init;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.client.renderer.entity.ThrownItemRenderer;

import net.mcreator.createcogsinvaders.client.renderer.SentryWarriorRenderer;
import net.mcreator.createcogsinvaders.client.renderer.SentryPistolRenderer;
import net.mcreator.createcogsinvaders.client.renderer.NetherMinerRenderer;
import net.mcreator.createcogsinvaders.client.renderer.MinerRenderer;
import net.mcreator.createcogsinvaders.client.renderer.ManufacturerRenderer;
import net.mcreator.createcogsinvaders.client.renderer.FireBallRenderer;
import net.mcreator.createcogsinvaders.client.renderer.ExplorerRenderer;
import net.mcreator.createcogsinvaders.client.renderer.EliteWarriorRenderer;
import net.mcreator.createcogsinvaders.client.renderer.ElitePistolRenderer;
import net.mcreator.createcogsinvaders.client.renderer.DroneExplorerRenderer;
import net.mcreator.createcogsinvaders.client.renderer.ChemistRenderer;
import net.mcreator.createcogsinvaders.client.renderer.BrassPelletWitherRenderer;
import net.mcreator.createcogsinvaders.client.renderer.BrassPelletRenderer;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class CreateCogsInvadersModEntityRenderers {
	@SubscribeEvent
	public static void registerEntityRenderers(EntityRenderersEvent.RegisterRenderers event) {
		event.registerEntityRenderer(CreateCogsInvadersModEntities.ELECTROSHOCK_CHARGE.get(), ThrownItemRenderer::new);
		event.registerEntityRenderer(CreateCogsInvadersModEntities.MINER.get(), MinerRenderer::new);
		event.registerEntityRenderer(CreateCogsInvadersModEntities.EXPLORER.get(), ExplorerRenderer::new);
		event.registerEntityRenderer(CreateCogsInvadersModEntities.MANUFACTURER.get(), ManufacturerRenderer::new);
		event.registerEntityRenderer(CreateCogsInvadersModEntities.CHEMIST.get(), ChemistRenderer::new);
		event.registerEntityRenderer(CreateCogsInvadersModEntities.DRONE_EXPLORER.get(), DroneExplorerRenderer::new);
		event.registerEntityRenderer(CreateCogsInvadersModEntities.NETHER_MINER.get(), NetherMinerRenderer::new);
		event.registerEntityRenderer(CreateCogsInvadersModEntities.SENTRY_PISTOL.get(), SentryPistolRenderer::new);
		event.registerEntityRenderer(CreateCogsInvadersModEntities.BRASS_PELLET.get(), BrassPelletRenderer::new);
		event.registerEntityRenderer(CreateCogsInvadersModEntities.SENTRY_WARRIOR.get(), SentryWarriorRenderer::new);
		event.registerEntityRenderer(CreateCogsInvadersModEntities.ELITE_PISTOL.get(), ElitePistolRenderer::new);
		event.registerEntityRenderer(CreateCogsInvadersModEntities.ELITE_WARRIOR.get(), EliteWarriorRenderer::new);
		event.registerEntityRenderer(CreateCogsInvadersModEntities.FIRE_BALL.get(), FireBallRenderer::new);
		event.registerEntityRenderer(CreateCogsInvadersModEntities.BRASS_PELLET_WITHER.get(), BrassPelletWitherRenderer::new);
		event.registerEntityRenderer(CreateCogsInvadersModEntities.ELECTRIC_CHARGE.get(), ThrownItemRenderer::new);
	}
}
