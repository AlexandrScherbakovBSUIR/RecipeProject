package guru.springframework.recipeproject.controllers;

import guru.springframework.recipeproject.domain.Ingredient;
import guru.springframework.recipeproject.domain.Recipe;
import guru.springframework.recipeproject.domain.RecipeNote;
import guru.springframework.recipeproject.services.CategoryService;
import guru.springframework.recipeproject.services.IngredientService;
import guru.springframework.recipeproject.services.RecipeNoteService;
import guru.springframework.recipeproject.services.RecipeService;
import guru.springframework.recipeproject.utils.CasterImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Slf4j
@Controller
public class RecipeController {
    //TODO: add some debug loggins


    private final RecipeService recipeService;
    private final CategoryService categoryService;
    private final RecipeNoteService recipeNoteService;
    private final IngredientService ingredientService;
    private final CasterImpl caster;


    public RecipeController(RecipeService recipeService, CategoryService categoryService, RecipeNoteService recipeNoteService, IngredientService ingredientService, CasterImpl caster) {
        this.recipeService = recipeService;
        this.categoryService = categoryService;
        this.recipeNoteService = recipeNoteService;
        this.ingredientService = ingredientService;
        this.caster = caster;
    }

    @RequestMapping("/recipes")
    public String getListOfRecipes(Model model){

        log.debug("Loading the list of recipes...");
        model.addAttribute("recipes",recipeService.findAllRecipes());
        return "recipes/listOfRecipes";
    }

    @RequestMapping("/Recipe")
    public String getConcreteRecipeByParameter(@RequestParam(value = "id", required = false) Long id, Model model){

        Recipe recipe = recipeService.findById(Long.valueOf(id));
        RecipeNote note = recipeNoteService.findById(recipe.getRecipeNote().getId());
        List<Ingredient> ingredients = ingredientService.findAllById(caster.takeIngredientIdFrom(recipe.getIngredients()));
        model.addAttribute("recipe",recipe);
        model.addAttribute("categories",
                categoryService.findAllCategoriesById(caster.takeCategoryIdFrom(recipe.getCategories())));
        model.addAttribute("note",note);
        model.addAttribute("ingredients",ingredients);

        return "recipes/Recipe";
    }

    @RequestMapping("/Recipe/{id}")
    public String getConcreteRecipeByPathVariable(@PathVariable String id, Model model){

        Recipe recipe = recipeService.findById(Long.valueOf(id));
        RecipeNote note = recipeNoteService.findById(recipe.getRecipeNote().getId());
        List<Ingredient> ingredients = ingredientService.findAllById(caster.takeIngredientIdFrom(recipe.getIngredients()));
        model.addAttribute("recipe",recipe);
        model.addAttribute("categories",
                categoryService.findAllCategoriesById(caster.takeCategoryIdFrom(recipe.getCategories())));
        model.addAttribute("note",note);
        model.addAttribute("ingredients",ingredients);


        return "recipes/Recipe";
    }
}
