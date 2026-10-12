package net.satisfy.bakery.platform.fabric;

import me.shedaniel.autoconfig.AutoConfig;
import net.satisfy.bakery.fabric.core.config.BakeryFabricConfig;
import net.satisfy.bakery.platform.PlatformHelper;

public class PlatformHelperImpl extends PlatformHelper {
    public static boolean shouldGiveEffect() {
        BakeryFabricConfig config = AutoConfig.getConfigHolder(BakeryFabricConfig.class).getConfig();
        return config.effects.completionistBannerEffect.bannerGiveEffect;
    }

    public static boolean shouldShowTooltip() {
        BakeryFabricConfig config = AutoConfig.getConfigHolder(BakeryFabricConfig.class).getConfig();
        return config.effects.completionistBannerEffect.bannerGiveEffect && config.effects.completionistBannerEffect.bannerShowTooltip;
    }

    public static boolean showBakerStationInfo() {
        BakeryFabricConfig config = AutoConfig.getConfigHolder(BakeryFabricConfig.class).getConfig();
        return config.infoTooltips.showBakerStationInfo;
    }

    public static boolean showJamPotInfo() {
        BakeryFabricConfig config = AutoConfig.getConfigHolder(BakeryFabricConfig.class).getConfig();
        return config.infoTooltips.showJamPotInfo;
    }

    public static boolean showDisplayInfo() {
        BakeryFabricConfig config = AutoConfig.getConfigHolder(BakeryFabricConfig.class).getConfig();
        return config.infoTooltips.showDisplayInfo;
    }

    public static boolean infoTooltipsNeedDungarees() {
        BakeryFabricConfig config = AutoConfig.getConfigHolder(BakeryFabricConfig.class).getConfig();
        return config.infoTooltips.needDungarees;
    }

    public static int getCroissantNutrition() {
        BakeryFabricConfig config = AutoConfig.getConfigHolder(BakeryFabricConfig.class).getConfig();
        return config.food.croissantNutrition;
    }

    public static float getCroissantSaturation() {
        BakeryFabricConfig config = AutoConfig.getConfigHolder(BakeryFabricConfig.class).getConfig();
        return config.food.croissantSaturation;
    }

    public static int getCrustyBreadNutrition() {
        BakeryFabricConfig config = AutoConfig.getConfigHolder(BakeryFabricConfig.class).getConfig();
        return config.food.crustyBreadNutrition;
    }

    public static float getCrustyBreadSaturation() {
        BakeryFabricConfig config = AutoConfig.getConfigHolder(BakeryFabricConfig.class).getConfig();
        return config.food.crustyBreadSaturation;
    }

    public static int getBreadNutrition() {
        BakeryFabricConfig config = AutoConfig.getConfigHolder(BakeryFabricConfig.class).getConfig();
        return config.food.breadNutrition;
    }

    public static float getBreadSaturation() {
        BakeryFabricConfig config = AutoConfig.getConfigHolder(BakeryFabricConfig.class).getConfig();
        return config.food.breadSaturation;
    }

    public static int getBaguetteNutrition() {
        BakeryFabricConfig config = AutoConfig.getConfigHolder(BakeryFabricConfig.class).getConfig();
        return config.food.baguetteNutrition;
    }

    public static float getBaguetteSaturation() {
        BakeryFabricConfig config = AutoConfig.getConfigHolder(BakeryFabricConfig.class).getConfig();
        return config.food.baguetteSaturation;
    }

    public static int getToastNutrition() {
        BakeryFabricConfig config = AutoConfig.getConfigHolder(BakeryFabricConfig.class).getConfig();
        return config.food.toastNutrition;
    }

    public static float getToastSaturation() {
        BakeryFabricConfig config = AutoConfig.getConfigHolder(BakeryFabricConfig.class).getConfig();
        return config.food.toastSaturation;
    }

    public static int getBraidedBreadNutrition() {
        BakeryFabricConfig config = AutoConfig.getConfigHolder(BakeryFabricConfig.class).getConfig();
        return config.food.braidedBreadNutrition;
    }

