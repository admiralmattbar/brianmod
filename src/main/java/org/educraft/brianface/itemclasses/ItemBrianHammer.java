package org.educraft.brianface.itemclasses;

import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.world.World;
import org.educraft.brianface.init.ModItems;

public class ItemBrianHammer extends Item {

    ToolMaterial materialIn;

    public ItemBrianHammer() {

        this.setUnlocalizedName("brian_hammer");
        this.setRegistryName("item_brian_hammer");
        this.setCreativeTab(CreativeTabs.TOOLS);
        this.setMaxDamage(100);
    }


    @Override
    public ActionResult<ItemStack> onItemRightClick(World worldIn, EntityPlayer playerIn, EnumHand handIn) {

        ItemStack stack = this.findAmmo(playerIn);
        ItemStack item;
        item = playerIn.getHeldItem(handIn);
        if(stack != ItemStack.EMPTY || playerIn.capabilities.isCreativeMode)
        {

            item.damageItem(1, playerIn);

            if(!worldIn.isRemote)
            {
                EntityItem copper_dust = new EntityItem(worldIn, playerIn.posX, playerIn.posY, playerIn.posZ, new ItemStack(ModItems.copper_dust));
                copper_dust.setNoPickupDelay();
                worldIn.spawnEntity(copper_dust);
            }

            if(!playerIn.capabilities.isCreativeMode)
            {


                stack.shrink(1);
                if(stack.isEmpty())
                {
                    playerIn.inventory.deleteStack(stack);
                }
            }
        }

        return super.onItemRightClick(worldIn, playerIn, handIn);
    }

    private ItemStack findAmmo(EntityPlayer player)
    {
        if(this.isAmmo(player.getHeldItem(EnumHand.OFF_HAND)))
        {
            return player.getHeldItem(EnumHand.OFF_HAND);
        }
        else if (this.isAmmo(player.getHeldItem(EnumHand.MAIN_HAND)))
        {
            return player.getHeldItem(EnumHand.MAIN_HAND);
        }
        else
        {
            for (int i = 0; i < player.inventory.getSizeInventory(); ++i)
            {
                ItemStack itemstack = player.inventory.getStackInSlot(i);

                if(this.isAmmo(itemstack))
                {
                    return itemstack;
                }
            }

            return ItemStack.EMPTY;
        }
    }

    protected boolean isAmmo(ItemStack stack)
    {
        return stack.getItem() == ModItems.copper_ingot;
    }



}
