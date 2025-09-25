package net.mcreator.createcogsinvaders.procedures;

import net.mcreator.createcogsinvaders.init.CreateCogsInvadersModEnchantments;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraftforge.registries.ForgeRegistries;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.projectile.Projectile;
import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.util.RandomSource;
import net.minecraft.sounds.SoundSource;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.BlockPos;

import net.mcreator.createcogsinvaders.item.TeslaCannonItem;
import net.mcreator.createcogsinvaders.init.CreateCogsInvadersModItems;
import net.mcreator.createcogsinvaders.init.CreateCogsInvadersModEntities;
import net.mcreator.createcogsinvaders.entity.ElectroshockChargeEntity;
import net.mcreator.createcogsinvaders.CreateCogsInvadersMod;

public class TeslaCannonShootProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (world instanceof Level lvl && lvl.isClientSide){
			return;
		}
		if (entity == null) return;
		if (!(entity instanceof LivingEntity liv)) return;

		ItemStack main = liv.getMainHandItem();
		if (main.getItem() != CreateCogsInvadersModItems.TESLA_CANNON.get()) return;

		int energy = TeslaCannonItem.getEnergy(main);

		if (energy > 0) {
			{
				Entity _shootFrom = entity;
				Level projectileLevel = _shootFrom.level();
				if (!projectileLevel.isClientSide()) {
					Projectile _entityToSpawn = new Object() {
						public Projectile getArrow(Level level, float damage, int knockback) {
							AbstractArrow entityToSpawn = new ElectroshockChargeEntity(
									CreateCogsInvadersModEntities.ELECTROSHOCK_CHARGE.get(), level);
							entityToSpawn.setOwner(_shootFrom);

							boolean hasLimitBreack = false;
							if (_shootFrom instanceof LivingEntity shooter) {
								ItemStack heldStack = shooter.getMainHandItem();
								if (heldStack.is(CreateCogsInvadersModItems.TESLA_CANNON.get())) {
									hasLimitBreack = EnchantmentHelper.getItemEnchantmentLevel(
											CreateCogsInvadersModEnchantments.LIMIT_BREACK.get(), heldStack) > 0;
								}
							}
							entityToSpawn.getPersistentData().putBoolean("LimitBreack", hasLimitBreack);
							entityToSpawn.setOwner(_shootFrom);
							entityToSpawn.setBaseDamage(0.1D);
							entityToSpawn.setKnockback(0);
							entityToSpawn.setSilent(true);
							return entityToSpawn;
						}
					}.getArrow(projectileLevel, 0.1f, 0);
					_entityToSpawn.setPos(_shootFrom.getX(), _shootFrom.getEyeY() - 0.1, _shootFrom.getZ());
					_entityToSpawn.shoot(_shootFrom.getLookAngle().x, _shootFrom.getLookAngle().y, _shootFrom.getLookAngle().z, 2.5f, 0.0f);
					projectileLevel.addFreshEntity(_entityToSpawn);
				}
			}

			if (world instanceof Level _level && !_level.isClientSide()) {
				_level.playSound(null, BlockPos.containing(x,y,z),
						ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("create_cogs_invaders:electroshock_throw")),
						SoundSource.PLAYERS, 0.7f, 1.0f);
			}

			if (main.getItem() instanceof TeslaCannonItem)
				main.getOrCreateTag().putString("geckoAnim", "On");
			CreateCogsInvadersMod.queueServerWork(5, () -> {
				if (main.getItem() instanceof TeslaCannonItem)
					main.getOrCreateTag().putString("geckoAnim", "empty");
			});

			TeslaCannonItem.setEnergy(main, energy - 1);
			if (entity instanceof Player _player)
				_player.getCooldowns().addCooldown(main.getItem(), 60);

			if (main.hurt(1, RandomSource.create(), null)) {
				main.shrink(1);
				main.setDamageValue(0);
			}
			return;
		}

		ItemStack off = liv.getOffhandItem();
		boolean tieneBateria = off.is(CreateCogsInvadersModItems.TESLA_BATTERY_AMMO.get());
		if (tieneBateria) {
			TeslaCannonItem.setEnergy(main, TeslaCannonItem.MAX_ENERGY);

			if (entity instanceof Player _plr && !_plr.getAbilities().instabuild) {
				off.shrink(1);
				_plr.getCooldowns().addCooldown(main.getItem(), 20);
			}

			if (world instanceof Level _level && !_level.isClientSide()) {
				_level.playSound(null, BlockPos.containing(x,y,z),
						ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("create_cogs_invaders:bolt_release")),
						SoundSource.PLAYERS, 1.5f, 1.0f);
			}
		}
	}
}
