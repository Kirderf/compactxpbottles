package com.kirderf.compactxpbottles;

import com.kirderf.compactxpbottles.items.CustomExperienceBottle;
import com.kirderf.compactxpbottles.lists.ItemList;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.FinishedRecipe;
import net.minecraft.data.recipes.RecipeCategory;
import net.minecraft.data.recipes.RecipeProvider;
import net.minecraft.data.recipes.ShapelessRecipeBuilder;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;

import java.util.List;
import java.util.function.Consumer;

public class ModRecipeProvider extends RecipeProvider {

    public ModRecipeProvider(PackOutput packOutput) {
        super(packOutput);
        System.out.println("ModRecipeProvider instantiated.");
    }

    @Override
    protected void buildRecipes(Consumer<FinishedRecipe> consumer) {
        System.out.println("Starting to build recipes...");
        List<CustomExperienceBottle> bottles = ItemList.BOTTLES.stream()
                .map(entry -> ItemList.BOTTLE_ITEMS.get(entry.getKey()).get())
                .toList();

        if (bottles.isEmpty()) {
            System.out.println("No bottles found in ItemList.BOTTLES!");
            return;
        }

        System.out.println("Found " + bottles.size() + " bottles. Adding recipes...");
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, bottles.get(0))
                .requires(Items.EXPERIENCE_BOTTLE, 4)
                .unlockedBy("has_xp_bottle", has(Items.EXPERIENCE_BOTTLE))
                .save(consumer);

        for (int i = 1; i < bottles.size(); i++) {
            Item ingredient = bottles.get(i - 1);
            Item result = bottles.get(i);

            System.out.println("Adding recipe: " + ingredient + " -> " + result);
            ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, result)
                    .requires(ingredient, 4)
                    .unlockedBy("has_" + ItemList.BOTTLES.get(i - 1).getKey(), has(ingredient))
                    .save(consumer);
        }
        System.out.println("Finished building recipes.");
    }

}