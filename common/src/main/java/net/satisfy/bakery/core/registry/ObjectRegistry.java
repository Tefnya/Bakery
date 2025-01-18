package net.satisfy.bakery.core.registry;

import dev.architectury.registry.registries.DeferredRegister;
import dev.architectury.registry.registries.Registrar;
import dev.architectury.registry.registries.RegistrySupplier;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.food.Foods;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.SwordItem;
import net.minecraft.world.item.Tiers;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.properties.NoteBlockInstrument;
import net.satisfy.bakery.core.block.*;
import net.satisfy.bakery.core.block.cake.*;
import net.satisfy.bakery.Bakery;
import net.satisfy.bakery.core.item.SmallCookingPotItem;
import net.satisfy.bakery.core.util.BakeryIdentifier;
import net.satisfy.bakery.platform.PlatformHelper;
import net.satisfy.farm_and_charm.core.block.*;
import net.satisfy.farm_and_charm.core.block.SinkBlock;
import net.satisfy.farm_and_charm.core.item.food.EffectBlockItem;
import net.satisfy.farm_and_charm.core.item.food.EffectItem;
import net.satisfy.farm_and_charm.core.registry.MobEffectRegistry;
import net.satisfy.farm_and_charm.core.util.Util;

import java.util.function.Consumer;
import java.util.function.Supplier;

public class ObjectRegistry {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(Bakery.MOD_ID, Registries.ITEM);
    public static final Registrar<Item> ITEM_REGISTRAR = ITEMS.getRegistrar();
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(Bakery.MOD_ID, Registries.BLOCK);
    public static final Registrar<Block> BLOCK_REGISTRAR = BLOCKS.getRegistrar();

