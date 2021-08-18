package com.manueh.winxclubreborn.common.entity;

import com.manueh.winxclubreborn.core.init.Registration;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ItemParticleOption;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.projectile.ProjectileUtil;
import net.minecraft.world.entity.projectile.ThrowableItemProjectile;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Explosion;
import net.minecraft.world.level.ExplosionDamageCalculator;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.TheEndGatewayBlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.HitResult;
import net.minecraft.world.phys.Vec3;

public class SoundWaveThrown extends ThrowableItemProjectile {


    public SoundWaveThrown(EntityType<? extends ThrowableItemProjectile> p_37432_, Level world) {
        super(p_37432_, world);
    }

    public SoundWaveThrown(LivingEntity entity, Level world) {
        super(Registration.SOUND_WAVE_ENTITY.get(), entity, world);
    }

    public SoundWaveThrown(double x, double y, double z, Level world) {
        super(Registration.SOUND_WAVE_ENTITY.get(), x, y, z, world);
    }



    public void handleEntityEvent(byte p_37484_) {
        if (p_37484_ == 3) {
            double var2 = 0.08D;

            for(int var4 = 0; var4 < 8; ++var4) {
                this.level.addParticle(new ItemParticleOption(ParticleTypes.ITEM, this.getItem()), this.getX(), this.getY(), this.getZ(), ((double)this.random.nextFloat() - 0.5D) * 0.08D, ((double)this.random.nextFloat() - 0.5D) * 0.08D, ((double)this.random.nextFloat() - 0.5D) * 0.08D);
            }

        }

    }
    private int delay = 3;
    private int time = 0;
    public void tick() {
        super.tick();
        if(time == delay) {
            if(!this.level.isClientSide()) {
                this.level.explode(this, new DamageSource("sound_wave"), (ExplosionDamageCalculator) null,(double) this.getX(), (double)this.getY(0.0625D), (double) this.getZ(), 4.0F, false, Explosion.BlockInteraction.BREAK);
                time = 0;
            }

        }

        time += 1;

    }
    protected void onHit(HitResult p_37488_) {
        super.onHit(p_37488_);
        if (!this.level.isClientSide) {

            //this.level.explode(this, this.getX(), this.getY(0.0625D), this.getZ(), 4.0F, Explosion.BlockInteraction.BREAK);

            this.level.broadcastEntityEvent(this, (byte)3);
            this.discard();
        }



    }
    @Override
    protected Item getDefaultItem() {
        return Registration.SOUND_WAVE.get().asItem();
    }
}
