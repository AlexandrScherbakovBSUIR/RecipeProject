package guru.springframework.recipeproject.services;

import guru.springframework.recipeproject.domain.Recipe;
import guru.springframework.recipeproject.repositories.RecipeRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class RecipeServiceImplTest {

    @Mock
    RecipeRepository recipeRepository;

    RecipeServiceImpl recipeService;



    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks( this);
         recipeService =new RecipeServiceImpl(recipeRepository);

    }

    @Test
    void saveAllRecipes() {
        Recipe recipe = new Recipe();
        List recipeData = new ArrayList();
        recipeData.add(recipe);

        when(recipeService.findAllRecipes()).thenReturn(recipeData);

      //  when(recipeRepository.findAll()).thenReturn(recipeData);

        List<Recipe> recipes =  recipeService.findAllRecipes();

        assertEquals(recipes.size(),1);
        verify(recipeRepository,times(1)).findAll();
    }

    @Test
    void findAllRecipes() {
    }
}