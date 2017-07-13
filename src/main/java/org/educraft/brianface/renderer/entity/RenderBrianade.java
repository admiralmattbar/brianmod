package org.educraft.brianface.renderer.entity;

import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.RenderItem;
import net.minecraft.client.renderer.block.model.ItemCameraTransforms;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.client.renderer.entity.RenderSnowball;
import net.minecraft.client.renderer.texture.TextureMap;
import net.minecraft.entity.Entity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import org.educraft.brianface.Reference;

@SideOnly(Side.CLIENT)
public class RenderBrianade extends RenderSnowball{

    private static ResourceLocation BRIANADE_TEXTURE = new ResourceLocation(Reference.MOD_ID+"textures/entity/brianade/brianade.png");

    public RenderBrianade(RenderManager renderManagerIn, Item itemIn, RenderItem itemRendererIn) {
        super(renderManagerIn, itemIn, itemRendererIn);
    }

    protected ResourceLocation getEntityTexture(Entity entity)
    {
        return BRIANADE_TEXTURE;
    }
}
