package guru.springframework.recipeproject.converters;

import guru.springframework.recipeproject.commands.RecipeCommand;
import guru.springframework.recipeproject.domain.Category;
import guru.springframework.recipeproject.domain.Ingredient;
import guru.springframework.recipeproject.domain.Recipe;
import lombok.Synchronized;
import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

@Component
public class RecipeToRecipeCommand implements Converter<Recipe, RecipeCommand> {
    private final IngredientToIngredientCommand ingredientToIngredientCommand ;
    private final CategoryToCategoryCommand categoryToCategoryCommand;
    private final RecipeNoteToRecipeNoteCommand recipeNoteToRecipeNoteCommand;

    public RecipeToRecipeCommand(IngredientToIngredientCommand ingredientToIngredientCommand,
                                 CategoryToCategoryCommand categoryToCategoryCommand,
                                 RecipeNoteToRecipeNoteCommand recipeNoteToRecipeNoteCommand) {
        this.ingredientToIngredientCommand = ingredientToIngredientCommand;
        this.categoryToCategoryCommand = categoryToCategoryCommand;
        this.recipeNoteToRecipeNoteCommand = recipeNoteToRecipeNoteCommand;
    }

    @Synchronized
    @Nullable
    @Override
    public RecipeCommand convert(Recipe source) {
        if(source!=null){
            RecipeCommand recipeCommand = new RecipeCommand();

            recipeCommand.setId(source.getId());
            recipeCommand.setPrepTime(source.getPrepTime());
            recipeCommand.setCookTime(source.getCookTime());
            recipeCommand.setServing(source.getServing());
            recipeCommand.setDescription(source.getDescription());
            recipeCommand.setDirections(source.getDirections());
            recipeCommand.setDifficulty(source.getDifficulty());
            recipeCommand.setUrl(source.getUrl());
            recipeCommand.setSource(source.getSource());
            recipeCommand.setRecipeNote(recipeNoteToRecipeNoteCommand.convert(source.getRecipeNote()));

            if(source.getCategories()!=null && !source.getCategories().isEmpty()){
                for (Category category: source.getCategories() ) {
                    recipeCommand.getCategories().add(categoryToCategoryCommand.convert(category));

                }
            }

            if(source.getIngredients()!=null && !source.getIngredients().isEmpty()){
                for (Ingredient ingredient: source.getIngredients()) {
                    recipeCommand.getIngredients().add(ingredientToIngredientCommand.convert(ingredient));
                }
            }
            return recipeCommand;
        }

        return null;
    }
}