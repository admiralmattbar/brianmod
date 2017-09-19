package org.educraft.brianface.entityclasses;

import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.projectile.EntityThrowable;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.datafix.DataFixer;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.*;

public class EntityBrianade extends EntityThrowable
{
    private EntityLivingBase throwerIn;
    private int throwerId;


    public EntityBrianade(World worldIn)
    {

        super(worldIn);
    }

    public EntityBrianade(World worldIn, EntityLivingBase throwerIn)
    {

        super(worldIn, throwerIn);
    }

    public EntityBrianade(World worldIn, double x, double y, double z)
    {

        super(worldIn, x, y, z);
    }

    public static void registerFixesBrianade(DataFixer fixer)
    {
        EntityThrowable.registerFixesThrowable(fixer, "Brianade");
    }

    @SideOnly(Side.CLIENT)
    public void handleStatusUpdate(byte id)
    {
        if (id == 3)
        {
            for (int i = 0; i < 8; ++i)
            {
                this.world.spawnParticle(EnumParticleTypes.EXPLOSION_HUGE, this.posX, this.posY, this.posZ, 1.0D, 1.0D, 1.0D, new int[0]);
            }
        }
    }

    @Override
    protected float getGravityVelocity()
    {
        return 0.06F;
    }

    protected void onImpact(RayTraceResult result)
    {

        if (!this.world.isRemote)
        {
            world.createExplosion(result.entityHit, result.hitVec.xCoord, result.hitVec.yCoord, result.hitVec.zCoord, 10f, true);
        }

        this.setDead();


        /*
        Entity target = result.entityHit;



        if (target != null) {
            if (target.getEntityId() == this.throwerIn.getEntityId()) {
                return;
            }

            if(!world.isRemote) {
                world.createExplosion(target, result.hitVec.xCoord, result.hitVec.yCoord, result.hitVec.zCoord, 10f, true);
            }
        }

        if (result.getBlockPos() != null) {
            //BlockPos pos = result.getBlockPos();
            //IBlockState state = world.getBlockState(pos);
            //Block blockIn = state.getBlock();

            if(!world.isRemote) {
                world.createExplosion(target, result.hitVec.xCoord, result.hitVec.yCoord, result.hitVec.zCoord, 10f, true);
            }

        }

        this.setDead();
        */
    }

}