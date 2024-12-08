package net.satisfy.bakery.item;

import com.google.common.collect.Maps;
import com.mojang.datafixers.util.Pair;
import java.util.Map;
import java.util.function.Supplier;
import net.minecraft.core.Direction;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.StandingAndWallBlockItem;
import net.minecraft.world.level.block.Block;
import net.satisfy.bakery.registry.ObjectRegistry;

public class StandardItem extends StandingAndWallBlockItem {
    private static final Map<Item, Pair<ResourceLocation, Supplier<MobEffectInstance>>> STANDARD_BY_ITEM = Maps.newHashMap();

    public StandardItem(Item.Properties properties, ResourceLocation texture, Supplier<MobEffectInstance> effectSupplier) {
        super((Block) ObjectRegistry.STANDARD.get(), (Block)ObjectRegistry.WALL_STANDARD.get(), properties, Direction.DOWN);
        STANDARD_BY_ITEM.put(this, new Pair(texture, effectSupplier));
    }

    public static Pair<ResourceLocation, Supplier<MobEffectInstance>> getPair(Item item) {
        return (Pair)STANDARD_BY_ITEM.get(item);
    }

    public static ResourceLocation getLocationOrNull(Item item) {
        Pair<ResourceLocation, Supplier<MobEffectInstance>> pair = (Pair)STANDARD_BY_ITEM.get(item);
        return pair == null ? null : (ResourceLocation)pair.getFirst();
    }

    public static MobEffectInstance getEffectInstanceOrNull(Item item) {
        Pair<ResourceLocation, Supplier<MobEffectInstance>> pair = (Pair)STANDARD_BY_ITEM.get(item);
        return pair == null ? null : (MobEffectInstance)((Supplier)pair.getSecond()).get();
    }

    public String getDescriptionId() {
        return this.getOrCreateDescriptionId();
    }
}

