
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.createcogsinvaders.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;

import net.minecraft.sounds.SoundEvent;
import net.minecraft.resources.ResourceLocation;

import net.mcreator.createcogsinvaders.CreateCogsInvadersMod;

public class CreateCogsInvadersModSounds {
	public static final DeferredRegister<SoundEvent> REGISTRY = DeferredRegister.create(ForgeRegistries.SOUND_EVENTS, CreateCogsInvadersMod.MODID);
	public static final RegistryObject<SoundEvent> BOLT_RELEASE = REGISTRY.register("bolt_release", () -> SoundEvent.createVariableRangeEvent(new ResourceLocation("create_cogs_invaders", "bolt_release")));
	public static final RegistryObject<SoundEvent> PELLET_SHOOT = REGISTRY.register("pellet_shoot", () -> SoundEvent.createVariableRangeEvent(new ResourceLocation("create_cogs_invaders", "pellet_shoot")));
	public static final RegistryObject<SoundEvent> FWOOMP = REGISTRY.register("fwoomp", () -> SoundEvent.createVariableRangeEvent(new ResourceLocation("create_cogs_invaders", "fwoomp")));
	public static final RegistryObject<SoundEvent> HEAVY_COG_DEATH = REGISTRY.register("heavy_cog_death", () -> SoundEvent.createVariableRangeEvent(new ResourceLocation("create_cogs_invaders", "heavy_cog_death")));
	public static final RegistryObject<SoundEvent> THE_STORY_UNFOLDS = REGISTRY.register("the_story_unfolds", () -> SoundEvent.createVariableRangeEvent(new ResourceLocation("create_cogs_invaders", "the_story_unfolds")));
	public static final RegistryObject<SoundEvent> ELECTROSHOCK_EFFECT = REGISTRY.register("electroshock_effect", () -> SoundEvent.createVariableRangeEvent(new ResourceLocation("create_cogs_invaders", "electroshock_effect")));
	public static final RegistryObject<SoundEvent> OMINOUS_HORN = REGISTRY.register("ominous_horn", () -> SoundEvent.createVariableRangeEvent(new ResourceLocation("create_cogs_invaders", "ominous_horn")));
	public static final RegistryObject<SoundEvent> COG_DEATH = REGISTRY.register("cog_death", () -> SoundEvent.createVariableRangeEvent(new ResourceLocation("create_cogs_invaders", "cog_death")));
	public static final RegistryObject<SoundEvent> COG_HURT = REGISTRY.register("cog_hurt", () -> SoundEvent.createVariableRangeEvent(new ResourceLocation("create_cogs_invaders", "cog_hurt")));
	public static final RegistryObject<SoundEvent> ELECTROSHOCK_THROW = REGISTRY.register("electroshock_throw", () -> SoundEvent.createVariableRangeEvent(new ResourceLocation("create_cogs_invaders", "electroshock_throw")));
	public static final RegistryObject<SoundEvent> STATION_ERROR = REGISTRY.register("station_error", () -> SoundEvent.createVariableRangeEvent(new ResourceLocation("create_cogs_invaders", "station_error")));
	public static final RegistryObject<SoundEvent> STATION_RELOAD = REGISTRY.register("station_reload", () -> SoundEvent.createVariableRangeEvent(new ResourceLocation("create_cogs_invaders", "station_reload")));
	public static final RegistryObject<SoundEvent> STATION_USE = REGISTRY.register("station_use", () -> SoundEvent.createVariableRangeEvent(new ResourceLocation("create_cogs_invaders", "station_use")));
	public static final RegistryObject<SoundEvent> TANK_TRACKS = REGISTRY.register("tank_tracks", () -> SoundEvent.createVariableRangeEvent(new ResourceLocation("create_cogs_invaders", "tank_tracks")));
}
