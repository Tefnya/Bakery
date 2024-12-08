package net.satisfy.bakery.entity;

import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.npc.VillagerTrades;
import net.minecraft.world.entity.npc.WanderingTrader;
import net.minecraft.world.item.trading.MerchantOffers;
import net.minecraft.world.level.Level;
import net.satisfy.bakery.registry.ObjectRegistry;
import net.satisfy.bakery.util.VillagerUtil;
import org.jetbrains.annotations.NotNull;

import java.util.HashMap;

import static net.satisfy.farm_and_charm.registry.ObjectRegistry.*;

public class WanderingBakerEntity extends WanderingTrader {
    public static final HashMap<Integer, VillagerTrades.ItemListing[]> TRADES = createTrades();

    private static HashMap<Integer, VillagerTrades.ItemListing[]> createTrades() {
        HashMap<Integer, VillagerTrades.ItemListing[]> trades = new HashMap<>();
        trades.put(1, new VillagerTrades.ItemListing[]{
                new VillagerUtil.SellItemFactory(DOUGH.get(), 2, 4, 8, 15),
                new VillagerUtil.SellItemFactory(ObjectRegistry.SWEET_DOUGH.get(), 2, 4, 8, 15),
                new VillagerUtil.SellItemFactory(ObjectRegistry.JAR.get(), 4, 2, 8, 1),
                new VillagerUtil.SellItemFactory(ObjectRegistry.TRAY.get(), 12, 1, 8, 25),
                new VillagerUtil.SellItemFactory(ObjectRegistry.BREADBOX.get(), 15, 1, 8, 30),
                new VillagerUtil.SellItemFactory(ObjectRegistry.CAKE_STAND.get(), 15, 1, 8, 30),
                new VillagerUtil.SellItemFactory(OAT.get(), 3, 5, 8, 5),
                new VillagerUtil.SellItemFactory(STRAWBERRY.get(), 3, 5, 8, 5),
                new VillagerUtil.SellItemFactory(STRAWBERRY_SEEDS.get(), 2, 6, 8, 3),
                new VillagerUtil.SellItemFactory(STOVE.get(), 25, 1, 8, 40),
                new VillagerUtil.SellItemFactory(ObjectRegistry.SMALL_COOKING_POT.get(), 8, 1, 8, 15),
                new VillagerUtil.SellItemFactory(ObjectRegistry.BAGUETTE_BLOCK.get(), 4, 2, 8, 5),
                new VillagerUtil.SellItemFactory(ObjectRegistry.CRUSTY_BREAD_BLOCK.get(), 4, 2, 8, 5),
                new VillagerUtil.SellItemFactory(ObjectRegistry.BRAIDED_BREAD_BLOCK.get(), 4, 1, 8, 5),
                new VillagerUtil.SellItemFactory(ObjectRegistry.SANDWICH.get(), 6, 2, 8, 10),
                new VillagerUtil.SellItemFactory(ObjectRegistry.APPLE_CUPCAKE.get(), 2, 1, 8, 5),
                new VillagerUtil.SellItemFactory(ObjectRegistry.APPLE_PIE.get(), 6, 1, 8, 5),
                new VillagerUtil.SellItemFactory(ObjectRegistry.APPLE_PIE_SLICE.get(), 3, 2, 8, 5),
                new VillagerUtil.SellItemFactory(ObjectRegistry.CHOCOLATE_TRUFFLE.get(), 1, 1, 8, 2),
        });
        return trades;
    }

    public WanderingBakerEntity(EntityType<? extends WanderingBakerEntity> entityType, Level world) {
        super(entityType, world);
    }

    @Override
    protected void updateTrades() {
        if (this.offers == null) {
            this.offers = new MerchantOffers();
        }
        this.addOffersFromItemListings(this.offers, TRADES.get(1), 8);
    }

    public static AttributeSupplier.@NotNull Builder createMobAttributes() {
        return Mob.createMobAttributes()
                .add(Attributes.MAX_HEALTH, 25.0)
                .add(Attributes.MOVEMENT_SPEED, 1.0);
    }
}
