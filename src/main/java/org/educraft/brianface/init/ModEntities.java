package org.educraft.brianface.init;

import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import org.educraft.brianface.entityclasses.EntityBrianade;
import org.educraft.brianface.renderer.entity.RenderBrianade;

public class ModEntities {

    @SideOnly(Side.CLIENT)
    public static void initModels() {

        RenderingRegistry.registerEntityRenderingHandler(EntityBrianade.class, RenderBrianade.Factory.INSTANCE);

    }

}