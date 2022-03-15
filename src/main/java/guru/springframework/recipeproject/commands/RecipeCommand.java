package guru.springframework.recipeproject.commands;

import guru.springframework.recipeproject.domain.Difficulty;
import guru.springframework.recipeproject.domain.RecipeNote;

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
    private NoteCommand recipeNote;
    private Set<IngredientCommand> ingredients;
    private Set<CategoryCommand> categories;

}
