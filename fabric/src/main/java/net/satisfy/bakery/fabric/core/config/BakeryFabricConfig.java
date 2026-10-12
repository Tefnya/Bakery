package net.satisfy.bakery.fabric.core.config;

import me.shedaniel.autoconfig.ConfigData;
import me.shedaniel.autoconfig.annotation.Config;
import me.shedaniel.autoconfig.annotation.ConfigEntry;

@Config(name = "bakery")
@Config.Gui.Background("minecraft:textures/block/bricks.png")
public class BakeryFabricConfig implements ConfigData {
    @ConfigEntry.Gui.CollapsibleObject
    public BakingSettings baking = new BakingSettings();

    @ConfigEntry.Gui.CollapsibleObject
    public InfoTooltipSettings infoTooltips = new InfoTooltipSettings();

    @ConfigEntry.Gui.CollapsibleObject
    public EffectsSettings effects = new EffectsSettings();

    @ConfigEntry.Gui.CollapsibleObject
    public MiscSettings misc = new MiscSettings();

    @ConfigEntry.Gui.CollapsibleObject
    public FoodSettings food = new FoodSettings();

    public static class BakingSettings {
        @ConfigEntry.Gui.Tooltip
        public boolean enableKneading = true;

        @ConfigEntry.Gui.Tooltip
        @ConfigEntry.BoundedDiscrete(min = 1, max = 50)
        public int kneadPresses = 8;

        @ConfigEntry.Gui.Tooltip
        @ConfigEntry.BoundedDiscrete(min = 1, max = 50)
        public int rollingPinPresses = 5;

        @ConfigEntry.Gui.Tooltip
        @ConfigEntry.BoundedDiscrete(min = 1, max = 400)
        public int knifeDuration = 10;

        @ConfigEntry.Gui.Tooltip
        @ConfigEntry.BoundedDiscrete(min = 1, max = 400)
        public int jamDuration = 16;

        @ConfigEntry.Gui.Tooltip
        public float knifeAttackSpeed = 2.0f;

        @ConfigEntry.Gui.Tooltip
        public float rollingPinAttackSpeed = 1.2f;
    }

    public static class InfoTooltipSettings {
        @ConfigEntry.Gui.Tooltip
        public boolean needDungarees = false;

        @ConfigEntry.Gui.Tooltip
        public boolean showBakerStationInfo = true;

        @ConfigEntry.Gui.Tooltip
        public boolean showJamPotInfo = true;

        @ConfigEntry.Gui.Tooltip
        public boolean showDisplayInfo = true;
    }

    public static class EffectsSettings {
        @ConfigEntry.Gui.CollapsibleObject
        public VitalityEffectSettings vitalityEffect = new VitalityEffectSettings();

        @ConfigEntry.Gui.CollapsibleObject
        public SugarRushEffectSettings sugarRushEffect = new SugarRushEffectSettings();

        @ConfigEntry.Gui.CollapsibleObject
        public CompletionistBannerEffectSettings completionistBannerEffect = new CompletionistBannerEffectSettings();

        public static class VitalityEffectSettings {
            @ConfigEntry.Gui.Tooltip
            @ConfigEntry.BoundedDiscrete(min = 1, max = 200)
            public int vitalityEffectInterval = 10;

            @ConfigEntry.Gui.Tooltip
            public float vitalityEffectExhaustionReduction = 0.08f;
        }

        public static class SugarRushEffectSettings {
            @ConfigEntry.Gui.Tooltip
            @ConfigEntry.BoundedDiscrete(min = 1, max = 50)
            public int sugarRushMaxStacks = 10;

            @ConfigEntry.Gui.Tooltip
            public double sugarRushBonusPerStack = 0.02;

            @ConfigEntry.Gui.Tooltip
            @ConfigEntry.BoundedDiscrete(min = 1, max = 50)
            public int sugarRushAttackSpeedStacks = 5;

            @ConfigEntry.Gui.Tooltip
            public boolean sugarRushAttackSpeed = true;
        }

        public static class CompletionistBannerEffectSettings {
            @ConfigEntry.Gui.Tooltip
            public boolean bannerGiveEffect = true;

