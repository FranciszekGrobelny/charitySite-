package pl.coderslab.charity.controller.admin;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.charity.model.Category;
import pl.coderslab.charity.repository.CategoryRepository;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/api/categories")
public class CategoryController {

    private final CategoryRepository categoryRepository;

    public CategoryController(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @ApiOperation(value = "get all categories")
    @GetMapping
    public List<Category> getAllCategories(){
        return categoryRepository.findAll();
    }

    @ApiOperation(value = "save category")
    @PostMapping
    public void createCategory(Category category){
        categoryRepository.save(category);
    }

    @ApiOperation(value = "get category by id")
    @GetMapping("/{id}")
    public Category getSelectedCategory(@PathVariable Long id){
        return categoryRepository.getOne(id);
    }

    @ApiOperation(value = "update category with specific id")
    @PutMapping("/{id}")
    public void updateCategory(@PathVariable Long id,
                                 Category category ){
        Category savedCategory = categoryRepository.getOne(id);
        savedCategory.setName(category.getName());
        categoryRepository.save(savedCategory);
    }

    @ApiOperation(value = "delete category by id")
    @DeleteMapping("/{id}")
    public void deleteCategory(@PathVariable Long id){
        categoryRepository.deleteById(id);
    }
}
