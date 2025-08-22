
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.createcogsinvaders.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;

import net.minecraft.world.level.block.Block;

import net.mcreator.createcogsinvaders.block.ExplorerHeadBlock;
import net.mcreator.createcogsinvaders.CreateCogsInvadersMod;

public class CreateCogsInvadersModBlocks {
	public static final DeferredRegister<Block> REGISTRY = DeferredRegister.create(ForgeRegistries.BLOCKS, CreateCogsInvadersMod.MODID);
	public static final RegistryObject<Block> EXPLORER_HEAD = REGISTRY.register("explorer_head", () -> new ExplorerHeadBlock());
	// Start of user code block custom blocks
	// End of user code block custom blocks
}
