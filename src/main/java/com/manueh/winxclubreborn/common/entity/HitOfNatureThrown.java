package com.manueh.winxclubreborn.common.entity;

import com.manueh.winxclubreborn.core.init.Registration;
import net.minecraft.block.Blocks;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.projectile.ProjectileItemEntity;
import net.minecraft.item.Item;
import net.minecraft.particles.ItemParticleData;
import net.minecraft.particles.ParticleTypes;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.World;

public class HitOfNatureThrown extends ProjectileItemEntity {


    public HitOfNatureThrown(EntityType<? extends ProjectileItemEntity> p_37432_, World world) {
        super(p_37432_, world);
    }

    public HitOfNatureThrown(LivingEntity entity, World world) {
        super(Registration.HIT_OF_NATURE_ENTITY.get(), entity, world);
    }

    public HitOfNatureThrown(double x, double y, double z, World world) {
        super(Registration.HIT_OF_NATURE_ENTITY.get(), x, y, z, world);
    }


    public void handleEntityEvent(byte p_37484_) {
        if (p_37484_ == 3) {
            double var2 = 0.08D;

            for(int var4 = 0; var4 < 8; ++var4) {
                this.level.addParticle(new ItemParticleData(ParticleTypes.ITEM, this.getItem()), this.getX(), this.getY(), this.getZ(), ((double)this.random.nextFloat() - 0.5D) * 0.08D, ((double)this.random.nextFloat() - 0.5D) * 0.08D, ((double)this.random.nextFloat() - 0.5D) * 0.08D);
            }
        }

    }


    protected void onHit(RayTraceResult hit) {
        super.onHit(hit);
        if (!this.level.isClientSide) {
            level.setBlockAndUpdate(new BlockPos(hit.getLocation()), Blocks.SPRUCE_LOG.defaultBlockState());
            level.setBlockAndUpdate(new BlockPos(hit.getLocation().add(0, 1, 0)), Blocks.SPRUCE_LOG.defaultBlockState());
            level.setBlockAndUpdate(new BlockPos(hit.getLocation().add(0, 2, 0)), Blocks.SPRUCE_LOG.defaultBlockState());
            level.setBlockAndUpdate(new BlockPos(hit.getLocation().add(0, 3, 0)), Blocks.SPRUCE_LOG.defaultBlockState());
            level.setBlockAndUpdate(new BlockPos(hit.getLocation().add(1, 3, 0)), Blocks.SPRUCE_LEAVES.defaultBlockState());
            level.setBlockAndUpdate(new BlockPos(hit.getLocation().add(1, 3, 1)), Blocks.SPRUCE_LEAVES.defaultBlockState());
            level.setBlockAndUpdate(new BlockPos(hit.getLocation().add(1, 3, -1)), Blocks.SPRUCE_LEAVES.defaultBlockState());
            level.setBlockAndUpdate(new BlockPos(hit.getLocation().add(-1, 3, 0)), Blocks.SPRUCE_LEAVES.defaultBlockState());
            level.setBlockAndUpdate(new BlockPos(hit.getLocation().add(-1, 3, 1)), Blocks.SPRUCE_LEAVES.defaultBlockState());
            level.setBlockAndUpdate(new BlockPos(hit.getLocation().add(-1, 3, -1)), Blocks.SPRUCE_LEAVES.defaultBlockState());
            level.setBlockAndUpdate(new BlockPos(hit.getLocation().add(0, 3, 1)), Blocks.SPRUCE_LEAVES.defaultBlockState());
            level.setBlockAndUpdate(new BlockPos(hit.getLocation().add(0, 3, -1)), Blocks.SPRUCE_LEAVES.defaultBlockState());
            level.setBlockAndUpdate(new BlockPos(hit.getLocation().add(0, 4, 0)), Blocks.SPRUCE_LEAVES.defaultBlockState());
            level.setBlockAndUpdate(new BlockPos(hit.getLocation().add(0, 4, 0)), Blocks.SPRUCE_LEAVES.defaultBlockState());

            this.level.broadcastEntityEvent(this, (byte)3);
            this.remove();
        }

    }
    @Override
    protected Item getDefaultItem() {
        return Registration.HIT_OF_NATURE.get().asItem();
    }
}
