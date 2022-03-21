package guru.springframework.recipeproject.converters;

import guru.springframework.recipeproject.commands.UnitOfMeasureCommand;
import guru.springframework.recipeproject.domain.UnitOfMeasure;
import lombok.Synchronized;
import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.Nullable;

public class UnitOfMeasureToUnitOfMeasureCommand implements Converter<UnitOfMeasure, UnitOfMeasureCommand> {

    @Synchronized
    @Nullable
    @Override
    public UnitOfMeasureCommand convert(UnitOfMeasure source) {
        if (source==null) {
            return null;
        }
        //TODO: UOMC should be final why?
        UnitOfMeasureCommand UOMC = new UnitOfMeasureCommand();
        UOMC.setId(source.getId());
        UOMC.setDescription(source.getDescription());
        return UOMC;
    }
}
