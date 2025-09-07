
package net.mcreator.createcogsinvaders.item;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.math.Axis;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.client.model.HumanoidModel;
import net.minecraft.client.player.LocalPlayer;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.HumanoidArm;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.*;
import net.minecraftforge.registries.ForgeRegistries;
import org.jetbrains.annotations.Nullable;
import software.bernie.geckolib.util.GeckoLibUtil;
import software.bernie.geckolib.core.object.PlayState;
import software.bernie.geckolib.core.animation.RawAnimation;
import software.bernie.geckolib.core.animation.AnimationState;
import software.bernie.geckolib.core.animation.AnimationController;
import software.bernie.geckolib.core.animation.AnimatableManager;
import software.bernie.geckolib.core.animatable.instance.AnimatableInstanceCache;
import software.bernie.geckolib.animatable.GeoItem;

import net.minecraftforge.client.extensions.common.IClientItemExtensions;

import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.Level;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.Entity;
import net.minecraft.client.renderer.BlockEntityWithoutLevelRenderer;

import net.mcreator.createcogsinvaders.procedures.HandDrillAnimationProcedure;
import net.mcreator.createcogsinvaders.item.renderer.HandDrillItemRenderer;

import java.util.List;
import java.util.function.Consumer;

import com.google.common.collect.Multimap;
import com.google.common.collect.ImmutableMultimap;

public class HandDrillItem extends Item implements GeoItem {
	private final AnimatableInstanceCache cache = GeckoLibUtil.createInstanceCache(this);
	public String animationprocedure = "empty";

	public HandDrillItem() {
		super(new Item.Properties().durability(512).rarity(Rarity.COMMON));
	}

	private Tier getDrillTier() {
		return Tiers.IRON;
	}

	@Override
	public boolean isValidRepairItem(ItemStack toRepair, ItemStack repair) {
		var andesite = ForgeRegistries.ITEMS.getValue(new ResourceLocation("create", "andesite_alloy"));
		return andesite != null && repair.is(andesite);
	}

	@Override
	public boolean shouldCauseReequipAnimation(ItemStack oldStack, ItemStack newStack, boolean slotChanged) {
		return false;
	}

	@Override
	public void initializeClient(Consumer<IClientItemExtensions> consumer) {
		super.initializeClient(consumer);
		consumer.accept(new IClientItemExtensions() {
			private final BlockEntityWithoutLevelRenderer renderer = new HandDrillItemRenderer();

			@Override
			public BlockEntityWithoutLevelRenderer getCustomRenderer() {
				return this.renderer;
			}

			@Override
			public HumanoidModel.ArmPose getArmPose(LivingEntity entity, InteractionHand hand, ItemStack stack) {
				return !stack.isEmpty() && stack.getItem() == HandDrillItem.this
						? HumanoidModel.ArmPose.CROSSBOW_HOLD
						: HumanoidModel.ArmPose.ITEM;
			}

			@Override
			public boolean applyForgeHandTransform(PoseStack poseStack, LocalPlayer player, HumanoidArm arm,
												   ItemStack itemInHand, float partialTick,
												   float equipProgress, float swingProgress) {
				int i = (arm == HumanoidArm.RIGHT) ? 1 : -1;

				poseStack.translate(i * 0.56F, -0.52F, -0.72F);
				poseStack.translate(0.0F, -0.05F, 0.10F);

				poseStack.mulPose(Axis.YP.rotationDegrees(i * -8.0F));
				poseStack.mulPose(Axis.XP.rotationDegrees(-6.0F));

				return true;
			}
		});
	}

	@Override
	public boolean onEntitySwing(ItemStack stack, LivingEntity entity) {
		return true;
	}

	private PlayState idlePredicate(AnimationState event) {
		if (this.animationprocedure.equals("empty")) {
			event.getController().setAnimation(RawAnimation.begin().thenLoop("Idle"));
			return PlayState.CONTINUE;
		}
		return PlayState.STOP;
	}

	String prevAnim = "empty";

	private PlayState procedurePredicate(AnimationState event) {
		if (!this.animationprocedure.equals("empty") && event.getController().getAnimationState() == AnimationController.State.STOPPED || (!this.animationprocedure.equals(prevAnim) && !this.animationprocedure.equals("empty"))) {
			if (!this.animationprocedure.equals(prevAnim))
				event.getController().forceAnimationReset();
			event.getController().setAnimation(RawAnimation.begin().thenPlay(this.animationprocedure));
			if (event.getController().getAnimationState() == AnimationController.State.STOPPED) {
				this.animationprocedure = "empty";
				event.getController().forceAnimationReset();
			}
		} else if (this.animationprocedure.equals("empty")) {
			prevAnim = "empty";
			return PlayState.STOP;
		}
		prevAnim = this.animationprocedure;
		return PlayState.CONTINUE;
	}

