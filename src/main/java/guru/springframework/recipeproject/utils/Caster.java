package guru.springframework.recipeproject.utils;

import guru.springframework.recipeproject.domain.Category;

import java.util.List;
import java.util.Set;

public interface Caster {



    List<Long> takeCategoryIdFrom(Set<Category> set);
}
