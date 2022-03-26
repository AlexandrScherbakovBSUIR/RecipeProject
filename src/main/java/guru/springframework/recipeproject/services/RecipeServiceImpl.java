package guru.springframework.recipeproject.services;

import guru.springframework.recipeproject.domain.Recipe;
import guru.springframework.recipeproject.repositories.RecipeRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RecipeServiceImpl implements RecipeService{


    private RecipeRepository recipeRepository;

    public RecipeServiceImpl(RecipeRepository recipeRepository) {
        this.recipeRepository = recipeRepository;
    }

    public List<Recipe> saveAllRecipes(List<Recipe> recipes){

        List<Recipe> response = (List<Recipe>)
        recipeRepository.saveAll(recipes);
        return  response;
    }

    public List<Recipe> findAllRecipes(){

        List<Recipe> response = (List<Recipe>)
        recipeRepository.findAll();
        return response;

    }

    @Override
    public Recipe findById(Long id) {
        Optional<Recipe> response = recipeRepository.findById(id);
        return response.get();
    }

    @Override
    public Recipe saveRecipe(Recipe recipe) {
        Recipe response = recipeRepository.save(recipe);
        return response;
    }
}
