package com.kirderf.compactxpbottles;

import com.kirderf.compactxpbottles.items.CustomExperienceBottle;
import com.kirderf.compactxpbottles.lists.ItemList;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.RecipeCategory;
import net.minecraft.data.recipes.RecipeOutput;
import net.minecraft.data.recipes.RecipeProvider;
import net.minecraft.data.recipes.ShapelessRecipeBuilder;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public class ModRecipeProvider extends RecipeProvider {

    public ModRecipeProvider(HolderLookup.Provider lookupProvider, RecipeOutput output) {
        super(lookupProvider, output);
    }

    @Override
    protected void buildRecipes() {
        List<CustomExperienceBottle> bottles = ItemList.BOTTLES.stream()
                .map(entry -> ItemList.BOTTLE_ITEMS.get(entry.getKey()).get())
                .toList();

        ShapelessRecipeBuilder.shapeless(items, RecipeCategory.MISC, bottles.getFirst())
                .requires(Items.EXPERIENCE_BOTTLE, 4)
                .unlockedBy("has_xp_bottle", has(Items.EXPERIENCE_BOTTLE))
                .save(output);

        for (int i = 1; i < bottles.size(); i++) {
            Item ingredient = bottles.get(i - 1);
            Item result = bottles.get(i);

            ShapelessRecipeBuilder.shapeless(items, RecipeCategory.MISC, result)
                    .requires(ingredient, 4)
                    .unlockedBy("has_" + ItemList.BOTTLES.get(i - 1).getKey(), has(ingredient))
                    .save(output);
        }
    }

    public static class Runner extends RecipeProvider.Runner {
        public Runner(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider) {
            super(output, lookupProvider);
        }

        @Override
        protected RecipeProvider createRecipeProvider(HolderLookup.Provider provider, RecipeOutput recipeOutput) {
            return new ModRecipeProvider(provider, recipeOutput);
        }

        @Override
        public String getName() {
            return "Compact XP Bottles Recipes";
        }
    }
}