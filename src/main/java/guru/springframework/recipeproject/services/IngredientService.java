package guru.springframework.recipeproject.services;

import guru.springframework.recipeproject.domain.Ingredient;

import java.util.List;

public interface IngredientService {

    Ingredient findById(Long id);
    List<Ingredient> findAllById(Iterable<Long> idList);
}
