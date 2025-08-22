
package net.mcreator.createcogsinvaders.item;

import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.Item;

public class XpContainerItem extends Item {
	public XpContainerItem() {
		super(new Item.Properties().stacksTo(1).rarity(Rarity.COMMON));
	}
}