    public static float getBraidedBreadSaturation() {
        BakeryFabricConfig config = AutoConfig.getConfigHolder(BakeryFabricConfig.class).getConfig();
        return config.food.braidedBreadSaturation;
    }

    public static int getSandwichNutrition() {
        BakeryFabricConfig config = AutoConfig.getConfigHolder(BakeryFabricConfig.class).getConfig();
        return config.food.sandwichNutrition;
    }

    public static float getSandwichSaturation() {
        BakeryFabricConfig config = AutoConfig.getConfigHolder(BakeryFabricConfig.class).getConfig();
        return config.food.sandwichSaturation;
    }

    public static int getVegetableSandwichNutrition() {
        BakeryFabricConfig config = AutoConfig.getConfigHolder(BakeryFabricConfig.class).getConfig();
        return config.food.vegetableSandwichNutrition;
    }

    public static float getVegetableSandwichSaturation() {
        BakeryFabricConfig config = AutoConfig.getConfigHolder(BakeryFabricConfig.class).getConfig();
        return config.food.vegetableSandwichSaturation;
    }

    public static int getGrilledSalmonSandwichNutrition() {
        BakeryFabricConfig config = AutoConfig.getConfigHolder(BakeryFabricConfig.class).getConfig();
        return config.food.grilledSalmonSandwichNutrition;
    }

    public static float getGrilledSalmonSandwichSaturation() {
        BakeryFabricConfig config = AutoConfig.getConfigHolder(BakeryFabricConfig.class).getConfig();
        return config.food.grilledSalmonSandwichSaturation;
    }

    public static int getGrilledBaconSandwichNutrition() {
        BakeryFabricConfig config = AutoConfig.getConfigHolder(BakeryFabricConfig.class).getConfig();
        return config.food.grilledBaconSandwichNutrition;
    }

    public static float getGrilledBaconSandwichSaturation() {
        BakeryFabricConfig config = AutoConfig.getConfigHolder(BakeryFabricConfig.class).getConfig();
        return config.food.grilledBaconSandwichSaturation;
    }

    public static int getBreadWithJamNutrition() {
        BakeryFabricConfig config = AutoConfig.getConfigHolder(BakeryFabricConfig.class).getConfig();
        return config.food.breadWithJamNutrition;
    }

    public static float getBreadWithJamSaturation() {
        BakeryFabricConfig config = AutoConfig.getConfigHolder(BakeryFabricConfig.class).getConfig();
        return config.food.breadWithJamSaturation;
    }

    public static int getStrawberryCakeSliceNutrition() {
        BakeryFabricConfig config = AutoConfig.getConfigHolder(BakeryFabricConfig.class).getConfig();
        return config.food.strawberryCakeSliceNutrition;
    }

    public static float getStrawberryCakeSliceSaturation() {
        BakeryFabricConfig config = AutoConfig.getConfigHolder(BakeryFabricConfig.class).getConfig();
        return config.food.strawberryCakeSliceSaturation;
    }

    public static int getSweetberryCakeSliceNutrition() {
        BakeryFabricConfig config = AutoConfig.getConfigHolder(BakeryFabricConfig.class).getConfig();
        return config.food.sweetberryCakeSliceNutrition;
    }

    public static float getSweetberryCakeSliceSaturation() {
        BakeryFabricConfig config = AutoConfig.getConfigHolder(BakeryFabricConfig.class).getConfig();
        return config.food.sweetberryCakeSliceSaturation;
    }

    public static int getChocolateCakeSliceNutrition() {
        BakeryFabricConfig config = AutoConfig.getConfigHolder(BakeryFabricConfig.class).getConfig();
        return config.food.chocolateCakeSliceNutrition;
    }

    public static float getChocolateCakeSliceSaturation() {
        BakeryFabricConfig config = AutoConfig.getConfigHolder(BakeryFabricConfig.class).getConfig();
        return config.food.chocolateCakeSliceSaturation;
    }