	@Override
	public void registerControllers(AnimatableManager.ControllerRegistrar data) {
		AnimationController procedureController = new AnimationController(this, "procedureController", 0, this::procedurePredicate);
		data.add(procedureController);
		AnimationController idleController = new AnimationController(this, "idleController", 0, this::idlePredicate);
		data.add(idleController);
	}

	@Override
	public AnimatableInstanceCache getAnimatableInstanceCache() {
		return this.cache;
	}

	@Override
	public int getEnchantmentValue() {
		return 14;
	}

	@Override
	public float getDestroySpeed(ItemStack par1ItemStack, BlockState par2Block) {
		return 12F;
	}

	@Override
	public Multimap<Attribute, AttributeModifier> getDefaultAttributeModifiers(EquipmentSlot equipmentSlot) {
		if (equipmentSlot == EquipmentSlot.MAINHAND) {
			ImmutableMultimap.Builder<Attribute, AttributeModifier> builder = ImmutableMultimap.builder();
			builder.putAll(super.getDefaultAttributeModifiers(equipmentSlot));
			builder.put(Attributes.ATTACK_DAMAGE, new AttributeModifier(BASE_ATTACK_DAMAGE_UUID, "Item modifier", 3d, AttributeModifier.Operation.ADDITION));
			builder.put(Attributes.ATTACK_SPEED, new AttributeModifier(BASE_ATTACK_SPEED_UUID, "Item modifier", -2.8, AttributeModifier.Operation.ADDITION));
			return builder.build();
		}
		return super.getDefaultAttributeModifiers(equipmentSlot);
	}

	@Override
	public boolean isCorrectToolForDrops(BlockState state) {
		if (!state.is(net.minecraft.tags.BlockTags.MINEABLE_WITH_PICKAXE)) return false;
		if (state.requiresCorrectToolForDrops()) {
			return net.minecraftforge.common.TierSortingRegistry.isCorrectTierForDrops(this.getDrillTier(), state);
		}
		return true;
	}

	@Override
	public boolean onBlockStartBreak(net.minecraft.world.item.ItemStack stack, net.minecraft.core.BlockPos origin, net.minecraft.world.entity.player.Player player) {
		net.minecraft.world.level.Level level = player.level();
		if (!player.isShiftKeyDown()) return false;
		if (level.isClientSide) return false;

		net.minecraft.world.level.block.state.BlockState originState = level.getBlockState(origin);
		if (!originState.is(net.minecraft.tags.BlockTags.MINEABLE_WITH_PICKAXE)) return false;
		if (originState.getDestroySpeed(level, origin) == -1.0F) return false;
		if (originState.requiresCorrectToolForDrops() && !this.isCorrectToolForDrops(originState)) return false;

		boolean creative = player.getAbilities() != null && player.getAbilities().instabuild;

		int remainingUses = stack.getMaxDamage() - stack.getDamageValue();
		if (!creative && remainingUses <= 0) return false;

		net.minecraft.core.Direction face;
		net.minecraft.world.phys.HitResult hr = player.pick(20.0D, 0.0F, false);
		if (hr instanceof net.minecraft.world.phys.BlockHitResult bhr) face = bhr.getDirection();
		else face = player.getDirection();

		java.util.LinkedHashSet<net.minecraft.core.BlockPos> targets = new java.util.LinkedHashSet<>();

		if (face.getAxis() == net.minecraft.core.Direction.Axis.Y) {
			for (int dx = -1; dx <= 1; dx++) for (int dz = -1; dz <= 1; dz++) targets.add(origin.offset(dx, 0, dz));
		} else if (face.getAxis() == net.minecraft.core.Direction.Axis.Z) {
			for (int dx = -1; dx <= 1; dx++) for (int dy = -1; dy <= 1; dy++) targets.add(origin.offset(dx, dy, 0));
		} else {
			for (int dy = -1; dy <= 1; dy++) for (int dz = -1; dz <= 1; dz++) targets.add(origin.offset(0, dy, dz));
		}

		targets.remove(origin);

		int neighborsAllowed = creative ? 8 : Math.max(0, Math.min(8, remainingUses - 1));
		boolean drop = !creative;

		int extrasBroken = 0;
		for (net.minecraft.core.BlockPos pos : targets) {
			if (extrasBroken >= neighborsAllowed) break;
			net.minecraft.world.level.block.state.BlockState st = level.getBlockState(pos);
			if (st.isAir()) continue;
			if (!st.is(net.minecraft.tags.BlockTags.MINEABLE_WITH_PICKAXE)) continue;
			if (st.getDestroySpeed(level, pos) == -1.0F) continue;
			if (st.requiresCorrectToolForDrops() && !this.isCorrectToolForDrops(st)) continue;
			boolean ok = level.destroyBlock(pos, drop, player);
			if (ok) extrasBroken++;
		}

		if (!creative && extrasBroken > 0) {
			stack.getOrCreateTag().putInt("handdrill_extra_damage", extrasBroken);
		}

		return false;
	}

