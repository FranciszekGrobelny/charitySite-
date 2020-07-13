package pl.coderslab.charity.controller.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import pl.coderslab.charity.model.Category;
import pl.coderslab.charity.repository.CategoryRepository;
import pl.coderslab.charity.service.CategoryService;

@Controller
@RequestMapping("/admin/panel")
public class PanelController {

    private final CategoryRepository categoryRepository;

    public PanelController(CategoryService categoryService, CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @GetMapping()
    public String showPanel(){
        return "admin/mainPanel";
    }

    @PostMapping("/create/category")
    public void createCategoryAction(@RequestParam String categoryName){

        //Category category = new Category(categoryName);
       // categoryRepository.save(category);
    }

    @PostMapping("/update/category")
    public void updateCategoryAction(){

    }

}
