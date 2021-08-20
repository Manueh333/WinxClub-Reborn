package com.manueh.winxclubreborn.common.entity;

import com.manueh.winxclubreborn.core.init.Registration;
import net.minecraft.core.particles.ItemParticleOption;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LightningBolt;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.projectile.ThrowableItemProjectile;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Explosion;
import net.minecraft.world.level.ExplosionDamageCalculator;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.HitResult;

public class SolariaRingThrown extends ThrowableItemProjectile {


    public SolariaRingThrown(EntityType<? extends ThrowableItemProjectile> p_37432_, Level world) {
        super(p_37432_, world);
    }

    public SolariaRingThrown(LivingEntity entity, Level world) {
        super(Registration.SOLARIA_RING_ENTITY.get(), entity, world);
    }

    public SolariaRingThrown(double x, double y, double z, Level world) {
        super(Registration.SOLARIA_RING_ENTITY.get(), x, y, z, world);
    }


    public void handleEntityEvent(byte p_37484_) {
        if (p_37484_ == 3) {
            double var2 = 0.08D;

            for(int var4 = 0; var4 < 8; ++var4) {
                this.level.addParticle(new ItemParticleOption(ParticleTypes.ITEM, this.getItem()), this.getX(), this.getY(), this.getZ(), ((double)this.random.nextFloat() - 0.5D) * 0.08D, ((double)this.random.nextFloat() - 0.5D) * 0.08D, ((double)this.random.nextFloat() - 0.5D) * 0.08D);
            }
        }

    }


    protected void onHit(HitResult p_37488_) {
        super.onHit(p_37488_);
        if (!this.level.isClientSide) {
            float var1 = 4.0F;
            this.level.explode(this, new DamageSource("solaria_ring"), (ExplosionDamageCalculator) null,(double) this.getX(), (double)this.getY(0.0625D), (double) this.getZ(), 1.5F, true, Explosion.BlockInteraction.NONE);
            LightningBolt bolt = new LightningBolt(EntityType.LIGHTNING_BOLT, level);
            bolt.setPos(this.getX(), this.getY(), this.getZ());
            this.level.addFreshEntity(bolt);
            LightningBolt bolt1 = new LightningBolt(EntityType.LIGHTNING_BOLT, level);
            bolt1.setPos(this.getX()+1, this.getY(), this.getZ());
            this.level.addFreshEntity(bolt1);
            LightningBolt bolt2 = new LightningBolt(EntityType.LIGHTNING_BOLT, level);
            bolt2.setPos(this.getX()-1, this.getY(), this.getZ());
            this.level.addFreshEntity(bolt2);
            LightningBolt bolt3 = new LightningBolt(EntityType.LIGHTNING_BOLT, level);
            bolt3.setPos(this.getX(), this.getY(), this.getZ()+1);
            this.level.addFreshEntity(bolt3);
            LightningBolt bolt4 = new LightningBolt(EntityType.LIGHTNING_BOLT, level);
            bolt4.setPos(this.getX(), this.getY(), this.getZ()-1);
            this.level.addFreshEntity(bolt4);
            LightningBolt bolt5 = new LightningBolt(EntityType.LIGHTNING_BOLT, level);
            bolt5.setPos(this.getX()+1, this.getY(), this.getZ()+1);
            this.level.addFreshEntity(bolt5);
            LightningBolt bolt6 = new LightningBolt(EntityType.LIGHTNING_BOLT, level);
            bolt6.setPos(this.getX()-1, this.getY(), this.getZ()+1);
            this.level.addFreshEntity(bolt6);
            LightningBolt bolt7 = new LightningBolt(EntityType.LIGHTNING_BOLT, level);
            bolt7.setPos(this.getX()+1, this.getY(), this.getZ()-1);
            this.level.addFreshEntity(bolt7);
            LightningBolt bolt8 = new LightningBolt(EntityType.LIGHTNING_BOLT, level);
            bolt8.setPos(this.getX()-1, this.getY(), this.getZ()-1);
            this.level.addFreshEntity(bolt8);
            this.level.broadcastEntityEvent(this, (byte)3);

            this.discard();
        }

    }
    @Override
    protected Item getDefaultItem() {
        return Registration.SOLARIA_RING.get().asItem();
    }
}