    public static int getChocolateGateauSliceNutrition() {
        BakeryFabricConfig config = AutoConfig.getConfigHolder(BakeryFabricConfig.class).getConfig();
        return config.food.chocolateGateauSliceNutrition;
    }

    public static float getChocolateGateauSliceSaturation() {
        BakeryFabricConfig config = AutoConfig.getConfigHolder(BakeryFabricConfig.class).getConfig();
        return config.food.chocolateGateauSliceSaturation;
    }

    public static int getBundtCakeSliceNutrition() {
        BakeryFabricConfig config = AutoConfig.getConfigHolder(BakeryFabricConfig.class).getConfig();
        return config.food.bundtCakeSliceNutrition;
    }

    public static float getBundtCakeSliceSaturation() {
        BakeryFabricConfig config = AutoConfig.getConfigHolder(BakeryFabricConfig.class).getConfig();
        return config.food.bundtCakeSliceSaturation;
    }

    public static int getLinzerTartSliceNutrition() {
        BakeryFabricConfig config = AutoConfig.getConfigHolder(BakeryFabricConfig.class).getConfig();
        return config.food.linzerTartSliceNutrition;
    }

    public static float getLinzerTartSliceSaturation() {
        BakeryFabricConfig config = AutoConfig.getConfigHolder(BakeryFabricConfig.class).getConfig();
        return config.food.linzerTartSliceSaturation;
    }

    public static int getApplePieSliceNutrition() {
        BakeryFabricConfig config = AutoConfig.getConfigHolder(BakeryFabricConfig.class).getConfig();
        return config.food.applePieSliceNutrition;
    }

    public static float getApplePieSliceSaturation() {
        BakeryFabricConfig config = AutoConfig.getConfigHolder(BakeryFabricConfig.class).getConfig();
        return config.food.applePieSliceSaturation;
    }

    public static int getGlowberryPieSliceNutrition() {
        BakeryFabricConfig config = AutoConfig.getConfigHolder(BakeryFabricConfig.class).getConfig();
        return config.food.glowberryPieSliceNutrition;
    }

    public static float getGlowberryPieSliceSaturation() {
        BakeryFabricConfig config = AutoConfig.getConfigHolder(BakeryFabricConfig.class).getConfig();
        return config.food.glowberryPieSliceSaturation;
    }

    public static int getChocolateTartSliceNutrition() {
        BakeryFabricConfig config = AutoConfig.getConfigHolder(BakeryFabricConfig.class).getConfig();
        return config.food.chocolateTartSliceNutrition;
    }

    public static float getChocolateTartSliceSaturation() {
        BakeryFabricConfig config = AutoConfig.getConfigHolder(BakeryFabricConfig.class).getConfig();
        return config.food.chocolateTartSliceSaturation;
    }

    public static int getPuddingSliceNutrition() {
        BakeryFabricConfig config = AutoConfig.getConfigHolder(BakeryFabricConfig.class).getConfig();
        return config.food.puddingSliceNutrition;
    }

    public static float getPuddingSliceSaturation() {
        BakeryFabricConfig config = AutoConfig.getConfigHolder(BakeryFabricConfig.class).getConfig();
        return config.food.puddingSliceSaturation;
    }

    public static int getStrawberryGlazedCookieNutrition() {
        BakeryFabricConfig config = AutoConfig.getConfigHolder(BakeryFabricConfig.class).getConfig();
        return config.food.strawberryGlazedCookieNutrition;
    }

    public static float getStrawberryGlazedCookieSaturation() {
        BakeryFabricConfig config = AutoConfig.getConfigHolder(BakeryFabricConfig.class).getConfig();
        return config.food.strawberryGlazedCookieSaturation;
    }

    public static int getSweetberryGlazedCookieNutrition() {
        BakeryFabricConfig config = AutoConfig.getConfigHolder(BakeryFabricConfig.class).getConfig();
        return config.food.sweetberryGlazedCookieNutrition;
    }

    public static float getSweetberryGlazedCookieSaturation() {
        BakeryFabricConfig config = AutoConfig.getConfigHolder(BakeryFabricConfig.class).getConfig();
        return config.food.sweetberryGlazedCookieSaturation;
    }