            @ConfigEntry.Gui.Tooltip
            @ConfigEntry.BoundedDiscrete(min = 1, max = 32)
            public int bannerEffectRadius = 8;

            @ConfigEntry.Gui.Tooltip
            @ConfigEntry.BoundedDiscrete(min = 0, max = 4)
            public int bannerEffectAmplifier = 1;

            @ConfigEntry.Gui.Tooltip
            public boolean bannerShowTooltip = true;
        }
    }

    public static class MiscSettings {
        @ConfigEntry.Gui.Tooltip
        public boolean animations = true;

        @ConfigEntry.Gui.Tooltip
        public boolean kneadingAnimation = true;
    }

    public static class FoodSettings {
        @ConfigEntry.Gui.Tooltip
        @ConfigEntry.BoundedDiscrete(min = 0, max = 20)
        public int cakeDoughNutrition = 2;

        @ConfigEntry.Gui.Tooltip
        public float cakeDoughSaturation = 0.1f;

        @ConfigEntry.Gui.Tooltip
        @ConfigEntry.BoundedDiscrete(min = 0, max = 20)
        public int sweetDoughNutrition = 2;

        @ConfigEntry.Gui.Tooltip
        public float sweetDoughSaturation = 0.1f;

        @ConfigEntry.Gui.Tooltip
        @ConfigEntry.BoundedDiscrete(min = 0, max = 20)
        public int croissantNutrition = 4;

        @ConfigEntry.Gui.Tooltip
        public float croissantSaturation = 0.5f;

        @ConfigEntry.Gui.Tooltip
        @ConfigEntry.BoundedDiscrete(min = 0, max = 72000)
        public int croissantEffectDuration = 900;

        @ConfigEntry.Gui.Tooltip
        @ConfigEntry.BoundedDiscrete(min = 0, max = 20)
        public int crustyBreadNutrition = 5;

        @ConfigEntry.Gui.Tooltip
        public float crustyBreadSaturation = 0.6f;

        @ConfigEntry.Gui.Tooltip
        @ConfigEntry.BoundedDiscrete(min = 0, max = 72000)
        public int crustyBreadEffectDuration = 4800;

        @ConfigEntry.Gui.Tooltip
        @ConfigEntry.BoundedDiscrete(min = 0, max = 20)
        public int breadNutrition = 5;

        @ConfigEntry.Gui.Tooltip
        public float breadSaturation = 0.6f;

        @ConfigEntry.Gui.Tooltip
        @ConfigEntry.BoundedDiscrete(min = 0, max = 72000)
        public int breadEffectDuration = 4200;

        @ConfigEntry.Gui.Tooltip
        @ConfigEntry.BoundedDiscrete(min = 0, max = 20)
        public int baguetteNutrition = 6;

        @ConfigEntry.Gui.Tooltip
        public float baguetteSaturation = 0.6f;

        @ConfigEntry.Gui.Tooltip
        @ConfigEntry.BoundedDiscrete(min = 0, max = 72000)
        public int baguetteEffectDuration = 4200;

        @ConfigEntry.Gui.Tooltip
        @ConfigEntry.BoundedDiscrete(min = 0, max = 20)
        public int toastNutrition = 3;

        @ConfigEntry.Gui.Tooltip
        public float toastSaturation = 0.5f;

        @ConfigEntry.Gui.Tooltip
        @ConfigEntry.BoundedDiscrete(min = 0, max = 72000)
        public int toastEffectDuration = 5400;

        @ConfigEntry.Gui.Tooltip
        @ConfigEntry.BoundedDiscrete(min = 0, max = 20)
        public int braidedBreadNutrition = 6;

        @ConfigEntry.Gui.Tooltip
        public float braidedBreadSaturation = 0.6f;

        @ConfigEntry.Gui.Tooltip
        @ConfigEntry.BoundedDiscrete(min = 0, max = 72000)
        public int braidedBreadEffectDuration = 4200;

        @ConfigEntry.Gui.Tooltip
        @ConfigEntry.BoundedDiscrete(min = 0, max = 20)
        public int sandwichNutrition = 9;

        @ConfigEntry.Gui.Tooltip
        public float sandwichSaturation = 0.8f;

