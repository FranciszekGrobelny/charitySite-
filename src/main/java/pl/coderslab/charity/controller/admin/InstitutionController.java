package pl.coderslab.charity.controller.admin;

import org.springframework.web.bind.annotation.*;
import pl.coderslab.charity.model.Institution;
import pl.coderslab.charity.repository.InstitutionRepository;

import java.util.List;

@RestController
@RequestMapping("/api/institutions")
public class InstitutionController {

    private final InstitutionRepository institutionRepository;

    public InstitutionController(InstitutionRepository institutionRepository) {
        this.institutionRepository = institutionRepository;
    }

    @GetMapping
    public List<Institution> allInstitutions() {
        return institutionRepository.findAll();
    }

    @PostMapping
    public void addInstitution(Institution institution) {
        institutionRepository.save(institution);
    }

    @GetMapping("/{id}")
    public Institution getInstitution(@PathVariable Long id) {
        Institution institution = institutionRepository.getOne(id);
        return institution;
    }

    @DeleteMapping("/{id}")
    public void deleteInstitution(@PathVariable Long id) {
        institutionRepository.deleteById(id);
    }

    @PutMapping("/{id}")
    public void updateInstitution(@PathVariable Long id, Institution institution) {
        Institution savedInstitution = institutionRepository.getOne(id);
        savedInstitution.setName(institution.getName());
        savedInstitution.setDescription(institution.getDescription());
        institutionRepository.save(savedInstitution);
    }

}
