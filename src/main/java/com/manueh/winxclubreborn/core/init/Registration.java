package com.manueh.winxclubreborn.core.init;

import com.manueh.winxclubreborn.Main;
import com.manueh.winxclubreborn.common.entity.*;
import com.manueh.winxclubreborn.common.items.CompuExplosion;
import com.manueh.winxclubreborn.common.items.HitOfNature;
import com.manueh.winxclubreborn.common.items.SoundWave;
import com.manueh.winxclubreborn.common.items.WolfClaw;
import com.manueh.winxclubreborn.common.tiers.MagicTier;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRenderers;
import net.minecraft.client.renderer.entity.ThrownItemRenderer;
import net.minecraft.client.renderer.entity.ThrownTridentRenderer;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.entity.projectile.ThrownEgg;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.entity.EntityTypeTest;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.fmllegacy.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class Registration {

    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, Main.MODID);
    public static final DeferredRegister<EntityType<?>> ENTITY_TYPES = DeferredRegister.create(ForgeRegistries.ENTITIES, Main.MODID);

    public static void init() {
        IEventBus bus = FMLJavaModLoadingContext.get().getModEventBus();
        ITEMS.register(bus);
        ENTITY_TYPES.register(bus);

    }

    public static final RegistryObject<Item> MAGIC_POWDER = ITEMS.register("magic_powder",
            () -> new Item(new Item.Properties().tab(Main.GROUP)));

    public static final RegistryObject<Item> HIT_OF_NATURE = ITEMS.register("hit_of_nature",
            () -> new HitOfNature(new Item.Properties().tab(Main.GROUP).stacksTo(1)));

    public static final RegistryObject<Item> COMPU_EXPLOSION = ITEMS.register("compu_explosion",
            () -> new CompuExplosion(new Item.Properties().tab(Main.GROUP).stacksTo(1)));

    public static final RegistryObject<Item> SOUND_WAVE = ITEMS.register("sound_wave",
            () -> new SoundWave(new Item.Properties().tab(Main.GROUP).stacksTo(1)));

    public static final RegistryObject<Item> WOLF_CLAW = ITEMS.register("wolf_claw",
            () -> new WolfClaw(MagicTier.MAGIC, 3, -2.4F, new Item.Properties().tab(Main.GROUP).stacksTo(1)));

    public static final RegistryObject<EntityType<HitOfNatureThrown>> HIT_OF_NATURE_ENTITY = ENTITY_TYPES.register("hit_of_nature_entity", () -> EntityType.Builder.<HitOfNatureThrown>of(HitOfNatureThrown::new, MobCategory.MISC).sized(0.25f, 0.25f).clientTrackingRange(4).updateInterval(10).build("hit_of_nature_entity"));

    public static final RegistryObject<EntityType<CompuExplosionThrown>> COMPU_EXPLOSION_ENTITY = ENTITY_TYPES.register("compu_explosion_entity", () -> EntityType.Builder.<CompuExplosionThrown>of(CompuExplosionThrown::new, MobCategory.MISC).sized(0.25f, 0.25f).clientTrackingRange(4).updateInterval(10).build("compu_explosion_entity"));

    public static final RegistryObject<EntityType<SoundWaveThrown>> SOUND_WAVE_ENTITY = ENTITY_TYPES.register("sound_wave_entity", () -> EntityType.Builder.<SoundWaveThrown>of(SoundWaveThrown::new, MobCategory.MISC).sized(0.25f, 0.25f).clientTrackingRange(6).updateInterval(10).build("sound_wave_entity"));

    public static final RegistryObject<EntityType<WolfClawThrown>> WOLF_CLAW_ENTITY = ENTITY_TYPES.register("wolf_claw_entity", () -> EntityType.Builder.<WolfClawThrown>of(WolfClawThrown::new, MobCategory.MISC).sized(0.25f, 0.25f).clientTrackingRange(4).updateInterval(10).build("wolf_claw_entity"));

    public static final RegistryObject<EntityType<DragonFuryThrown>> DRAGON_FURY_ENTITY = ENTITY_TYPES.register("dragon_fury_entity", () -> EntityType.Builder.<DragonFuryThrown>of(DragonFuryThrown::new, MobCategory.MISC).sized(0.25f, 0.25f).clientTrackingRange(4).updateInterval(10).build("dragon_fury_entity"));

}