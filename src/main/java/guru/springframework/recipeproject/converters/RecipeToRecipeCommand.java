package guru.springframework.recipeproject.converters;

import guru.springframework.recipeproject.commands.RecipeCommand;
import guru.springframework.recipeproject.domain.Recipe;
import lombok.Synchronized;
import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.Nullable;

public class RecipeToRecipeCommand implements Converter<Recipe, RecipeCommand> {

    @Synchronized
    @Nullable
    @Override
    public RecipeCommand convert(Recipe source) {
        if(source!=null){


        }

        return null;
    }
}
