
package net.mcreator.createcogsinvaders.item;

import net.mcreator.createcogsinvaders.init.CreateCogsInvadersModEnchantments;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraft.world.level.Level;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Item;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.InteractionHand;

import net.mcreator.createcogsinvaders.procedures.MedkitCureProcedure;

import java.util.Map;

public class MedkitItem extends Item {
	public MedkitItem() {
		super(new Item.Properties().durability(5).rarity(Rarity.COMMON));
	}

	@Override
	public InteractionResultHolder<ItemStack> use(Level world, Player entity, InteractionHand hand) {
		InteractionResultHolder<ItemStack> ar = super.use(world, entity, hand);
		MedkitCureProcedure.execute(world, entity.getX(), entity.getY(), entity.getZ(), entity);
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
		return ench == CreateCogsInvadersModEnchantments.HEALING_BOOST.get();
	}

	@Override
	public boolean isBookEnchantable(ItemStack stack, ItemStack book) {
		Map<Enchantment, Integer> map = EnchantmentHelper.getEnchantments(book);
		return map.size() == 1 && map.containsKey(CreateCogsInvadersModEnchantments.HEALING_BOOST.get());
	}
}
