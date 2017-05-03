/*
 * This is the main class for the mod. All of the things you make have to be initialized and registered here. This also
 * helps you with your proxy settings so that you do not crash the game when you run a server with this mod.
 */

package org.educraft.brianface;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.Mod.Instance;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;

import org.educraft.brianface.init.ModBlocks;
import org.educraft.brianface.init.ModCrafting;
import org.educraft.brianface.init.ModItems;
import org.educraft.brianface.proxy.CommonProxy;
import org.educraft.brianface.worldgenerator.ModWorldGen;

@Mod(modid = Reference.MOD_ID, name = Reference.NAME, version = Reference.VERSION, acceptedMinecraftVersions = Reference.ACCEPTED_VERSIONS)
public class Main 
{
	@Instance
	public static Main instance;
	
	@SidedProxy(clientSide = Reference.CLIENT_PROXY_CLASS, serverSide = Reference.SERVER_PROXY_CLASS)
	public static CommonProxy proxy;

	@EventHandler
	public void preInit(FMLPreInitializationEvent event) 
	{
		System.out.println("PreInit Test");
		
		ModItems.init();
		ModItems.register();

		ModBlocks.init();
		ModBlocks.register();
		
		//MaterialGenerator.register();
	}
	
	@EventHandler
	public void init(FMLInitializationEvent event) 
	{
		System.out.println("Init Test");
		proxy.init();
		
		ModCrafting.register();
		
		GameRegistry.registerWorldGenerator(new ModWorldGen(), 0);
	}
	
	@EventHandler
	public void postInit(FMLPostInitializationEvent event) 
	{
		System.out.println("PostInit Test");
	}

}