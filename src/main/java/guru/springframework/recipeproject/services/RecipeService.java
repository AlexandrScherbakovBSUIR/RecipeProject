package guru.springframework.recipeproject.services;

import guru.springframework.recipeproject.domain.Recipe;

import java.util.List;

public interface RecipeService {

    List<Recipe> saveAllRecipes(List<Recipe> recipes);
    List<Recipe> findAllRecipes();
}