    public static int getChocolateGlazedCookieNutrition() {
        BakeryFabricConfig config = AutoConfig.getConfigHolder(BakeryFabricConfig.class).getConfig();
        return config.food.chocolateGlazedCookieNutrition;
    }

    public static float getChocolateGlazedCookieSaturation() {
        BakeryFabricConfig config = AutoConfig.getConfigHolder(BakeryFabricConfig.class).getConfig();
        return config.food.chocolateGlazedCookieSaturation;
    }

    public static int getStrawberryCupcakeNutrition() {
        BakeryFabricConfig config = AutoConfig.getConfigHolder(BakeryFabricConfig.class).getConfig();
        return config.food.strawberryCupcakeNutrition;
    }

    public static float getStrawberryCupcakeSaturation() {
        BakeryFabricConfig config = AutoConfig.getConfigHolder(BakeryFabricConfig.class).getConfig();
        return config.food.strawberryCupcakeSaturation;
    }

    public static int getSweetberryCupcakeNutrition() {
        BakeryFabricConfig config = AutoConfig.getConfigHolder(BakeryFabricConfig.class).getConfig();
        return config.food.sweetberryCupcakeNutrition;
    }

    public static float getSweetberryCupcakeSaturation() {
        BakeryFabricConfig config = AutoConfig.getConfigHolder(BakeryFabricConfig.class).getConfig();
        return config.food.sweetberryCupcakeSaturation;
    }

    public static int getAppleCupcakeNutrition() {
        BakeryFabricConfig config = AutoConfig.getConfigHolder(BakeryFabricConfig.class).getConfig();
        return config.food.appleCupcakeNutrition;
    }

    public static float getAppleCupcakeSaturation() {
        BakeryFabricConfig config = AutoConfig.getConfigHolder(BakeryFabricConfig.class).getConfig();
        return config.food.appleCupcakeSaturation;
    }

    public static int getCornetNutrition() {
        BakeryFabricConfig config = AutoConfig.getConfigHolder(BakeryFabricConfig.class).getConfig();
        return config.food.cornetNutrition;
    }

    public static float getCornetSaturation() {
        BakeryFabricConfig config = AutoConfig.getConfigHolder(BakeryFabricConfig.class).getConfig();
        return config.food.cornetSaturation;
    }

    public static int getJamRollNutrition() {
        BakeryFabricConfig config = AutoConfig.getConfigHolder(BakeryFabricConfig.class).getConfig();
        return config.food.jamRollNutrition;
    }

    public static float getJamRollSaturation() {
        BakeryFabricConfig config = AutoConfig.getConfigHolder(BakeryFabricConfig.class).getConfig();
        return config.food.jamRollSaturation;
    }

    public static int getWaffleNutrition() {
        BakeryFabricConfig config = AutoConfig.getConfigHolder(BakeryFabricConfig.class).getConfig();
        return config.food.waffleNutrition;
    }

    public static float getWaffleSaturation() {
        BakeryFabricConfig config = AutoConfig.getConfigHolder(BakeryFabricConfig.class).getConfig();
        return config.food.waffleSaturation;
    }

    public static int getChocolateTruffleNutrition() {
        BakeryFabricConfig config = AutoConfig.getConfigHolder(BakeryFabricConfig.class).getConfig();
        return config.food.chocolateTruffleNutrition;
    }

    public static float getChocolateTruffleSaturation() {
        BakeryFabricConfig config = AutoConfig.getConfigHolder(BakeryFabricConfig.class).getConfig();
        return config.food.chocolateTruffleSaturation;
    }

    public static int getMisslilituBiscuitNutrition() {
        BakeryFabricConfig config = AutoConfig.getConfigHolder(BakeryFabricConfig.class).getConfig();
        return config.food.misslilituBiscuitNutrition;
    }

    public static float getMisslilituBiscuitSaturation() {
        BakeryFabricConfig config = AutoConfig.getConfigHolder(BakeryFabricConfig.class).getConfig();
        return config.food.misslilituBiscuitSaturation;
    }

