package org.educraft.brianface.init;

import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.fml.common.registry.EntityRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import org.educraft.brianface.Main;
import org.educraft.brianface.entityclasses.EntityBrianade;
import org.educraft.brianface.renderer.entity.RenderBrianade;

public class ModEntities {

    @SideOnly(Side.CLIENT)
    public static void init() {


        EntityRegistry.registerModEntity(new ResourceLocation("brianface:brianade"), EntityBrianade.class, "brianade", 0, Main.instance, 64, 80, true);
    }

    public static void initModels(){

        RenderingRegistry.registerEntityRenderingHandler(EntityBrianade.class, RenderBrianade.FACTORY);

    }

}