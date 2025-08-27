
package net.mcreator.createcogsinvaders.item;

import net.minecraftforge.registries.ForgeRegistries;

import net.minecraft.world.item.RecordItem;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.Item;
import net.minecraft.resources.ResourceLocation;

public class BrassDiscItem extends RecordItem {
	public BrassDiscItem() {
		super(7, () -> ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("create_cogs_invaders:the_story_unfolds")), new Item.Properties().stacksTo(1).rarity(Rarity.RARE), 1800);
	}
}
