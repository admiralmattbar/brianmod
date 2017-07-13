package org.educraft.brianface.blockclasses;

import java.util.Collection;
import java.util.Random;

import com.google.common.base.Optional;
import net.minecraft.block.properties.IProperty;
import net.minecraft.creativetab.CreativeTabs;
import org.educraft.brianface.init.ModBlocks;


import net.minecraft.block.BlockBush;
import net.minecraft.block.state.IBlockState;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.common.IPlantable;

public class BlockBrianBushEmpty extends BlockBush implements IProperty {
	
	static float f = 0.4F;
	
	private static AxisAlignedBB BOUNDING_BOX = new AxisAlignedBB(0.5F - f, 0.0F, 0.5F - f, 0.5F + f, 0.5F + f, 0.5F + f);

	private boolean rTick = true;

	public BlockBrianBushEmpty(){
		
		super();
		this.setTickRandomly(rTick); //Random updates to plant
		this.setSoundType(blockSoundType);
		setCreativeTab(CreativeTabs.DECORATIONS);
	}
	
	public boolean isFullCube(IBlockState state){
		return false;
	}
	
	public boolean isOpaqueCube(IBlockState state){
		return false;
	}
	
	@Override
	public AxisAlignedBB getBoundingBox(IBlockState state, IBlockAccess source, BlockPos pos){
		return BOUNDING_BOX;
	}
	
	@Override
	public void randomTick(World worldIn, BlockPos pos, IBlockState state, Random rand){
		super.randomTick(worldIn,  pos,  state,  rand);
		//Makes sure it grows 30% of the ticks
		final int GROW_CHANCE = 30;
		if(rand.nextInt(100) < GROW_CHANCE){
			worldIn.setBlockState(pos, ModBlocks.brian_bush_full.getDefaultState());
			rTick = false;
		}
	}

	@Override
	public String getName() {
		return null;
	}

	@Override
	public Collection getAllowedValues() {
		return null;
	}

	@Override
	public Class getValueClass() {
		return null;
	}

	@Override
	public Optional parseValue(String value) {
		return null;
	}

	@Override
	public String getName(Comparable value) {
		return null;
	}
}
