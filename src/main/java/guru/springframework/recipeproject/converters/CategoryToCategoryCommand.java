package guru.springframework.recipeproject.converters;

import guru.springframework.recipeproject.commands.CategoryCommand;
import guru.springframework.recipeproject.domain.Category;
import lombok.Synchronized;
import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

@Component
public class CategoryToCategoryCommand implements Converter<Category, CategoryCommand> {

    @Synchronized
    @Nullable
    @Override
    public CategoryCommand convert(Category source) {
        if(source!=null){
            CategoryCommand categoryCommand = new CategoryCommand();
            categoryCommand.setId(source.getId());
            categoryCommand.setDescription(source.getDescription());
            return  categoryCommand;

        }
        return null;
    }
}
