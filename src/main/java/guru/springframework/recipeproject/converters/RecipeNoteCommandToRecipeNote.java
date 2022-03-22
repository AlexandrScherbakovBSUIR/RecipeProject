package guru.springframework.recipeproject.converters;

import guru.springframework.recipeproject.commands.RecipeNoteCommand;
import guru.springframework.recipeproject.domain.RecipeNote;
import lombok.Synchronized;
import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

@Component
public class RecipeNoteCommandToRecipeNote implements Converter<RecipeNoteCommand, RecipeNote> {

    @Synchronized
    @Nullable
    @Override
    public RecipeNote convert(RecipeNoteCommand source) {
        if(source!=null){
            RecipeNote recipeNote = new RecipeNote();
            recipeNote.setId(source.getId());
            recipeNote.setRecipeNote(source.getRecipeNote());
            return recipeNote;
        }

        return null;
    }
}
