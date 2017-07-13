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
import org.educraft.brianface.init.ModBlocks;
import org.educraft.brianface.init.ModItems;

public class ClientProxy implements ICommonProxy {

	@Override
	public void preInit(FMLPreInitializationEvent event){

		//ModEntities.initModels();

		/*
		RenderingRegistry.registerEntityRenderingHandler(EntityBrian.class, new IRenderFactory<EntityBrian>() {
			@Override
			public Render<? super EntityBrian> createRenderFor(RenderManager manager) {
				return new RenderBrian(manager, new ModelBrian(), 0.5F);
			}
		});
		*/


	}

	@Override
	public void init(FMLInitializationEvent event) {
		ModItems.registerRenders();
		ModBlocks.registerRenders();

	}

	@Override
	public void postInit(FMLPostInitializationEvent event) {

	}

}