        @ConfigEntry.Gui.Tooltip
        @ConfigEntry.BoundedDiscrete(min = 0, max = 72000)
        public int sandwichEffectDuration = 1500;

        @ConfigEntry.Gui.Tooltip
        @ConfigEntry.BoundedDiscrete(min = 0, max = 20)
        public int vegetableSandwichNutrition = 7;

        @ConfigEntry.Gui.Tooltip
        public float vegetableSandwichSaturation = 0.6f;

        @ConfigEntry.Gui.Tooltip
        @ConfigEntry.BoundedDiscrete(min = 0, max = 72000)
        public int vegetableSandwichEffectDuration = 1800;

        @ConfigEntry.Gui.Tooltip
        @ConfigEntry.BoundedDiscrete(min = 0, max = 20)
        public int grilledSalmonSandwichNutrition = 8;

        @ConfigEntry.Gui.Tooltip
        public float grilledSalmonSandwichSaturation = 0.8f;

        @ConfigEntry.Gui.Tooltip
        @ConfigEntry.BoundedDiscrete(min = 0, max = 72000)
        public int grilledSalmonSandwichEffectDuration = 1200;

        @ConfigEntry.Gui.Tooltip
        @ConfigEntry.BoundedDiscrete(min = 0, max = 20)
        public int grilledBaconSandwichNutrition = 8;

        @ConfigEntry.Gui.Tooltip
        public float grilledBaconSandwichSaturation = 0.8f;

        @ConfigEntry.Gui.Tooltip
        @ConfigEntry.BoundedDiscrete(min = 0, max = 72000)
        public int grilledBaconSandwichEffectDuration = 1200;

        @ConfigEntry.Gui.Tooltip
        @ConfigEntry.BoundedDiscrete(min = 0, max = 20)
        public int breadWithJamNutrition = 3;

        @ConfigEntry.Gui.Tooltip
        public float breadWithJamSaturation = 0.5f;

        @ConfigEntry.Gui.Tooltip
        @ConfigEntry.BoundedDiscrete(min = 0, max = 72000)
        public int breadWithJamEffectDuration = 400;

        @ConfigEntry.Gui.Tooltip
        @ConfigEntry.BoundedDiscrete(min = 0, max = 20)
        public int strawberryCakeSliceNutrition = 4;

        @ConfigEntry.Gui.Tooltip
        public float strawberryCakeSliceSaturation = 0.6f;

        @ConfigEntry.Gui.Tooltip
        @ConfigEntry.BoundedDiscrete(min = 0, max = 72000)
        public int strawberryCakeSliceEffectDuration = 600;

        @ConfigEntry.Gui.Tooltip
        @ConfigEntry.BoundedDiscrete(min = 0, max = 20)
        public int sweetberryCakeSliceNutrition = 4;

        @ConfigEntry.Gui.Tooltip
        public float sweetberryCakeSliceSaturation = 0.6f;

        @ConfigEntry.Gui.Tooltip
        @ConfigEntry.BoundedDiscrete(min = 0, max = 72000)
        public int sweetberryCakeSliceEffectDuration = 600;

        @ConfigEntry.Gui.Tooltip
        @ConfigEntry.BoundedDiscrete(min = 0, max = 20)
        public int chocolateCakeSliceNutrition = 4;

        @ConfigEntry.Gui.Tooltip
        public float chocolateCakeSliceSaturation = 0.7f;

        @ConfigEntry.Gui.Tooltip
        @ConfigEntry.BoundedDiscrete(min = 0, max = 72000)
        public int chocolateCakeSliceEffectDuration = 600;

        @ConfigEntry.Gui.Tooltip
        @ConfigEntry.BoundedDiscrete(min = 0, max = 20)
        public int chocolateGateauSliceNutrition = 4;

        @ConfigEntry.Gui.Tooltip
        public float chocolateGateauSliceSaturation = 0.7f;

        @ConfigEntry.Gui.Tooltip
        @ConfigEntry.BoundedDiscrete(min = 0, max = 72000)
        public int chocolateGateauSliceEffectDuration = 600;

        @ConfigEntry.Gui.Tooltip
        @ConfigEntry.BoundedDiscrete(min = 0, max = 20)
        public int bundtCakeSliceNutrition = 3;

