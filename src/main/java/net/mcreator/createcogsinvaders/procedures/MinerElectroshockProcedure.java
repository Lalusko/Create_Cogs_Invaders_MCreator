package net.mcreator.createcogsinvaders.procedures;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.event.entity.living.LivingAttackEvent;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffectInstance;

import net.mcreator.createcogsinvaders.init.CreateCogsInvadersModMobEffects;
import net.mcreator.createcogsinvaders.init.CreateCogsInvadersModItems;
import net.mcreator.createcogsinvaders.entity.NetherMinerEntity;
import net.mcreator.createcogsinvaders.entity.MinerEntity;

import javax.annotation.Nullable;

@Mod.EventBusSubscriber
public class MinerElectroshockProcedure {
	@SubscribeEvent
	public static void onEntityAttacked(LivingAttackEvent event) {
		if (event != null && event.getEntity() != null) {
			execute(event, event.getEntity(), event.getSource().getEntity());
		}
	}

	public static void execute(Entity entity, Entity sourceentity) {
		execute(null, entity, sourceentity);
	}

	private static void execute(@Nullable Event event, Entity entity, Entity sourceentity) {
		if (entity == null || sourceentity == null)
			return;
		if (sourceentity instanceof MinerEntity || sourceentity instanceof NetherMinerEntity) {
			if ((entity instanceof LivingEntity _entUseItem2 ? _entUseItem2.getUseItem() : ItemStack.EMPTY).getItem() == CreateCogsInvadersModItems.TESLA_SHIELD.get()) {
				if (sourceentity instanceof LivingEntity _entity && !_entity.level().isClientSide())
					_entity.addEffect(new MobEffectInstance(CreateCogsInvadersModMobEffects.ELECTROSHOCK.get(), 120, 0));
			}
		}
	}
}
