package net.mcreator.createcogsinvaders.procedures;

import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.tags.TagKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.entity.projectile.Projectile;
import net.minecraftforge.event.entity.living.LivingAttackEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = "create_cogs_invaders", bus = Mod.EventBusSubscriber.Bus.FORGE)
public class DoNotBetrayProcedure {

	// Tag de facción (entity_types): data/tu_modid/tags/entity_types/faction_allies.json
	private static final TagKey<EntityType<?>> ALLIES =
			TagKey.create(Registries.ENTITY_TYPE, new ResourceLocation("create_cogs_invaders", "cogs"));

	@SubscribeEvent
	public static void onLivingAttack(LivingAttackEvent event) {
		LivingEntity victim = event.getEntity();
		if (victim == null) return;

		// Atacante lógico (jugador/mob que causó el daño)
		Entity attacker = event.getSource().getEntity();

		// Entidad directa del daño (proyectil si lo hay)
		Entity direct = event.getSource().getDirectEntity();

		// A veces attacker puede venir null (según el tipo de daño). Tomamos owner del proyectil como respaldo.
		if (attacker == null && direct instanceof Projectile proj) {
			attacker = proj.getOwner();
		}
		if (attacker == null || attacker == victim) return; // ignora ambiente o auto-daño

		boolean victimAllied  = victim.getType().is(ALLIES);
		boolean attackerAllied = attacker.getType().is(ALLIES);

		if (victimAllied && attackerAllied) {
			// Cancela el daño (antes de aplicarse)
			if (event.isCancelable()) event.setCanceled(true);
			else if (event.hasResult()) event.setResult(Event.Result.DENY);

			// Si fue proyectil, lo removemos para que no rebote ni persista
			if (direct instanceof Projectile) {
				direct.discard();
			}

			// Opcional: limpia objetivos para que no sigan peleando por IA
			if (victim instanceof Mob mv && mv.getTarget() == attacker) mv.setTarget(null);
			if (attacker instanceof Mob ma && ma.getTarget() == victim) ma.setTarget(null);
		}
	}
}
