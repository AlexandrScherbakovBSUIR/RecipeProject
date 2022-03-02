package guru.springframework.recipeproject.controllers;

import guru.springframework.recipeproject.domain.Recipe;
import guru.springframework.recipeproject.services.CategoryService;
import guru.springframework.recipeproject.services.RecipeService;
import guru.springframework.recipeproject.utils.CasterImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Slf4j
@Controller
public class RecipeController {
    //TODO: add some debug loggins


    private final RecipeService recipeService;
    private final CategoryService categoryService;


    public RecipeController(RecipeService recipeService, CategoryService categoryService) {
        this.recipeService = recipeService;
        this.categoryService = categoryService;
    }

    @RequestMapping("/recipes")
    public String getListOfRecipes(Model model){

        log.debug("Loading the list of recipes...");
        model.addAttribute("recipes",recipeService.findAllRecipes());
        return "recipes/listOfRecipes";
    }

    @RequestMapping("/Recipe")
    public String getConcreteRecipeByParameter(@RequestParam(value = "id", required = false) Long id, Model model){

        Recipe recipe = recipeService.findById(id);
        model.addAttribute("recipe",recipe  );
        model.addAttribute("categories",
                categoryService.findAllCategoriesById(new CasterImpl().takeCategoryIdFrom(recipe.getCategories())));

        return "recipes/Recipe";
    }

    @RequestMapping("/Recipe/{id}")
    public String getConcreteRecipeByPathVariable(@PathVariable String id, Model model){

        Recipe recipe = recipeService.findById(Long.valueOf(id));
        model.addAttribute("recipe",recipe);
        model.addAttribute("categories",
                categoryService.findAllCategoriesById(new CasterImpl().takeCategoryIdFrom(recipe.getCategories())));

        return "recipes/Recipe";
    }
}
