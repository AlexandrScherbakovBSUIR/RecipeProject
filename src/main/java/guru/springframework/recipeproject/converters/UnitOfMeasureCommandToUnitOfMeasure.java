package guru.springframework.recipeproject.converters;

import guru.springframework.recipeproject.commands.UnitOfMeasureCommand;
import guru.springframework.recipeproject.domain.UnitOfMeasure;
import lombok.Synchronized;
import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.Nullable;

public class UnitOfMeasureCommandToUnitOfMeasure implements Converter<UnitOfMeasureCommand, UnitOfMeasure> {

    @Nullable
    @Synchronized
    @Override
    public UnitOfMeasure convert(UnitOfMeasureCommand source) {

        if (source==null){
            return null;
        }
//todo: final?
        UnitOfMeasure UOM = new UnitOfMeasure();
        UOM.setId(source.getId());
        UOM.setDescription(source.getDescription());

        return UOM;

    }
 }
