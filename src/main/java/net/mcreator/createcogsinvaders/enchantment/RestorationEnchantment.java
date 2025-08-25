
package net.mcreator.createcogsinvaders.enchantment;

import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.item.enchantment.EnchantmentCategory;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.EquipmentSlot;

import net.mcreator.createcogsinvaders.init.CreateCogsInvadersModItems;

import java.util.List;

public class RestorationEnchantment extends Enchantment {
	private static final EnchantmentCategory ENCHANTMENT_CATEGORY = EnchantmentCategory.create("create_cogs_invaders_restoration", item -> Ingredient.of(new ItemStack(CreateCogsInvadersModItems.REPAIR_KIT.get())).test(new ItemStack(item)));

	public RestorationEnchantment() {
		super(Enchantment.Rarity.UNCOMMON, ENCHANTMENT_CATEGORY, new EquipmentSlot[]{EquipmentSlot.MAINHAND, EquipmentSlot.OFFHAND});
	}

	@Override
	public int getMinCost(int level) {
		return 1 + level * 10;
	}

	@Override
	public int getMaxCost(int level) {
		return 6 + level * 10;
	}

	@Override
	public int getMaxLevel() {
		return 3;
	}

	@Override
	protected boolean checkCompatibility(Enchantment enchantment) {
		return super.checkCompatibility(enchantment) && !List.of(Enchantments.UNBREAKING).contains(enchantment);
	}

	@Override
	public boolean isTreasureOnly() {
		return true;
	}
}
