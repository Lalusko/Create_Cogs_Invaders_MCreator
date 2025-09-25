
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.createcogsinvaders.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.entity.EntityAttributeCreationEvent;

import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Entity;

import net.mcreator.createcogsinvaders.entity.SentryWarriorEntity;
import net.mcreator.createcogsinvaders.entity.SentryPistolEntity;
import net.mcreator.createcogsinvaders.entity.NetherMinerEntity;
import net.mcreator.createcogsinvaders.entity.MinerEntity;
import net.mcreator.createcogsinvaders.entity.ManufacturerEntity;
import net.mcreator.createcogsinvaders.entity.FireBallEntity;
import net.mcreator.createcogsinvaders.entity.ExplorerEntity;
import net.mcreator.createcogsinvaders.entity.EliteWarriorEntity;
import net.mcreator.createcogsinvaders.entity.ElitePistolEntity;
import net.mcreator.createcogsinvaders.entity.ElectroshockChargeEntity;
import net.mcreator.createcogsinvaders.entity.ElectricChargeEntity;
import net.mcreator.createcogsinvaders.entity.DroneExplorerEntity;
import net.mcreator.createcogsinvaders.entity.ChemistEntity;
import net.mcreator.createcogsinvaders.entity.BrassPelletWitherEntity;
import net.mcreator.createcogsinvaders.entity.BrassPelletEntity;
import net.mcreator.createcogsinvaders.CreateCogsInvadersMod;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class CreateCogsInvadersModEntities {
	public static final DeferredRegister<EntityType<?>> REGISTRY = DeferredRegister.create(ForgeRegistries.ENTITY_TYPES, CreateCogsInvadersMod.MODID);
	public static final RegistryObject<EntityType<ElectroshockChargeEntity>> ELECTROSHOCK_CHARGE = register("electroshock_charge", EntityType.Builder.<ElectroshockChargeEntity>of(ElectroshockChargeEntity::new, MobCategory.MISC)
			.setCustomClientFactory(ElectroshockChargeEntity::new).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(1).sized(0.2f, 0.2f));
	public static final RegistryObject<EntityType<MinerEntity>> MINER = register("miner",
			EntityType.Builder.<MinerEntity>of(MinerEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(MinerEntity::new)

					.sized(0.6f, 2f));
	public static final RegistryObject<EntityType<ExplorerEntity>> EXPLORER = register("explorer",
			EntityType.Builder.<ExplorerEntity>of(ExplorerEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(ExplorerEntity::new)

					.sized(0.6f, 2f));
	public static final RegistryObject<EntityType<ManufacturerEntity>> MANUFACTURER = register("manufacturer",
			EntityType.Builder.<ManufacturerEntity>of(ManufacturerEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(ManufacturerEntity::new)

					.sized(0.6f, 2f));
	public static final RegistryObject<EntityType<ChemistEntity>> CHEMIST = register("chemist",
			EntityType.Builder.<ChemistEntity>of(ChemistEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(ChemistEntity::new).fireImmune().sized(0.6f, 2f));
	public static final RegistryObject<EntityType<DroneExplorerEntity>> DRONE_EXPLORER = register("drone_explorer",
			EntityType.Builder.<DroneExplorerEntity>of(DroneExplorerEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(DroneExplorerEntity::new)

					.sized(0.6f, 1.8f));
	public static final RegistryObject<EntityType<NetherMinerEntity>> NETHER_MINER = register("nether_miner", EntityType.Builder.<NetherMinerEntity>of(NetherMinerEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true)
			.setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(NetherMinerEntity::new).fireImmune().sized(0.6f, 2f));
	public static final RegistryObject<EntityType<SentryPistolEntity>> SENTRY_PISTOL = register("sentry_pistol",
			EntityType.Builder.<SentryPistolEntity>of(SentryPistolEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(SentryPistolEntity::new)

					.sized(0.6f, 2f));
	public static final RegistryObject<EntityType<BrassPelletEntity>> BRASS_PELLET = register("brass_pellet",
			EntityType.Builder.<BrassPelletEntity>of(BrassPelletEntity::new, MobCategory.MISC).setCustomClientFactory(BrassPelletEntity::new).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(1).sized(0.2f, 0.2f));
	public static final RegistryObject<EntityType<SentryWarriorEntity>> SENTRY_WARRIOR = register("sentry_warrior",
			EntityType.Builder.<SentryWarriorEntity>of(SentryWarriorEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(SentryWarriorEntity::new)

					.sized(0.6f, 2f));
	public static final RegistryObject<EntityType<ElitePistolEntity>> ELITE_PISTOL = register("elite_pistol", EntityType.Builder.<ElitePistolEntity>of(ElitePistolEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true)
			.setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(ElitePistolEntity::new).fireImmune().sized(0.6f, 2f));
	public static final RegistryObject<EntityType<EliteWarriorEntity>> ELITE_WARRIOR = register("elite_warrior", EntityType.Builder.<EliteWarriorEntity>of(EliteWarriorEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true)
			.setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(EliteWarriorEntity::new).fireImmune().sized(0.6f, 2f));
	public static final RegistryObject<EntityType<FireBallEntity>> FIRE_BALL = register("fire_ball",
			EntityType.Builder.<FireBallEntity>of(FireBallEntity::new, MobCategory.MISC).setCustomClientFactory(FireBallEntity::new).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(1).sized(0.3f, 0.3f));
	public static final RegistryObject<EntityType<BrassPelletWitherEntity>> BRASS_PELLET_WITHER = register("brass_pellet_wither", EntityType.Builder.<BrassPelletWitherEntity>of(BrassPelletWitherEntity::new, MobCategory.MISC)
			.setCustomClientFactory(BrassPelletWitherEntity::new).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(1).sized(0.2f, 0.2f));
	public static final RegistryObject<EntityType<ElectricChargeEntity>> ELECTRIC_CHARGE = register("electric_charge", EntityType.Builder.<ElectricChargeEntity>of(ElectricChargeEntity::new, MobCategory.MISC)
			.setCustomClientFactory(ElectricChargeEntity::new).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(1).sized(0.25f, 0.25f));

	// Start of user code block custom entities
	// End of user code block custom entities
	private static <T extends Entity> RegistryObject<EntityType<T>> register(String registryname, EntityType.Builder<T> entityTypeBuilder) {
		return REGISTRY.register(registryname, () -> (EntityType<T>) entityTypeBuilder.build(registryname));
	}

	@SubscribeEvent
	public static void init(FMLCommonSetupEvent event) {
		event.enqueueWork(() -> {
			MinerEntity.init();
			ExplorerEntity.init();
			ManufacturerEntity.init();
			ChemistEntity.init();
			DroneExplorerEntity.init();
			NetherMinerEntity.init();
			SentryPistolEntity.init();
			SentryWarriorEntity.init();
			ElitePistolEntity.init();
			EliteWarriorEntity.init();
		});
	}

	@SubscribeEvent
	public static void registerAttributes(EntityAttributeCreationEvent event) {
		event.put(MINER.get(), MinerEntity.createAttributes().build());
		event.put(EXPLORER.get(), ExplorerEntity.createAttributes().build());
		event.put(MANUFACTURER.get(), ManufacturerEntity.createAttributes().build());
		event.put(CHEMIST.get(), ChemistEntity.createAttributes().build());
		event.put(DRONE_EXPLORER.get(), DroneExplorerEntity.createAttributes().build());
		event.put(NETHER_MINER.get(), NetherMinerEntity.createAttributes().build());
		event.put(SENTRY_PISTOL.get(), SentryPistolEntity.createAttributes().build());
		event.put(SENTRY_WARRIOR.get(), SentryWarriorEntity.createAttributes().build());
		event.put(ELITE_PISTOL.get(), ElitePistolEntity.createAttributes().build());
		event.put(ELITE_WARRIOR.get(), EliteWarriorEntity.createAttributes().build());
	}
}
