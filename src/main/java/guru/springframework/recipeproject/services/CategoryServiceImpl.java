package guru.springframework.recipeproject.services;

import guru.springframework.recipeproject.domain.Category;
import guru.springframework.recipeproject.repositories.CategoryRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository categoryRepository;

    public CategoryServiceImpl(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public List<Category> findAllCategoriesById(Iterable<Long> idList) {
        List<Category> response = (List<Category>) categoryRepository.findAllById(idList);

        return response;
    }

    @Override
    public Category findById(Long id) {
        Optional<Category> response = categoryRepository.findById(id);

        return response.get();
    }
}
