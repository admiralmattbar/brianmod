package org.educraft.brianface.worldgenerator;

import java.util.Random;

//import org.educraft.brianface.init.ModBlocks;

import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenerator;

public class WorldGenBrianBushes extends WorldGenerator{
	static BlockPos bushPos;
	public boolean generate(World worldIn, Random rand, BlockPos pos) {
		//Pick between jerkied bush and empty bush. Random boolean in ternary, true and full, false and empty.
		//Block brian_bush = rand.nextBoolean() ? ModBlocks.brian_bush_full : ModBlocks.brian_bush_empty;
		int y = 1 + getGroundFromAbove(worldIn, pos.getX(), pos.getZ());
		//debug option:
		System.out.println("Y ground = " + y + "at (" + pos.getX() + ", " + pos.getZ() + ")");
		//Use the calculated y value as the minimum spawn height to make sure it spawns above ground
		if(y >= pos.getY()){
			bushPos = new BlockPos(pos.getX(), y, pos.getZ());
		}
		//Make sure it only replaces air
		Block toReplace = worldIn.getBlockState(bushPos).getBlock();
		if(toReplace == Blocks.AIR || toReplace == Blocks.GRASS || toReplace == Blocks.TALLGRASS){
			//worldIn.setBlockState(bushPos, brian_bush.getDefaultState(),2);
			System.out.println("placed a brian bush!");
		} else {
			System.out.println("this block is occupied by " + toReplace.getUnlocalizedName());
		}
		return false;
	}
	
	//Make sure bush is placed on grass or dirt.
	public static int getGroundFromAbove(World world, int x, int z){
		int y = 255;
		boolean foundGround = false;
		while(!foundGround && y-- >= 0){
			Block blockAt = world.getBlockState(new BlockPos(x,y,z)).getBlock();
			//We consider dirt or grass the ground
			foundGround = blockAt == Blocks.DIRT || blockAt == Blocks.GRASS;
		}
		return y;
	}

}
