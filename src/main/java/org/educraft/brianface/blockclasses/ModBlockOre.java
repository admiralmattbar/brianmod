package org.educraft.brianface.blockclasses;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;

public class ModBlockOre extends Block {
	
	//Fields for blocks that drop things
	private Block drop;
	private int meta;
	private int least_quantity;
	private int most_quantity;
	private String harvest_level;
	private int harvest_challenge;
	private float hardness;
	private float resistance;
	
	protected ModBlockOre(String unlocalizedName, String registryName, Material mat, Block drop, int meta, int least_quantity, int most_quantity, String harvest_level, int harvest_challenge, float hardness, float resistance) {
		super(mat);
		setHarvestLevel(harvest_level, harvest_challenge);
		setHardness(hardness);
		setResistance(resistance);
		setUnlocalizedName(unlocalizedName);
		setRegistryName(registryName);
		setCreativeTab(CreativeTabs.BUILDING_BLOCKS);
		
		//Setting the fields for blocks that drop things
		this.drop = drop;
		this.meta = meta;
		this.least_quantity = least_quantity;
		this.most_quantity = most_quantity;
		//this.harvest_level = harvest_level;
		//this.harvest_challenge = harvest_challenge;
		//this.hardness = hardness;
		//this.resistance = resistance;
		
	}
	
	public ModBlockOre(String unlocalizedName, String registryName, Material mat, Block drop, int least_quantity, int most_quantity, String harvest_level, int harvest_challenge, float hardness, float resistance) {
		this(unlocalizedName, registryName, mat, drop, 0, least_quantity, most_quantity, harvest_level, harvest_challenge, hardness, resistance);
	}
	
	protected ModBlockOre(String unlocalizedName, String registryName, Material mat, Block drop, String harvest_level, int harvest_challenge, float hardness, float resistance) {
		this(unlocalizedName, registryName, mat, drop, 1, 1, harvest_level, harvest_challenge, hardness, resistance);
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
