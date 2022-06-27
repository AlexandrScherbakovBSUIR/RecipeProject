package guru.springframework.recipeproject.controllers;

import guru.springframework.recipeproject.commands.CategoryCommand;
import guru.springframework.recipeproject.commands.IngredientCommand;
import guru.springframework.recipeproject.commands.RecipeCommand;
import guru.springframework.recipeproject.converters.CategoryToCategoryCommand;
import guru.springframework.recipeproject.converters.RecipeCommandToRecipe;
import guru.springframework.recipeproject.converters.UnitOfMeasureToUnitOfMeasureCommand;
import guru.springframework.recipeproject.domain.Category;
import guru.springframework.recipeproject.domain.Difficulty;
import guru.springframework.recipeproject.repositories.CategoryRepository;
import guru.springframework.recipeproject.repositories.UnitOfMeasureRepository;
import guru.springframework.recipeproject.services.RecipeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Slf4j
@Controller
public class RecipeController {
    //TODO: add some debug loggins


    private  RecipeService recipeService;
    private final RecipeCommandToRecipe recipeCommandToRecipe;
    private final UnitOfMeasureRepository unitOfMeasureRepository;
    private final CategoryRepository categoryRepository;

    public RecipeController(RecipeService recipeService, RecipeCommandToRecipe recipeCommandToRecipe, UnitOfMeasureRepository unitOfMeasureRepository, CategoryRepository categoryRepository) {
        this.recipeService = recipeService;
        this.recipeCommandToRecipe = recipeCommandToRecipe;
        this.unitOfMeasureRepository = unitOfMeasureRepository;
        this.categoryRepository = categoryRepository;
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
        ;
        model.addAttribute("listOfCategories",
                convertCategorySetToCategoryCommandSet((List<Category>) categoryRepository.findAll()));

        return "recipes/newRecipe";
    }

    @PostMapping("/newRecipe")
    public String postNewRecipe(@ModelAttribute("recipeCommand") RecipeCommand recipeCommand, Model model){

        UnitOfMeasureToUnitOfMeasureCommand unitOfMeasureToUnitOfMeasureCommand = new UnitOfMeasureToUnitOfMeasureCommand();

        IngredientCommand oregano = new IngredientCommand();
        oregano.setDescription("dried oregano");
        oregano.setAmount(BigDecimal.valueOf(1));
        oregano.setUnitOfMeasure(unitOfMeasureToUnitOfMeasureCommand.convert(unitOfMeasureRepository.findByDescription("Teaspoon")));

        CategoryCommand categoryCommand = new CategoryCommand();
        CategoryToCategoryCommand categoryToCategoryCommand = new CategoryToCategoryCommand();

        recipeCommand.setIngredientCommands(Set.of(oregano));
        recipeCommand.getCategoryCommands().add(categoryToCategoryCommand.convert(categoryRepository.findByDescription("Fast Food")));

        recipeService.saveRecipe(recipeCommandToRecipe.convert(recipeCommand));

        //todo: call other method
        model.addAttribute("recipes",recipeService.findAllRecipes());
        return "recipes/listOfRecipes";

    }

    public List<CategoryCommand> convertCategorySetToCategoryCommandSet(List<Category> categories){
        List<CategoryCommand> categoryCommands = new ArrayList<CategoryCommand>();
        CategoryToCategoryCommand categoryToCategoryCommand = new CategoryToCategoryCommand();

        for (Category category:categories) {
            categoryCommands.add(categoryToCategoryCommand.convert(category));

        }

        return  categoryCommands;
    }
}
