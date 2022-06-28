package guru.springframework.recipeproject.converters;

import guru.springframework.recipeproject.commands.CategoryCommand;
import guru.springframework.recipeproject.commands.IngredientCommand;
import guru.springframework.recipeproject.commands.RecipeCommand;
import guru.springframework.recipeproject.domain.Ingredient;
import guru.springframework.recipeproject.domain.Recipe;
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

    public RecipeCommandToRecipe(IngredientCommandToIngredient ingredientCommandToIngredient,
                                 CategoryCommandToCategory categoryCommandToCategory,
                                 RecipeNoteCommandToRecipeNote recipeNoteCommandToRecipeNote) {
        this.ingredientCommandToIngredient = ingredientCommandToIngredient;
        this.categoryCommandToCategory = categoryCommandToCategory;
        this.recipeNoteCommandToRecipeNote = recipeNoteCommandToRecipeNote;
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
                for (CategoryCommand categoryCommand:source.getCategoryCommands()) {
                    recipe.getCategories().add(categoryCommandToCategory.convert(categoryCommand));
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
