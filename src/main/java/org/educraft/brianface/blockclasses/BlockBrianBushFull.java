package org.educraft.brianface.blockclasses;

import net.minecraft.util.EnumHand;
import org.educraft.brianface.init.ModBlocks;
import org.educraft.brianface.init.ModItems;

import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class BlockBrianBushFull extends BlockBrianBushEmpty {
	public BlockBrianBushFull(){
		super();
		this.setTickRandomly(false); //Stops random growth
	}

	@Override
	public boolean onBlockActivated(World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ) {
        //This makes it work on server side.
        if(worldIn.isRemote) {

            return true;
        }
        else {
            EntityItem brapple = new EntityItem(worldIn, playerIn.posX, playerIn.posY, playerIn.posZ,
                    new ItemStack(ModItems.brapple));
            brapple.setNoPickupDelay();
            worldIn.spawnEntity(brapple);

            //Now the bush has no more jerky
            worldIn.setBlockState(pos, ModBlocks.brian_bush_empty.getDefaultState(), 2);

            return true;
        }
	}

}