    public static int getBunNutrition() {
        BakeryFabricConfig config = AutoConfig.getConfigHolder(BakeryFabricConfig.class).getConfig();
        return config.food.bunNutrition;
    }

    public static float getBunSaturation() {
        BakeryFabricConfig config = AutoConfig.getConfigHolder(BakeryFabricConfig.class).getConfig();
        return config.food.bunSaturation;
    }

    public static int getVitalityEffectInterval() {
        BakeryFabricConfig config = AutoConfig.getConfigHolder(BakeryFabricConfig.class).getConfig();
        return config.effects.vitalityEffect.vitalityEffectInterval;
    }

    public static float getVitalityEffectExhaustionReduction() {
        BakeryFabricConfig config = AutoConfig.getConfigHolder(BakeryFabricConfig.class).getConfig();
        return config.effects.vitalityEffect.vitalityEffectExhaustionReduction;
    }

    public static int getSugarRushMaxStacks() {
        BakeryFabricConfig config = AutoConfig.getConfigHolder(BakeryFabricConfig.class).getConfig();
        return config.effects.sugarRushEffect.sugarRushMaxStacks;
    }

    public static double getSugarRushBonusPerStack() {
        BakeryFabricConfig config = AutoConfig.getConfigHolder(BakeryFabricConfig.class).getConfig();
        return config.effects.sugarRushEffect.sugarRushBonusPerStack;
    }

    public static int getSugarRushAttackSpeedStacks() {
        BakeryFabricConfig config = AutoConfig.getConfigHolder(BakeryFabricConfig.class).getConfig();
        return config.effects.sugarRushEffect.sugarRushAttackSpeedStacks;
    }

    public static boolean isSugarRushAttackSpeedEnabled() {
        BakeryFabricConfig config = AutoConfig.getConfigHolder(BakeryFabricConfig.class).getConfig();
        return config.effects.sugarRushEffect.sugarRushAttackSpeed;
    }

    public static int getBannerEffectRadius() {
        BakeryFabricConfig config = AutoConfig.getConfigHolder(BakeryFabricConfig.class).getConfig();
        return config.effects.completionistBannerEffect.bannerEffectRadius;
    }

    public static int getBannerEffectAmplifier() {
        BakeryFabricConfig config = AutoConfig.getConfigHolder(BakeryFabricConfig.class).getConfig();
        return config.effects.completionistBannerEffect.bannerEffectAmplifier;
    }

    public static boolean animationsEnabled() {
        BakeryFabricConfig config = AutoConfig.getConfigHolder(BakeryFabricConfig.class).getConfig();
        return config.misc.animations;
    }

    public static boolean isBakerStationAnimationEnabled() {
        BakeryFabricConfig config = AutoConfig.getConfigHolder(BakeryFabricConfig.class).getConfig();
        return config.misc.kneadingAnimation;
    }

    public static boolean isKneadingEnabled() {
        BakeryFabricConfig config = AutoConfig.getConfigHolder(BakeryFabricConfig.class).getConfig();
        return config.baking.enableKneading;
    }

    public static int getKneadPresses() {
        BakeryFabricConfig config = AutoConfig.getConfigHolder(BakeryFabricConfig.class).getConfig();
        return config.baking.kneadPresses;
    }

    public static int getRollingPinPresses() {
        BakeryFabricConfig config = AutoConfig.getConfigHolder(BakeryFabricConfig.class).getConfig();
        return config.baking.rollingPinPresses;
    }

    public static int getKnifeDuration() {
        BakeryFabricConfig config = AutoConfig.getConfigHolder(BakeryFabricConfig.class).getConfig();
        return config.baking.knifeDuration;
    }

    public static int getJamDuration() {
        BakeryFabricConfig config = AutoConfig.getConfigHolder(BakeryFabricConfig.class).getConfig();
        return config.baking.jamDuration;
    }

    public static float getKnifeAttackSpeed() {
        BakeryFabricConfig config = AutoConfig.getConfigHolder(BakeryFabricConfig.class).getConfig();
        return (float) config.baking.knifeAttackSpeed;
    }