        @ConfigEntry.Gui.Tooltip
        public float bundtCakeSliceSaturation = 0.6f;

        @ConfigEntry.Gui.Tooltip
        @ConfigEntry.BoundedDiscrete(min = 0, max = 72000)
        public int bundtCakeSliceEffectDuration = 600;

        @ConfigEntry.Gui.Tooltip
        @ConfigEntry.BoundedDiscrete(min = 0, max = 20)
        public int linzerTartSliceNutrition = 4;

        @ConfigEntry.Gui.Tooltip
        public float linzerTartSliceSaturation = 0.6f;

        @ConfigEntry.Gui.Tooltip
        @ConfigEntry.BoundedDiscrete(min = 0, max = 72000)
        public int linzerTartSliceEffectDuration = 600;

        @ConfigEntry.Gui.Tooltip
        @ConfigEntry.BoundedDiscrete(min = 0, max = 20)
        public int applePieSliceNutrition = 4;

        @ConfigEntry.Gui.Tooltip
        public float applePieSliceSaturation = 0.6f;

        @ConfigEntry.Gui.Tooltip
        @ConfigEntry.BoundedDiscrete(min = 0, max = 72000)
        public int applePieSliceEffectDuration = 600;

        @ConfigEntry.Gui.Tooltip
        @ConfigEntry.BoundedDiscrete(min = 0, max = 20)
        public int glowberryPieSliceNutrition = 4;

        @ConfigEntry.Gui.Tooltip
        public float glowberryPieSliceSaturation = 0.6f;

        @ConfigEntry.Gui.Tooltip
        @ConfigEntry.BoundedDiscrete(min = 0, max = 72000)
        public int glowberryPieSliceEffectDuration = 600;

        @ConfigEntry.Gui.Tooltip
        @ConfigEntry.BoundedDiscrete(min = 0, max = 20)
        public int chocolateTartSliceNutrition = 4;

        @ConfigEntry.Gui.Tooltip
        public float chocolateTartSliceSaturation = 0.7f;

        @ConfigEntry.Gui.Tooltip
        @ConfigEntry.BoundedDiscrete(min = 0, max = 72000)
        public int chocolateTartSliceEffectDuration = 600;

        @ConfigEntry.Gui.Tooltip
        @ConfigEntry.BoundedDiscrete(min = 0, max = 20)
        public int puddingSliceNutrition = 3;

        @ConfigEntry.Gui.Tooltip
        public float puddingSliceSaturation = 0.6f;

        @ConfigEntry.Gui.Tooltip
        @ConfigEntry.BoundedDiscrete(min = 0, max = 72000)
        public int puddingSliceEffectDuration = 600;

        @ConfigEntry.Gui.Tooltip
        @ConfigEntry.BoundedDiscrete(min = 0, max = 20)
        public int strawberryGlazedCookieNutrition = 3;

        @ConfigEntry.Gui.Tooltip
        public float strawberryGlazedCookieSaturation = 0.4f;

        @ConfigEntry.Gui.Tooltip
        @ConfigEntry.BoundedDiscrete(min = 0, max = 72000)
        public int strawberryGlazedCookieEffectDuration = 400;

        @ConfigEntry.Gui.Tooltip
        @ConfigEntry.BoundedDiscrete(min = 0, max = 20)
        public int sweetberryGlazedCookieNutrition = 3;

        @ConfigEntry.Gui.Tooltip
        public float sweetberryGlazedCookieSaturation = 0.4f;

        @ConfigEntry.Gui.Tooltip
        @ConfigEntry.BoundedDiscrete(min = 0, max = 72000)
        public int sweetberryGlazedCookieEffectDuration = 400;

        @ConfigEntry.Gui.Tooltip
        @ConfigEntry.BoundedDiscrete(min = 0, max = 20)
        public int chocolateGlazedCookieNutrition = 3;

        @ConfigEntry.Gui.Tooltip
        public float chocolateGlazedCookieSaturation = 0.4f;

        @ConfigEntry.Gui.Tooltip
        @ConfigEntry.BoundedDiscrete(min = 0, max = 72000)
        public int chocolateGlazedCookieEffectDuration = 400;

