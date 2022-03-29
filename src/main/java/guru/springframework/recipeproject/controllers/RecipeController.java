package guru.springframework.recipeproject.controllers;

import guru.springframework.recipeproject.commands.RecipeCommand;
import guru.springframework.recipeproject.converters.RecipeCommandToRecipe;
import guru.springframework.recipeproject.domain.Difficulty;
import guru.springframework.recipeproject.domain.Recipe;
import guru.springframework.recipeproject.services.RecipeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Slf4j
@Controller
public class RecipeController {
    //TODO: add some debug loggins


    private  RecipeService recipeService;
    private final RecipeCommandToRecipe recipeCommandToRecipe;

    public RecipeController(RecipeService recipeService, RecipeCommandToRecipe recipeCommandToRecipe) {
        this.recipeService = recipeService;
        this.recipeCommandToRecipe = recipeCommandToRecipe;
    }

    @RequestMapping("/recipes")
    public String getListOfRecipes(Model model){

        log.debug("Loading the list of recipes...");
        model.addAttribute("recipes",recipeService.findAllRecipes());
        return "recipes/listOfRecipes";
    }
    /*by id*/
    @RequestMapping("/recipe")
    public String getConcreteRecipeByParameter(@RequestParam(value = "id", required = false) Long id, Model model){

        model.addAttribute("recipe",recipeService.findById(Long.valueOf(id)));

        return "recipes/recipe";
    }
    /*view*/
    @RequestMapping("/recipe/{id}")
    public String getConcreteRecipeByPathVariable(@PathVariable String id, Model model){

        model.addAttribute("recipe",recipeService.findById(Long.valueOf(id)));

        return "recipes/recipe";
    }

    @GetMapping("/newRecipe")
    public String getNewRecipeForm(Model model){
        RecipeCommand recipeCommand = new RecipeCommand();
        model.addAttribute("recipeCommand",recipeCommand);
        model.addAttribute("listOfDifficulty",Difficulty.values());

        return "recipes/newRecipe";
    }

    @PostMapping("/newRecipe")
    public String postNewRecipe(@ModelAttribute("recipeCommand") RecipeCommand recipeCommand){
        recipeService.saveRecipe(recipeCommandToRecipe.convert(recipeCommand));

        return "recipes/listOfRecipes";

    }
}
