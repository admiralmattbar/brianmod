/*
 * This class is where you create and register new items. It also comes with a method by which any item you register here gets
 * attached to a texture that can give your item a unique look. Go through the methods below and and copy items in the style
 * given and you will be able to create many different types of items.
 */

package org.educraft.brianface.init;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.SoundEvents;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.Item;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemHoe;
import net.minecraft.item.ItemSpade;
/*
 * This class is where you start creating your items. Add them as variables, then initialize them, linking them to a class. You have to register them
 * and use the registerRender method to set up their textures (textures should be added to the resources folder).
 */
import net.minecraftforge.common.util.EnumHelper;
import net.minecraftforge.fml.common.registry.GameRegistry;

import org.educraft.brianface.Reference;
import org.educraft.brianface.itemclasses.*;

public class ModItems
{

	//Item variables go here
	
	//Random item that is just black square, use this for recipes.
	public static Item brian_face;
	
	//Consumable items
	public static Item brian_jerky;
	public static Item raw_brian;
	public static Item brapple;
	public static Item brian_poo;
	
	//Armor Items
	public static Item brian_helmet;
	public static Item brian_chestplate;
	public static Item brian_leggings;
	public static Item brian_boots;
	
	//Tools and Weapons
	public static Item brian_wrench;
	public static Item brian_axe;
	public static Item brian_shovel;
	public static Item brian_hoe;
	public static Item brian_pickaxe;
	public static Item brianade;
	
	//Create your own materials for tools and armor
	public static final Item.ToolMaterial brian_material = EnumHelper.addToolMaterial("brian_material", 3, 2000, 10.0F, 3.0F, 50);
	//public static final ItemArmor.ArmorMaterial armor_name;
	/*
	 * This creates a new material to make tools out of. Using EnumHelper to construct it, give the 1. Material name, 
	 * 2. Harvest level (1 to 3), 3. uses until it breaks, 4. strength against blocks (followed by a decimal and "F"), 5. Damage to entities (also a float),
	 * 6. How well the item responds to enchantments (1-100).
	 */
	
	public static final ItemArmor.ArmorMaterial brian_armor = EnumHelper.addArmorMaterial("brian_armor", //Name of armor material
																									Reference.MOD_ID + ":"+"armor_brian_tex",  //Name of texture for material
																									2000, //How durable the armor material is (diamond is 33), how many hits it takes before breaking
																									new int[]{10, 10, 10, 10}, //Resisting damage for different parts 1. head, 2. chest, 3. legs, 4. boots
																																//Number is half hearts you do not lose when hit in that spot
																									25, //Enchantability of the material, this is the same as gold
																									SoundEvents.ITEM_ARMOR_EQUIP_GOLD, //When equipped sounds like gold
																									2.5F //Slightly tougher than diamond
																									);
	
	public static void init()
	{
		//Initialize items with class
		brian_wrench = new ItemToolItem(ModItems.brian_material).setUnlocalizedName("brian_wrench").setRegistryName("item_brian_wrench");
		
		brian_face = new ItemBrian();
		//Any item will have to be initialized here like above. This explains that your item has its own class.
		
		brian_jerky = new ItemBrianJerky(); 
		raw_brian = new ItemFood(2, 1.0F, true).setUnlocalizedName("raw_brian").setRegistryName("item_raw_brian").setCreativeTab(CreativeTabs.FOOD);
		brian_poo = new Item().setUnlocalizedName("brian_poo").setRegistryName("item_brian_poo").setCreativeTab(CreativeTabs.BREWING);
		//This is a food item. Create it's class extending ItemFood instead of Item.

		brapple = new ItemFood(4, 2.1F, false).setUnlocalizedName("brapple").setRegistryName("item_brapple").setCreativeTab(CreativeTabs.FOOD);
		
		brian_helmet = new ItemBrianArmor(brian_armor, 1, EntityEquipmentSlot.HEAD).setUnlocalizedName("brian_helmet").setRegistryName("item_brian_helmet"); 
		//When calling the ItemBrianArmor class you put the material name and body location in the parentheses.
		//This is a new helmet made out of the armor material made above.
		//Go to the Reference class and add MATERIAL_HELMET to your register and unlocalized name making method.
		//The number you see in the parentheses "1" for material_helmet is the texture layer. Set it for 1 for every piece of armor except the leggings, which should be set at 2.
		
		brian_chestplate = new ItemBrianArmor(brian_armor, 1, EntityEquipmentSlot.CHEST).setUnlocalizedName("brian_chestplate").setRegistryName("item_brian_chestplate");
		brian_leggings = new ItemBrianArmor(brian_armor, 2 /*notice leggings are different here*/, EntityEquipmentSlot.LEGS).setUnlocalizedName("brian_leggings").setRegistryName("item_brian_leggings"); 
		brian_boots = new ItemBrianArmor(brian_armor, 1, EntityEquipmentSlot.FEET).setUnlocalizedName("brian_boots").setRegistryName("item_brian_boots"); 
		
		//Tools and Weapons
		brian_pickaxe = new ItemBrianPickaxe().setRegistryName("item_brian_pickaxe");
		brian_hoe = new ItemHoe(ModItems.brian_material).setRegistryName("item_brian_hoe").setUnlocalizedName("item_brian_hoe").setCreativeTab(CreativeTabs.TOOLS);
		brian_axe = new ItemBrianAxe(ModItems.brian_material).setUnlocalizedName("brian_axe").setRegistryName("item_brian_axe").setCreativeTab(CreativeTabs.TOOLS);
		brian_shovel = new ItemSpade(ModItems.brian_material).setUnlocalizedName("brian_shovel").setRegistryName("item_brian_shovel").setCreativeTab(CreativeTabs.TOOLS);
		brian_wrench = new ItemBrianWrench();
		brianade = new ItemBrianade().setUnlocalizedName("brianade").setRegistryName("item_brianade").setCreativeTab(CreativeTabs.COMBAT);
	}

	public static void register()
	{
		//Register items with forge
		GameRegistry.register(brian_face);
		GameRegistry.register(brian_jerky);
		GameRegistry.register(brian_helmet);
		GameRegistry.register(brian_chestplate);
		GameRegistry.register(brian_leggings);
		GameRegistry.register(brian_boots);
		GameRegistry.register(raw_brian);
		GameRegistry.register(brian_pickaxe);
		GameRegistry.register(brian_wrench);
		GameRegistry.register(brian_hoe);
		GameRegistry.register(brian_axe);
		GameRegistry.register(brian_shovel);
		GameRegistry.register(brapple);
		GameRegistry.register(brian_poo);
		GameRegistry.register(brianade);
	}

	public static void registerRenders()
	{
		//List of items calling the registerRender method
		registerRender(brian_face);
		registerRender(brian_jerky);
		registerRender(brian_helmet);
		registerRender(brian_chestplate);
		registerRender(brian_leggings);
		registerRender(brian_boots);
		registerRender(raw_brian);
		registerRender(brian_shovel);
		registerRender(brian_axe);
		registerRender(brian_pickaxe);
		registerRender(brian_hoe);
		registerRender(brian_wrench);
		registerRender(brapple);
		registerRender(brian_poo);
		registerRender(brianade);
	}

	private static void registerRender(Item item)
	{
		//Method used to register item with texture
		//There is no need to add to this method
		Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(item, 0, new ModelResourceLocation(item.getRegistryName(), "inventory"));
	}
}