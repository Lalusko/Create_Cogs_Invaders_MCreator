
package net.mcreator.createcogsinvaders.item;

import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.Item;

public class PowderedSulfurItem extends Item {
	public PowderedSulfurItem() {
		super(new Item.Properties().stacksTo(64).rarity(Rarity.COMMON));
	}
}
