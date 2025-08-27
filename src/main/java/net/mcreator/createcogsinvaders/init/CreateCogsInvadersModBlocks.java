
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.createcogsinvaders.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;

import net.minecraft.world.level.block.Block;

import net.mcreator.createcogsinvaders.block.SulfurOreBlock;
import net.mcreator.createcogsinvaders.block.RawSulfurBlockBlock;
import net.mcreator.createcogsinvaders.block.NetherMinerHeadBlock;
import net.mcreator.createcogsinvaders.block.MinerHeadBlock;
import net.mcreator.createcogsinvaders.block.ManufacturerHeadBlock;
import net.mcreator.createcogsinvaders.block.HealingStationBlock;
import net.mcreator.createcogsinvaders.block.ExplorerHeadBlock;
import net.mcreator.createcogsinvaders.block.DeepslateSulfurOreBlock;
import net.mcreator.createcogsinvaders.block.ChemistHeadBlock;
import net.mcreator.createcogsinvaders.block.ArmorRepairStationBlock;
import net.mcreator.createcogsinvaders.CreateCogsInvadersMod;

public class CreateCogsInvadersModBlocks {
	public static final DeferredRegister<Block> REGISTRY = DeferredRegister.create(ForgeRegistries.BLOCKS, CreateCogsInvadersMod.MODID);
	public static final RegistryObject<Block> EXPLORER_HEAD = REGISTRY.register("explorer_head", () -> new ExplorerHeadBlock());
	public static final RegistryObject<Block> MANUFACTURER_HEAD = REGISTRY.register("manufacturer_head", () -> new ManufacturerHeadBlock());
	public static final RegistryObject<Block> MINER_HEAD = REGISTRY.register("miner_head", () -> new MinerHeadBlock());
	public static final RegistryObject<Block> ARMOR_REPAIR_STATION = REGISTRY.register("armor_repair_station", () -> new ArmorRepairStationBlock());
	public static final RegistryObject<Block> HEALING_STATION = REGISTRY.register("healing_station", () -> new HealingStationBlock());
	public static final RegistryObject<Block> RAW_SULFUR_BLOCK = REGISTRY.register("raw_sulfur_block", () -> new RawSulfurBlockBlock());
	public static final RegistryObject<Block> SULFUR_ORE = REGISTRY.register("sulfur_ore", () -> new SulfurOreBlock());
	public static final RegistryObject<Block> DEEPSLATE_SULFUR_ORE = REGISTRY.register("deepslate_sulfur_ore", () -> new DeepslateSulfurOreBlock());
	public static final RegistryObject<Block> NETHER_MINER_HEAD = REGISTRY.register("nether_miner_head", () -> new NetherMinerHeadBlock());
	public static final RegistryObject<Block> CHEMIST_HEAD = REGISTRY.register("chemist_head", () -> new ChemistHeadBlock());
	// Start of user code block custom blocks
	// End of user code block custom blocks
}
