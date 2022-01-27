package guru.springframework.recipeproject.controllers;

import guru.springframework.recipeproject.repositories.CategoryRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {

    private CategoryRepository categoryRepository;

    public IndexController(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @RequestMapping({"","/","/index"})
    public String getIndexPage(){



        return "index";
    }

}
