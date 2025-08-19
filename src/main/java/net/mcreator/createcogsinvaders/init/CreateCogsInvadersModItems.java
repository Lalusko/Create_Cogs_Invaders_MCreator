
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.createcogsinvaders.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;

import net.minecraft.world.item.Item;

import net.mcreator.createcogsinvaders.item.ElectroshockChargeIconItem;
import net.mcreator.createcogsinvaders.CreateCogsInvadersMod;

public class CreateCogsInvadersModItems {
	public static final DeferredRegister<Item> REGISTRY = DeferredRegister.create(ForgeRegistries.ITEMS, CreateCogsInvadersMod.MODID);
	public static final RegistryObject<Item> ELECTROSHOCK_CHARGE_ICON = REGISTRY.register("electroshock_charge_icon", () -> new ElectroshockChargeIconItem());
	// Start of user code block custom items
	// End of user code block custom items
}
