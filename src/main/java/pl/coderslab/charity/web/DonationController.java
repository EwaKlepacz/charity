package pl.coderslab.charity.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.charity.model.entities.Donation;
import pl.coderslab.charity.model.repositories.CategoryRepository;
import pl.coderslab.charity.model.repositories.DonationRepository;
import pl.coderslab.charity.model.repositories.InstitutionRepostiory;

@Controller

public class DonationController {

    private DonationRepository donationRepository;
    private CategoryRepository categoryRepository;
    private InstitutionRepostiory institutionRepostiory;

    public DonationController(DonationRepository donationRepository, CategoryRepository categoryRepository, InstitutionRepostiory institutionRepostiory) {
        this.donationRepository = donationRepository;
        this.categoryRepository = categoryRepository;
        this.institutionRepostiory = institutionRepostiory;
    }

    @RequestMapping("/form")

        public String form (Model model) {
          model.addAttribute("categories", categoryRepository.findAll());
          model.addAttribute("institutions", institutionRepostiory.findAll());
                return "form";
    }
}