    public static float getRollingPinAttackSpeed() {
        BakeryFabricConfig config = AutoConfig.getConfigHolder(BakeryFabricConfig.class).getConfig();
        return (float) config.baking.rollingPinAttackSpeed;
    }

    public static int getCroissantEffectDuration() {
        BakeryFabricConfig config = AutoConfig.getConfigHolder(BakeryFabricConfig.class).getConfig();
        return config.food.croissantEffectDuration;
    }

    public static int getCrustyBreadEffectDuration() {
        BakeryFabricConfig config = AutoConfig.getConfigHolder(BakeryFabricConfig.class).getConfig();
        return config.food.crustyBreadEffectDuration;
    }

    public static int getBreadEffectDuration() {
        BakeryFabricConfig config = AutoConfig.getConfigHolder(BakeryFabricConfig.class).getConfig();
        return config.food.breadEffectDuration;
    }

    public static int getBaguetteEffectDuration() {
        BakeryFabricConfig config = AutoConfig.getConfigHolder(BakeryFabricConfig.class).getConfig();
        return config.food.baguetteEffectDuration;
    }

    public static int getToastEffectDuration() {
        BakeryFabricConfig config = AutoConfig.getConfigHolder(BakeryFabricConfig.class).getConfig();
        return config.food.toastEffectDuration;
    }

    public static int getBraidedBreadEffectDuration() {
        BakeryFabricConfig config = AutoConfig.getConfigHolder(BakeryFabricConfig.class).getConfig();
        return config.food.braidedBreadEffectDuration;
    }

    public static int getSandwichEffectDuration() {
        BakeryFabricConfig config = AutoConfig.getConfigHolder(BakeryFabricConfig.class).getConfig();
        return config.food.sandwichEffectDuration;
    }

    public static int getVegetableSandwichEffectDuration() {
        BakeryFabricConfig config = AutoConfig.getConfigHolder(BakeryFabricConfig.class).getConfig();
        return config.food.vegetableSandwichEffectDuration;
    }

    public static int getGrilledSalmonSandwichEffectDuration() {
        BakeryFabricConfig config = AutoConfig.getConfigHolder(BakeryFabricConfig.class).getConfig();
        return config.food.grilledSalmonSandwichEffectDuration;
    }

    public static int getGrilledBaconSandwichEffectDuration() {
        BakeryFabricConfig config = AutoConfig.getConfigHolder(BakeryFabricConfig.class).getConfig();
        return config.food.grilledBaconSandwichEffectDuration;
    }

    public static int getBreadWithJamEffectDuration() {
        BakeryFabricConfig config = AutoConfig.getConfigHolder(BakeryFabricConfig.class).getConfig();
        return config.food.breadWithJamEffectDuration;
    }

    public static int getStrawberryCakeSliceEffectDuration() {
        BakeryFabricConfig config = AutoConfig.getConfigHolder(BakeryFabricConfig.class).getConfig();
        return config.food.strawberryCakeSliceEffectDuration;
    }

    public static int getSweetberryCakeSliceEffectDuration() {
        BakeryFabricConfig config = AutoConfig.getConfigHolder(BakeryFabricConfig.class).getConfig();
        return config.food.sweetberryCakeSliceEffectDuration;
    }

    public static int getChocolateCakeSliceEffectDuration() {
        BakeryFabricConfig config = AutoConfig.getConfigHolder(BakeryFabricConfig.class).getConfig();
        return config.food.chocolateCakeSliceEffectDuration;
    }

    public static int getChocolateGateauSliceEffectDuration() {
        BakeryFabricConfig config = AutoConfig.getConfigHolder(BakeryFabricConfig.class).getConfig();
        return config.food.chocolateGateauSliceEffectDuration;
    }

    public static int getBundtCakeSliceEffectDuration() {
        BakeryFabricConfig config = AutoConfig.getConfigHolder(BakeryFabricConfig.class).getConfig();
        return config.food.bundtCakeSliceEffectDuration;
    }

