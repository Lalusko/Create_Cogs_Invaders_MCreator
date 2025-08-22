package net.mcreator.createcogsinvaders.procedures;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;

import net.mcreator.createcogsinvaders.init.CreateCogsInvadersModMobEffects;

public class ElectroshockScreenProcedureProcedure {
	public static boolean execute(Entity entity) {
		if (entity == null)
			return false;
		return entity instanceof LivingEntity _livEnt0 && _livEnt0.hasEffect(CreateCogsInvadersModMobEffects.ELECTROSHOCK.get());
	}
}
