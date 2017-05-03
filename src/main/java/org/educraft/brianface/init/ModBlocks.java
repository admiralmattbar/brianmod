/*
 * This class is where you create and register new blocks. It also comes with a method by which any item you register here gets
 * attached to a texture that can give your item a unique look. Go through the methods below and and copy block variables in the style
 * given and you will be able to create many different types of blocks.
 */

package org.educraft.brianface.init;

import org.educraft.brianface.blockclasses.BlockBrianBushEmpty;
import org.educraft.brianface.blockclasses.BlockBrianBushFull;
import org.educraft.brianface.blockclasses.BlockDiffBlock;
import org.educraft.brianface.blockclasses.BlockBrian;
import org.educraft.brianface.blockclasses.ModBlockOre;
import net.minecraft.block.Block;
import net.minecraft.block.material.MapColor;
import net.minecraft.block.material.Material;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraft.item.ItemBlock;

public class ModBlocks {

	//Block variables go here
	public static Block brian_ore;
	public static Block fun_block;
	public static Block diff_block;
	public static Block brian_hair;
	public static Block brian_face;
	public static Block brian_side;
	public static Block brian_back;
	public static Block weird_block;
	public static Block brian_bush_empty;
	public static Block brian_bush_full;
	
	/*public static Block brian_bush_empty;
	public static Block brian_bush_full;*/
	

	public static void init() {
		//Initialize items with class
		brian_bush_empty = new BlockBrianBushEmpty().setUnlocalizedName("brian_bush_empty").setRegistryName("block_brian_bush_empty");
		brian_bush_full = new BlockBrianBushFull().setUnlocalizedName("brian_bush_full").setRegistryName("block_brian_bush_full");
		brian_hair = new Block(Material.CLAY, MapColor.CLAY).setUnlocalizedName("brian_hair").setCreativeTab(CreativeTabs.DECORATIONS).setRegistryName("block_brian_hair");
		brian_ore = new ModBlockOre("brian_ore", "block_brian_ore", Material.ROCK, ModBlocks.brian_ore, 1, 1, "pickaxe", 1, 5.0F, 7.0F);
		fun_block = new BlockBrian();
		diff_block = new BlockDiffBlock(Material.ROCK).setUnlocalizedName("diff_block").setRegistryName("block_diff").setCreativeTab(CreativeTabs.BUILDING_BLOCKS);
		weird_block = new Block(Material.ROCK).setUnlocalizedName("weird_block").setRegistryName("block_weird").setCreativeTab(CreativeTabs.DECORATIONS);
	}

	public static void register() {
		//Register items with forge
		registerBlock(brian_ore);
		registerBlock(fun_block);
		registerBlock(diff_block);
		registerBlock(brian_hair);
		registerBlock(weird_block);
		registerBlock(brian_bush_empty);
		registerBlock(brian_bush_full);
	}

	private static void registerBlock(Block block) {
		GameRegistry.register(block);
		ItemBlock item = new ItemBlock(block);
		item.setRegistryName(block.getRegistryName());
		GameRegistry.register(item);
	}

	public static void registerRenders() {
		//List of items calling the registerRender method
		registerRender(brian_ore);
		registerRender(fun_block);
		registerRender(diff_block);
		registerRender(brian_hair);
		registerRender(weird_block);
		registerRender(brian_bush_empty);
		registerRender(brian_bush_full);
	}

	private static void registerRender(Block block) {
		//Method used to register item with texture
		Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(Item.getItemFromBlock(block), 0, new ModelResourceLocation(block.getRegistryName(), "inventory"));
	}
}