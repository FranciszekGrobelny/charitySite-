package pl.coderslab.charity.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.coderslab.charity.repository.CategoryRepository;

@Controller
@RequestMapping("/donation")
public class DonationController {

    private final CategoryRepository categoryRepository;

    public DonationController(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @GetMapping("/create")
    public String makeDonation(Model model){

        model.addAttribute("allCategories", categoryRepository.findAll());
        return "/donation/createDonation";
    }
    @PostMapping("/confirm")
    public String confirmDonation(){

        return "/donation/confirmDonation";
    }
}
