
package net.mcreator.createcogsinvaders.item;

import net.minecraft.client.gui.screens.Screen;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class DialItem extends Item {
	public DialItem() {
		super(new Item.Properties().stacksTo(1).rarity(Rarity.COMMON));
	}

	@Override
	public void appendHoverText(ItemStack p_41421_, @Nullable Level p_41422_, List<Component> p_41423_, TooltipFlag p_41424_) {
		if (Screen.hasShiftDown()) {
			p_41423_.add(Component.translatable("tooltip.create_cogs_invaders.hold_shift.shift_down"));
			p_41423_.add(Component.translatable("tooltip.create_cogs_invaders.space.shift_down"));
			p_41423_.add(Component.translatable("tooltip.create_cogs_invaders.right_click.shift_down"));
			p_41423_.add(Component.translatable("tooltip.create_cogs_invaders.dial.shift_down_0"));
			p_41423_.add(Component.translatable("tooltip.create_cogs_invaders.right_click_sneak.shift_down"));
			p_41423_.add(Component.translatable("tooltip.create_cogs_invaders.dial.shift_down_1"));
		} else {
			p_41423_.add(Component.translatable("tooltip.create_cogs_invaders.hold_shift"));
		}
		super.appendHoverText(p_41421_, p_41422_, p_41423_, p_41424_);
	}
}
