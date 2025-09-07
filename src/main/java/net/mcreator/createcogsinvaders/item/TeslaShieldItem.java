
package net.mcreator.createcogsinvaders.item;

import net.minecraft.client.gui.screens.Screen;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.*;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class TeslaShieldItem extends ShieldItem {
	public TeslaShieldItem() {
		super(new Item.Properties().durability(512));
	}

	@Override
	public boolean isValidRepairItem(ItemStack itemstack, ItemStack repairitem) {
		return Ingredient.of(new ItemStack(Items.COPPER_INGOT)).test(repairitem);
	}

	@Override
	public void appendHoverText(ItemStack stack, Level level, List<Component> tooltip, TooltipFlag flag) {
		if (Screen.hasShiftDown()) {
			tooltip.add(Component.translatable("tooltip.create_cogs_invaders.hold_shift.shift_down"));
			tooltip.add(Component.translatable("tooltip.create_cogs_invaders.space.shift_down"));
			tooltip.add(Component.translatable("tooltip.create_cogs_invaders.tesla_shield.shift_down_0"));
			tooltip.add(Component.translatable("tooltip.create_cogs_invaders.tesla_shield.shift_down_1"));
		} else {
			tooltip.add(Component.translatable("tooltip.create_cogs_invaders.hold_shift"));
		}
		super.appendHoverText(stack, level, tooltip, flag);
	}
}
