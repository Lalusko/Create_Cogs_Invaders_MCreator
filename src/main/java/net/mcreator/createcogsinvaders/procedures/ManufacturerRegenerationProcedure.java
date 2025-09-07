package net.mcreator.createcogsinvaders.procedures;

import net.mcreator.createcogsinvaders.entity.ManufacturerEntity;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = "create_cogs_invaders", bus = Mod.EventBusSubscriber.Bus.FORGE)
public class ManufacturerRegenerationProcedure {
	private static final String NBT_NEXT = "regen_next_tick";
	private static final String NBT_UNTIL = "regen_active_until";

	@SubscribeEvent
	public static void onHurt(net.minecraftforge.event.entity.living.LivingHurtEvent e) {
		if (!(e.getEntity() instanceof ManufacturerEntity)) return;
		var mob = (ManufacturerEntity) e.getEntity();
		long t = mob.level().getGameTime();
		mob.getPersistentData().putLong(NBT_NEXT, t + 200);  // 10s
		mob.getPersistentData().putLong(NBT_UNTIL, 0);
		mob.removeEffect(MobEffects.REGENERATION);
	}

	@SubscribeEvent
	public static void onTick(net.minecraftforge.event.entity.living.LivingEvent.LivingTickEvent e) {
		if (!(e.getEntity() instanceof ManufacturerEntity mob)) return;
		if (mob.level().isClientSide) return;

		long t = mob.level().getGameTime();
		var nbt = mob.getPersistentData();

		float hp = mob.getHealth();
		float max = mob.getMaxHealth();

		if (hp >= max) {
			mob.removeEffect(MobEffects.REGENERATION);
			nbt.putLong(NBT_NEXT, 0);
			nbt.putLong(NBT_UNTIL, 0);
			return;
		}

		long next = nbt.getLong(NBT_NEXT);
		long until = nbt.getLong(NBT_UNTIL);

		if (mob.hasEffect(MobEffects.REGENERATION) && t >= until) {
			mob.removeEffect(MobEffects.REGENERATION);
		}

		if (!mob.hasEffect(MobEffects.REGENERATION)) {
			if (t >= next && hp < max) {
				mob.addEffect(new MobEffectInstance(MobEffects.REGENERATION, 200, 0, false, true));
				nbt.putLong(NBT_UNTIL, t + 200);
			} else if (until > 0 && t >= until && hp < max) {
				nbt.putLong(NBT_NEXT, t + 200);
			}
		}
	}
}
