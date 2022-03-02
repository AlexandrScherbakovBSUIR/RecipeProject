package guru.springframework.recipeproject.services;

import guru.springframework.recipeproject.domain.Category;

import java.util.List;

public interface CategoryService {

    List<Category> findAllCategoriesById(Iterable<Long> idList);
    Category findById(Long id);

}
