package net.mcreator.createcogsinvaders.procedures;

import net.minecraft.core.Direction;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LightLayer;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.state.BlockState;

public class MinerSpawnProcedure {
	public static boolean execute(LevelAccessor world, double x, double y, double z) {
		if (!(world instanceof Level level) || level.dimension() != Level.OVERWORLD) return false;
		BlockPos pos = BlockPos.containing(x, y, z);

		if (level.canSeeSkyFromBelowWater(pos.above())) return false;

		if (level.getBrightness(LightLayer.BLOCK, pos) > 0) return false;

		if (pos.getY() > 50) return false;

		BlockPos belowPos = pos.below();
		BlockState below = level.getBlockState(belowPos);
		boolean stoneLike = below.is(BlockTags.STONE_ORE_REPLACEABLES)
				|| below.is(Blocks.STONE) || below.is(Blocks.DEEPSLATE)
				|| below.is(Blocks.TUFF) || below.is(Blocks.DRIPSTONE_BLOCK)
				|| below.is(Blocks.CALCITE);
		if (!stoneLike || !below.isFaceSturdy(level, belowPos, Direction.UP)) return false;

		return true;
	}
}
