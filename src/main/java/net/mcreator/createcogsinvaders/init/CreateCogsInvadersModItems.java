
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.createcogsinvaders.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.common.ForgeSpawnEggItem;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.BlockItem;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.item.ItemProperties;

import net.mcreator.createcogsinvaders.item.XpContainerItem;
import net.mcreator.createcogsinvaders.item.TeslaShieldItem;
import net.mcreator.createcogsinvaders.item.TeslaCannonItem;
import net.mcreator.createcogsinvaders.item.TeslaBatteryAmmoItem;
import net.mcreator.createcogsinvaders.item.RepairKitItem;
import net.mcreator.createcogsinvaders.item.RawSulfurItem;
import net.mcreator.createcogsinvaders.item.PowderedSulfurItem;
import net.mcreator.createcogsinvaders.item.NetheriteHandDrillItem;
import net.mcreator.createcogsinvaders.item.MedkitItem;
import net.mcreator.createcogsinvaders.item.IncompleteElectroconductiveMechanismItem;
import net.mcreator.createcogsinvaders.item.IncompleteDynamicMechanismItem;
import net.mcreator.createcogsinvaders.item.IncompleteAdvancedMechanismItem;
import net.mcreator.createcogsinvaders.item.HandDrillItem;
import net.mcreator.createcogsinvaders.item.ElectroshockChargeIconItem;
import net.mcreator.createcogsinvaders.item.ElectroconductiveMechanismItem;
import net.mcreator.createcogsinvaders.item.ElectroconductiveChipItem;
import net.mcreator.createcogsinvaders.item.DynamicMechanismItem;
import net.mcreator.createcogsinvaders.item.DynamicChipItem;
import net.mcreator.createcogsinvaders.item.DialRepairItem;
import net.mcreator.createcogsinvaders.item.DialItem;
import net.mcreator.createcogsinvaders.item.DialHealingItem;
import net.mcreator.createcogsinvaders.item.CopperWireItem;
import net.mcreator.createcogsinvaders.item.BrassGlassBottleItem;
import net.mcreator.createcogsinvaders.item.BrassDiscItem;
import net.mcreator.createcogsinvaders.item.AdvancedMechanismItem;
import net.mcreator.createcogsinvaders.item.AdvancedChipItem;
import net.mcreator.createcogsinvaders.CreateCogsInvadersMod;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class CreateCogsInvadersModItems {
	public static final DeferredRegister<Item> REGISTRY = DeferredRegister.create(ForgeRegistries.ITEMS, CreateCogsInvadersMod.MODID);
	public static final RegistryObject<Item> ELECTROSHOCK_CHARGE_ICON = REGISTRY.register("electroshock_charge_icon", () -> new ElectroshockChargeIconItem());
	public static final RegistryObject<Item> TESLA_CANNON = REGISTRY.register("tesla_cannon", () -> new TeslaCannonItem());
	public static final RegistryObject<Item> EXPLORER_HEAD = block(CreateCogsInvadersModBlocks.EXPLORER_HEAD);
	public static final RegistryObject<Item> ADVANCED_CHIP = REGISTRY.register("advanced_chip", () -> new AdvancedChipItem());
	public static final RegistryObject<Item> ADVANCED_MECHANISM = REGISTRY.register("advanced_mechanism", () -> new AdvancedMechanismItem());
	public static final RegistryObject<Item> TESLA_BATTERY_AMMO = REGISTRY.register("tesla_battery_ammo", () -> new TeslaBatteryAmmoItem());
	public static final RegistryObject<Item> BRASS_GLASS_BOTTLE = REGISTRY.register("brass_glass_bottle", () -> new BrassGlassBottleItem());
	public static final RegistryObject<Item> COPPER_WIRE = REGISTRY.register("copper_wire", () -> new CopperWireItem());
	public static final RegistryObject<Item> DIAL = REGISTRY.register("dial", () -> new DialItem());
	public static final RegistryObject<Item> DIAL_HEALING = REGISTRY.register("dial_healing", () -> new DialHealingItem());
	public static final RegistryObject<Item> DIAL_REPAIR = REGISTRY.register("dial_repair", () -> new DialRepairItem());
	public static final RegistryObject<Item> DYNAMIC_CHIP = REGISTRY.register("dynamic_chip", () -> new DynamicChipItem());
	public static final RegistryObject<Item> DYNAMIC_MECHANISM = REGISTRY.register("dynamic_mechanism", () -> new DynamicMechanismItem());
	public static final RegistryObject<Item> ELECTROCONDUCTIVE_CHIP = REGISTRY.register("electroconductive_chip", () -> new ElectroconductiveChipItem());
	public static final RegistryObject<Item> ELECTROCONDUCTIVE_MECHANISM = REGISTRY.register("electroconductive_mechanism", () -> new ElectroconductiveMechanismItem());
	public static final RegistryObject<Item> INCOMPLETE_ADVANCED_MECHANISM = REGISTRY.register("incomplete_advanced_mechanism", () -> new IncompleteAdvancedMechanismItem());
	public static final RegistryObject<Item> INCOMPLETE_DYNAMIC_MECHANISM = REGISTRY.register("incomplete_dynamic_mechanism", () -> new IncompleteDynamicMechanismItem());
	public static final RegistryObject<Item> INCOMPLETE_ELECTROCONDUCTIVE_MECHANISM = REGISTRY.register("incomplete_electroconductive_mechanism", () -> new IncompleteElectroconductiveMechanismItem());
	public static final RegistryObject<Item> POWDERED_SULFUR = REGISTRY.register("powdered_sulfur", () -> new PowderedSulfurItem());
	public static final RegistryObject<Item> RAW_SULFUR = REGISTRY.register("raw_sulfur", () -> new RawSulfurItem());
	public static final RegistryObject<Item> XP_CONTAINER = REGISTRY.register("xp_container", () -> new XpContainerItem());
	public static final RegistryObject<Item> MEDKIT = REGISTRY.register("medkit", () -> new MedkitItem());
	public static final RegistryObject<Item> REPAIR_KIT = REGISTRY.register("repair_kit", () -> new RepairKitItem());
	public static final RegistryObject<Item> TESLA_SHIELD = REGISTRY.register("tesla_shield", () -> new TeslaShieldItem());
	public static final RegistryObject<Item> MANUFACTURER_HEAD = block(CreateCogsInvadersModBlocks.MANUFACTURER_HEAD);
	public static final RegistryObject<Item> MINER_HEAD = block(CreateCogsInvadersModBlocks.MINER_HEAD);
	public static final RegistryObject<Item> ARMOR_REPAIR_STATION = block(CreateCogsInvadersModBlocks.ARMOR_REPAIR_STATION);
	public static final RegistryObject<Item> HEALING_STATION = block(CreateCogsInvadersModBlocks.HEALING_STATION);
	public static final RegistryObject<Item> RAW_SULFUR_BLOCK = block(CreateCogsInvadersModBlocks.RAW_SULFUR_BLOCK);
	public static final RegistryObject<Item> SULFUR_ORE = block(CreateCogsInvadersModBlocks.SULFUR_ORE);
	public static final RegistryObject<Item> DEEPSLATE_SULFUR_ORE = block(CreateCogsInvadersModBlocks.DEEPSLATE_SULFUR_ORE);
	public static final RegistryObject<Item> NETHER_MINER_HEAD = block(CreateCogsInvadersModBlocks.NETHER_MINER_HEAD);
	public static final RegistryObject<Item> CHEMIST_HEAD = block(CreateCogsInvadersModBlocks.CHEMIST_HEAD);
	public static final RegistryObject<Item> BRASS_DISC = REGISTRY.register("brass_disc", () -> new BrassDiscItem());
	public static final RegistryObject<Item> HAND_DRILL = REGISTRY.register("hand_drill", () -> new HandDrillItem());
	public static final RegistryObject<Item> NETHERITE_HAND_DRILL = REGISTRY.register("netherite_hand_drill", () -> new NetheriteHandDrillItem());
	public static final RegistryObject<Item> MINER_SPAWN_EGG = REGISTRY.register("miner_spawn_egg", () -> new ForgeSpawnEggItem(CreateCogsInvadersModEntities.MINER, -6710887, -9419493, new Item.Properties()));
	public static final RegistryObject<Item> EXPLORER_SPAWN_EGG = REGISTRY.register("explorer_spawn_egg", () -> new ForgeSpawnEggItem(CreateCogsInvadersModEntities.EXPLORER, -2067120, -10066330, new Item.Properties()));
	public static final RegistryObject<Item> MANUFACTURER_SPAWN_EGG = REGISTRY.register("manufacturer_spawn_egg", () -> new ForgeSpawnEggItem(CreateCogsInvadersModEntities.MANUFACTURER, -13210, -10079488, new Item.Properties()));
	public static final RegistryObject<Item> CHEMIST_SPAWN_EGG = REGISTRY.register("chemist_spawn_egg", () -> new ForgeSpawnEggItem(CreateCogsInvadersModEntities.CHEMIST, -2395058, -13429226, new Item.Properties()));
	public static final RegistryObject<Item> DRONE_EXPLORER_SPAWN_EGG = REGISTRY.register("drone_explorer_spawn_egg", () -> new ForgeSpawnEggItem(CreateCogsInvadersModEntities.DRONE_EXPLORER, -2066864, -10066330, new Item.Properties()));
	public static final RegistryObject<Item> NETHER_MINER_SPAWN_EGG = REGISTRY.register("nether_miner_spawn_egg", () -> new ForgeSpawnEggItem(CreateCogsInvadersModEntities.NETHER_MINER, -13297897, -13261, new Item.Properties()));
	public static final RegistryObject<Item> SENTRY_PISTOL_SPAWN_EGG = REGISTRY.register("sentry_pistol_spawn_egg", () -> new ForgeSpawnEggItem(CreateCogsInvadersModEntities.SENTRY_PISTOL, -15328226, -13210, new Item.Properties()));
	public static final RegistryObject<Item> SENTRY_WARRIOR_SPAWN_EGG = REGISTRY.register("sentry_warrior_spawn_egg", () -> new ForgeSpawnEggItem(CreateCogsInvadersModEntities.SENTRY_WARRIOR, -15328226, -13210, new Item.Properties()));
	public static final RegistryObject<Item> ELITE_PISTOL_SPAWN_EGG = REGISTRY.register("elite_pistol_spawn_egg", () -> new ForgeSpawnEggItem(CreateCogsInvadersModEntities.ELITE_PISTOL, -14870242, -14675952, new Item.Properties()));
	public static final RegistryObject<Item> ELITE_WARRIOR_SPAWN_EGG = REGISTRY.register("elite_warrior_spawn_egg", () -> new ForgeSpawnEggItem(CreateCogsInvadersModEntities.ELITE_WARRIOR, -14870242, -14807281, new Item.Properties()));

	// Start of user code block custom items
	// End of user code block custom items
	private static RegistryObject<Item> block(RegistryObject<Block> block) {
		return REGISTRY.register(block.getId().getPath(), () -> new BlockItem(block.get(), new Item.Properties()));
	}

	@SubscribeEvent
	public static void clientLoad(FMLClientSetupEvent event) {
		event.enqueueWork(() -> {
			ItemProperties.register(TESLA_SHIELD.get(), new ResourceLocation("blocking"), ItemProperties.getProperty(Items.SHIELD, new ResourceLocation("blocking")));
		});
	}
}