        @ConfigEntry.Gui.Tooltip
        @ConfigEntry.BoundedDiscrete(min = 0, max = 20)
        public int strawberryCupcakeNutrition = 3;

        @ConfigEntry.Gui.Tooltip
        public float strawberryCupcakeSaturation = 0.5f;

        @ConfigEntry.Gui.Tooltip
        @ConfigEntry.BoundedDiscrete(min = 0, max = 72000)
        public int strawberryCupcakeEffectDuration = 400;

        @ConfigEntry.Gui.Tooltip
        @ConfigEntry.BoundedDiscrete(min = 0, max = 20)
        public int sweetberryCupcakeNutrition = 3;

        @ConfigEntry.Gui.Tooltip
        public float sweetberryCupcakeSaturation = 0.5f;

        @ConfigEntry.Gui.Tooltip
        @ConfigEntry.BoundedDiscrete(min = 0, max = 72000)
        public int sweetberryCupcakeEffectDuration = 400;

        @ConfigEntry.Gui.Tooltip
        @ConfigEntry.BoundedDiscrete(min = 0, max = 20)
        public int appleCupcakeNutrition = 3;

        @ConfigEntry.Gui.Tooltip
        public float appleCupcakeSaturation = 0.5f;

        @ConfigEntry.Gui.Tooltip
        @ConfigEntry.BoundedDiscrete(min = 0, max = 72000)
        public int appleCupcakeEffectDuration = 400;

        @ConfigEntry.Gui.Tooltip
        @ConfigEntry.BoundedDiscrete(min = 0, max = 20)
        public int cornetNutrition = 3;

        @ConfigEntry.Gui.Tooltip
        public float cornetSaturation = 0.5f;

        @ConfigEntry.Gui.Tooltip
        @ConfigEntry.BoundedDiscrete(min = 0, max = 72000)
        public int cornetEffectDuration = 400;

        @ConfigEntry.Gui.Tooltip
        @ConfigEntry.BoundedDiscrete(min = 0, max = 20)
        public int jamRollNutrition = 3;

        @ConfigEntry.Gui.Tooltip
        public float jamRollSaturation = 0.4f;

        @ConfigEntry.Gui.Tooltip
        @ConfigEntry.BoundedDiscrete(min = 0, max = 72000)
        public int jamRollEffectDuration = 400;

        @ConfigEntry.Gui.Tooltip
        @ConfigEntry.BoundedDiscrete(min = 0, max = 20)
        public int waffleNutrition = 4;

        @ConfigEntry.Gui.Tooltip
        public float waffleSaturation = 0.5f;

        @ConfigEntry.Gui.Tooltip
        @ConfigEntry.BoundedDiscrete(min = 0, max = 72000)
        public int waffleEffectDuration = 800;

        @ConfigEntry.Gui.Tooltip
        @ConfigEntry.BoundedDiscrete(min = 0, max = 20)
        public int chocolateTruffleNutrition = 2;

        @ConfigEntry.Gui.Tooltip
        public float chocolateTruffleSaturation = 0.4f;

        @ConfigEntry.Gui.Tooltip
        @ConfigEntry.BoundedDiscrete(min = 0, max = 72000)
        public int chocolateTruffleEffectDuration = 200;

        @ConfigEntry.Gui.Tooltip
        @ConfigEntry.BoundedDiscrete(min = 0, max = 20)
        public int misslilituBiscuitNutrition = 3;

        @ConfigEntry.Gui.Tooltip
        public float misslilituBiscuitSaturation = 0.5f;

        @ConfigEntry.Gui.Tooltip
        @ConfigEntry.BoundedDiscrete(min = 0, max = 72000)
        public int misslilituBiscuitEffectDuration = 900;

        @ConfigEntry.Gui.Tooltip
        @ConfigEntry.BoundedDiscrete(min = 0, max = 20)
        public int bunNutrition = 4;

        @ConfigEntry.Gui.Tooltip
        public float bunSaturation = 0.5f;

        @ConfigEntry.Gui.Tooltip
        @ConfigEntry.BoundedDiscrete(min = 0, max = 72000)
        public int bunEffectDuration = 2800;
    }
}
