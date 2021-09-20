package component;

public class Recipe {
    // EXAMPLE instance variable
    private String name;
    private String[] ingredients;
    private String instructions;
    private String notes;

    public Recipe(String name, String[] ingredients, String instructions, String notes) {
        this.name = name;
        this.ingredients = ingredients;
        this.instructions = instructions;
        this.notes = notes;
    }

    public Recipe(String name, String[] ingredients, String instructions) {
        this.name = name;
        this.ingredients = ingredients;
        this.instructions = instructions;
    }

    @Override
    public String toString() {
        return this.name;
    }

    // EXAMPLE getter
    public String getName() {
        return name;
    }

    // EXAMPLE setter
    public void setName(String name) {
        this.name = name;
    }

    public String[] getIngredients() {
        return ingredients;
    }

    public void setIngredients(String[] ingredients) {
        this.ingredients = ingredients;
    }

    public String getInstructions() {
        return instructions;
    }

    public void setInstructions(String instructions) {
        this.instructions = instructions;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }
}
