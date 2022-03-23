package guru.springframework.recipeproject.converters;

import guru.springframework.recipeproject.commands.CategoryCommand;
import guru.springframework.recipeproject.commands.IngredientCommand;
import guru.springframework.recipeproject.commands.RecipeCommand;
import guru.springframework.recipeproject.domain.Recipe;
import lombok.Synchronized;
import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

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

            recipe.setId(source.getId());
            recipe.setCookTime(source.getCookTime());
            recipe.setPrepTime(source.getPrepTime());
            recipe.setServing(source.getServing());
            recipe.setDescription(source.getDescription());
            recipe.setDirections(source.getDirections());
            recipe.setDifficulty(source.getDifficulty());
            recipe.setSource(source.getSource());
            recipe.setUrl(source.getUrl());
            recipe.setRecipeNote(recipeNoteCommandToRecipeNote.convert(source.getRecipeNote()));

            if(source.getCategories()!=null && !source.getCategories().isEmpty()){
                for (CategoryCommand categoryCommand:source.getCategories()) {
                    recipe.getCategories().add(categoryCommandToCategory.convert(categoryCommand));
                }
            }

            if(source.getIngredients()!=null && !source.getIngredients().isEmpty()){
                for (IngredientCommand ingredientCommand: source.getIngredients()) {
                    recipe.getIngredients().add(ingredientCommandToIngredient.convert(ingredientCommand));
                                    }
            }

        }
        return null;
    }
}
