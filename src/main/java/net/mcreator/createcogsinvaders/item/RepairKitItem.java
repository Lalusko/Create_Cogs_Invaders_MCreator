
package net.mcreator.createcogsinvaders.item;

import net.mcreator.createcogsinvaders.init.CreateCogsInvadersModEnchantments;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraft.world.level.Level;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Item;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.InteractionHand;

import net.mcreator.createcogsinvaders.procedures.RepairKitProcedureProcedure;
import org.jetbrains.annotations.Nullable;

import java.util.List;
import java.util.Map;

public class RepairKitItem extends Item {
	public RepairKitItem() {
		super(new Item.Properties().durability(5).rarity(Rarity.COMMON));
	}

	@Override
	public InteractionResultHolder<ItemStack> use(Level world, Player entity, InteractionHand hand) {
		InteractionResultHolder<ItemStack> ar = super.use(world, entity, hand);
		RepairKitProcedureProcedure.execute(world, entity.getX(), entity.getY(), entity.getZ(), entity);
		return ar;
	}

	@Override
	public boolean isEnchantable(ItemStack stack) {
		return true;
	}

	@Override
	public int getEnchantmentValue() {
		return 1;
	}

	@Override
	public boolean canApplyAtEnchantingTable(ItemStack stack, Enchantment ench) {
		return ench == CreateCogsInvadersModEnchantments.RESTORATION.get();
	}

	@Override
	public boolean isBookEnchantable(ItemStack stack, ItemStack book) {
		Map<Enchantment, Integer> map = EnchantmentHelper.getEnchantments(book);
		return map.size() == 1 && map.containsKey(CreateCogsInvadersModEnchantments.RESTORATION.get());
	}

	@Override
	public void appendHoverText(ItemStack p_41421_, @Nullable Level p_41422_, List<Component> p_41423_, TooltipFlag p_41424_) {
		if (Screen.hasShiftDown()) {
			p_41423_.add(Component.translatable("tooltip.create_cogs_invaders.hold_shift.shift_down"));
			p_41423_.add(Component.translatable("tooltip.create_cogs_invaders.space.shift_down"));
			p_41423_.add(Component.translatable("tooltip.create_cogs_invaders.repair_kit.shift_down_0"));
			p_41423_.add(Component.translatable("tooltip.create_cogs_invaders.repair_kit.shift_down_1"));
			p_41423_.add(Component.translatable("tooltip.create_cogs_invaders.repair_kit.shift_down_2"));
			p_41423_.add(Component.translatable("tooltip.create_cogs_invaders.repair_kit.shift_down_3"));
		} else {
			p_41423_.add(Component.translatable("tooltip.create_cogs_invaders.hold_shift"));
		}
		super.appendHoverText(p_41421_, p_41422_, p_41423_, p_41424_);
	}
}
