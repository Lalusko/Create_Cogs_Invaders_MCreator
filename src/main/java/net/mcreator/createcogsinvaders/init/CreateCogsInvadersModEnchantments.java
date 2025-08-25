
/*
 *	MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.createcogsinvaders.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;

import net.minecraft.world.item.enchantment.Enchantment;

import net.mcreator.createcogsinvaders.enchantment.RestorationEnchantment;
import net.mcreator.createcogsinvaders.enchantment.LimitBreackEnchantment;
import net.mcreator.createcogsinvaders.enchantment.HealingBoostEnchantment;
import net.mcreator.createcogsinvaders.CreateCogsInvadersMod;

public class CreateCogsInvadersModEnchantments {
	public static final DeferredRegister<Enchantment> REGISTRY = DeferredRegister.create(ForgeRegistries.ENCHANTMENTS, CreateCogsInvadersMod.MODID);
	public static final RegistryObject<Enchantment> HEALING_BOOST = REGISTRY.register("healing_boost", () -> new HealingBoostEnchantment());
	public static final RegistryObject<Enchantment> RESTORATION = REGISTRY.register("restoration", () -> new RestorationEnchantment());
	public static final RegistryObject<Enchantment> LIMIT_BREACK = REGISTRY.register("limit_breack", () -> new LimitBreackEnchantment());
}
