
package net.mcreator.createcogsinvaders.item;

import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.Item;

public class DynamicMechanismItem extends Item {
	public DynamicMechanismItem() {
		super(new Item.Properties().stacksTo(64).rarity(Rarity.UNCOMMON));
	}
}
