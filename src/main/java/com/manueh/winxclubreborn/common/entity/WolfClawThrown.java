package com.manueh.winxclubreborn.common.entity;

import com.manueh.winxclubreborn.core.init.Registration;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.projectile.ProjectileItemEntity;
import net.minecraft.item.Item;
import net.minecraft.particles.ItemParticleData;
import net.minecraft.particles.ParticleTypes;
import net.minecraft.util.DamageSource;
import net.minecraft.util.math.EntityRayTraceResult;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.World;

public class WolfClawThrown extends ProjectileItemEntity {


    public WolfClawThrown(EntityType<? extends ProjectileItemEntity> p_37432_, World world) {
        super(p_37432_, world);
    }

    public WolfClawThrown(LivingEntity entity, World world) {
        super(Registration.WOLF_CLAW_ENTITY.get(), entity, world);
    }

    public WolfClawThrown(double x, double y, double z, World world) {
        super(Registration.WOLF_CLAW_ENTITY.get(), x, y, z, world);
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

            //this.level.explode(this, this.getX(), this.getY(0.0625D), this.getZ(), 4.0F, Explosion.Mode.BREAK);

            this.level.broadcastEntityEvent(this, (byte)3);
            this.remove();
        }



    }

    protected void onHitEntity(EntityRayTraceResult p_37259_) {
        p_37259_.getEntity().hurt(new DamageSource("wolf_claw"), 10F);
    }

    @Override
    protected Item getDefaultItem() {
        return Registration.WOLF_CLAW.get().asItem();
    }
}
