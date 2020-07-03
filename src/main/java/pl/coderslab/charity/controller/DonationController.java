package pl.coderslab.charity.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import pl.coderslab.charity.repository.CategoryRepository;
import pl.coderslab.charity.repository.InstitutionRepository;

import java.util.List;

@Controller
@RequestMapping("/donation")
@Slf4j
public class DonationController {

    private final CategoryRepository categoryRepository;
    private final InstitutionRepository institutionRepository;

    public DonationController(CategoryRepository categoryRepository, InstitutionRepository institutionRepository) {
        this.categoryRepository = categoryRepository;
        this.institutionRepository = institutionRepository;
    }

    @GetMapping("/create")
    public String makeDonation(Model model){

        model.addAttribute("allCategories", categoryRepository.findAll());
        model.addAttribute("allInstitutions", institutionRepository.findAll());
        return "/donation/createDonation";
    }
    @PostMapping("/confirm")
    public String confirmDonation(@RequestParam(name = "categories") List<String> categories,
                                  @RequestParam(name="bags") int bags,
                                  @RequestParam(name = "organization") String institution,
                                  @RequestParam String address,
                                  @RequestParam String city,
                                  @RequestParam String postcode,
                                  @RequestParam String phone,
                                  @RequestParam String data,
                                  @RequestParam String time,
                                  @RequestParam String more_info){
        log.info("Wybrane kategorie przez uzytkownika: {}", categories.toString());
        log.info("Liczba wybranych workow: {}", bags);
        log.info("Wybrana fundacja: {}", institution);
        log.info("Informacje użytkownika: {}, {}, {}, {}, {}, {}, {}", address, city, postcode, phone, data, time, more_info);
        return "/donation/confirmDonation";
    }
}
