package day02;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class RecipeTest {
    @Test
    void createTestByName() {
        Recipe recipe = new Recipe("Soup");
        assertEquals("Soup", recipe.getName());
        assertNull(recipe.getDescription());
        assertEquals(0, recipe.getIngredients().size());
    }

    @Test
    void createTestByNameAndDescription() {
        Recipe recipe = new Recipe("Soup", "Tasty");
        assertEquals("Soup", recipe.getName());
        assertEquals("Tasty", recipe.getDescription());
        assertEquals(0, recipe.getIngredients().size());
    }

    @Test
    void addOneIngredient() {
        Recipe recipe = new Recipe("Soup");
        recipe.addIngredient("onion");
        assertEquals("onion", recipe.getIngredients().get(0));
        assertEquals(1, recipe.getIngredients().size());
    }

    @Test
    void addMoreIngredient() {
        Recipe recipe = new Recipe("Soup");
        recipe.addIngredient("onion");
        recipe.addIngredient("meat");
        recipe.addIngredient("carrot");
        assertArrayEquals(new String[]{"onion", "meat", "carrot"}, recipe.getIngredients().toArray());
        assertEquals(List.of("onion", "meat", "carrot"), recipe.getIngredients());
    }
}