package pl.coderslab.charity.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.coderslab.charity.model.Institution;
import pl.coderslab.charity.repository.DonationRepository;
import pl.coderslab.charity.repository.InstitutionRepository;

import java.util.List;


@Controller @Slf4j
public class HomeController {

    private final InstitutionRepository institutionRepository;
    private final DonationRepository donationRepository;

    public HomeController(InstitutionRepository institutionRepository, DonationRepository donationRepository) {
        this.institutionRepository = institutionRepository;
        this.donationRepository = donationRepository;
    }

    @RequestMapping("/")
    public String homeAction(Model model){
        List<Institution> institutionList = institutionRepository.findAll();
        log.info("lista fundacji: {}", institutionList.toString());
        log.info("liczba oddanych worków:{}", donationRepository.sumByQuantity());
        log.info("liczba przekazanych darów:{}", donationRepository.sumGivenItems());

        model.addAttribute("allInstitutions", institutionList);
        model.addAttribute("allDonation", donationRepository.sumByQuantity());
        if(donationRepository.sumGivenItems() != null) {
            model.addAttribute("allGivenItems", donationRepository.sumGivenItems());
        }else{
            model.addAttribute("allGivenItems", 0);
        }
        return "index";
    }
}
