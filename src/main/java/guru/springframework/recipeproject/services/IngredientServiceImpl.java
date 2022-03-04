package guru.springframework.recipeproject.services;

import guru.springframework.recipeproject.domain.Ingredient;
import guru.springframework.recipeproject.repositories.IngredientRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class IngredientServiceImpl implements IngredientService {

    private final IngredientRepository ingredientRepository;

    public IngredientServiceImpl(IngredientRepository ingredientRepository) {
        this.ingredientRepository = ingredientRepository;
    }

    @Override
    public Ingredient findById(Long id) {
        Optional<Ingredient> response = ingredientRepository.findById(id);
        return response.get();
    }

    @Override
    public List<Ingredient> findAllById(Iterable<Long> idList) {

        List<Ingredient> response = (List<Ingredient>) ingredientRepository.findAllById(idList);

        return response;
    }

}
