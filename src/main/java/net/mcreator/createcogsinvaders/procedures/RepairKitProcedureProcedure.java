package net.mcreator.createcogsinvaders.procedures;

import net.minecraftforge.registries.ForgeRegistries;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.util.RandomSource;
import net.minecraft.sounds.SoundSource;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.BlockPos;

import net.mcreator.createcogsinvaders.init.CreateCogsInvadersModItems;
import net.mcreator.createcogsinvaders.init.CreateCogsInvadersModEnchantments;

public class RepairKitProcedureProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		boolean useMain = false;
		boolean useOff = false;
		double repairAmt = 0;
		double curDmg = 0;
		double newDmg = 0;
		double restoLv1 = 0;
		if (!world.isClientSide()) {
			useMain = (entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == CreateCogsInvadersModItems.REPAIR_KIT.get();
			useOff = (entity instanceof LivingEntity _livEnt ? _livEnt.getOffhandItem() : ItemStack.EMPTY).getItem() == CreateCogsInvadersModItems.REPAIR_KIT.get();
			if (useMain) {
				if ((entity instanceof LivingEntity _livEnt ? _livEnt.getOffhandItem() : ItemStack.EMPTY).isDamaged()
						&& !((entity instanceof LivingEntity _livEnt ? _livEnt.getOffhandItem() : ItemStack.EMPTY).getItem() == CreateCogsInvadersModItems.REPAIR_KIT.get())) {
					restoLv1 = (entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getEnchantmentLevel(CreateCogsInvadersModEnchantments.RESTORATION.get());
					repairAmt = 50 + 15 * restoLv1;
					curDmg = (entity instanceof LivingEntity _livEnt ? _livEnt.getOffhandItem() : ItemStack.EMPTY).getDamageValue();
					newDmg = Math.max(0, curDmg - repairAmt);
					(entity instanceof LivingEntity _livEnt ? _livEnt.getOffhandItem() : ItemStack.EMPTY).setDamageValue((int) newDmg);
					if (world instanceof Level _level) {
						if (!_level.isClientSide()) {
							_level.playSound(null, BlockPos.containing(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.grindstone.use")), SoundSource.PLAYERS, 1, 1);
						} else {
							_level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.grindstone.use")), SoundSource.PLAYERS, 1, 1, false);
						}
					}
					if (entity instanceof Player _player)
						_player.getCooldowns().addCooldown((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem(), 100);
					if (!(entity instanceof Player _plr ? _plr.getAbilities().instabuild : false)) {
						{
							ItemStack _ist = (entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY);
							if (_ist.hurt(1, RandomSource.create(), null)) {
								_ist.shrink(1);
								_ist.setDamageValue(0);
							}
						}
					}
				}
			} else if (useOff) {
				if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).isDamaged()
						&& !((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == CreateCogsInvadersModItems.REPAIR_KIT.get())) {
					restoLv1 = (entity instanceof LivingEntity _livEnt ? _livEnt.getOffhandItem() : ItemStack.EMPTY).getEnchantmentLevel(CreateCogsInvadersModEnchantments.RESTORATION.get());
					repairAmt = 50 + 15 * restoLv1;
					curDmg = (entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getDamageValue();
					newDmg = Math.max(0, curDmg - repairAmt);
					(entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).setDamageValue((int) newDmg);
					if (world instanceof Level _level) {
						if (!_level.isClientSide()) {
							_level.playSound(null, BlockPos.containing(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.grindstone.use")), SoundSource.PLAYERS, 1, 1);
						} else {
							_level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.grindstone.use")), SoundSource.PLAYERS, 1, 1, false);
						}
					}
					if (entity instanceof Player _player)
						_player.getCooldowns().addCooldown((entity instanceof LivingEntity _livEnt ? _livEnt.getOffhandItem() : ItemStack.EMPTY).getItem(), 100);
					if (!(entity instanceof Player _plr ? _plr.getAbilities().instabuild : false)) {
						{
							ItemStack _ist = (entity instanceof LivingEntity _livEnt ? _livEnt.getOffhandItem() : ItemStack.EMPTY);
							if (_ist.hurt(1, RandomSource.create(), null)) {
								_ist.shrink(1);
								_ist.setDamageValue(0);
							}
						}
					}
				}
			}
		}
	}
}
