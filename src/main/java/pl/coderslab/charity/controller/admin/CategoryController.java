package pl.coderslab.charity.controller.admin;

import org.springframework.web.bind.annotation.*;
import pl.coderslab.charity.model.Category;
import pl.coderslab.charity.repository.CategoryRepository;

import java.util.List;

@RestController
@RequestMapping("/api/categories")
public class CategoryController {

    private final CategoryRepository categoryRepository;

    public CategoryController(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @GetMapping
    public List<Category> getAllCategories(){
        return categoryRepository.findAll();
    }

    @GetMapping("/{id}")
    public Category getSelectedCategory(@PathVariable Long id){
        return categoryRepository.getOne(id);
    }

    @PostMapping
    public void createCategory(Category category){
         categoryRepository.save(category);
    }

    @PutMapping("/{id}")
    public void updateCategory(@PathVariable Long id,
                                 Category category ){
        Category savedCategory = categoryRepository.getOne(id);
        savedCategory.setName(category.getName());
        categoryRepository.save(savedCategory);
    }

    @DeleteMapping("/{id}")
    public void deleteCategory(@PathVariable Long id){
        categoryRepository.deleteById(id);
    }
}
