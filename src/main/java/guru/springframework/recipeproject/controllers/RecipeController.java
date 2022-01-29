package guru.springframework.recipeproject.controllers;

import guru.springframework.recipeproject.services.RecipeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Slf4j
@Controller
public class RecipeController {
    //todo: add some debug loggins

    @Autowired
    private RecipeService recipeService;

    @RequestMapping("/recipes")
    public String getListOfRecipes(Model model){

        model.addAttribute("recipes",recipeService.findAllRecipes());
        return "recipes/listOfRecipes";
    }
}
