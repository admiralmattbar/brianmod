package org.educraft.brianface.renderer.entity;

import net.minecraft.client.model.ModelBiped;
import net.minecraft.client.renderer.entity.RenderBiped;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.entity.monster.EntityZombie;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import org.educraft.brianface.entityclasses.EntityBrian;
import org.educraft.brianface.modelclasses.ModelBrian;

@SideOnly(Side.CLIENT)
public class RenderBrian extends RenderBiped<EntityBrian>
{
    private static final ResourceLocation BRIAN_TEXTURES = new ResourceLocation("textures/entity/brian/brian.png");

    public RenderBrian(RenderManager renderManagerIn)
    {
        super(renderManagerIn, new ModelBiped(), 0.5F);
    }

    /**
     * Returns the location of an entity's texture. Doesn't seem to be called unless you call Render.bindEntityTexture.
     */
    protected ResourceLocation getEntityTexture(EntityBrian entity)
    {
        return BRIAN_TEXTURES;
    }
}