package net.mcreator.createcogsinvaders.procedures;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffectInstance;

import net.mcreator.createcogsinvaders.init.CreateCogsInvadersModMobEffects;

public class ElectroshockChargeEffectApplyProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		if ((entity instanceof LivingEntity _livEnt ? _livEnt.getHealth() : -1) < 50 && !(entity instanceof LivingEntity _livEnt1 && _livEnt1.isBlocking())) {
			if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
				_entity.addEffect(new MobEffectInstance(CreateCogsInvadersModMobEffects.ELECTROSHOCK.get(), 120, 0));
		}
	}
}
