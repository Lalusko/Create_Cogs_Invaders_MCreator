
package net.mcreator.createcogsinvaders.potion;

import net.minecraft.world.item.Items;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.AttributeMap;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.effect.MobEffect;

import net.mcreator.createcogsinvaders.procedures.ElectroshockStartedProcedure;
import net.mcreator.createcogsinvaders.procedures.ElectroshockActiveProcedure;

import java.util.List;
import java.util.ArrayList;

public class ElectroshockMobEffect extends MobEffect {
	public ElectroshockMobEffect() {
		super(MobEffectCategory.HARMFUL, -12401153);
		this.addAttributeModifier(Attributes.MOVEMENT_SPEED, "de3f6055-bb91-3877-8d30-36457eee3e2c", -0.5, AttributeModifier.Operation.MULTIPLY_TOTAL);
		this.addAttributeModifier(Attributes.ATTACK_SPEED, "13295c6b-da00-3031-adf0-3afcdb251d72", -0.5, AttributeModifier.Operation.MULTIPLY_TOTAL);
		this.addAttributeModifier(Attributes.ATTACK_DAMAGE, "887cde9e-a1c7-3e7f-a41e-c43777969372", -0.25, AttributeModifier.Operation.MULTIPLY_TOTAL);
	}

	@Override
	public List<ItemStack> getCurativeItems() {
		ArrayList<ItemStack> cures = new ArrayList<ItemStack>();
		cures.add(new ItemStack(Items.HONEY_BOTTLE));
		return cures;
	}

	@Override
	public void addAttributeModifiers(LivingEntity entity, AttributeMap attributeMap, int amplifier) {
		super.addAttributeModifiers(entity, attributeMap, amplifier);
		ElectroshockStartedProcedure.execute(entity.level(), entity.getX(), entity.getY(), entity.getZ());
	}

	@Override
	public void applyEffectTick(LivingEntity entity, int amplifier) {
		ElectroshockActiveProcedure.execute(entity);
	}

	@Override
	public boolean isDurationEffectTick(int duration, int amplifier) {
		return true;
	}
}
