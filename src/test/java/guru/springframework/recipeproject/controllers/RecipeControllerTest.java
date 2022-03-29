package guru.springframework.recipeproject.controllers;

import guru.springframework.recipeproject.converters.RecipeCommandToRecipe;
import guru.springframework.recipeproject.domain.Recipe;
import guru.springframework.recipeproject.repositories.RecipeRepository;
import guru.springframework.recipeproject.services.RecipeServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.ui.Model;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

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
    @Mock
    RecipeCommandToRecipe recipeCommandToRecipe;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
        //recipeService = new RecipeServiceImpl(recipeRepository);
        recipeController = new RecipeController(recipeService, recipeCommandToRecipe);
        System.out.println(recipeService.toString()+"1");
     //   recipeService = new RecipeServiceImpl(recipeRepository);
        System.out.println(recipeService.toString());
     //   model.addAttribute("recipes",recipeService.findAllRecipes());

    }

    @Test
    void testMockMVC() throws Exception {
        MockMvc mockMvc = MockMvcBuilders.standaloneSetup(recipeController).build();

        mockMvc.perform(get("/recipes"))
                .andExpect(status().isOk())
                .andExpect(view().name("recipes/listOfRecipes"));
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