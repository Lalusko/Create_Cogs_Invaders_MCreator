package net.mcreator.createcogsinvaders.procedures;

import net.minecraftforge.registries.ForgeRegistries;

import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.Entity;
import net.minecraft.sounds.SoundSource;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.BlockPos;

public class ARSRepairProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, BlockState blockstate, Entity entity) {
		if (entity == null)
			return;
		ItemStack sFeet = ItemStack.EMPTY;
		ItemStack sLegs = ItemStack.EMPTY;
		ItemStack sChest = ItemStack.EMPTY;
		ItemStack sHead = ItemStack.EMPTY;
		ItemStack fixFeet = ItemStack.EMPTY;
		ItemStack fixLegs = ItemStack.EMPTY;
		ItemStack fixChest = ItemStack.EMPTY;
		ItemStack fixHead = ItemStack.EMPTY;
		double repaired = 0;
		(entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.FEET) : ItemStack.EMPTY).setDamageValue((int) Double.NEGATIVE_INFINITY);
		(entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.LEGS) : ItemStack.EMPTY).setDamageValue((int) Double.NEGATIVE_INFINITY);
		(entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.CHEST) : ItemStack.EMPTY).setDamageValue((int) Double.NEGATIVE_INFINITY);
		(entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.HEAD) : ItemStack.EMPTY).setDamageValue((int) Double.NEGATIVE_INFINITY);
		ARSParticlesProcedure.execute(world, x, y, z, blockstate);
		if (world.isClientSide()) {
			if (world instanceof Level _level) {
				if (!_level.isClientSide()) {
					_level.playSound(null, BlockPos.containing(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("create_cogs_invaders:station_use")), SoundSource.BLOCKS, 1, 1);
				} else {
					_level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("create_cogs_invaders:station_use")), SoundSource.BLOCKS, 1, 1, false);
				}
			}
		}
	}
}
