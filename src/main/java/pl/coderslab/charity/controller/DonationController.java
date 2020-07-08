package pl.coderslab.charity.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import pl.coderslab.charity.dto.donation.CreateDonationDTO;
import pl.coderslab.charity.model.Category;
import pl.coderslab.charity.model.CurrentUser;
import pl.coderslab.charity.model.Institution;
import pl.coderslab.charity.model.User;
import pl.coderslab.charity.repository.CategoryRepository;
import pl.coderslab.charity.repository.InstitutionRepository;
import pl.coderslab.charity.service.CategoryService;
import pl.coderslab.charity.service.DonationService;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Collection;
import java.util.List;

@Controller
@RequestMapping("/donation")
@Slf4j
public class DonationController {

    private final CategoryRepository categoryRepository;
    private final CategoryService categoryService;
    private final InstitutionRepository institutionRepository;
    private final DonationService donationService;


    public DonationController(CategoryRepository categoryRepository, InstitutionRepository institutionRepository, DonationService donationService, CategoryService categoryService) {
        this.categoryRepository = categoryRepository;
        this.institutionRepository = institutionRepository;
        this.donationService = donationService;
        this.categoryService = categoryService;
    }

    @GetMapping("/create")
    public String makeDonation(Model model, @AuthenticationPrincipal UserDetails user){

        log.warn("zalogowany uzytkownik i jego rola: {}, {}", user.getUsername(), user.getAuthorities());

        model.addAttribute("allCategories", categoryRepository.findAll());
        model.addAttribute("allInstitutions", institutionRepository.findAll());
        model.addAttribute("loggedAs", user.getUsername());
        return "/donation/createDonation";
    }
    @PostMapping("/confirm")
    public String confirmDonation(@RequestParam(name = "categories") List<String> categories,
                                  @RequestParam(name="bags") int quantity,
                                  @RequestParam(name = "organization") String institutionName,
                                  @RequestParam(name = "address") String street,
                                  @RequestParam String city,
                                  @RequestParam(name = "postcode") String zipcode,
                                  @RequestParam String phone,
                                  @RequestParam String date,
                                  @RequestParam String time,
                                  @RequestParam String more_info){
        log.info("Wybrane kategorie przez uzytkownika: {}", categories.toString());
        log.info("Liczba wybranych workow: {}", quantity);
        log.info("Wybrana fundacja: {}", institutionName);
        log.info("Informacje użytkownika: {}, {}, {}, {}, {}, {}, {}", street, city, zipcode, phone, date, time, more_info);

        Institution newInstitution = institutionRepository.getInstitutionByName(institutionName);
        List<Category> newCategories = categoryService.getCategoryList(categories);
        CreateDonationDTO newDonation = new CreateDonationDTO(quantity,newCategories,newInstitution,street,city,zipcode,LocalDate.parse(date),LocalTime.parse(time),more_info);

        donationService.save(newDonation);
        return "/donation/confirmDonation";
    }
}
