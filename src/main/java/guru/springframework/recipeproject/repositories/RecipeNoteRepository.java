package guru.springframework.recipeproject.repositories;

import guru.springframework.recipeproject.domain.RecipeNote;
import org.springframework.data.repository.CrudRepository;

public interface RecipeNoteRepository extends CrudRepository<RecipeNote,Long> {
}
