package guru.springframework.recipeproject.commands;

import guru.springframework.recipeproject.domain.Difficulty;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class RecipeCommand {
    private Long id;
    private String description;
    private Integer prepTime;
    private Integer cookTime;
    private Integer serving;
    private String source;
    private String url;
    private String directions;
    private Difficulty difficulty;
    private RecipeNoteCommand recipeNoteCommand;
    private Set<IngredientCommand> ingredientCommands = new HashSet<>();
   // private List<CategoryCommand> categoryCommands = new ArrayList<>();
    private CategoryCommand[] categoryCommands;
    public RecipeCommand() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getPrepTime() {
        return prepTime;
    }

    public void setPrepTime(Integer prepTime) {
        this.prepTime = prepTime;
    }

    public Integer getCookTime() {
        return cookTime;
    }

    public void setCookTime(Integer cookTime) {
        this.cookTime = cookTime;
    }

    public Integer getServing() {
        return serving;
    }

    public void setServing(Integer serving) {
        this.serving = serving;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getDirections() {
        return directions;
    }

    public void setDirections(String directions) {
        this.directions = directions;
    }

    public Difficulty getDifficulty() {
        return difficulty;
    }

    public void setDifficulty(Difficulty difficulty) {
        this.difficulty = difficulty;
    }

    public RecipeNoteCommand getRecipeNoteCommand() {
        return recipeNoteCommand;
    }

    public void setRecipeNoteCommand(RecipeNoteCommand recipeNoteCommand) {
        this.recipeNoteCommand = recipeNoteCommand;
    }

    public Set<IngredientCommand> getIngredientCommands() {
        return ingredientCommands;
    }

    public void setIngredientCommands(Set<IngredientCommand> ingredientCommands) {
        this.ingredientCommands = ingredientCommands;
    }

/*    public List<CategoryCommand> getCategoryCommands() {
        return categoryCommands;
    }

    public void setCategoryCommands(List<CategoryCommand> categoryCommands) {
        this.categoryCommands = categoryCommands;
    }*/

    public CategoryCommand[] getCategoryCommands() {
        return categoryCommands;
    }

    public void setCategoryCommands(CategoryCommand[] categoryCommands) {
        this.categoryCommands = categoryCommands;
    }
}