	@Override
	public boolean mineBlock(net.minecraft.world.item.ItemStack stack, net.minecraft.world.level.Level level, net.minecraft.world.level.block.state.BlockState state, net.minecraft.core.BlockPos pos, net.minecraft.world.entity.LivingEntity entity) {
		if (entity instanceof net.minecraft.world.entity.player.Player p && p.getAbilities().instabuild) {
			if (stack.hasTag()) stack.getTag().remove("handdrill_extra_damage");
			return true;
		}
		if (!level.isClientSide && state.getDestroySpeed(level, pos) != 0.0F) {
			stack.hurtAndBreak(1, entity, e -> e.broadcastBreakEvent(net.minecraft.world.entity.EquipmentSlot.MAINHAND));
			if (stack.hasTag()) {
				int extra = stack.getTag().getInt("handdrill_extra_damage");
				if (extra > 0) {
					stack.hurtAndBreak(extra, entity, e -> e.broadcastBreakEvent(net.minecraft.world.entity.EquipmentSlot.MAINHAND));
					stack.getTag().remove("handdrill_extra_damage");
				}
			}
		}
		return true;
	}

	@Override
	public boolean hurtEnemy(net.minecraft.world.item.ItemStack stack, net.minecraft.world.entity.LivingEntity target, net.minecraft.world.entity.LivingEntity attacker) {
		if (attacker != null && !attacker.level().isClientSide) {
			stack.hurtAndBreak(1, attacker, e -> e.broadcastBreakEvent(net.minecraft.world.entity.EquipmentSlot.MAINHAND));
		}
		return true;
	}

	@Override
	public void inventoryTick(ItemStack itemstack, Level world, Entity entity, int slot, boolean selected) {
		super.inventoryTick(itemstack, world, entity, slot, selected);
		if (selected)
			HandDrillAnimationProcedure.execute(entity);
	}

	@Override
	public boolean canPerformAction(net.minecraft.world.item.ItemStack stack, net.minecraftforge.common.ToolAction action) {
		return action == net.minecraftforge.common.ToolActions.PICKAXE_DIG;
	}

	@Override
	public void appendHoverText(ItemStack p_41421_, @Nullable Level p_41422_, List<Component> p_41423_, TooltipFlag p_41424_) {
		if (Screen.hasShiftDown()) {
			p_41423_.add(Component.translatable("tooltip.create_cogs_invaders.hold_shift.shift_down"));
			p_41423_.add(Component.translatable("tooltip.create_cogs_invaders.space.shift_down"));
			p_41423_.add(Component.translatable("tooltip.create_cogs_invaders.hand_drill.shift_down_0"));
			p_41423_.add(Component.translatable("tooltip.create_cogs_invaders.hand_drill.shift_down_1"));
			p_41423_.add(Component.translatable("tooltip.create_cogs_invaders.hand_drill.shift_down_2"));
			p_41423_.add(Component.translatable("tooltip.create_cogs_invaders.space.shift_down"));
			p_41423_.add(Component.translatable("tooltip.create_cogs_invaders.shift_breack_block.shift_down"));
			p_41423_.add(Component.translatable("tooltip.create_cogs_invaders.hand_drill.shift_down_3"));
			p_41423_.add(Component.translatable("tooltip.create_cogs_invaders.hand_drill.shift_down_4"));
		} else {
			p_41423_.add(Component.translatable("tooltip.create_cogs_invaders.hold_shift"));
		}
		super.appendHoverText(p_41421_, p_41422_, p_41423_, p_41424_);
	}
}
