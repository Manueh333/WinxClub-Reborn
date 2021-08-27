package com.manueh.winxclubreborn.core.init;

import com.manueh.winxclubreborn.Main;
import com.manueh.winxclubreborn.common.entity.*;
import com.manueh.winxclubreborn.common.items.*;
import com.manueh.winxclubreborn.common.tiers.MagicArmorTier;
import com.manueh.winxclubreborn.common.tiers.MagicTier;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.OreBlock;
import net.minecraft.block.material.Material;
import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.EntityType;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class Registration {

    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, Main.MODID);
    public static final DeferredRegister<EntityType<?>> ENTITY_TYPES = DeferredRegister.create(ForgeRegistries.ENTITIES, Main.MODID);
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, Main.MODID);


    public static void init() {
        IEventBus bus = FMLJavaModLoadingContext.get().getModEventBus();
        ITEMS.register(bus);
        ENTITY_TYPES.register(bus);
        BLOCKS.register(bus);

    }

    //BLOCKS
    public static final RegistryObject<Block> MAGIC_ORE = BLOCKS.register("magic_ore", () -> new OreBlock(AbstractBlock.Properties.of(Material.STONE).strength(1.0F, 1.0F).requiresCorrectToolForDrops()));
    public static final RegistryObject<Item> MAGIC_ORE_ITEM = ITEMS.register("magic_ore",
            () -> new BlockItem(MAGIC_ORE.get(), new Item.Properties().tab(Main.GROUP)));
    //ITEMS
    public static final RegistryObject<Item> MAGIC_POWDER = ITEMS.register("magic_powder",
            () -> new Item(new Item.Properties().tab(Main.GROUP).fireResistant()));

    public static final RegistryObject<Item> WINGS = ITEMS.register("wings",
            () -> new ArmorItem(MagicArmorTier.MAGIC, EquipmentSlotType.CHEST, new Item.Properties().tab(Main.GROUP).fireResistant()));

    public static final RegistryObject<Item> HIT_OF_NATURE = ITEMS.register("hit_of_nature",
            () -> new HitOfNature(new Item.Properties().tab(Main.GROUP).stacksTo(1).fireResistant()));

    public static final RegistryObject<Item> COMPU_EXPLOSION = ITEMS.register("compu_explosion",
            () -> new CompuExplosion(new Item.Properties().tab(Main.GROUP).stacksTo(1).fireResistant()));

    public static final RegistryObject<Item> SOUND_WAVE = ITEMS.register("sound_wave",
            () -> new SoundWave(new Item.Properties().tab(Main.GROUP).stacksTo(1).fireResistant()));

    public static final RegistryObject<Item> WOLF_CLAW = ITEMS.register("wolf_claw",
            () -> new WolfClaw(MagicTier.MAGIC, 7, -1.8F, new Item.Properties().tab(Main.GROUP).stacksTo(1).fireResistant()));

    public static final RegistryObject<Item> DRAGON_FURY = ITEMS.register("dragon_fury",
            () -> new DragonFury(new Item.Properties().tab(Main.GROUP).stacksTo(1).fireResistant()));

    public static final RegistryObject<Item> SOLARIA_RING = ITEMS.register("solaria_ring",
            () -> new SolariaRing(MagicTier.MAGIC, 2, -3.0F, new Item.Properties().tab(Main.GROUP).stacksTo(1).fireResistant()));

    public static final RegistryObject<Item> POWER_BALL = ITEMS.register("power_ball",
            () -> new PowerBall(new Item.Properties().tab(Main.GROUP).stacksTo(1).fireResistant()));

    public static final RegistryObject<Phantoblade> PHANTOBLADE_1 = ITEMS.register("phantoblade_1",
            () -> new Phantoblade(MagicTier.PHANTOBLADE, 6, -3F, new Item.Properties().tab(Main.GROUP).stacksTo(1).fireResistant()));

    public static final RegistryObject<Phantoblade> PHANTOBLADE_2 = ITEMS.register("phantoblade_2",
            () -> new Phantoblade(MagicTier.PHANTOBLADE, 5, -2.3F, new Item.Properties().tab(Main.GROUP).stacksTo(1).fireResistant()));

    public static final RegistryObject<Phantoblade> PHANTOBLADE_3 = ITEMS.register("phantoblade_3",
            () -> new Phantoblade(MagicTier.PHANTOBLADE, 4, -1.8F, new Item.Properties().tab(Main.GROUP).stacksTo(1).fireResistant()));


    //THROWABLE ENTITIES

    public static final RegistryObject<EntityType<HitOfNatureThrown>> HIT_OF_NATURE_ENTITY = ENTITY_TYPES.register("hit_of_nature_entity", () -> EntityType.Builder.<HitOfNatureThrown>of(HitOfNatureThrown::new, EntityClassification.MISC).sized(0.25f, 0.25f).clientTrackingRange(4).updateInterval(10).build("hit_of_nature_entity"));

    public static final RegistryObject<EntityType<CompuExplosionThrown>> COMPU_EXPLOSION_ENTITY = ENTITY_TYPES.register("compu_explosion_entity", () -> EntityType.Builder.<CompuExplosionThrown>of(CompuExplosionThrown::new, EntityClassification.MISC).sized(0.25f, 0.25f).clientTrackingRange(4).updateInterval(10).build("compu_explosion_entity"));

    public static final RegistryObject<EntityType<SoundWaveThrown>> SOUND_WAVE_ENTITY = ENTITY_TYPES.register("sound_wave_entity", () -> EntityType.Builder.<SoundWaveThrown>of(SoundWaveThrown::new, EntityClassification.MISC).sized(0.25f, 0.25f).clientTrackingRange(6).updateInterval(10).build("sound_wave_entity"));

    public static final RegistryObject<EntityType<WolfClawThrown>> WOLF_CLAW_ENTITY = ENTITY_TYPES.register("wolf_claw_entity", () -> EntityType.Builder.<WolfClawThrown>of(WolfClawThrown::new, EntityClassification.MISC).sized(0.25f, 0.25f).clientTrackingRange(4).updateInterval(10).build("wolf_claw_entity"));

    public static final RegistryObject<EntityType<DragonFuryThrown>> DRAGON_FURY_ENTITY = ENTITY_TYPES.register("dragon_fury_entity", () -> EntityType.Builder.<DragonFuryThrown>of(DragonFuryThrown::new, EntityClassification.MISC).sized(0.25f, 0.25f).clientTrackingRange(4).updateInterval(10).build("dragon_fury_entity"));

    public static final RegistryObject<EntityType<SolariaRingThrown>> SOLARIA_RING_ENTITY = ENTITY_TYPES.register("solaria_ring_entity", () -> EntityType.Builder.<SolariaRingThrown>of(SolariaRingThrown::new, EntityClassification.MISC).sized(0.25f, 0.25f).clientTrackingRange(4).updateInterval(10).build("solaria_ring_entity"));

    public static final RegistryObject<EntityType<PowerBallThrown>> POWER_BALL_ENTITY = ENTITY_TYPES.register("power_ball_entity", () -> EntityType.Builder.<PowerBallThrown>of(PowerBallThrown::new, EntityClassification.MISC).sized(0.25f, 0.25f).clientTrackingRange(4).updateInterval(10).build("power_ball_entity"));

    //FEATURES


}