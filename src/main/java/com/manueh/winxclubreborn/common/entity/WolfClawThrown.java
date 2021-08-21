package com.manueh.winxclubreborn.common.entity;

import com.manueh.winxclubreborn.core.init.Registration;
import net.minecraft.core.particles.ItemParticleOption;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.projectile.ThrowableItemProjectile;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.EntityHitResult;
import net.minecraft.world.phys.HitResult;

public class WolfClawThrown extends ThrowableItemProjectile {


    public WolfClawThrown(EntityType<? extends ThrowableItemProjectile> p_37432_, Level world) {
        super(p_37432_, world);
    }

    public WolfClawThrown(LivingEntity entity, Level world) {
        super(Registration.WOLF_CLAW_ENTITY.get(), entity, world);
    }

    public WolfClawThrown(double x, double y, double z, Level world) {
        super(Registration.WOLF_CLAW_ENTITY.get(), x, y, z, world);
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

            //this.level.explode(this, this.getX(), this.getY(0.0625D), this.getZ(), 4.0F, Explosion.BlockInteraction.BREAK);

            this.level.broadcastEntityEvent(this, (byte)3);
            this.discard();
        }



    }

    protected void onHitEntity(EntityHitResult p_37259_) {
        p_37259_.getEntity().hurt(new DamageSource("wolf_claw"), 10F);
    }

    @Override
    protected Item getDefaultItem() {
        return Registration.WOLF_CLAW.get().asItem();
    }
}
