package org.educraft.brianface.blockclasses;

import org.educraft.brianface.init.ModBlocks;
//import org.educraft.brianface.init.ModBlocks;
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
	
	public boolean onBlockActivated(World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn, EnumFacing side, float hitX, float hitY, float hitZ){
		
		//This makes it work on server side.
		if(!worldIn.isRemote)
		{
			
			return true;
		}
		else
		{
			EntityItem brian_jerky = new EntityItem(worldIn, playerIn.posX, playerIn.posY, playerIn.posZ, new ItemStack(ModItems.brian_jerky));
			brian_jerky.setNoPickupDelay();
			worldIn.spawnEntity(brian_jerky);
			
			//Now the bush has no more jerky
			worldIn.setBlockState(pos, ModBlocks.brian_bush_empty.getDefaultState(), 2);
			
			return true;
		}
		
	}
}
