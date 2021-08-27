package com.manueh.winxclubreborn.common.entity;

import com.manueh.winxclubreborn.core.init.Registration;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.projectile.ProjectileItemEntity;
import net.minecraft.item.Item;
import net.minecraft.particles.ItemParticleData;
import net.minecraft.particles.ParticleTypes;
import net.minecraft.util.DamageSource;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.Explosion;
import net.minecraft.world.ExplosionContext;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

public class CompuExplosionThrown extends ProjectileItemEntity {


    public CompuExplosionThrown(EntityType<? extends ProjectileItemEntity> p_37432_, World world) {
        super(p_37432_, world);
    }

    public CompuExplosionThrown(LivingEntity entity, World world) {
        super(/*Registration.COMPU_EXPLOSION_ENTITY.get()*/ EntityType.EGG, entity, world);
    }

    public CompuExplosionThrown(double x, double y, double z, World world) {
        super(Registration.COMPU_EXPLOSION_ENTITY.get(), x, y, z, world);
    }


    @OnlyIn(Dist.CLIENT)
    public void handleEntityEvent(byte p_70103_1_) {
        if (p_70103_1_ == 3) {
            double d0 = 0.08D;

            for(int i = 0; i < 8; ++i) {
                this.level.addParticle(new ItemParticleData(ParticleTypes.ITEM, this.getItem()), this.getX(), this.getY(), this.getZ(), ((double)this.random.nextFloat() - 0.5D) * 0.08D, ((double)this.random.nextFloat() - 0.5D) * 0.08D, ((double)this.random.nextFloat() - 0.5D) * 0.08D);
            }
        }

    }

    protected void onHit(RayTraceResult p_37488_) {
        super.onHit(p_37488_);
        if (!this.level.isClientSide) {
            float var1 = 4.0F;
            this.level.explode(this, new DamageSource("compu_explosion"), (ExplosionContext) null,(double) this.getX(), (double)this.getY(0.0625D), (double) this.getZ(), 4.0F, false, Explosion.Mode.BREAK);

            this.level.broadcastEntityEvent(this, (byte)3);
            this.remove();
        }

    }
    @Override
    protected Item getDefaultItem() {
        return Registration.COMPU_EXPLOSION.get();
    }
}
