package net.mcreator.createcogsinvaders.procedures;

import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffectInstance;

import net.mcreator.createcogsinvaders.init.CreateCogsInvadersModMobEffects;

public class ElectroshockChargeEffectApplyProcedure {
	public static void execute(Entity entity) {
		if (entity == null) return;

		if (entity.level().isClientSide()) return;

		boolean ignoreLimit = false;
		float targetHP = -1f;
		boolean targetBlocking = false;

		if (entity instanceof LivingEntity target) {
			targetHP = target.getHealth();
			targetBlocking = target.isBlocking();

			DamageSource last = target.getLastDamageSource();
			if (last != null) {
				Entity immediate = last.getDirectEntity();
				if (immediate != null) {
					ignoreLimit = immediate.getPersistentData().getBoolean("LimitBreack");
				}
			}
		}

		if ((ignoreLimit || targetHP < 50.0f) && !targetBlocking) {
			if (entity instanceof LivingEntity liv && !liv.level().isClientSide())
				liv.addEffect(new MobEffectInstance(CreateCogsInvadersModMobEffects.ELECTROSHOCK.get(), 120, 0));
		}
	}
}
