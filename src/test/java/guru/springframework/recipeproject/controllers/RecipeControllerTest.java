package guru.springframework.recipeproject.controllers;

import guru.springframework.recipeproject.domain.Recipe;
import guru.springframework.recipeproject.repositories.RecipeRepository;
import guru.springframework.recipeproject.services.RecipeService;
import guru.springframework.recipeproject.services.RecipeServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.ui.Model;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.*;

class RecipeControllerTest {
    //TODO: initialisation and how mocks work
    //TODO: ArgumentCaptor, when(), verify()
    @Mock
    Model model;
    @Mock
    RecipeRepository recipeRepository;
    @Mock
    RecipeServiceImpl recipeService;
    RecipeController recipeController;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
        //recipeService = new RecipeServiceImpl(recipeRepository);
        recipeController = new RecipeController(recipeService);
        System.out.println(recipeService.toString()+"1");
     //   recipeService = new RecipeServiceImpl(recipeRepository);
        System.out.println(recipeService.toString());
     //   model.addAttribute("recipes",recipeService.findAllRecipes());

    }

    @Test
    void getListOfRecipes() {
        List<Recipe> listOfRecipes = new ArrayList<Recipe>();
        Recipe recipe1 = new Recipe();
        Recipe recipe2 = new Recipe();
        recipe1.setId(1l);
        recipe2.setId(2l);

        listOfRecipes.add(recipe1);
        listOfRecipes.add(recipe2);
        ArgumentCaptor<List<Recipe>> listArgumentCaptor = ArgumentCaptor.forClass(List.class);
        when(recipeService.findAllRecipes()).thenReturn(listOfRecipes);
        assertEquals(recipeController.getListOfRecipes(model),"recipes/listOfRecipes");
        verify(recipeService,times(1)).findAllRecipes();
        verify(model,times(1)).addAttribute(eq("recipes"),listArgumentCaptor.capture());
    }
}