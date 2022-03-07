package guru.springframework.recipeproject.services;

import guru.springframework.recipeproject.domain.Ingredient;
import guru.springframework.recipeproject.repositories.IngredientRepository;
import guru.springframework.recipeproject.repositories.UnitOfMeasureRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class IngredientServiceImpl implements IngredientService {

    private final IngredientRepository ingredientRepository;
    private final UnitOfMeasureRepository unitOfMeasureRepository;

    public IngredientServiceImpl(IngredientRepository ingredientRepository, UnitOfMeasureRepository unitOfMeasureRepository) {
        this.ingredientRepository = ingredientRepository;
        this.unitOfMeasureRepository = unitOfMeasureRepository;
    }

    @Override
    public Ingredient findById(Long id) {
        Optional<Ingredient> response = ingredientRepository.findById(id);
        return response.get();
    }

    @Override
    public List<Ingredient> findAllById(Iterable<Long> idList) {

        List<Ingredient> response = (List<Ingredient>) ingredientRepository.findAllById(idList);
        for (Ingredient ingredient: response) {
            System.out.println(ingredient.getUnitOfMeasure());
        }

        return response;
    }


}
