package net.mcreator.createcogsinvaders.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;

public class FireBallExplodeProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		if (world instanceof Level _level && !_level.isClientSide())
			_level.explode(null, x, y, z, 1, Level.ExplosionInteraction.MOB);
		if (!(entity instanceof LivingEntity _livEnt1 && _livEnt1.isBlocking())) {
			entity.setSecondsOnFire(5);
		}
	}
}
