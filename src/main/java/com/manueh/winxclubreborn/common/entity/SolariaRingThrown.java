package com.manueh.winxclubreborn.common.entity;

import com.manueh.winxclubreborn.core.init.Registration;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.LightningBoltEntity;
import net.minecraft.entity.projectile.ProjectileItemEntity;
import net.minecraft.item.Item;
import net.minecraft.particles.ItemParticleData;
import net.minecraft.particles.ParticleTypes;
import net.minecraft.util.DamageSource;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.Explosion;
import net.minecraft.world.ExplosionContext;
import net.minecraft.world.World;

public class SolariaRingThrown extends ProjectileItemEntity {


    public SolariaRingThrown(EntityType<? extends ProjectileItemEntity> p_37432_, World world) {
        super(p_37432_, world);
    }

    public SolariaRingThrown(LivingEntity entity, World world) {
        super(Registration.SOLARIA_RING_ENTITY.get(), entity, world);
    }

    public SolariaRingThrown(double x, double y, double z, World world) {
        super(Registration.SOLARIA_RING_ENTITY.get(), x, y, z, world);
    }


    public void handleEntityEvent(byte p_37484_) {
        if (p_37484_ == 3) {
            double var2 = 0.08D;

            for(int var4 = 0; var4 < 8; ++var4) {
                this.level.addParticle(new ItemParticleData(ParticleTypes.ITEM, this.getItem()), this.getX(), this.getY(), this.getZ(), ((double)this.random.nextFloat() - 0.5D) * 0.08D, ((double)this.random.nextFloat() - 0.5D) * 0.08D, ((double)this.random.nextFloat() - 0.5D) * 0.08D);
            }
        }

    }


    protected void onHit(RayTraceResult p_37488_) {
        super.onHit(p_37488_);
        if (!this.level.isClientSide) {
            float var1 = 4.0F;
            this.level.explode(this, new DamageSource("solaria_ring"), (ExplosionContext) null,(double) this.getX(), (double)this.getY(0.0625D), (double) this.getZ(), 1.5F, true, Explosion.Mode.NONE);
            LightningBoltEntity bolt = new LightningBoltEntity(EntityType.LIGHTNING_BOLT, level);
            bolt.setPos(this.getX(), this.getY(), this.getZ());
            this.level.addFreshEntity(bolt);
            LightningBoltEntity bolt1 = new LightningBoltEntity(EntityType.LIGHTNING_BOLT, level);
            bolt1.setPos(this.getX()+1, this.getY(), this.getZ());
            this.level.addFreshEntity(bolt1);
            LightningBoltEntity bolt2 = new LightningBoltEntity(EntityType.LIGHTNING_BOLT, level);
            bolt2.setPos(this.getX()-1, this.getY(), this.getZ());
            this.level.addFreshEntity(bolt2);
            LightningBoltEntity bolt3 = new LightningBoltEntity(EntityType.LIGHTNING_BOLT, level);
            bolt3.setPos(this.getX(), this.getY(), this.getZ()+1);
            this.level.addFreshEntity(bolt3);
            LightningBoltEntity bolt4 = new LightningBoltEntity(EntityType.LIGHTNING_BOLT, level);
            bolt4.setPos(this.getX(), this.getY(), this.getZ()-1);
            this.level.addFreshEntity(bolt4);
            LightningBoltEntity bolt5 = new LightningBoltEntity(EntityType.LIGHTNING_BOLT, level);
            bolt5.setPos(this.getX()+1, this.getY(), this.getZ()+1);
            this.level.addFreshEntity(bolt5);
            LightningBoltEntity bolt6 = new LightningBoltEntity(EntityType.LIGHTNING_BOLT, level);
            bolt6.setPos(this.getX()-1, this.getY(), this.getZ()+1);
            this.level.addFreshEntity(bolt6);
            LightningBoltEntity bolt7 = new LightningBoltEntity(EntityType.LIGHTNING_BOLT, level);
            bolt7.setPos(this.getX()+1, this.getY(), this.getZ()-1);
            this.level.addFreshEntity(bolt7);
            LightningBoltEntity bolt8 = new LightningBoltEntity(EntityType.LIGHTNING_BOLT, level);
            bolt8.setPos(this.getX()-1, this.getY(), this.getZ()-1);
            this.level.addFreshEntity(bolt8);
            this.level.broadcastEntityEvent(this, (byte)3);

            this.remove();
        }

    }
    @Override
    protected Item getDefaultItem() {
        return Registration.SOLARIA_RING.get().asItem();
    }
}
