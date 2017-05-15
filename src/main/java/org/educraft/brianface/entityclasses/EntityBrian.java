package org.educraft.brianface.entityclasses;

import net.minecraft.block.Block;
import net.minecraft.entity.EntityAgeable;
import net.minecraft.entity.EnumCreatureType;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.*;
import net.minecraft.entity.passive.EntityTameable;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.init.SoundEvents;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.storage.loot.LootTableList;
import net.minecraftforge.fml.common.registry.EntityRegistry;
import org.educraft.brianface.init.ModItems;

import javax.annotation.Nullable;

public class EntityBrian extends EntityTameable {

    int particlecounter;

    public EntityBrian(World world){
        super(world);
        this.setSize(1.4F, 0.9F);
        this.tasks.addTask(0, new EntityAISwimming(this));
        this.tasks.addTask(1, new EntityAISit(this));
        this.tasks.addTask(2, new EntityAIFollowOwner(this, 1.5D, 12.0F, 5F));
        this.tasks.addTask(3, new EntityAITempt(this, 1.0D, ModItems.brapple, false));
        this.tasks.addTask(4, new EntityAIPanic(this, 2.0D));
        this.tasks.addTask(5, new EntityAIMate(this, 1.0D));
        this.tasks.addTask(6, new EntityAITempt(this, 1.25D, Items.WHEAT, false));
        this.tasks.addTask(7, new EntityAIFollowParent(this, 1.25D));
        this.tasks.addTask(8, new EntityAIWanderAvoidWater(this, 1.0D));
        this.tasks.addTask(9, new EntityAIWatchClosest(this, EntityPlayer.class, 6.0F));
        this.tasks.addTask(10, new EntityAILookIdle(this));
        particlecounter = 0;
    }

    public static void RegisterEntity() {
        //EntityRegistry.registerModEntity(EntityBrian.class, "Brian", EntityRegistry.findGlobalUniqueEntityId(), utils.ColorFromRGB(137,91,0), utils));
        EntityRegistry.addSpawn(EntityBrian.class, 25, 1, 5, EnumCreatureType.CREATURE, Biome.);
    }

    protected void applyEntityAttributes()
    {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(10.0D);
        this.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(1.0D);
    }

    protected void entityInit() {
        super.entityInit();
    }

    protected void playStepSound(BlockPos pos, Block blockIn)
    {
        this.playSound(SoundEvents.BLOCK_ANVIL_STEP, 0.15F, 1.0F);
    }

    protected float getSoundVolume()
    {
        return 0.2F;
    }

    /*
    @Nullable
    protected ResourceLocation getLootTable()
    {
        return ModLootTableList.ENTITIES_BRIAN;
    }
    */

    public void writeEntityToNBT(NBTTagCompound tag){
        super.writeEntityToNBT(tag);
    }

    public void readEntityFromNBT(NBTTagCompound tag){
        super.readEntityFromNBT(tag);
    }

    @Nullable
    @Override
    public EntityAgeable createChild(EntityAgeable ageable) {
        return null;
    }
}
