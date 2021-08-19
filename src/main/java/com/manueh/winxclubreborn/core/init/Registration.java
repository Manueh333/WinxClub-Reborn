package com.manueh.winxclubreborn.core.init;

import com.manueh.winxclubreborn.Main;
import com.manueh.winxclubreborn.common.blocks.MagicGeneratorBlockEntity;
import com.manueh.winxclubreborn.common.blocks.MagicGeneratorContainer;
import com.manueh.winxclubreborn.common.blocks.MagicPowderGenerator;
import com.manueh.winxclubreborn.common.entity.*;
import com.manueh.winxclubreborn.common.items.*;
import com.manueh.winxclubreborn.common.tiers.MagicTier;
import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.inventory.MenuType;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraftforge.common.extensions.IForgeContainerType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.fmllegacy.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class Registration {

    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, Main.MODID);
    public static final DeferredRegister<EntityType<?>> ENTITY_TYPES = DeferredRegister.create(ForgeRegistries.ENTITIES, Main.MODID);
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, Main.MODID);
    private static final DeferredRegister<BlockEntityType<?>> BLOCKENTITIES = DeferredRegister.create(ForgeRegistries.BLOCK_ENTITIES, Main.MODID);
    private static final DeferredRegister<MenuType<?>> CONTAINERS = DeferredRegister.create(ForgeRegistries.CONTAINERS, Main.MODID);
    public static void init() {
        IEventBus bus = FMLJavaModLoadingContext.get().getModEventBus();
        ITEMS.register(bus);
        ENTITY_TYPES.register(bus);
        BLOCKS.register(bus);
        BLOCKENTITIES.register(bus);
        CONTAINERS.register(bus);
    }

    //BLOCKS
    public static final RegistryObject<Block> GENERATOR = BLOCKS.register("magic_generator", MagicPowderGenerator::new);
    public static final RegistryObject<Item> GENERATOR_ITEM = ITEMS.register("magic_generator",
            () -> new BlockItem(GENERATOR.get(), new Item.Properties().tab(Main.GROUP).stacksTo(1)));
    public static final RegistryObject<BlockEntityType<MagicGeneratorBlockEntity>> GENERATOR_BE = BLOCKENTITIES.register("magic_generator_block_entity",
            () -> BlockEntityType.Builder.of(MagicGeneratorBlockEntity::new, GENERATOR.get()).build(null));
    public static final RegistryObject<MenuType<MagicGeneratorContainer>> GENERATOR_CONTAINER = CONTAINERS.register("magic_generator_container", () -> IForgeContainerType.create((windowId, inv, data) -> {
        BlockPos pos = data.readBlockPos();
        Level world = inv.player.getCommandSenderWorld();
        return new MagicGeneratorContainer(windowId, world, pos, inv, inv.player);
    }));
    //POWERS
    public static final RegistryObject<Item> MAGIC_POWDER = ITEMS.register("magic_powder",
            () -> new Item(new Item.Properties().tab(Main.GROUP).fireResistant()));

    public static final RegistryObject<Item> HIT_OF_NATURE = ITEMS.register("hit_of_nature",
            () -> new HitOfNature(new Item.Properties().tab(Main.GROUP).stacksTo(1).fireResistant()));

    public static final RegistryObject<Item> COMPU_EXPLOSION = ITEMS.register("compu_explosion",
            () -> new CompuExplosion(new Item.Properties().tab(Main.GROUP).stacksTo(1).fireResistant()));

    public static final RegistryObject<Item> SOUND_WAVE = ITEMS.register("sound_wave",
            () -> new SoundWave(new Item.Properties().tab(Main.GROUP).stacksTo(1).fireResistant()));

    public static final RegistryObject<Item> WOLF_CLAW = ITEMS.register("wolf_claw",
            () -> new WolfClaw(MagicTier.MAGIC, 3, -2.4F, new Item.Properties().tab(Main.GROUP).stacksTo(1).fireResistant()));

    public static final RegistryObject<Item> DRAGON_FURY = ITEMS.register("dragon_fury",
            () -> new DragonFury(new Item.Properties().tab(Main.GROUP).stacksTo(1).fireResistant()));

    public static final RegistryObject<Item> SOLARIA_RING = ITEMS.register("solaria_ring",
            () -> new SolariaRing(MagicTier.MAGIC, 1, -3.0F, new Item.Properties().tab(Main.GROUP).stacksTo(1).fireResistant()));

    public static final RegistryObject<Item> POWER_BALL = ITEMS.register("power_ball",
            () -> new PowerBall(new Item.Properties().tab(Main.GROUP).stacksTo(1).fireResistant()));

    //THROWABLE ENTITIES
    public static final RegistryObject<EntityType<HitOfNatureThrown>> HIT_OF_NATURE_ENTITY = ENTITY_TYPES.register("hit_of_nature_entity", () -> EntityType.Builder.<HitOfNatureThrown>of(HitOfNatureThrown::new, MobCategory.MISC).sized(0.25f, 0.25f).clientTrackingRange(4).updateInterval(10).build("hit_of_nature_entity"));

    public static final RegistryObject<EntityType<CompuExplosionThrown>> COMPU_EXPLOSION_ENTITY = ENTITY_TYPES.register("compu_explosion_entity", () -> EntityType.Builder.<CompuExplosionThrown>of(CompuExplosionThrown::new, MobCategory.MISC).sized(0.25f, 0.25f).clientTrackingRange(4).updateInterval(10).build("compu_explosion_entity"));

    public static final RegistryObject<EntityType<SoundWaveThrown>> SOUND_WAVE_ENTITY = ENTITY_TYPES.register("sound_wave_entity", () -> EntityType.Builder.<SoundWaveThrown>of(SoundWaveThrown::new, MobCategory.MISC).sized(0.25f, 0.25f).clientTrackingRange(6).updateInterval(10).build("sound_wave_entity"));

    public static final RegistryObject<EntityType<WolfClawThrown>> WOLF_CLAW_ENTITY = ENTITY_TYPES.register("wolf_claw_entity", () -> EntityType.Builder.<WolfClawThrown>of(WolfClawThrown::new, MobCategory.MISC).sized(0.25f, 0.25f).clientTrackingRange(4).updateInterval(10).build("wolf_claw_entity"));

    public static final RegistryObject<EntityType<DragonFuryThrown>> DRAGON_FURY_ENTITY = ENTITY_TYPES.register("dragon_fury_entity", () -> EntityType.Builder.<DragonFuryThrown>of(DragonFuryThrown::new, MobCategory.MISC).sized(0.25f, 0.25f).clientTrackingRange(4).updateInterval(10).build("dragon_fury_entity"));

    public static final RegistryObject<EntityType<SolariaRingThrown>> SOLARIA_RING_ENTITY = ENTITY_TYPES.register("solaria_ring_entity", () -> EntityType.Builder.<SolariaRingThrown>of(SolariaRingThrown::new, MobCategory.MISC).sized(0.25f, 0.25f).clientTrackingRange(4).updateInterval(10).build("solaria_ring_entity"));

    public static final RegistryObject<EntityType<PowerBallThrown>> POWER_BALL_ENTITY = ENTITY_TYPES.register("power_ball_entity", () -> EntityType.Builder.<PowerBallThrown>of(PowerBallThrown::new, MobCategory.MISC).sized(0.25f, 0.25f).clientTrackingRange(4).updateInterval(10).build("power_ball_entity"));


}