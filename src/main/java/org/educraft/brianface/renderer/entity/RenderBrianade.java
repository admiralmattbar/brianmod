package org.educraft.brianface.renderer.entity;

import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.client.registry.IRenderFactory;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import org.educraft.brianface.Reference;
import org.educraft.brianface.entityclasses.EntityBrianade;

import javax.annotation.Nullable;

@SideOnly(Side.CLIENT)
public class RenderBrianade<T extends EntityBrianade> extends Render<T> {

    private static ResourceLocation BRIANADE_TEXTURE = new ResourceLocation(Reference.MOD_ID+":textures/entity/brianade/brianade.png");

    public static final Factory FACTORY = new Factory();

    public RenderBrianade(RenderManager renderManagerIn) {
        super(renderManagerIn);
    }

    @Nullable
    @Override
    protected ResourceLocation getEntityTexture(EntityBrianade entity) {
        return BRIANADE_TEXTURE;
    }

    public static class Factory implements IRenderFactory<EntityBrianade> {

        @Override
        public Render<? super EntityBrianade> createRenderFor(RenderManager manager){

            return new RenderBrianade(manager);

        }

    }

}
