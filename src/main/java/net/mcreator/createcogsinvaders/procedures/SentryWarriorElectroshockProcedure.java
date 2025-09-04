package net.mcreator.createcogsinvaders.procedures;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.event.entity.living.LivingAttackEvent;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffectInstance;

import net.mcreator.createcogsinvaders.init.CreateCogsInvadersModMobEffects;
import net.mcreator.createcogsinvaders.entity.SentryWarriorEntity;

import javax.annotation.Nullable;

@Mod.EventBusSubscriber
public class SentryWarriorElectroshockProcedure {
	@SubscribeEvent
	public static void onEntityAttacked(LivingAttackEvent event) {
		if (event != null && event.getEntity() != null) {
			execute(event, event.getEntity(), event.getSource().getEntity());
		}
	}

	public static void execute(Entity entity, Entity sourceentity) {
		execute(null, entity, sourceentity);
	}

	private static void execute(@Nullable Event event, Entity entity, Entity sourceentity) {
		if (entity == null || sourceentity == null)
			return;
		if (sourceentity instanceof SentryWarriorEntity) {
			if (!(entity instanceof LivingEntity _livEnt1 && _livEnt1.isBlocking())) {
				if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
					_entity.addEffect(new MobEffectInstance(CreateCogsInvadersModMobEffects.ELECTROSHOCK.get(), 120, 0));
			}
		}
	}
}
