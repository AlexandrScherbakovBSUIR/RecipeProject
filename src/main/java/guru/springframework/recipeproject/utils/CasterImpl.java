package guru.springframework.recipeproject.utils;

import guru.springframework.recipeproject.domain.Category;
import guru.springframework.recipeproject.domain.Ingredient;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
@Component
public class CasterImpl implements Caster {
    @Override
    public List<Long> takeCategoryIdFrom(Set<Category> set) {
        List<Long> result = new ArrayList<Long>();
        for (Category category : set
             ) {
            result.add(category.getId());
        }
        return result;
    }
    @Override
    public List<Long> takeIngredientIdFrom(Set<Ingredient> set) {
        List<Long> result = new ArrayList<Long>();
        for (Ingredient ingredient : set
        ) {
            result.add(ingredient.getId());
        }
        return result;
    }
}
