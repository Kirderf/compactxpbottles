package com.kirderf.compactxpbottles;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class ResourceAssetsTest {

    @Test
    void x4RecipeCraftsFromFourVanillaExperienceBottles() throws IOException {
        Path recipePath = Path.of("src", "generated", "resources", "data", "compactxpbottles", "recipes", "experience_bottle_x4.json");
        assertTrue(Files.exists(recipePath), "Recipe file must exist for x4 tier.");

        String recipeJson = Files.readString(recipePath);
        assertTrue(recipeJson.contains("\"item\": \"compactxpbottles:experience_bottle_x4\""), "Recipe result must be experience_bottle_x4.");

        int ingredientOccurrences = recipeJson.split("\"item\": \"minecraft:experience_bottle\"", -1).length - 1;
        assertEquals(4, ingredientOccurrences, "Recipe must require exactly four vanilla experience bottles.");
    }

    @Test
    void x4ModelAndTextureAreLinked() throws IOException {
        Path modelPath = Path.of("src", "main", "resources", "assets", "compactxpbottles", "models", "item", "experience_bottle_x4.json");
        Path texturePath = Path.of("src", "main", "resources", "assets", "compactxpbottles", "textures", "item", "experience_bottle_x4.png");

        assertTrue(Files.exists(modelPath), "Item model must exist for x4 tier.");
        assertTrue(Files.exists(texturePath), "Item texture must exist for x4 tier.");

        String modelJson = Files.readString(modelPath);
        assertTrue(modelJson.contains("\"layer0\": \"compactxpbottles:item/experience_bottle_x4\""), "x4 item model must point at x4 texture.");
    }

    @Test
    void englishLocalizationContainsX4Name() throws IOException {
        Path langPath = Path.of("src", "main", "resources", "assets", "compactxpbottles", "lang", "en_us.json");
        assertTrue(Files.exists(langPath), "English localization file must exist.");

        String langJson = Files.readString(langPath);
        assertTrue(
                langJson.contains("\"item.compactxpbottles.experience_bottle_x4\": \"Experience Bottle x4\""),
                "Localization must contain the x4 item name."
        );
    }
}
