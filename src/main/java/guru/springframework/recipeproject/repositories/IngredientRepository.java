package guru.springframework.recipeproject.repositories;

import guru.springframework.recipeproject.domain.Ingredient;
import org.springframework.data.repository.CrudRepository;

public interface IngredientRepository extends CrudRepository<Ingredient,Long> {
}
