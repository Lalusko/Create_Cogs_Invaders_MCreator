
package net.mcreator.createcogsinvaders.item;

import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.Item;

public class ElectroconductiveMechanismItem extends Item {
	public ElectroconductiveMechanismItem() {
		super(new Item.Properties().stacksTo(64).rarity(Rarity.UNCOMMON));
	}
}
