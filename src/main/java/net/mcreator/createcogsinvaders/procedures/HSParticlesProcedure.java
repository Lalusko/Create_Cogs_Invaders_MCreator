package net.mcreator.createcogsinvaders.procedures;

import net.minecraft.world.level.block.state.properties.Property;
import net.minecraft.world.level.block.state.properties.EnumProperty;
import net.minecraft.world.level.block.state.properties.DirectionProperty;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.core.Direction;

import net.mcreator.createcogsinvaders.init.CreateCogsInvadersModParticleTypes;

public class HSParticlesProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, BlockState blockstate) {
		if ((new Object() {
			public Direction getDirection(BlockState _bs) {
				Property<?> _prop = _bs.getBlock().getStateDefinition().getProperty("facing");
				if (_prop instanceof DirectionProperty _dp)
					return _bs.getValue(_dp);
				_prop = _bs.getBlock().getStateDefinition().getProperty("axis");
				return _prop instanceof EnumProperty _ep && _ep.getPossibleValues().toArray()[0] instanceof Direction.Axis ? Direction.fromAxisAndDirection((Direction.Axis) _bs.getValue(_ep), Direction.AxisDirection.POSITIVE) : Direction.NORTH;
			}
		}.getDirection(blockstate)) == Direction.NORTH) {
			world.addParticle((SimpleParticleType) (CreateCogsInvadersModParticleTypes.HEALING_7.get()), (Math.floor(x) + 0.5), (Math.floor(y) + 0.1), (Math.floor(z) + 0.5), 0, 0.04, (-0.4));
			world.addParticle((SimpleParticleType) (CreateCogsInvadersModParticleTypes.HEALING_6.get()), (Math.floor(x) + 0.5), (Math.floor(y) + 0.1), (Math.floor(z) + 0.5), 0, 0.06, (-0.7));
			world.addParticle((SimpleParticleType) (CreateCogsInvadersModParticleTypes.HEALING_5.get()), (Math.floor(x) + 0.5), (Math.floor(y) + 0.1), (Math.floor(z) + 0.5), 0, 0.08, (-0.6));
			world.addParticle((SimpleParticleType) (CreateCogsInvadersModParticleTypes.HEALING_4.get()), (Math.floor(x) + 0.5), (Math.floor(y) + 0.1), (Math.floor(z) + 0.5), 0, 0.1, (-0.5));
			world.addParticle((SimpleParticleType) (CreateCogsInvadersModParticleTypes.HEALING_3.get()), (Math.floor(x) + 0.5), (Math.floor(y) + 0.1), (Math.floor(z) + 0.5), 0, 0.12, (-0.3));
			world.addParticle((SimpleParticleType) (CreateCogsInvadersModParticleTypes.HEALING_2.get()), (Math.floor(x) + 0.5), (Math.floor(y) + 0.1), (Math.floor(z) + 0.5), 0, 0.14, (-0.6));
			world.addParticle((SimpleParticleType) (CreateCogsInvadersModParticleTypes.HEALING_1.get()), (Math.floor(x) + 0.5), (Math.floor(y) + 0.1), (Math.floor(z) + 0.5), 0, 0.16, (-0.4));
			world.addParticle((SimpleParticleType) (CreateCogsInvadersModParticleTypes.HEALING_0.get()), (Math.floor(x) + 0.5), (Math.floor(y) + 0.1), (Math.floor(z) + 0.5), 0, 0.2, (-0.6));
		} else if ((new Object() {
			public Direction getDirection(BlockState _bs) {
				Property<?> _prop = _bs.getBlock().getStateDefinition().getProperty("facing");
				if (_prop instanceof DirectionProperty _dp)
					return _bs.getValue(_dp);
				_prop = _bs.getBlock().getStateDefinition().getProperty("axis");
				return _prop instanceof EnumProperty _ep && _ep.getPossibleValues().toArray()[0] instanceof Direction.Axis ? Direction.fromAxisAndDirection((Direction.Axis) _bs.getValue(_ep), Direction.AxisDirection.POSITIVE) : Direction.NORTH;
			}
		}.getDirection(blockstate)) == Direction.SOUTH) {
			world.addParticle((SimpleParticleType) (CreateCogsInvadersModParticleTypes.HEALING_7.get()), (Math.floor(x) + 0.5), (Math.floor(y) + 0.1), (Math.floor(z) + 0.5), 0, 0.04, 0.4);
			world.addParticle((SimpleParticleType) (CreateCogsInvadersModParticleTypes.HEALING_6.get()), (Math.floor(x) + 0.5), (Math.floor(y) + 0.1), (Math.floor(z) + 0.5), 0, 0.06, 0.7);
			world.addParticle((SimpleParticleType) (CreateCogsInvadersModParticleTypes.HEALING_5.get()), (Math.floor(x) + 0.5), (Math.floor(y) + 0.1), (Math.floor(z) + 0.5), 0, 0.08, 0.6);
			world.addParticle((SimpleParticleType) (CreateCogsInvadersModParticleTypes.HEALING_4.get()), (Math.floor(x) + 0.5), (Math.floor(y) + 0.1), (Math.floor(z) + 0.5), 0, 0.1, 0.5);
			world.addParticle((SimpleParticleType) (CreateCogsInvadersModParticleTypes.HEALING_3.get()), (Math.floor(x) + 0.5), (Math.floor(y) + 0.1), (Math.floor(z) + 0.5), 0, 0.12, 0.3);
			world.addParticle((SimpleParticleType) (CreateCogsInvadersModParticleTypes.HEALING_2.get()), (Math.floor(x) + 0.5), (Math.floor(y) + 0.1), (Math.floor(z) + 0.5), 0, 0.14, 0.6);
			world.addParticle((SimpleParticleType) (CreateCogsInvadersModParticleTypes.HEALING_1.get()), (Math.floor(x) + 0.5), (Math.floor(y) + 0.1), (Math.floor(z) + 0.5), 0, 0.16, 0.4);
			world.addParticle((SimpleParticleType) (CreateCogsInvadersModParticleTypes.HEALING_0.get()), (Math.floor(x) + 0.5), (Math.floor(y) + 0.1), (Math.floor(z) + 0.5), 0, 0.2, 0.6);
		} else if ((new Object() {
			public Direction getDirection(BlockState _bs) {
				Property<?> _prop = _bs.getBlock().getStateDefinition().getProperty("facing");
				if (_prop instanceof DirectionProperty _dp)
					return _bs.getValue(_dp);
				_prop = _bs.getBlock().getStateDefinition().getProperty("axis");
				return _prop instanceof EnumProperty _ep && _ep.getPossibleValues().toArray()[0] instanceof Direction.Axis ? Direction.fromAxisAndDirection((Direction.Axis) _bs.getValue(_ep), Direction.AxisDirection.POSITIVE) : Direction.NORTH;
			}
		}.getDirection(blockstate)) == Direction.WEST) {
			world.addParticle((SimpleParticleType) (CreateCogsInvadersModParticleTypes.HEALING_7.get()), (Math.floor(x) + 0.5), (Math.floor(y) + 0.1), (Math.floor(z) + 0.5), (-0.4), 0.04, 0);
			world.addParticle((SimpleParticleType) (CreateCogsInvadersModParticleTypes.HEALING_6.get()), (Math.floor(x) + 0.5), (Math.floor(y) + 0.1), (Math.floor(z) + 0.5), (-0.7), 0.06, 0);
			world.addParticle((SimpleParticleType) (CreateCogsInvadersModParticleTypes.HEALING_5.get()), (Math.floor(x) + 0.5), (Math.floor(y) + 0.1), (Math.floor(z) + 0.5), (-0.6), 0.08, 0);
			world.addParticle((SimpleParticleType) (CreateCogsInvadersModParticleTypes.HEALING_4.get()), (Math.floor(x) + 0.5), (Math.floor(y) + 0.1), (Math.floor(z) + 0.5), (-0.5), 0.1, 0);
			world.addParticle((SimpleParticleType) (CreateCogsInvadersModParticleTypes.HEALING_3.get()), (Math.floor(x) + 0.5), (Math.floor(y) + 0.1), (Math.floor(z) + 0.5), (-0.3), 0.12, 0);
			world.addParticle((SimpleParticleType) (CreateCogsInvadersModParticleTypes.HEALING_2.get()), (Math.floor(x) + 0.5), (Math.floor(y) + 0.1), (Math.floor(z) + 0.5), (-0.6), 0.14, 0);
			world.addParticle((SimpleParticleType) (CreateCogsInvadersModParticleTypes.HEALING_1.get()), (Math.floor(x) + 0.5), (Math.floor(y) + 0.1), (Math.floor(z) + 0.5), (-0.4), 0.16, 0);
			world.addParticle((SimpleParticleType) (CreateCogsInvadersModParticleTypes.HEALING_0.get()), (Math.floor(x) + 0.5), (Math.floor(y) + 0.1), (Math.floor(z) + 0.5), (-0.6), 0.2, 0);
		} else if ((new Object() {
			public Direction getDirection(BlockState _bs) {
				Property<?> _prop = _bs.getBlock().getStateDefinition().getProperty("facing");
				if (_prop instanceof DirectionProperty _dp)
					return _bs.getValue(_dp);
				_prop = _bs.getBlock().getStateDefinition().getProperty("axis");
				return _prop instanceof EnumProperty _ep && _ep.getPossibleValues().toArray()[0] instanceof Direction.Axis ? Direction.fromAxisAndDirection((Direction.Axis) _bs.getValue(_ep), Direction.AxisDirection.POSITIVE) : Direction.NORTH;
			}
		}.getDirection(blockstate)) == Direction.EAST) {
			world.addParticle((SimpleParticleType) (CreateCogsInvadersModParticleTypes.HEALING_7.get()), (Math.floor(x) + 0.5), (Math.floor(y) + 0.1), (Math.floor(z) + 0.5), 0.4, 0.04, 0);
			world.addParticle((SimpleParticleType) (CreateCogsInvadersModParticleTypes.HEALING_6.get()), (Math.floor(x) + 0.5), (Math.floor(y) + 0.1), (Math.floor(z) + 0.5), 0.7, 0.06, 0);
			world.addParticle((SimpleParticleType) (CreateCogsInvadersModParticleTypes.HEALING_5.get()), (Math.floor(x) + 0.5), (Math.floor(y) + 0.1), (Math.floor(z) + 0.5), 0.6, 0.08, 0);
			world.addParticle((SimpleParticleType) (CreateCogsInvadersModParticleTypes.HEALING_4.get()), (Math.floor(x) + 0.5), (Math.floor(y) + 0.1), (Math.floor(z) + 0.5), 0.5, 0.1, 0);
			world.addParticle((SimpleParticleType) (CreateCogsInvadersModParticleTypes.HEALING_3.get()), (Math.floor(x) + 0.5), (Math.floor(y) + 0.1), (Math.floor(z) + 0.5), 0.3, 0.12, 0);
			world.addParticle((SimpleParticleType) (CreateCogsInvadersModParticleTypes.HEALING_2.get()), (Math.floor(x) + 0.5), (Math.floor(y) + 0.1), (Math.floor(z) + 0.5), 0.6, 0.14, 0);
			world.addParticle((SimpleParticleType) (CreateCogsInvadersModParticleTypes.HEALING_1.get()), (Math.floor(x) + 0.5), (Math.floor(y) + 0.1), (Math.floor(z) + 0.5), 0.4, 0.16, 0);
			world.addParticle((SimpleParticleType) (CreateCogsInvadersModParticleTypes.HEALING_0.get()), (Math.floor(x) + 0.5), (Math.floor(y) + 0.1), (Math.floor(z) + 0.5), 0.6, 0.2, 0);
		}
	}
}
