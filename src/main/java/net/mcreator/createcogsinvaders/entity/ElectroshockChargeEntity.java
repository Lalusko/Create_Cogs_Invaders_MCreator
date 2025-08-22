
package net.mcreator.createcogsinvaders.entity;

import net.minecraft.world.phys.BlockHitResult;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.network.PlayMessages;
import net.minecraftforge.network.NetworkHooks;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.world.phys.EntityHitResult;
import net.minecraft.world.level.Level;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.projectile.ItemSupplier;
import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.util.RandomSource;
import net.minecraft.sounds.SoundSource;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.protocol.game.ClientGamePacketListener;
import net.minecraft.network.protocol.Packet;

import net.mcreator.createcogsinvaders.procedures.ElectroshockChargeEffectApplyProcedure;
import net.mcreator.createcogsinvaders.init.CreateCogsInvadersModItems;
import net.mcreator.createcogsinvaders.init.CreateCogsInvadersModEntities;

@OnlyIn(value = Dist.CLIENT, _interface = ItemSupplier.class)
public class ElectroshockChargeEntity extends AbstractArrow implements ItemSupplier {
	public static final ItemStack PROJECTILE_ITEM = new ItemStack(CreateCogsInvadersModItems.ELECTROSHOCK_CHARGE_ICON.get());
	public static final int MAX_LIFETIME_TICKS = 60;

	public ElectroshockChargeEntity(PlayMessages.SpawnEntity packet, Level world) {
		super(CreateCogsInvadersModEntities.ELECTROSHOCK_CHARGE.get(), world);
		this.setNoGravity(true);
	}

	public ElectroshockChargeEntity(EntityType<? extends ElectroshockChargeEntity> type, Level world) {
		super(type, world);
		this.setNoGravity(true);
	}

	public ElectroshockChargeEntity(EntityType<? extends ElectroshockChargeEntity> type, double x, double y, double z, Level world) {
		super(type, x, y, z, world);
		this.setNoGravity(true);
	}

	public ElectroshockChargeEntity(EntityType<? extends ElectroshockChargeEntity> type, LivingEntity entity, Level world) {
		super(type, entity, world);
		this.setNoGravity(true);
	}

	@Override
	public Packet<ClientGamePacketListener> getAddEntityPacket() {
		return NetworkHooks.getEntitySpawningPacket(this);
	}

	@Override
	@OnlyIn(Dist.CLIENT)
	public ItemStack getItem() {
		return PROJECTILE_ITEM;
	}

	@Override
	protected ItemStack getPickupItem() {
		return PROJECTILE_ITEM;
	}

	@Override
	protected void doPostHurtEffects(LivingEntity entity) {
		super.doPostHurtEffects(entity);
		entity.setArrowCount(entity.getArrowCount() - 1);
	}

	@Override
	public void playerTouch(Player entity) {
		super.playerTouch(entity);
		ElectroshockChargeEffectApplyProcedure.execute(entity);
	}

	@Override
	public void onHitEntity(EntityHitResult entityHitResult) {
		super.onHitEntity(entityHitResult);
		ElectroshockChargeEffectApplyProcedure.execute(entityHitResult.getEntity());
	}

	@Override
	protected void onHitBlock(BlockHitResult hit) {
		super.onHitBlock(hit);
		if (!this.level().isClientSide) {
			this.discard();
		}
	}

	@Override
	public void tick() {
		super.tick();

		if (!this.isNoGravity()) {
			this.setNoGravity(true);
		}

		if (!this.level().isClientSide && this.tickCount >= MAX_LIFETIME_TICKS) {
			this.discard();
		}
	}

	public static ElectroshockChargeEntity shoot(Level world, LivingEntity entity, RandomSource source) {
		return shoot(world, entity, source, 2.5f, 0.1, 0);
	}

	public static ElectroshockChargeEntity shoot(Level world, LivingEntity entity, RandomSource source, float pullingPower) {
		return shoot(world, entity, source, pullingPower * 2.5f, 0.1, 0);
	}

	public static ElectroshockChargeEntity shoot(Level world, LivingEntity entity, RandomSource random, float power, double damage, int knockback) {
		ElectroshockChargeEntity entityarrow = new ElectroshockChargeEntity(CreateCogsInvadersModEntities.ELECTROSHOCK_CHARGE.get(), entity, world);
		entityarrow.shoot(entity.getViewVector(1).x, entity.getViewVector(1).y, entity.getViewVector(1).z, power * 2, 0);
		entityarrow.setSilent(true);
		entityarrow.setCritArrow(false);
		entityarrow.setBaseDamage(damage);
		entityarrow.setKnockback(knockback);
		world.addFreshEntity(entityarrow);
		world.playSound(null, entity.getX(), entity.getY(), entity.getZ(), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("create_cogs_invaders:electroshock_throw")), SoundSource.PLAYERS, 1,
				1f / (random.nextFloat() * 0.5f + 1) + (power / 2));
		return entityarrow;
	}

	public static ElectroshockChargeEntity shoot(LivingEntity entity, LivingEntity target) {
		ElectroshockChargeEntity entityarrow = new ElectroshockChargeEntity(CreateCogsInvadersModEntities.ELECTROSHOCK_CHARGE.get(), entity, entity.level());
		double dx = target.getX() - entity.getX();
		double dy = target.getY() + target.getEyeHeight() - 1.1;
		double dz = target.getZ() - entity.getZ();
		entityarrow.shoot(dx, dy - entityarrow.getY() + Math.hypot(dx, dz) * 0.2F, dz, 2.5f * 2, 12.0F);
		entityarrow.setSilent(true);
		entityarrow.setBaseDamage(0.1);
		entityarrow.setKnockback(0);
		entityarrow.setCritArrow(false);
		entity.level().addFreshEntity(entityarrow);
		entity.level().playSound(null, entity.getX(), entity.getY(), entity.getZ(), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("create_cogs_invaders:electroshock_throw")), SoundSource.PLAYERS, 1,
				1f / (RandomSource.create().nextFloat() * 0.5f + 1));
		return entityarrow;
	}
}
