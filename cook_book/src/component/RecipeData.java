package component;

import java.io.*;
import java.nio.file.*;
import java.util.*;

public class RecipeData {
    // EXAMPLE class variable
    private static RecipeData instance = new RecipeData();
    private static String filename;
    private List<Recipe> recipeItems;

    public static RecipeData getInstance() {
        return instance;
    }

    public List<Recipe> getRecipeItems() {
        return recipeItems;
    }

    public void setRecipeItems(List<Recipe> recipeItems) {
        this.recipeItems = recipeItems;
    }

    private RecipeData() {
        filename = "RecipeListItems.txt";
    }

    // EXAMPLE exceptions & persistence
    public void saveRecipeItems() throws IOException {
        Path path = Paths.get(filename);
        try (BufferedWriter bw = Files.newBufferedWriter(path)) {
            for (Recipe recipe : recipeItems) {
                bw.write(String.format("%s\t%s\t%s\t%s", recipe.getName(), Arrays.toString(recipe.getIngredients()),
                        recipe.getInstructions(), recipe.getNotes()));
                bw.newLine();
            }
        }
    }
}
