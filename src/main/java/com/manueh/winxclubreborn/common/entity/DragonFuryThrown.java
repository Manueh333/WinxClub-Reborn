package com.manueh.winxclubreborn.common.entity;

import com.manueh.winxclubreborn.core.init.Registration;
import net.minecraft.core.particles.ItemParticleOption;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.projectile.ThrowableItemProjectile;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Explosion;
import net.minecraft.world.level.ExplosionDamageCalculator;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.HitResult;

public class DragonFuryThrown extends ThrowableItemProjectile {

    public DragonFuryThrown(EntityType<? extends ThrowableItemProjectile> p_37432_, Level world) {
        super(p_37432_, world);
    }

    public DragonFuryThrown(LivingEntity entity, Level world) {
        super(Registration.DRAGON_FURY_ENTITY.get(), entity, world);
    }

    public DragonFuryThrown(double x, double y, double z, Level world) {
        super(Registration.DRAGON_FURY_ENTITY.get(), x, y, z, world);
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
            this.level.explode(this, new DamageSource("dragon_fury"), (ExplosionDamageCalculator) null,(double) this.getX(), (double)this.getY(0.0625D), (double) this.getZ(), 4.0F, true, Explosion.BlockInteraction.BREAK);

            this.level.broadcastEntityEvent(this, (byte)3);
            this.discard();
        }

    }
    @Override
    protected Item getDefaultItem() {
        return Registration.DRAGON_FURY.get().asItem();
    }
}
