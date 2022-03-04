package guru.springframework.recipeproject.services;

import guru.springframework.recipeproject.domain.RecipeNote;

public interface RecipeNoteService {

    RecipeNote findById(Long id);
}
