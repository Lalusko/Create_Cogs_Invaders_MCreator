
package net.mcreator.createcogsinvaders.item;

import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.Item;

public class DynamicChipItem extends Item {
	public DynamicChipItem() {
		super(new Item.Properties().stacksTo(64).rarity(Rarity.UNCOMMON));
	}
}
