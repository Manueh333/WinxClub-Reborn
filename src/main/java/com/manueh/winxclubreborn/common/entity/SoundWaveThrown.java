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

public class SoundWaveThrown extends ProjectileItemEntity {


    public SoundWaveThrown(EntityType<? extends ProjectileItemEntity> p_37432_, World world) {
        super(p_37432_, world);
    }

    public SoundWaveThrown(LivingEntity entity, World world) {
        super(Registration.SOUND_WAVE_ENTITY.get(), entity, world);
    }

    public SoundWaveThrown(double x, double y, double z, World world) {
        super(Registration.SOUND_WAVE_ENTITY.get(), x, y, z, world);
    }



    public void handleEntityEvent(byte p_37484_) {
        if (p_37484_ == 3) {
            double var2 = 0.08D;

            for(int var4 = 0; var4 < 8; ++var4) {
                this.level.addParticle(new ItemParticleData(ParticleTypes.ITEM, this.getItem()), this.getX(), this.getY(), this.getZ(), ((double)this.random.nextFloat() - 0.5D) * 0.08D, ((double)this.random.nextFloat() - 0.5D) * 0.08D, ((double)this.random.nextFloat() - 0.5D) * 0.08D);
            }

        }

    }
    private int delay = 3;
    private int time = 0;
    public void tick() {
        super.tick();
        if(time == delay) {
            if(!this.level.isClientSide()) {
                this.level.explode(this, new DamageSource("sound_wave"), (ExplosionContext) null,(double) this.getX(), (double)this.getY(0.0625D), (double) this.getZ(), 4.0F, false, Explosion.Mode.BREAK);
                time = 0;
            }

        }

        time += 1;

    }
    protected void onHit(RayTraceResult p_37488_) {
        super.onHit(p_37488_);
        if (!this.level.isClientSide) {

            //this.level.explode(this, this.getX(), this.getY(0.0625D), this.getZ(), 4.0F, Explosion.Mode.BREAK);

            this.level.broadcastEntityEvent(this, (byte)3);
            this.remove();
        }



    }
    @Override
    protected Item getDefaultItem() {
        return Registration.SOUND_WAVE.get().asItem();
    }
}
