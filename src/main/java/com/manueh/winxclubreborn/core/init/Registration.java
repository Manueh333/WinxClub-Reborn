package com.manueh.winxclubreborn.core.init;

import com.manueh.winxclubreborn.Main;
import com.manueh.winxclubreborn.common.entity.CompuExplosionThrown;
import com.manueh.winxclubreborn.common.items.CompuExplosion;
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

    public static final RegistryObject<Item> COMPU_EXPLOSION = ITEMS.register("compu_explosion",
            () -> new CompuExplosion(new Item.Properties().tab(Main.GROUP)));

    public static final RegistryObject<EntityType<CompuExplosionThrown>> COMPU_EXPLOSION_ENTITY = ENTITY_TYPES.register("compu_explosion_entity", () -> EntityType.Builder.<CompuExplosionThrown>of(CompuExplosionThrown::new, MobCategory.MISC).sized(0.25f, 0.25f).clientTrackingRange(4).updateInterval(10).build(new ResourceLocation(Main.MODID, "compu_explosion_entity").toString()));


}
