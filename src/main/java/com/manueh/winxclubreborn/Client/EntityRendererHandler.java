package com.manueh.winxclubreborn.Client;

import com.manueh.winxclubreborn.core.init.Registration;
import net.minecraft.client.GameSettings;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.renderer.ItemRenderer;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.SpriteRenderer;
import net.minecraft.client.renderer.texture.TextureManager;
import net.minecraft.resources.IReloadableResourceManager;

public class EntityRendererHandler extends EntityRendererManager {
    public EntityRendererHandler(TextureManager p_i226034_1_, ItemRenderer p_i226034_2_, IReloadableResourceManager p_i226034_3_, FontRenderer p_i226034_4_, GameSettings p_i226034_5_) {
        super(p_i226034_1_, p_i226034_2_, p_i226034_3_, p_i226034_4_, p_i226034_5_);
        this.registerRenderers(p_i226034_2_, p_i226034_3_);

    }


    public void registerRenderers(net.minecraft.client.renderer.ItemRenderer p_229097_1_, IReloadableResourceManager p_229097_2_) {
        this.register(Registration.COMPU_EXPLOSION_ENTITY.get(), new SpriteRenderer(this, p_229097_1_));
        this.register(Registration.HIT_OF_NATURE_ENTITY.get(), new SpriteRenderer(this, p_229097_1_));
        this.register(Registration.POWER_BALL_ENTITY.get(), new SpriteRenderer(this, p_229097_1_));
        this.register(Registration.SOLARIA_RING_ENTITY.get(), new SpriteRenderer(this, p_229097_1_));
        this.register(Registration.DRAGON_FURY_ENTITY.get(), new SpriteRenderer(this, p_229097_1_));
        this.register(Registration.WOLF_CLAW_ENTITY.get(), new SpriteRenderer(this, p_229097_1_));
        this.register(Registration.SOUND_WAVE_ENTITY.get(), new SpriteRenderer(this, p_229097_1_));
    }


}