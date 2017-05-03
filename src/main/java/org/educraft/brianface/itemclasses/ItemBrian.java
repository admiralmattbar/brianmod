/*
 * This is what a typical item class looks like. The peculiar things about your items go in their own class that your item inherits from.
 * If you want your item to be in the game be sure to include it in ModItems.
 */

package org.educraft.brianface.itemclasses;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class ItemBrian extends Item {
	
	public ItemBrian() {
		setUnlocalizedName("brian_face"); 
		setRegistryName("item_brian");  
		setCreativeTab(CreativeTabs.MISC); //Places item in a special Creative Tab for this mod.
		this.setFull3D(); //Better for holding an item view. 
	}
}