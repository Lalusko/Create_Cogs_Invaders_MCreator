package net.mcreator.createcogsinvaders.procedures;

import net.mcreator.createcogsinvaders.init.CreateCogsInvadersModEnchantments;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.event.entity.living.ShieldBlockEvent;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.damagesource.DamageSource;

import net.mcreator.createcogsinvaders.init.CreateCogsInvadersModMobEffects;
import net.mcreator.createcogsinvaders.init.CreateCogsInvadersModItems;

import javax.annotation.Nullable;

@Mod.EventBusSubscriber
public class TeslaShieldProcedureProcedure {
	@SubscribeEvent
	public static void whenEntityBlocksWithShield(ShieldBlockEvent event) {
		if (event != null && event.getEntity() != null) {
			execute(event, event.getDamageSource(), event.getEntity(), event.getDamageSource().getEntity());
		}
	}

	private static void execute(@Nullable Event event, DamageSource damagesource, Entity entity, Entity sourceentity) {
		if (damagesource == null || entity == null || sourceentity == null) return;

		if (!damagesource.isIndirect() && entity instanceof LivingEntity blocker) {
			ItemStack used = blocker.getUseItem();

			boolean isTeslaShield = used.is(CreateCogsInvadersModItems.TESLA_SHIELD.get());
			boolean hasLimitBreack = EnchantmentHelper.getItemEnchantmentLevel(
					CreateCogsInvadersModEnchantments.LIMIT_BREACK.get(), used) > 0;

			float attackerHP = (sourceentity instanceof LivingEntity liv) ? liv.getHealth() : -1f;

			if (isTeslaShield && (hasLimitBreack || attackerHP < 50.0f)) {
				if (sourceentity instanceof LivingEntity liv && !liv.level().isClientSide())
					liv.addEffect(new MobEffectInstance(CreateCogsInvadersModMobEffects.ELECTROSHOCK.get(), 120, 0));
			}
		}
	}
}
