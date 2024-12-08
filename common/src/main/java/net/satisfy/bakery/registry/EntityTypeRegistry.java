package net.satisfy.bakery.registry;

import com.mojang.datafixers.types.Type;
import de.cristelknight.doapi.common.block.entity.StorageBlockEntity;
import dev.architectury.registry.level.entity.EntityAttributeRegistry;
import dev.architectury.registry.registries.DeferredRegister;
import dev.architectury.registry.registries.Registrar;
import dev.architectury.registry.registries.RegistrySupplier;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.satisfy.bakery.block.entity.SmallCookingPotBlockEntity;
import net.satisfy.bakery.entity.WanderingBakerEntity;
import net.satisfy.bakery.util.BakeryIdentifier;
import net.satisfy.bakery.Bakery;
import net.satisfy.farm_and_charm.FarmAndCharm;

import java.util.HashSet;
import java.util.function.Supplier;


public enum EntityTypeRegistry {
    ;

    private static final Registrar<BlockEntityType<?>> BLOCK_ENTITY_TYPES = DeferredRegister.create(FarmAndCharm.MOD_ID, Registries.BLOCK_ENTITY_TYPE).getRegistrar();
    public static final DeferredRegister<EntityType<?>> ENTITY_TYPES = DeferredRegister.create(FarmAndCharm.MOD_ID, Registries.ENTITY_TYPE);

    public static final RegistrySupplier<BlockEntityType<SmallCookingPotBlockEntity>> SMALL_COOKING_POT_BLOCK_ENTITY = registerBlockEntity("small_cooking_pot", () -> BlockEntityType.Builder.of(SmallCookingPotBlockEntity::new, ObjectRegistry.SMALL_COOKING_POT.get()).build(null));

    public static final RegistrySupplier<BlockEntityType<StorageBlockEntity>> STORAGE_ENTITY = registerBlockEntity("storage", () -> BlockEntityType.Builder.of(StorageBlockEntity::new, StorageTypeRegistry.registerBlocks(new HashSet<>()).toArray(new Block[0])).build(null));

    public static final RegistrySupplier<EntityType<WanderingBakerEntity>> WANDERING_BAKER = registerEntityType("wandering_baker",
            () -> EntityType.Builder.of(WanderingBakerEntity::new, MobCategory.CREATURE)
                    .sized(0.6f, 1.95f)
                    .clientTrackingRange(10)
                    .build(new BakeryIdentifier("wandering_baker").toString()));




    private static <T extends BlockEntityType<?>> RegistrySupplier<T> registerBlockEntity(String name, final Supplier<T> type) {
        return BLOCK_ENTITY_TYPES.register(new BakeryIdentifier(name), type);
    }

    private static <T extends EntityType<?>> RegistrySupplier<T> registerEntityType(String name, final Supplier<T> type) {
        return ENTITY_TYPES.register(new BakeryIdentifier(name), type);
    }

    public static void init() {
        ENTITY_TYPES.register();
        EntityAttributeRegistry.register(WANDERING_BAKER, WanderingBakerEntity::createMobAttributes);
        Bakery.LOGGER.debug("Registering Mod Entities and Block Entities for " + Bakery.MOD_ID);
    }
}
