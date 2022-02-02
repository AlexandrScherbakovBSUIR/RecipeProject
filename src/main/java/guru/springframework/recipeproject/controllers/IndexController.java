package guru.springframework.recipeproject.controllers;

import guru.springframework.recipeproject.repositories.CategoryRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Slf4j
@Controller
public class IndexController {
    //todo: add some debug loggins

    private CategoryRepository categoryRepository;

    public IndexController(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @RequestMapping({"","/","/index"})
    public String getIndexPage(){

        log.debug("Loading the index page...");
        return "index";
    }

}
