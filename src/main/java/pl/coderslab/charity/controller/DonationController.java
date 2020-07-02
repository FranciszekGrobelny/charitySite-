package pl.coderslab.charity.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import pl.coderslab.charity.repository.CategoryRepository;

import java.util.List;

@Controller
@RequestMapping("/donation")
@Slf4j
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
    public String confirmDonation(@RequestParam(name = "categories") List<String> categories ){
        log.info("Wybrane kategorie przez uzytkownika: {}", categories.toString());
        return "/donation/confirmDonation";
    }
}
