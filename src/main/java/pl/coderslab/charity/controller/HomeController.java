package pl.coderslab.charity.controller;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.coderslab.charity.model.Institution;
import pl.coderslab.charity.repository.InstitutionRepository;

import java.util.List;


@Controller @Slf4j
public class HomeController {

    private final Logger logger = LoggerFactory.getLogger(HomeController.class);
    private final InstitutionRepository institutionRepository;

    public HomeController(InstitutionRepository institutionRepository) {
        this.institutionRepository = institutionRepository;
    }

    @RequestMapping("/")
    public String homeAction(Model model){
        List<Institution> institutionList = institutionRepository.findAll();
        logger.info("lista fundacji: {}", institutionList.toString());

        model.addAttribute("allInstitutions", institutionList);
        return "index";
    }
}
