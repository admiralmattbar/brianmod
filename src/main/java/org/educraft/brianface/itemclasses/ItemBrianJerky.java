/*
 * This is what a typical item class looks like. The peculiar things about your items go in their own class that your item inherits from.
 * If you want your item to be in the game be sure to include it in ModItems. This particular item is a food item. Any food you create shoudl
 * have its own method that looks like this.
 */

package org.educraft.brianface.itemclasses;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemFood;

public class ItemBrianJerky extends ItemFood {

	public ItemBrianJerky() {
		super(6, 1.0F, true); //The first number is how many half-food icons it fills, second is how long it fills you for, and third is true or false on whether wolves can eat it or not.
		setUnlocalizedName("brian_jerky"); //This uses a method created in Reference. Add your item there.
		setRegistryName("item_brian_jerky");
		setCreativeTab(CreativeTabs.FOOD); //Places item in the food tab for Creative Tabs.
	}

}
