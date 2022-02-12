package guru.springframework.recipeproject.controllers;

import guru.springframework.recipeproject.repositories.RecipeRepository;
import guru.springframework.recipeproject.services.RecipeService;
import guru.springframework.recipeproject.services.RecipeServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.ui.Model;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

class RecipeControllerTest {
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
        assertEquals(recipeController.getListOfRecipes(model),"recipes/listOfRecipes");
        verify(recipeService,times(1)).findAllRecipes();
        verify(model,times(1)).addAttribute(eq("recipes"),anyList());
    }
}