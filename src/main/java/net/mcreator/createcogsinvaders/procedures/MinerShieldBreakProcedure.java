package net.mcreator.createcogsinvaders.procedures;

import net.mcreator.createcogsinvaders.entity.NetherMinerEntity;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.util.Mth;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.event.entity.living.LivingAttackEvent;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.item.ShieldItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.sounds.SoundSource;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.BlockPos;

import net.mcreator.createcogsinvaders.entity.MinerEntity;

import javax.annotation.Nullable;

@Mod.EventBusSubscriber(modid = "create_cogs_invaders", bus = Mod.EventBusSubscriber.Bus.FORGE)
public class MinerShieldBreakProcedure {

	@SubscribeEvent
	public static void onAttack(LivingAttackEvent e) {
		if (!(e.getEntity() instanceof Player p)) return;

		Entity src = e.getSource().getEntity();
		if (!(src instanceof LivingEntity attacker)) return;

		if (!(attacker instanceof MinerEntity || attacker instanceof NetherMinerEntity)) return;

		if (!p.isBlocking()) return;
		ItemStack using = p.getUseItem();
		if (!(using.getItem() instanceof net.minecraft.world.item.ShieldItem)) return;

		try { p.disableShield(true); } catch (Throwable ignored) {} // si existe en tu mapeo
		p.stopUsingItem();

		int cooldownTicks = 100; // 5 s
		p.getCooldowns().addCooldown(using.getItem(), cooldownTicks);

		double atk = (attacker.getAttribute(Attributes.ATTACK_DAMAGE) != null)
				? attacker.getAttributeValue(Attributes.ATTACK_DAMAGE)
				: 5.0;
		int shieldWear = Mth.clamp((int)Math.ceil(atk / 2.0), 1, 6);

		using.hurtAndBreak(shieldWear, p, pl -> {
			final InteractionHand used = p.getUsedItemHand() != null ? p.getUsedItemHand() :
					(p.getOffhandItem() == using ? InteractionHand.OFF_HAND : InteractionHand.MAIN_HAND);
			pl.broadcastBreakEvent(used);
		});

		if (!p.level().isClientSide) {
			p.level().playSound(null, p.blockPosition(),
					SoundEvents.SHIELD_BREAK, SoundSource.PLAYERS, 1.0f, 1.0f);
		}

		if (e.isCancelable()) e.setCanceled(true);
		else if (e.hasResult()) e.setResult(Event.Result.DENY);
	}
}
