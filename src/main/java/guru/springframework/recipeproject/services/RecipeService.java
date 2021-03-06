package guru.springframework.recipeproject.services;

import guru.springframework.recipeproject.domain.Recipe;

import java.util.List;
import java.util.Optional;

public interface RecipeService {

    List<Recipe> saveAllRecipes(List<Recipe> recipes);
    List<Recipe> findAllRecipes();
    Recipe findById(Long id);
    Recipe saveRecipe(Recipe recipe);
}
