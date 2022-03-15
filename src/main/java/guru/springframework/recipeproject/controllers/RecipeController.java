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

    public RecipeController(RecipeService recipeService) {
        this.recipeService = recipeService;

    }

    @RequestMapping("/recipes")
    public String getListOfRecipes(Model model){

        log.debug("Loading the list of recipes...");
        model.addAttribute("recipes",recipeService.findAllRecipes());
        return "recipes/listOfRecipes";
    }
    /*by id*/
    @RequestMapping("/Recipe")
    public String getConcreteRecipeByParameter(@RequestParam(value = "id", required = false) Long id, Model model){

        model.addAttribute("recipe",recipeService.findById(Long.valueOf(id)));

        return "recipes/Recipe";
    }
    /*view*/
    @RequestMapping("/Recipe/{id}")
    public String getConcreteRecipeByPathVariable(@PathVariable String id, Model model){

        model.addAttribute("recipe",recipeService.findById(Long.valueOf(id)));

        return "recipes/Recipe";
    }
}
