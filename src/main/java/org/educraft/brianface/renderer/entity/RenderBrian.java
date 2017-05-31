package org.educraft.brianface.renderer.entity;

import net.minecraft.client.model.ModelCow;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.entity.passive.EntityCow;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import org.educraft.brianface.entityclasses.EntityBrian;
import org.educraft.brianface.modelclasses.ModelBrian;

import javax.annotation.Nullable;

@SideOnly(Side.CLIENT)
public class RenderBrian extends RenderLiving<EntityBrian>
{
    private static final ResourceLocation BRIAN_TEXTURES = new ResourceLocation("bm:textures/entity/brian/brian.png");

    public RenderBrian(RenderManager p_i47210_1_)
    {
        super(p_i47210_1_, new ModelBrian(), 0.7F);
    }

    @Nullable
    @Override
    protected ResourceLocation getEntityTexture(EntityBrian entity) {
        return BRIAN_TEXTURES;
    }
}