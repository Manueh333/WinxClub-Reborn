package com.manueh.winxclubreborn.common.entity;

import com.manueh.winxclubreborn.core.init.Registration;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ItemParticleOption;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.projectile.ThrowableItemProjectile;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.phys.HitResult;

public class HitOfNatureThrown extends ThrowableItemProjectile {


    public HitOfNatureThrown(EntityType<? extends ThrowableItemProjectile> p_37432_, Level world) {
        super(p_37432_, world);
    }

    public HitOfNatureThrown(LivingEntity entity, Level world) {
        super(Registration.HIT_OF_NATURE_ENTITY.get(), entity, world);
    }

    public HitOfNatureThrown(double x, double y, double z, Level world) {
        super(Registration.HIT_OF_NATURE_ENTITY.get(), x, y, z, world);
    }


    public void handleEntityEvent(byte p_37484_) {
        if (p_37484_ == 3) {
            double var2 = 0.08D;

            for(int var4 = 0; var4 < 8; ++var4) {
                this.level.addParticle(new ItemParticleOption(ParticleTypes.ITEM, this.getItem()), this.getX(), this.getY(), this.getZ(), ((double)this.random.nextFloat() - 0.5D) * 0.08D, ((double)this.random.nextFloat() - 0.5D) * 0.08D, ((double)this.random.nextFloat() - 0.5D) * 0.08D);
            }
        }

    }


    protected void onHit(HitResult hit) {
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
            this.discard();
        }

    }
    @Override
    protected Item getDefaultItem() {
        return Registration.HIT_OF_NATURE.get().asItem();
    }
}
