/* 
 * This class covers your textures when you are running the client version of Minecraft. Your textures will not render on a server 
 * because they simply do not do that.
 */

package org.educraft.brianface.proxy;

import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraftforge.fml.client.registry.IRenderFactory;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import org.educraft.brianface.Reference;
import org.educraft.brianface.entityclasses.EntityBrianade;
import org.educraft.brianface.init.ModBlocks;
import org.educraft.brianface.init.ModEntities;
import org.educraft.brianface.init.ModItems;
import org.educraft.brianface.renderer.entity.RenderBrianade;

public class ClientProxy implements ICommonProxy {

	@Override
	public void preInit(FMLPreInitializationEvent event){

		ModEntities.initModels();
		//RenderingRegistry.registerEntityRenderingHandler(EntityBrianade.class, new RenderBrianade(Reference.MOD_ID.brianade));
		//RenderingRegistry.registerEntityRenderingHandler(EntityBrianade.class, RenderBrianade.FACTORY);

	}

	@Override
	public void init(FMLInitializationEvent event) {
		ModItems.registerRenders();
		ModBlocks.registerRenders();
		RenderingRegistry.registerEntityRenderingHandler(EntityBrianade.class, RenderBrianade.FACTORY);

	}

	@Override
	public void postInit(FMLPostInitializationEvent event) {

	}

}