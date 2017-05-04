package org.educraft.brianface.blockclasses;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;

public class BlockBrianOre extends Block {
	
	//Fields for blocks that drop things
	private Block drop;
	private int meta;
	private int least_quantity;
	private int most_quantity;
	
	protected BlockBrianOre(Block drop, int meta) {
		super(Material.ROCK);
		setHarvestLevel("pickaxe", 1);
		setHardness(5.0F);
		setResistance(7.0F);
		setUnlocalizedName("brian_ore");
		setRegistryName("block_brian_ore");
		setCreativeTab(CreativeTabs.BUILDING_BLOCKS);
		
		//Setting the fields for blocks that drop things
		this.drop = drop;
		this.meta = meta;
		this.least_quantity = 1;
		this.most_quantity = 1;
		
	}
	
	public BlockBrianOre(Block drop, int least_quantity, int most_quantity) {
		this(drop, 0);
	}
	
	protected BlockBrianOre(Block drop) {
		this(drop, 1, 1);
	}
	
	public Block getBlockDropped(IBlockState blockstate, Random random, int fortune) {
		return this.drop;
	}
	
	@Override
	public int damageDropped(IBlockState blockstate) {
		return this.meta;
	}
	
	@Override
	public int quantityDropped(IBlockState blockstate, int fortune, Random random) {
		if(this.least_quantity >= this.most_quantity){
			return this.least_quantity;
		}
		
		return this.least_quantity + random.nextInt(this.most_quantity - this.least_quantity + fortune + 1);
	}

}
