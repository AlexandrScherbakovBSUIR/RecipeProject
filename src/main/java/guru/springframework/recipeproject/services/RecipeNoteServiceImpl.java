package guru.springframework.recipeproject.services;

import guru.springframework.recipeproject.domain.RecipeNote;
import guru.springframework.recipeproject.repositories.RecipeNoteRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class RecipeNoteServiceImpl implements RecipeNoteService {

    private final RecipeNoteRepository recipeNoteRepository;

    public RecipeNoteServiceImpl(RecipeNoteRepository recipeNoteRepository) {
        this.recipeNoteRepository = recipeNoteRepository;
    }

    @Override
    public RecipeNote findById(Long id) {
        Optional<RecipeNote> response = recipeNoteRepository.findById(id);

        return response.get();
    }
}
