
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.createcogsinvaders.init;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.client.event.RegisterParticleProvidersEvent;
import net.minecraftforge.api.distmarker.Dist;

import net.mcreator.createcogsinvaders.client.particle.RepairParticle;
import net.mcreator.createcogsinvaders.client.particle.Healing7Particle;
import net.mcreator.createcogsinvaders.client.particle.Healing6Particle;
import net.mcreator.createcogsinvaders.client.particle.Healing5Particle;
import net.mcreator.createcogsinvaders.client.particle.Healing4Particle;
import net.mcreator.createcogsinvaders.client.particle.Healing3Particle;
import net.mcreator.createcogsinvaders.client.particle.Healing2Particle;
import net.mcreator.createcogsinvaders.client.particle.Healing1Particle;
import net.mcreator.createcogsinvaders.client.particle.Healing0Particle;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class CreateCogsInvadersModParticles {
	@SubscribeEvent
	public static void registerParticles(RegisterParticleProvidersEvent event) {
		event.registerSpriteSet(CreateCogsInvadersModParticleTypes.REPAIR.get(), RepairParticle::provider);
		event.registerSpriteSet(CreateCogsInvadersModParticleTypes.HEALING_0.get(), Healing0Particle::provider);
		event.registerSpriteSet(CreateCogsInvadersModParticleTypes.HEALING_1.get(), Healing1Particle::provider);
		event.registerSpriteSet(CreateCogsInvadersModParticleTypes.HEALING_2.get(), Healing2Particle::provider);
		event.registerSpriteSet(CreateCogsInvadersModParticleTypes.HEALING_3.get(), Healing3Particle::provider);
		event.registerSpriteSet(CreateCogsInvadersModParticleTypes.HEALING_4.get(), Healing4Particle::provider);
		event.registerSpriteSet(CreateCogsInvadersModParticleTypes.HEALING_5.get(), Healing5Particle::provider);
		event.registerSpriteSet(CreateCogsInvadersModParticleTypes.HEALING_6.get(), Healing6Particle::provider);
		event.registerSpriteSet(CreateCogsInvadersModParticleTypes.HEALING_7.get(), Healing7Particle::provider);
	}
}
