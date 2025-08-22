
package net.mcreator.createcogsinvaders.item;

import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.Item;

public class DialItem extends Item {
	public DialItem() {
		super(new Item.Properties().stacksTo(1).rarity(Rarity.COMMON));
	}
}
