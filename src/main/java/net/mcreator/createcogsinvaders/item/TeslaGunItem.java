
package net.mcreator.createcogsinvaders.item;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.math.Axis;
import net.mcreator.createcogsinvaders.procedures.TeslaGunShootProcedure;
import net.minecraft.ChatFormatting;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.client.model.HumanoidModel;
import net.minecraft.client.player.LocalPlayer;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.HumanoidArm;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import software.bernie.geckolib.util.GeckoLibUtil;
import software.bernie.geckolib.core.object.PlayState;
import software.bernie.geckolib.core.animation.RawAnimation;
import software.bernie.geckolib.core.animation.AnimationState;
import software.bernie.geckolib.core.animation.AnimationController;
import software.bernie.geckolib.core.animation.AnimatableManager;
import software.bernie.geckolib.core.animatable.instance.AnimatableInstanceCache;
import software.bernie.geckolib.animatable.GeoItem;

import net.minecraftforge.client.extensions.common.IClientItemExtensions;

import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Item;
import net.minecraft.client.renderer.BlockEntityWithoutLevelRenderer;

import net.mcreator.createcogsinvaders.item.renderer.TeslaGunItemRenderer;

import java.util.List;
import java.util.function.Consumer;

public class TeslaGunItem extends Item implements GeoItem {
	private final AnimatableInstanceCache cache = GeckoLibUtil.createInstanceCache(this);
	public String animationprocedure = "empty";

	public TeslaGunItem() {
		super(new Item.Properties().durability(128).rarity(Rarity.COMMON));
	}

	public static final String ENERGY_TAG = "Energy";
	public static final int MAX_ENERGY = 64;

	public static int getEnergy(ItemStack stack) {
		CompoundTag tag = stack.getOrCreateTag();
		return tag.getInt(ENERGY_TAG);
	}

	public static void setEnergy(ItemStack stack, int value) {
		if (value < 0) value = 0;
		if (value > MAX_ENERGY) value = MAX_ENERGY;
		stack.getOrCreateTag().putInt(ENERGY_TAG, value);
	}

	@Override
	public boolean shouldCauseReequipAnimation(ItemStack oldStack, ItemStack newStack, boolean slotChanged) {
		return false;
	}

	@Override
	public void initializeClient(Consumer<IClientItemExtensions> consumer) {
		super.initializeClient(consumer);
		consumer.accept(new IClientItemExtensions() {
			private final BlockEntityWithoutLevelRenderer renderer = new TeslaGunItemRenderer();

			@Override
			public BlockEntityWithoutLevelRenderer getCustomRenderer() {
				return this.renderer;
			}

			@Override
			public HumanoidModel.ArmPose getArmPose(LivingEntity entity, InteractionHand hand, ItemStack stack) {
				return !stack.isEmpty() && stack.getItem() == TeslaGunItem.this
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
	public void appendHoverText(ItemStack stack, Level level, List<Component> tooltip, TooltipFlag flag) {
		int e = getEnergy(stack);
		tooltip.add(
				Component.translatable("tooltip.create_cogs_invaders.tesla_cannon.energy", e, MAX_ENERGY)
						.withStyle(ChatFormatting.GRAY)
		);

		if (Screen.hasShiftDown()) {
			tooltip.add(Component.translatable("tooltip.create_cogs_invaders.hold_shift.shift_down"));
			tooltip.add(Component.translatable("tooltip.create_cogs_invaders.space.shift_down"));
			tooltip.add(Component.translatable("tooltip.create_cogs_invaders.tesla_cannon.shift_down_0"));
			tooltip.add(Component.translatable("tooltip.create_cogs_invaders.tesla_cannon.shift_down_1"));
			tooltip.add(Component.translatable("tooltip.create_cogs_invaders.tesla_cannon.shift_down_2"));
			tooltip.add(Component.translatable("tooltip.create_cogs_invaders.tesla_cannon.shift_down_3"));
			tooltip.add(Component.translatable("tooltip.create_cogs_invaders.space.shift_down"));
			tooltip.add(Component.translatable("tooltip.create_cogs_invaders.right_click.shift_down"));
			tooltip.add(Component.translatable("tooltip.create_cogs_invaders.shoot.shift_down"));
			tooltip.add(Component.translatable("tooltip.create_cogs_invaders.reload.shift_down"));
			tooltip.add(Component.translatable("tooltip.create_cogs_invaders.tesla_cannon.shift_down_4"));
			tooltip.add(Component.translatable("tooltip.create_cogs_invaders.tesla_cannon.shift_down_5"));
			tooltip.add(Component.translatable("tooltip.create_cogs_invaders.tesla_cannon.shift_down_6"));
		} else {
			tooltip.add(Component.translatable("tooltip.create_cogs_invaders.hold_shift"));
		}
		super.appendHoverText(stack, level, tooltip, flag);
	}

	@Override
	public InteractionResultHolder<ItemStack> use(Level world, Player entity, InteractionHand hand) {
		InteractionResultHolder<ItemStack> ar = super.use(world, entity, hand);
		ItemStack itemstack = ar.getObject();
		double x = entity.getX();
		double y = entity.getY();
		double z = entity.getZ();

		TeslaGunShootProcedure.execute(world, x, y, z, entity);
		return ar;
	}
}
