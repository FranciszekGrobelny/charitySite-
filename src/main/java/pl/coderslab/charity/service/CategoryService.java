package pl.coderslab.charity.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import pl.coderslab.charity.model.Category;
import pl.coderslab.charity.repository.CategoryRepository;

import java.util.ArrayList;
import java.util.List;

@Service @Slf4j
public class CategoryService {

    private final CategoryRepository categoryRepository;

    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    public List<Category> getCategoryList(List<String> categories) {
        log.info("Lista przesłanych kategorii: {}", categories);
        List<Category> newCategories = new ArrayList<>();
        for (String category : categories) {
            newCategories.add(categoryRepository.getCategoryByName(category));
        }
        log.info("Zapisane kategorie: {}", newCategories.toString());
        return newCategories;
    }
}
