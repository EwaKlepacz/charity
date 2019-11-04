package pl.coderslab.charity;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.charity.model.entities.Category;
import pl.coderslab.charity.model.entities.Donation;
import pl.coderslab.charity.model.entities.Institution;
import pl.coderslab.charity.model.repositories.CategoryRepository;
import pl.coderslab.charity.model.repositories.DonationRepository;
import pl.coderslab.charity.model.repositories.InstitutionRepostiory;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/form")

public class DonationController {

    private DonationRepository donationRepository;
    private CategoryRepository categoryRepository;
    private InstitutionRepostiory institutionRepostiory;

    public DonationController(DonationRepository donationRepository, CategoryRepository categoryRepository, InstitutionRepostiory institutionRepostiory) {
        this.donationRepository = donationRepository;
        this.categoryRepository = categoryRepository;
        this.institutionRepostiory = institutionRepostiory;
    }


    @ModelAttribute("institutions")
    public List<Institution> institutions() {
        return institutionRepostiory.findAll();
    }

    @ModelAttribute("categories")
    public List<Category> categories() {
        return categoryRepository.findAll();
    }


@GetMapping
    public String prepareForm(Model model) {
        Donation donation = new Donation();
        model.addAttribute("donation", donation);
        return "form";
    }

  @PostMapping
    public String procesForm(@Valid Donation donation) {
        donationRepository.save(donation);
        return "redirect:/";
    }

    public static class AdminController {
    }
}

