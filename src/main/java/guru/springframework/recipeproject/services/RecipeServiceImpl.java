package guru.springframework.recipeproject.services;

import guru.springframework.recipeproject.domain.Recipe;
import guru.springframework.recipeproject.repositories.RecipeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RecipeServiceImpl implements RecipeService{

    @Autowired
    private RecipeRepository recipeRepository;

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


}
