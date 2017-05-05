/*
 * This is where you create crafting recipes for your items. Whether the recipe is shaped, shapeless or smelted matters.
 */

package org.educraft.brianface.init;

import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class ModCrafting {
	
	public static void register() {
		//Crafting recipes go here
		
		//Shaped recipes
		//Use the method shown below. The first item is a new ItemStack and that is what is created.
		
		//Creating recipes for brian armor
		GameRegistry.addShapedRecipe(new ItemStack(ModItems.brian_chestplate), "M M", "MMM", "MMM", 'M', ModItems.brian_face);
		GameRegistry.addShapedRecipe(new ItemStack(ModItems.brian_helmet), "MMM", "M M", 'M', ModItems.brian_face);
		GameRegistry.addShapedRecipe(new ItemStack(ModItems.brian_leggings), "MMM", "M M", "M M", 'M', ModItems.brian_face);
		GameRegistry.addShapedRecipe(new ItemStack(ModItems.brian_boots), "M M", "M M", 'M', ModItems.brian_face);
		
		//Shapeless recipes
			//Shapeless recipes also start with the new ItemStack of the item being created. They then list the ingredients as a new Object[] inside brackets.
		
		GameRegistry.addShapelessRecipe(new ItemStack(ModItems.brian_jerky, 1), new Object[] {Items.ROTTEN_FLESH, ModItems.brian_face});
		GameRegistry.addShapelessRecipe(new ItemStack(ModItems.brian_jerky), new ItemStack(ModItems.brian_face), new ItemStack(Items.BEEF));
		
		//Smelting recipes
			//These recipes start with the ingredient and end with the product. Afterwards there is a number of experience gained followed by an F with no space.
		
		
		//Smelting Blocks
		GameRegistry.addSmelting(ModBlocks.brian_ore, new ItemStack(ModItems.brian_face, 2), 1.5F);
		
		//Smelting Items
		GameRegistry.addSmelting(ModItems.raw_brian, new ItemStack(ModItems.brian_jerky), 1.2F);
	}
}
