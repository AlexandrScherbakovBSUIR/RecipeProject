package guru.springframework.recipeproject.utils;

import guru.springframework.recipeproject.domain.Category;
import guru.springframework.recipeproject.domain.Ingredient;

import java.util.List;
import java.util.Set;

public interface Caster {



    List<Long> takeCategoryIdFrom(Set<Category> set);

    List<Long> takeIngredientIdFrom(Set<Ingredient> set);
}
