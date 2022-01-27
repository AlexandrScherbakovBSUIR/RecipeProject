package guru.springframework.recipeproject.bootstrap;

import guru.springframework.recipeproject.domain.*;
import guru.springframework.recipeproject.repositories.CategoryRepository;
import guru.springframework.recipeproject.repositories.RecipeRepository;
import guru.springframework.recipeproject.repositories.UnitOfMeasureRepository;
import guru.springframework.recipeproject.services.RecipeServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.*;

@Component
public class BootstrapRecipeFiller implements CommandLineRunner {

    @Autowired
    private RecipeRepository recipeRepository;
    @Autowired
    private CategoryRepository categoryRepository;
    @Autowired
    private UnitOfMeasureRepository unitOfMeasureRepository;
    @Autowired
    private RecipeServiceImpl recipeService;

    @Override
    public void run(String... args) throws Exception {

        Ingredient avocado = new Ingredient();
        avocado.setDescription("avocado");
        avocado.setAmount(BigDecimal.valueOf(2));
        avocado.setUnitOfMeasure(unitOfMeasureRepository.findByDescription("Piece"));

        Ingredient salt = new Ingredient();
        salt.setDescription("salt");
        salt.setAmount(BigDecimal.valueOf(0.25));
        salt.setUnitOfMeasure(unitOfMeasureRepository.findByDescription("Teaspoon"));

        Ingredient lemonJuice = new Ingredient();
        lemonJuice.setDescription("lemon Juice");
        lemonJuice.setAmount(BigDecimal.valueOf(1));
        lemonJuice.setUnitOfMeasure(unitOfMeasureRepository.findByDescription("Tablespoon"));

        Ingredient redOnion = new Ingredient();
        redOnion.setDescription("minced red onion");
        redOnion.setAmount(BigDecimal.valueOf(4));
        redOnion.setUnitOfMeasure(unitOfMeasureRepository.findByDescription("Piece"));

        Ingredient chili  = new Ingredient();
        chili.setDescription("serrano (or jalapeño) chilis");
        chili.setAmount(BigDecimal.valueOf(2));
        chili.setUnitOfMeasure(unitOfMeasureRepository.findByDescription("Piece"));

        Ingredient cilantro  = new Ingredient();
        cilantro.setDescription("cilantro ");
        cilantro.setAmount(BigDecimal.valueOf(2));
        cilantro.setUnitOfMeasure(unitOfMeasureRepository.findByDescription("Tablespoon"));

        Ingredient pepper = new Ingredient();
        pepper.setDescription("freshly ground black pepper");
        pepper.setAmount(BigDecimal.valueOf(1));
        pepper.setUnitOfMeasure(unitOfMeasureRepository.findByDescription("Pinch"));

        Ingredient tomato = new Ingredient();
        tomato.setDescription("tomato");
        tomato.setAmount(BigDecimal.valueOf(0.5));
        tomato.setUnitOfMeasure(unitOfMeasureRepository.findByDescription("Piece"));

        Ingredient radish  = new Ingredient();
        radish.setDescription("Red radish");
        radish.setAmount(BigDecimal.valueOf(1));
        radish.setUnitOfMeasure(unitOfMeasureRepository.findByDescription("Piece"));

        Ingredient tortilla = new Ingredient();
        tortilla.setDescription("Tortilla chips");
        tortilla.setAmount(BigDecimal.valueOf(2));
        tortilla.setUnitOfMeasure(unitOfMeasureRepository.findByDescription("Package"));

        Ingredient powder = new Ingredient();
        powder.setDescription("ancho chili powder");
        powder.setAmount(BigDecimal.valueOf(2));
        powder.setUnitOfMeasure(unitOfMeasureRepository.findByDescription("Tablespoon"));

        Ingredient oregano = new Ingredient();
        oregano.setDescription("dried oregano");
        oregano.setAmount(BigDecimal.valueOf(1));
        oregano.setUnitOfMeasure(unitOfMeasureRepository.findByDescription("Teaspoon"));

        Ingredient sugar = new Ingredient();
        sugar.setDescription("sugar");
        sugar.setAmount(BigDecimal.valueOf(1));
        sugar.setUnitOfMeasure(unitOfMeasureRepository.findByDescription("Teaspoon"));

        Ingredient salt2 = new Ingredient();
        salt2.setDescription("salt");
        salt2.setAmount(BigDecimal.valueOf(0.5));
        salt2.setUnitOfMeasure(unitOfMeasureRepository.findByDescription("Teaspoon"));

        Ingredient garlic  = new Ingredient();
        garlic.setDescription("clove garlic");
        garlic.setAmount(BigDecimal.valueOf(1));
        garlic.setUnitOfMeasure(unitOfMeasureRepository.findByDescription("Piece"));

        Ingredient zest  = new Ingredient();
        zest.setDescription("finely grated orange zest");
        zest.setAmount(BigDecimal.valueOf(1));
        zest.setUnitOfMeasure(unitOfMeasureRepository.findByDescription("Tablespoon"));

        Ingredient orangeJuice = new Ingredient();
        orangeJuice.setDescription("fresh-squeezed orange juice");
        orangeJuice.setAmount(BigDecimal.valueOf(3));
        orangeJuice.setUnitOfMeasure(unitOfMeasureRepository.findByDescription("Tablespoon"));

        Ingredient oil = new Ingredient();
        oil.setDescription("olive oil");
        oil.setAmount(BigDecimal.valueOf(2));
        oil.setUnitOfMeasure(unitOfMeasureRepository.findByDescription("Tablespoon"));

        Ingredient chickenThighs  = new Ingredient();
        chickenThighs.setDescription("skinless, boneless chicken thighs");
        chickenThighs.setAmount(BigDecimal.valueOf(6));
        chickenThighs.setUnitOfMeasure(unitOfMeasureRepository.findByDescription("Piece"));

        Ingredient tortillas = new Ingredient();
        tortillas.setDescription("small corn tortillas");
        tortillas.setAmount(BigDecimal.valueOf(8));
        tortillas.setUnitOfMeasure(unitOfMeasureRepository.findByDescription("Piece"));

        RecipeNote recipeNoteForGuacamole = new RecipeNote();
        recipeNoteForGuacamole.setRecipeNote("Be careful handling chilis! If using, it's best to wear food-safe gloves. "
                +"If no gloves are available, wash your hands thoroughly after handling, and do not touch your "
                +"eyes or the area near your eyes for several hours afterwards.");

        RecipeNote recipeNoteForTacos = new RecipeNote();
        recipeNoteForTacos.setRecipeNote("Look for ancho chile powder with the Mexican ingredients" +
                " at your grocery store, on buy it online. (If you can't find ancho chili powder, you replace the ancho" +
                " chili, the oregano, and the cumin with 2 1/2 tablespoons regular chili powder, though the flavor" +
                " won't be quite the same.)");

        Recipe guacamole = new Recipe();
        guacamole.setPrepTime(10);
        guacamole.setCookTime(10);
        guacamole.setDescription("How to Make the Best Guacamole");
        guacamole.setDirections("1:Cut the avocado;2:Mash the avocado flesh;3:Add remaining ingredients to taste;4:Serve immediately.");
        guacamole.setDifficulty(Difficulty.EASY);
        guacamole.setServing(4);
        guacamole.setUrl("https://www.simplyrecipes.com/recipes/perfect_guacamole/");
        guacamole.setRecipeNote(recipeNoteForGuacamole);
        guacamole.setCategories(new HashSet<>());
        guacamole.getCategories().add(categoryRepository.findByDescription("Mexican"));
        recipeNoteForGuacamole.setRecipe(guacamole);

        avocado.setRecipe(guacamole);
        salt.setRecipe(guacamole);
        lemonJuice.setRecipe(guacamole);
        redOnion.setRecipe(guacamole);
        chili.setRecipe(guacamole);
        cilantro.setRecipe(guacamole);
        pepper.setRecipe(guacamole);
        tomato.setRecipe(guacamole);
        radish.setRecipe(guacamole);
        tortilla.setRecipe(guacamole);

        guacamole.setIngredients(Set.of(avocado,salt,lemonJuice,redOnion,chili,
                cilantro,pepper,tomato,radish,tortilla));


        //recipeRepository.save(guacamole);

        Recipe tacos = new Recipe();
        tacos.setPrepTime(20);
        tacos.setCookTime(15);
        tacos.setDescription("Spicy Grilled Chicken Tacos");
        tacos.setDirections("1:Prepare a gas or charcoal grill for medium-high, direct heat;" +
                "2:Make the marinade and coat the chicken;3:Grill the chicken;" +
                "4:Warm the tortillas;5:Assemble the tacos.");
        tacos.setDifficulty(Difficulty.MODERATE);
        tacos.setServing(6);
        tacos.setUrl("https://www.simplyrecipes.com/recipes/spicy_grilled_chicken_tacos/");
        tacos.setCategories(new HashSet<>());
        tacos.getCategories().add(categoryRepository.findByDescription("Mexican"));
        tacos.getCategories().add(categoryRepository.findByDescription("Fast Food"));
        tacos.setRecipeNote(recipeNoteForTacos);
        recipeNoteForTacos.setRecipe(tacos);

        powder.setRecipe(tacos);
        oregano.setRecipe(tacos);
        sugar.setRecipe(tacos);
        salt2.setRecipe(tacos);
        garlic.setRecipe(tacos);
        zest.setRecipe(tacos);
        orangeJuice.setRecipe(tacos);
        oil.setRecipe(tacos);
        chickenThighs.setRecipe(tacos);
        tacos.setIngredients(Set.of(powder,oregano,sugar,salt2,garlic,zest,orangeJuice,oil,chickenThighs));







        recipeService.saveAllRecipes(List.of(guacamole,tacos));


    }
}
