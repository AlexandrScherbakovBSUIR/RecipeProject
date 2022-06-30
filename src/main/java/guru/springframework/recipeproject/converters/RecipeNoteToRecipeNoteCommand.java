package guru.springframework.recipeproject.converters;

import guru.springframework.recipeproject.commands.RecipeNoteCommand;
import guru.springframework.recipeproject.domain.RecipeNote;
import lombok.Synchronized;
import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

@Component
public class RecipeNoteToRecipeNoteCommand implements Converter<RecipeNote, RecipeNoteCommand> {

    @Synchronized
    @Nullable
    @Override
    public RecipeNoteCommand convert(RecipeNote source) {
        if(source!=null){
            RecipeNoteCommand recipeNoteCommand = new RecipeNoteCommand();
            recipeNoteCommand.setId(source.getId());
            recipeNoteCommand.setRecipeNoteCommand(source.getRecipeNote());
            return recipeNoteCommand;

        }
        return null;
    }
}