    public static int getLinzerTartSliceEffectDuration() {
        BakeryFabricConfig config = AutoConfig.getConfigHolder(BakeryFabricConfig.class).getConfig();
        return config.food.linzerTartSliceEffectDuration;
    }

    public static int getApplePieSliceEffectDuration() {
        BakeryFabricConfig config = AutoConfig.getConfigHolder(BakeryFabricConfig.class).getConfig();
        return config.food.applePieSliceEffectDuration;
    }

    public static int getGlowberryPieSliceEffectDuration() {
        BakeryFabricConfig config = AutoConfig.getConfigHolder(BakeryFabricConfig.class).getConfig();
        return config.food.glowberryPieSliceEffectDuration;
    }

    public static int getChocolateTartSliceEffectDuration() {
        BakeryFabricConfig config = AutoConfig.getConfigHolder(BakeryFabricConfig.class).getConfig();
        return config.food.chocolateTartSliceEffectDuration;
    }

    public static int getPuddingSliceEffectDuration() {
        BakeryFabricConfig config = AutoConfig.getConfigHolder(BakeryFabricConfig.class).getConfig();
        return config.food.puddingSliceEffectDuration;
    }

    public static int getStrawberryGlazedCookieEffectDuration() {
        BakeryFabricConfig config = AutoConfig.getConfigHolder(BakeryFabricConfig.class).getConfig();
        return config.food.strawberryGlazedCookieEffectDuration;
    }

    public static int getSweetberryGlazedCookieEffectDuration() {
        BakeryFabricConfig config = AutoConfig.getConfigHolder(BakeryFabricConfig.class).getConfig();
        return config.food.sweetberryGlazedCookieEffectDuration;
    }

    public static int getChocolateGlazedCookieEffectDuration() {
        BakeryFabricConfig config = AutoConfig.getConfigHolder(BakeryFabricConfig.class).getConfig();
        return config.food.chocolateGlazedCookieEffectDuration;
    }

    public static int getStrawberryCupcakeEffectDuration() {
        BakeryFabricConfig config = AutoConfig.getConfigHolder(BakeryFabricConfig.class).getConfig();
        return config.food.strawberryCupcakeEffectDuration;
    }

    public static int getSweetberryCupcakeEffectDuration() {
        BakeryFabricConfig config = AutoConfig.getConfigHolder(BakeryFabricConfig.class).getConfig();
        return config.food.sweetberryCupcakeEffectDuration;
    }

    public static int getAppleCupcakeEffectDuration() {
        BakeryFabricConfig config = AutoConfig.getConfigHolder(BakeryFabricConfig.class).getConfig();
        return config.food.appleCupcakeEffectDuration;
    }

    public static int getCornetEffectDuration() {
        BakeryFabricConfig config = AutoConfig.getConfigHolder(BakeryFabricConfig.class).getConfig();
        return config.food.cornetEffectDuration;
    }

    public static int getJamRollEffectDuration() {
        BakeryFabricConfig config = AutoConfig.getConfigHolder(BakeryFabricConfig.class).getConfig();
        return config.food.jamRollEffectDuration;
    }

    public static int getChocolateTruffleEffectDuration() {
        BakeryFabricConfig config = AutoConfig.getConfigHolder(BakeryFabricConfig.class).getConfig();
        return config.food.chocolateTruffleEffectDuration;
    }

    public static int getMisslilituBiscuitEffectDuration() {
        BakeryFabricConfig config = AutoConfig.getConfigHolder(BakeryFabricConfig.class).getConfig();
        return config.food.misslilituBiscuitEffectDuration;
    }

    public static int getWaffleEffectDuration() {
        BakeryFabricConfig config = AutoConfig.getConfigHolder(BakeryFabricConfig.class).getConfig();
        return config.food.waffleEffectDuration;
    }

    public static int getBunEffectDuration() {
        BakeryFabricConfig config = AutoConfig.getConfigHolder(BakeryFabricConfig.class).getConfig();
        return config.food.bunEffectDuration;
    }
}
