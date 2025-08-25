
package net.mcreator.createcogsinvaders.enchantment;

import net.minecraft.world.item.enchantment.EnchantmentCategory;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.EquipmentSlot;

import net.mcreator.createcogsinvaders.init.CreateCogsInvadersModItems;

public class LimitBreackEnchantment extends Enchantment {
	private static final EnchantmentCategory ENCHANTMENT_CATEGORY = EnchantmentCategory.create("create_cogs_invaders_limit_breack",
			item -> Ingredient.of(new ItemStack(CreateCogsInvadersModItems.TESLA_CANNON.get()), new ItemStack(CreateCogsInvadersModItems.TESLA_SHIELD.get())).test(new ItemStack(item)));

	public LimitBreackEnchantment() {
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
	public boolean isTreasureOnly() {
		return true;
	}

	@Override
	public boolean isTradeable() {
		return false;
	}
}
