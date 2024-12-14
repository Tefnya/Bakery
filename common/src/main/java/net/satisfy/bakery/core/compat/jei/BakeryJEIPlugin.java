package net.satisfy.bakery.core.compat.jei;

import mezz.jei.api.IModPlugin;
import mezz.jei.api.JeiPlugin;
import mezz.jei.api.registration.IRecipeCatalystRegistration;
import mezz.jei.api.registration.IRecipeCategoryRegistration;
import mezz.jei.api.registration.IRecipeRegistration;
import net.minecraft.client.Minecraft;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.crafting.RecipeManager;
import net.satisfy.bakery.core.compat.jei.category.BakerStationCategory;
import net.satisfy.bakery.core.registry.ObjectRegistry;
import net.satisfy.bakery.core.registry.RecipeTypeRegistry;
import org.jetbrains.annotations.NotNull;
import net.satisfy.bakery.core.recipe.BakingStationRecipe;
import net.satisfy.bakery.core.util.BakeryIdentifier;

import java.util.List;
import java.util.Objects;


@JeiPlugin
public class BakeryJEIPlugin implements IModPlugin {

    @Override
    public void registerCategories(IRecipeCategoryRegistration registration) {
        registration.addRecipeCategories(new BakerStationCategory(registration.getJeiHelpers().getGuiHelper()));
    }


    @Override
    public void registerRecipes(IRecipeRegistration registration) {
        RecipeManager rm = Objects.requireNonNull(Minecraft.getInstance().level).getRecipeManager();
        List<BakingStationRecipe> cakingRecipes = rm.getAllRecipesFor(RecipeTypeRegistry.BAKING_STATION_RECIPE_TYPE.get());
        registration.addRecipes(BakerStationCategory.CAKING, cakingRecipes);

    }

    @Override
    public @NotNull ResourceLocation getPluginUid() {
        return new BakeryIdentifier("jei_plugin");
    }

    @Override
    public void registerRecipeCatalysts(IRecipeCatalystRegistration registration) {
        registration.addRecipeCatalyst(ObjectRegistry.BAKER_STATION.get().asItem().getDefaultInstance(), BakerStationCategory.CAKING);
    }
}