    public static final RegistrySupplier<Block> BAKERY_BANNER = registerWithItem("bakery_banner", () -> new CompletionistBannerBlock(BlockBehaviour.Properties.of().strength(1F).instrument(NoteBlockInstrument.BASS).noCollission().sound(SoundType.WOOD)));
    public static final RegistrySupplier<Block> BAKERY_WALL_BANNER = registerWithoutItem("bakery_wall_banner", () -> new CompletionistWallBannerBlock(BlockBehaviour.Properties.of().strength(1F).instrument(NoteBlockInstrument.BASS).noCollission().sound(SoundType.WOOD)));
    public static final RegistrySupplier<Block> KITCHEN_SINK = registerWithItem("kitchen_sink", () -> new SinkBlock(BlockBehaviour.Properties.copy(Blocks.BRICKS).noOcclusion()));
    public static final RegistrySupplier<Block> BAKER_STATION = registerWithItem("baker_station", () -> new BakerStationBlock(BlockBehaviour.Properties.copy(Blocks.BRICKS)));
    public static final RegistrySupplier<Block> BRICK_COUNTER = registerWithItem("brick_counter", () -> new LineConnectingBlock(BlockBehaviour.Properties.copy(Blocks.BRICKS)));
    public static final RegistrySupplier<Block> CABINET = registerWithItem("cabinet", () -> new CabinetBlock(BlockBehaviour.Properties.of().strength(2.0F, 3.0F).sound(SoundType.WOOD), SoundEventRegistry.CABINET_OPEN.get(), SoundEventRegistry.CABINET_CLOSE.get()));
    public static final RegistrySupplier<Block> DRAWER = registerWithItem("drawer", () -> new CabinetBlock(BlockBehaviour.Properties.of().strength(2.0F, 3.0F).sound(SoundType.WOOD), SoundEventRegistry.DRAWER_OPEN.get(), SoundEventRegistry.DRAWER_CLOSE.get()));
    public static final RegistrySupplier<Block> WALL_CABINET = registerWithItem("wall_cabinet", () -> new CabinetWallBlock(BlockBehaviour.Properties.of().strength(2.0F, 3.0F).sound(SoundType.WOOD), SoundEventRegistry.CABINET_OPEN.get(), SoundEventRegistry.CABINET_CLOSE.get()));
    public static final RegistrySupplier<Block> IRON_BENCH = registerWithItem("iron_bench", () -> new BenchBlock(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK)));
    public static final RegistrySupplier<Block> IRON_CHAIR = registerWithItem("iron_chair", () -> new ChairBlock(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK)));
    public static final RegistrySupplier<Block> IRON_TABLE = registerWithItem("iron_table", () -> new TableBlock(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK)));
    public static final RegistrySupplier<Block> STREET_SIGN = registerWithItem("street_sign", () -> new StreetSignBlock(BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS)));
    public static final RegistrySupplier<Block> CAKE_STAND = registerWithItem("cake_stand", () -> new CakeStandBlock(BlockBehaviour.Properties.copy(Blocks.FLOWER_POT).sound(SoundType.GLASS)));
    public static final RegistrySupplier<Block> CAKE_DISPLAY = registerWithItem("cake_display", () -> new CakeDisplayBlock(BlockBehaviour.Properties.copy(Blocks.FLOWER_POT).sound(SoundType.GLASS)));
    public static final RegistrySupplier<Block> CUPCAKE_DISPLAY = registerWithItem("cupcake_display", () -> new CupcakeDisplayBlock(BlockBehaviour.Properties.copy(Blocks.FLOWER_POT).sound(SoundType.WOOD)));
    public static final RegistrySupplier<Block> BREADBOX = registerWithItem("breadbox", () -> new BreadBox(BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS)));
    public static final RegistrySupplier<Block> TRAY = registerWithItem("tray", () -> new TrayBlock(BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS)));
    public static final RegistrySupplier<Block> BREAD_CRATE = registerWithItem("bread_crate", () -> new BreadBasketBlock(BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS)));
    public static final RegistrySupplier<Block> WALL_DISPLAY = registerWithItem("wall_display", () -> new WallDisplayBlock(BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS)));
    public static final RegistrySupplier<Block> CHOCOLATE_BOX = registerWithItem("chocolate_box", () -> new EatableBoxBlock(BlockBehaviour.Properties.copy(Blocks.CAKE)));
    public static final RegistrySupplier<Item> ROLLING_PIN = registerItem("rolling_pin", () -> new SwordItem(Tiers.WOOD, 1, -2f, getSettings().rarity(Rarity.COMMON)));
    public static final RegistrySupplier<Item> BREAD_KNIFE = registerItem("bread_knife", () -> new SwordItem(Tiers.IRON, 1, -2f, getSettings().rarity(Rarity.COMMON)));
    public static final RegistrySupplier<Block> SMALL_COOKING_POT = registerWithoutItem("small_cooking_pot", () -> new SmallCookingPotBlock(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK)));
    public static final RegistrySupplier<Item> SMALL_COOKING_POT_ITEM = registerItem("small_cooking_pot", () -> new SmallCookingPotItem(SMALL_COOKING_POT.get(), getSettings()));
    public static final RegistrySupplier<Block> JAR = registerWithItem("jar", () -> new StackableBlock(BlockBehaviour.Properties.copy(Blocks.GLASS).instabreak().noOcclusion().sound(SoundType.GLASS), 3));
    public static final RegistrySupplier<Block> STRAWBERRY_JAM = registerWithItem("strawberry_jam", () -> new StackableBlock(BlockBehaviour.Properties.copy(Blocks.GLASS).instabreak().noOcclusion().sound(SoundType.GLASS), 3));
    public static final RegistrySupplier<Block> GLOWBERRY_JAM = registerWithItem("glowberry_jam", () -> new StackableBlock(BlockBehaviour.Properties.copy(Blocks.GLASS).instabreak().noOcclusion().sound(SoundType.GLASS), 3));
    public static final RegistrySupplier<Block> SWEETBERRY_JAM = registerWithItem("sweetberry_jam", () -> new StackableBlock(BlockBehaviour.Properties.copy(Blocks.GLASS).instabreak().noOcclusion().sound(SoundType.GLASS), 3));
    public static final RegistrySupplier<Block> CHOCOLATE_JAM = registerWithItem("chocolate_jam", () -> new StackableBlock(BlockBehaviour.Properties.copy(Blocks.GLASS).instabreak().noOcclusion().sound(SoundType.GLASS), 3));
    public static final RegistrySupplier<Block> APPLE_JAM = registerWithItem("apple_jam", () -> new StackableBlock(BlockBehaviour.Properties.copy(Blocks.GLASS).instabreak().sound(SoundType.GLASS).noOcclusion(), 3));
    public static final RegistrySupplier<Block> CRUSTY_BREAD_BLOCK = registerWithoutItem("crusty_bread_block", () -> new StackableEatableBlock(BlockBehaviour.Properties.copy(Blocks.CAKE), 3));
    public static final RegistrySupplier<Block> BREAD_BLOCK = registerWithoutItem("bread_block", () -> new StackableEatableBlock(BlockBehaviour.Properties.copy(Blocks.CAKE), 3));
    public static final RegistrySupplier<Block> BAGUETTE_BLOCK = registerWithoutItem("baguette_block", () -> new StackableEatableBlock(BlockBehaviour.Properties.copy(Blocks.CAKE), 4));
    public static final RegistrySupplier<Block> TOAST_BLOCK = registerWithoutItem("toast_block", () -> new StackableEatableBlock(BlockBehaviour.Properties.copy(Blocks.CAKE), 3));
    public static final RegistrySupplier<Block> BRAIDED_BREAD_BLOCK = registerWithoutItem("braided_bread_block", () -> new StackableEatableBlock(BlockBehaviour.Properties.copy(Blocks.CAKE), 3));
    public static final RegistrySupplier<Block> BUN_BLOCK = registerWithoutItem("bun_block", () -> new StackableBlock(BlockBehaviour.Properties.copy(Blocks.CAKE), 4));
    public static final RegistrySupplier<Block> STRAWBERRY_CAKE = registerWithItem("strawberry_cake", () -> new CakeBlock(BlockBehaviour.Properties.copy(Blocks.CAKE), ObjectRegistry.STRAWBERRY_CAKE_SLICE));
    public static final RegistrySupplier<Block> SWEETBERRY_CAKE = registerWithItem("sweetberry_cake", () -> new CakeBlock((BlockBehaviour.Properties.copy(Blocks.CAKE)), ObjectRegistry.SWEETBERRY_CAKE_SLICE));
    public static final RegistrySupplier<Block> CHOCOLATE_CAKE = registerWithItem("chocolate_cake", () -> new CakeBlock((BlockBehaviour.Properties.copy(Blocks.CAKE)), ObjectRegistry.CHOCOLATE_CAKE_SLICE));
    public static final RegistrySupplier<Block> BUNDT_CAKE = registerWithItem("bundt_cake", () -> new BundtCakeBlock(BlockBehaviour.Properties.copy(Blocks.CAKE), ObjectRegistry.BUNDT_CAKE_SLICE));
    public static final RegistrySupplier<Block> LINZER_TART = registerWithItem("linzer_tart", () -> new LinzerTartBlock(BlockBehaviour.Properties.copy(Blocks.CAKE), ObjectRegistry.LINZER_TART_SLICE));
    public static final RegistrySupplier<Block> APPLE_PIE = registerWithItem("apple_pie", () -> new ApplePieBlock((BlockBehaviour.Properties.copy(Blocks.CAKE)), ObjectRegistry.APPLE_PIE_SLICE));
    public static final RegistrySupplier<Block> GLOWBERRY_TART = registerWithItem("glowberry_tart", () -> new GlowberryTartBlock((BlockBehaviour.Properties.copy(Blocks.CAKE)), ObjectRegistry.GLOWBERRY_PIE_SLICE));
    public static final RegistrySupplier<Block> PUDDING = registerWithItem("pudding", () -> new PuddingBlock(BlockBehaviour.Properties.copy(Blocks.CAKE), ObjectRegistry.PUDDING_SLICE));
    public static final RegistrySupplier<Block> WAFFLE_BLOCK = registerWithoutItem("waffle_block", () -> new StackableEatableBlock(BlockBehaviour.Properties.copy(Blocks.CAKE), 4));
    public static final RegistrySupplier<Item> CAKE_DOUGH = registerItem("cake_dough", () -> new Item(getSettings().food(Foods.SWEET_BERRIES)));
    public static final RegistrySupplier<Item> SWEET_DOUGH = registerItem("sweet_dough", () -> new Item(getSettings().food(Foods.SWEET_BERRIES)));
    public static final RegistrySupplier<Item> CROISSANT = registerItem("croissant", () -> new EffectItem(getFoodItemSettings(PlatformHelper.getCroissantNutrition(), PlatformHelper.getCroissantSaturation(), MobEffectRegistry.SUSTENANCE.get(), 900), 400, false));
    public static final RegistrySupplier<Item> CRUSTY_BREAD = registerItem("crusty_bread", () -> new EffectBlockItem(CRUSTY_BREAD_BLOCK.get(), getFoodItemSettings(PlatformHelper.getCrustyBreadNutrition(), PlatformHelper.getCrustyBreadSaturation(), MobEffectRegistry.SUSTENANCE.get(), 4800)));
    public static final RegistrySupplier<Item> BREAD = registerItem("bread", () -> new EffectBlockItem(BREAD_BLOCK.get(), getFoodItemSettings(PlatformHelper.getBreadNutrition(), PlatformHelper.getBreadSaturation(), MobEffectRegistry.SUSTENANCE.get(), 4200)));
    public static final RegistrySupplier<Item> BAGUETTE = registerItem("baguette", () -> new EffectBlockItem(BAGUETTE_BLOCK.get(), getFoodItemSettings(PlatformHelper.getBaguetteNutrition(), PlatformHelper.getBaguetteSaturation(), MobEffectRegistry.SUSTENANCE.get(), 4200)));
    public static final RegistrySupplier<Item> TOAST = registerItem("toast", () -> new EffectBlockItem(TOAST_BLOCK.get(), getFoodItemSettings(PlatformHelper.getToastNutrition(), PlatformHelper.getToastSaturation(), MobEffectRegistry.SUSTENANCE.get(), 5400)));
    public static final RegistrySupplier<Item> BRAIDED_BREAD = registerItem("braided_bread", () -> new EffectBlockItem(BRAIDED_BREAD_BLOCK.get(), getFoodItemSettings(PlatformHelper.getBraidedBreadNutrition(), PlatformHelper.getBraidedBreadSaturation(), MobEffectRegistry.SUSTENANCE.get(), 4200)));
    public static final RegistrySupplier<Item> SANDWICH = registerItem("sandwich", () -> new EffectItem(getFoodItemSettings(PlatformHelper.getSandwichNutrition(), PlatformHelper.getSandwichSaturation(), MobEffectRegistry.SATIATION.get(), 1500), 4800, false));
    public static final RegistrySupplier<Item> VEGETABLE_SANDWICH = registerItem("vegetable_sandwich", () -> new EffectItem(getFoodItemSettings(PlatformHelper.getVegetableSandwichNutrition(), PlatformHelper.getVegetableSandwichSaturation(), MobEffectRegistry.SATIATION.get(), 1800), 4800, false));
    public static final RegistrySupplier<Item> GRILLED_SALMON_SANDWICH = registerItem("grilled_salmon_sandwich", () -> new EffectItem(getFoodItemSettings(PlatformHelper.getGrilledSalmonSandwichNutrition(), PlatformHelper.getGrilledSalmonSandwichSaturation(), MobEffectRegistry.SATIATION.get(), 1200), 4800, false));
    public static final RegistrySupplier<Item> GRILLED_BACON_SANDWICH = registerItem("grilled_bacon_sandwich", () -> new EffectItem(getFoodItemSettings(PlatformHelper.getGrilledBaconSandwichNutrition(), PlatformHelper.getGrilledBaconSandwichSaturation(), MobEffectRegistry.SATIATION.get(), 1200), 6000, false));
    public static final RegistrySupplier<Item> BREAD_WITH_JAM = registerItem("bread_with_jam", () -> new EffectItem(getFoodItemSettings(PlatformHelper.getBreadWithJamNutrition(), PlatformHelper.getBreadWithJamSaturation(), MobEffectRegistry.RESTED.get(), 400), 2500, false));
    public static final RegistrySupplier<Item> STRAWBERRY_CAKE_SLICE = registerItem("strawberry_cake_slice", () -> new EffectItem(getFoodItemSettings(PlatformHelper.getStrawberryCakeSliceNutrition(), PlatformHelper.getStrawberryCakeSliceSaturation(), MobEffectRegistry.SWEETS.get(), 900), 700, false));
    public static final RegistrySupplier<Item> SWEETBERRY_CAKE_SLICE = registerItem("sweetberry_cake_slice", () -> new EffectItem(getFoodItemSettings(PlatformHelper.getSweetberryCakeSliceNutrition(), PlatformHelper.getSweetberryCakeSliceSaturation(), MobEffectRegistry.SWEETS.get(), 900), 700, false));
    public static final RegistrySupplier<Item> CHOCOLATE_CAKE_SLICE = registerItem("chocolate_cake_slice", () -> new EffectItem(getFoodItemSettings(PlatformHelper.getChocolateCakeSliceNutrition(), PlatformHelper.getChocolateCakeSliceSaturation(), MobEffectRegistry.SWEETS.get(), 900), 700, false));
    public static final RegistrySupplier<Item> CHOCOLATE_GATEAU_SLICE = registerItem("chocolate_gateau_slice", () -> new EffectItem(getFoodItemSettings(PlatformHelper.getChocolateGateauSliceNutrition(), PlatformHelper.getChocolateGateauSliceSaturation(), MobEffectRegistry.SWEETS.get(), 900), 800, false));
    public static final RegistrySupplier<Item> BUNDT_CAKE_SLICE = registerItem("bundt_cake_slice", () -> new EffectItem(getFoodItemSettings(PlatformHelper.getBundtCakeSliceNutrition(), PlatformHelper.getBundtCakeSliceSaturation(), MobEffectRegistry.SWEETS.get(), 900), 800, false));
    public static final RegistrySupplier<Item> LINZER_TART_SLICE = registerItem("linzer_tart_slice", () -> new EffectItem(getFoodItemSettings(PlatformHelper.getLinzerTartSliceNutrition(), PlatformHelper.getLinzerTartSliceSaturation(), MobEffectRegistry.SWEETS.get(), 900), 800, false));
    public static final RegistrySupplier<Item> APPLE_PIE_SLICE = registerItem("apple_pie_slice", () -> new EffectItem(getFoodItemSettings(PlatformHelper.getApplePieSliceNutrition(), PlatformHelper.getApplePieSliceSaturation(), MobEffectRegistry.SWEETS.get(), 900), 800, false));
    public static final RegistrySupplier<Item> GLOWBERRY_PIE_SLICE = registerItem("glowberry_pie_slice", () -> new EffectItem(getFoodItemSettings(PlatformHelper.getGlowberryPieSliceNutrition(), PlatformHelper.getGlowberryPieSliceSaturation(), MobEffectRegistry.SWEETS.get(), 900), 800, false));
    public static final RegistrySupplier<Item> CHOCOLATE_TART_SLICE = registerItem("chocolate_tart_slice", () -> new EffectItem(getFoodItemSettings(PlatformHelper.getChocolateTartSliceNutrition(), PlatformHelper.getChocolateTartSliceSaturation(), MobEffectRegistry.SWEETS.get(), 900), 800, false));
    public static final RegistrySupplier<Item> PUDDING_SLICE = registerItem("pudding_slice", () -> new EffectItem(getFoodItemSettings(PlatformHelper.getPuddingSliceNutrition(), PlatformHelper.getPuddingSliceSaturation(), MobEffectRegistry.SWEETS.get(), 900), 800, false));
    public static final RegistrySupplier<Item> STRAWBERRY_GLAZED_COOKIE = registerItem("strawberry_glazed_cookie", () -> new EffectItem(getFoodItemSettings(PlatformHelper.getStrawberryGlazedCookieNutrition(), PlatformHelper.getStrawberryGlazedCookieSaturation(), MobEffectRegistry.SWEETS.get(), 900), 800, false));
    public static final RegistrySupplier<Item> SWEETBERRY_GLAZED_COOKIE = registerItem("sweetberry_glazed_cookie", () -> new EffectItem(getFoodItemSettings(PlatformHelper.getSweetberryGlazedCookieNutrition(), PlatformHelper.getSweetberryGlazedCookieSaturation(), MobEffectRegistry.SWEETS.get(), 900), 800, false));
    public static final RegistrySupplier<Item> CHOCOLATE_GLAZED_COOKIE = registerItem("chocolate_glazed_cookie", () -> new EffectItem(getFoodItemSettings(PlatformHelper.getChocolateGlazedCookieNutrition(), PlatformHelper.getChocolateGlazedCookieSaturation(), MobEffectRegistry.SWEETS.get(), 900), 800, false));
    public static final RegistrySupplier<Item> STRAWBERRY_CUPCAKE = registerItem("strawberry_cupcake", () -> new EffectItem(getFoodItemSettings(PlatformHelper.getStrawberryCupcakeNutrition(), PlatformHelper.getStrawberryCupcakeSaturation(), MobEffectRegistry.SWEETS.get(), 900), 800, false));
    public static final RegistrySupplier<Item> SWEETBERRY_CUPCAKE = registerItem("sweetberry_cupcake", () -> new EffectItem(getFoodItemSettings(PlatformHelper.getSweetberryCupcakeNutrition(), PlatformHelper.getSweetberryCupcakeSaturation(), MobEffectRegistry.SWEETS.get(), 900), 800, false));
    public static final RegistrySupplier<Item> APPLE_CUPCAKE = registerItem("apple_cupcake", () -> new EffectItem(getFoodItemSettings(PlatformHelper.getAppleCupcakeNutrition(), PlatformHelper.getAppleCupcakeSaturation(), MobEffectRegistry.SWEETS.get(), 900), 800, false));
    public static final RegistrySupplier<Item> CORNET = registerItem("cornet", () -> new EffectItem(getFoodItemSettings(PlatformHelper.getCornetNutrition(), PlatformHelper.getCornetSaturation(), MobEffectRegistry.SWEETS.get(), 900), 800, false));
    public static final RegistrySupplier<Item> JAM_ROLL = registerItem("jam_roll", () -> new EffectItem(getFoodItemSettings(PlatformHelper.getJamRollNutrition(), PlatformHelper.getJamRollSaturation(), MobEffectRegistry.SWEETS.get(), 900), 800, false));
    public static final RegistrySupplier<Item> WAFFLE = registerItem("waffle", () -> new EffectBlockItem(WAFFLE_BLOCK.get(), getFoodItemSettings(PlatformHelper.getWaffleNutrition(), PlatformHelper.getWaffleSaturation(), MobEffectRegistry.SUSTENANCE.get(), 800)));
    public static final RegistrySupplier<Item> CHOCOLATE_TRUFFLE = registerItem("chocolate_truffle", () -> new EffectItem(getFoodItemSettings(PlatformHelper.getChocolateTruffleNutrition(), PlatformHelper.getChocolateTruffleSaturation(), MobEffectRegistry.SWEETS.get(), 900), 200, false));
    public static final RegistrySupplier<Item> MISSLILITU_BISCUIT = registerItem("misslilitu_biscuit", () -> new EffectItem(getFoodItemSettings(PlatformHelper.getMisslilituBiscuitNutrition(), PlatformHelper.getMisslilituBiscuitSaturation(), MobEffectRegistry.SUSTENANCE.get(), 900), 4200, false));
    public static final RegistrySupplier<Item> BUN = registerItem("bun", () -> new EffectBlockItem(BUN_BLOCK.get(), getFoodItemSettings(PlatformHelper.getBunNutrition(), PlatformHelper.getBunSaturation(), MobEffectRegistry.SUSTENANCE.get(), 2800)));

    public static final RegistrySupplier<Block> CHOCOLATE_GATEAU = registerWithItem("chocolate_gateau", () -> new CakeBlock(BlockBehaviour.Properties.copy(Blocks.CAKE), CHOCOLATE_GATEAU_SLICE));
    public static final RegistrySupplier<Block> CHOCOLATE_TART = registerWithItem("chocolate_tart", () -> new ChocolateTart(BlockBehaviour.Properties.copy(Blocks.CAKE), CHOCOLATE_TART_SLICE));
    public static final RegistrySupplier<Block> BLANK_CAKE = registerWithoutItem("blank_cake", () -> new BlankCakeBlock(BlockBehaviour.Properties.copy(Blocks.CAKE).forceSolidOn()));
    public static final RegistrySupplier<Block> APPLE_CUPCAKE_BLOCK = registerWithoutItem("apple_cupcake_block", () -> new CupcakeBlock(BlockBehaviour.Properties.copy(Blocks.CAKE).instabreak().forceSolidOn()));
    public static final RegistrySupplier<Block> SWEETBERRY_CUPCAKE_BLOCK = registerWithoutItem("sweetberry_cupcake_block", () -> new CupcakeBlock(BlockBehaviour.Properties.copy(Blocks.CAKE).instabreak().forceSolidOn()));
    public static final RegistrySupplier<Block> STRAWBERRY_CUPCAKE_BLOCK = registerWithoutItem("strawberry_cupcake_block", () -> new CupcakeBlock(BlockBehaviour.Properties.copy(Blocks.CAKE).instabreak().forceSolidOn()));
    public static final RegistrySupplier<Block> CHOCOLATE_COOKIE_BLOCK = registerWithoutItem("chocolate_cookie_block", () -> new CookieBlock(BlockBehaviour.Properties.copy(Blocks.CAKE).instabreak().forceSolidOn()));
    public static final RegistrySupplier<Block> SWEETBERRY_COOKIE_BLOCK = registerWithoutItem("sweetberry_cookie_block", () -> new CookieBlock(BlockBehaviour.Properties.copy(Blocks.CAKE).instabreak().forceSolidOn()));
    public static final RegistrySupplier<Block> STRAWBERRY_COOKIE_BLOCK = registerWithoutItem("strawberry_cookie_block", () -> new CookieBlock(BlockBehaviour.Properties.copy(Blocks.CAKE).instabreak().forceSolidOn()));

    public static void init() {
        ITEMS.register();
        BLOCKS.register();
    }

    private static Item.Properties getSettings(Consumer<Item.Properties> consumer) {
        Item.Properties settings = new Item.Properties();
        consumer.accept(settings);
        return settings;
    }

    static Item.Properties getSettings() {
        return getSettings(settings -> {
        });
    }

    public static <T extends Block> RegistrySupplier<T> registerWithItem(String name, Supplier<T> block) {
        return Util.registerWithItem(BLOCKS, BLOCK_REGISTRAR, ITEMS, ITEM_REGISTRAR, new BakeryIdentifier(name), block);
    }


    public static <T extends Block> RegistrySupplier<T> registerWithoutItem(String path, Supplier<T> block) {
        return Util.registerWithoutItem(BLOCKS, BLOCK_REGISTRAR, new BakeryIdentifier(path), block);
    }

    public static <T extends Item> RegistrySupplier<T> registerItem(String path, Supplier<T> itemSupplier) {
        return Util.registerItem(ITEMS, ITEM_REGISTRAR, new BakeryIdentifier(path), itemSupplier);
    }

    private static Item.Properties getFoodItemSettings(int nutrition, float saturationMod, MobEffect effect, int duration) {
        return getFoodItemSettings(nutrition, saturationMod, effect, duration, true, false);
    }

    public static BlockBehaviour.Properties properties(float strength) {
        return properties(strength, strength);
    }

    public static BlockBehaviour.Properties properties(float breakSpeed, float explosionResist) {
        return BlockBehaviour.Properties.of().strength(breakSpeed, explosionResist);
    }

    private static Item.Properties getFoodItemSettings(int nutrition, float saturationMod, MobEffect effect, int duration, boolean alwaysEat, boolean fast) {
        return getSettings().food(createFood(nutrition, saturationMod, effect, duration, alwaysEat, fast));
    }

    private static FoodProperties createFood(int nutrition, float saturationMod, MobEffect effect, int duration, boolean alwaysEat, boolean fast) {
        FoodProperties.Builder food = new FoodProperties.Builder().nutrition(nutrition).saturationMod(saturationMod);
        if (alwaysEat) food.alwaysEat();
        if (fast) food.fast();
        if (effect != null) food.effect(new MobEffectInstance(effect, duration), 1.0f);
        return food.build();
    }
}

