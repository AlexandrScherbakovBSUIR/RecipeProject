package guru.springframework.recipeproject.utils;

import guru.springframework.recipeproject.domain.Category;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

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
}
