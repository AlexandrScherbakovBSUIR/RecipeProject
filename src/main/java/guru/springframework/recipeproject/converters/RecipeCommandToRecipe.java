package guru.springframework.recipeproject.converters;

import guru.springframework.recipeproject.commands.IngredientCommand;
import guru.springframework.recipeproject.commands.RecipeCommand;
import guru.springframework.recipeproject.domain.Ingredient;
import guru.springframework.recipeproject.domain.Recipe;
import guru.springframework.recipeproject.repositories.CategoryRepository;
import lombok.Synchronized;
import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.Set;

@Component
public class RecipeCommandToRecipe implements Converter<RecipeCommand,Recipe> {
    private final IngredientCommandToIngredient ingredientCommandToIngredient;
    private final CategoryCommandToCategory categoryCommandToCategory;
    private final RecipeNoteCommandToRecipeNote recipeNoteCommandToRecipeNote;
    private final CategoryRepository categoryRepository;
    public RecipeCommandToRecipe(IngredientCommandToIngredient ingredientCommandToIngredient,
                                 CategoryCommandToCategory categoryCommandToCategory,
                                 RecipeNoteCommandToRecipeNote recipeNoteCommandToRecipeNote, CategoryRepository categoryRepository) {
        this.ingredientCommandToIngredient = ingredientCommandToIngredient;
        this.categoryCommandToCategory = categoryCommandToCategory;
        this.recipeNoteCommandToRecipeNote = recipeNoteCommandToRecipeNote;
        this.categoryRepository = categoryRepository;
    }

    @Synchronized
    @Nullable
    @Override
    public Recipe convert(RecipeCommand source) {
        if(source!=null){
            Recipe recipe = new Recipe();
            Set<Ingredient> ingredients= new HashSet<Ingredient>();

            recipe.setId(source.getId());
            recipe.setCookTime(source.getCookTime());
            recipe.setPrepTime(source.getPrepTime());
            recipe.setServing(source.getServing());
            recipe.setDescription(source.getDescription());
            recipe.setDirections(source.getDirections());
            recipe.setDifficulty(source.getDifficulty());
            recipe.setSource(source.getSource());
            recipe.setUrl(source.getUrl());
            recipe.setRecipeNote(recipeNoteCommandToRecipeNote.convert(source.getRecipeNoteCommand()));

            //todo:
            recipe.setIngredients(new HashSet<>());
            recipe.setCategories(new HashSet<>());

            if(source.getCategoryCommands()!=null && source.getCategoryCommands().length> 0){
                for (String categoryCommand:source.getCategoryCommands()) {

                    recipe.getCategories().add(categoryRepository.findByDescription(categoryCommand));
                }
            }

            if(source.getIngredientCommands()!=null && !source.getIngredientCommands().isEmpty()){
                for (IngredientCommand ingredientCommand: source.getIngredientCommands()) {
                    ingredients.add(ingredientCommandToIngredient.convert(ingredientCommand));
                }
            }
            recipe.setIngredients(ingredients);
            return recipe;
        }
        return null;
    }
}
