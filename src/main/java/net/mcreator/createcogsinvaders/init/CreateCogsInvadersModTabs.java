
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.createcogsinvaders.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.network.chat.Component;
import net.minecraft.core.registries.Registries;

import net.mcreator.createcogsinvaders.CreateCogsInvadersMod;

public class CreateCogsInvadersModTabs {
	public static final DeferredRegister<CreativeModeTab> REGISTRY = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, CreateCogsInvadersMod.MODID);
	public static final RegistryObject<CreativeModeTab> CREATE_COGS_INVADERS = REGISTRY.register("create_cogs_invaders",
			() -> CreativeModeTab.builder().title(Component.translatable("item_group.create_cogs_invaders.create_cogs_invaders")).icon(() -> new ItemStack(CreateCogsInvadersModBlocks.EXPLORER_HEAD.get())).displayItems((parameters, tabData) -> {
				tabData.accept(CreateCogsInvadersModBlocks.SULFUR_ORE.get().asItem());
				tabData.accept(CreateCogsInvadersModBlocks.DEEPSLATE_SULFUR_ORE.get().asItem());
				tabData.accept(CreateCogsInvadersModBlocks.RAW_SULFUR_BLOCK.get().asItem());
				tabData.accept(CreateCogsInvadersModBlocks.HEALING_STATION.get().asItem());
				tabData.accept(CreateCogsInvadersModBlocks.ARMOR_REPAIR_STATION.get().asItem());
				tabData.accept(CreateCogsInvadersModBlocks.EXPLORER_HEAD.get().asItem());
				tabData.accept(CreateCogsInvadersModBlocks.CHEMIST_HEAD.get().asItem());
				tabData.accept(CreateCogsInvadersModBlocks.MINER_HEAD.get().asItem());
				tabData.accept(CreateCogsInvadersModBlocks.NETHER_MINER_HEAD.get().asItem());
				tabData.accept(CreateCogsInvadersModBlocks.MANUFACTURER_HEAD.get().asItem());
				tabData.accept(CreateCogsInvadersModItems.MEDKIT.get());
				tabData.accept(CreateCogsInvadersModItems.REPAIR_KIT.get());
				tabData.accept(CreateCogsInvadersModItems.HAND_DRILL.get());
				tabData.accept(CreateCogsInvadersModItems.NETHERITE_HAND_DRILL.get());
				tabData.accept(CreateCogsInvadersModItems.TESLA_GUN.get());
				tabData.accept(CreateCogsInvadersModItems.TESLA_CANNON.get());
				tabData.accept(CreateCogsInvadersModItems.TESLA_SHIELD.get());
				tabData.accept(CreateCogsInvadersModItems.RAW_SULFUR.get());
				tabData.accept(CreateCogsInvadersModItems.POWDERED_SULFUR.get());
				tabData.accept(CreateCogsInvadersModItems.COPPER_WIRE.get());
				tabData.accept(CreateCogsInvadersModItems.ELECTROCONDUCTIVE_CHIP.get());
				tabData.accept(CreateCogsInvadersModItems.DYNAMIC_CHIP.get());
				tabData.accept(CreateCogsInvadersModItems.ADVANCED_CHIP.get());
				tabData.accept(CreateCogsInvadersModItems.ELECTROCONDUCTIVE_MECHANISM.get());
				tabData.accept(CreateCogsInvadersModItems.DYNAMIC_MECHANISM.get());
				tabData.accept(CreateCogsInvadersModItems.ADVANCED_MECHANISM.get());
				tabData.accept(CreateCogsInvadersModItems.BRASS_GLASS_BOTTLE.get());
				tabData.accept(CreateCogsInvadersModItems.XP_CONTAINER.get());
				tabData.accept(CreateCogsInvadersModItems.TESLA_BATTERY_AMMO.get());
				tabData.accept(CreateCogsInvadersModItems.DIAL.get());
				tabData.accept(CreateCogsInvadersModItems.BRASS_DISC.get());
				tabData.accept(CreateCogsInvadersModItems.EXPLORER_SPAWN_EGG.get());
				tabData.accept(CreateCogsInvadersModItems.DRONE_EXPLORER_SPAWN_EGG.get());
				tabData.accept(CreateCogsInvadersModItems.CHEMIST_SPAWN_EGG.get());
				tabData.accept(CreateCogsInvadersModItems.MINER_SPAWN_EGG.get());
				tabData.accept(CreateCogsInvadersModItems.NETHER_MINER_SPAWN_EGG.get());
				tabData.accept(CreateCogsInvadersModItems.MANUFACTURER_SPAWN_EGG.get());
				tabData.accept(CreateCogsInvadersModItems.SENTRY_PISTOL_SPAWN_EGG.get());
				tabData.accept(CreateCogsInvadersModItems.SENTRY_WARRIOR_SPAWN_EGG.get());
				tabData.accept(CreateCogsInvadersModItems.ELITE_PISTOL_SPAWN_EGG.get());
				tabData.accept(CreateCogsInvadersModItems.ELITE_WARRIOR_SPAWN_EGG.get());
			}).build());
}
