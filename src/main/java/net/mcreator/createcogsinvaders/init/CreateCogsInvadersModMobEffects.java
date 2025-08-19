
/*
 *	MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.createcogsinvaders.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;

import net.minecraft.world.effect.MobEffect;

import net.mcreator.createcogsinvaders.potion.ElectroshockMobEffect;
import net.mcreator.createcogsinvaders.CreateCogsInvadersMod;

public class CreateCogsInvadersModMobEffects {
	public static final DeferredRegister<MobEffect> REGISTRY = DeferredRegister.create(ForgeRegistries.MOB_EFFECTS, CreateCogsInvadersMod.MODID);
	public static final RegistryObject<MobEffect> ELECTROSHOCK = REGISTRY.register("electroshock", () -> new ElectroshockMobEffect());
}
