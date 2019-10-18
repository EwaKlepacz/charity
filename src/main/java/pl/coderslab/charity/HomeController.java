package pl.coderslab.charity;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.coderslab.charity.model.entities.Category;
import pl.coderslab.charity.model.entities.Institution;
import pl.coderslab.charity.model.repositories.CategoryRepository;
import pl.coderslab.charity.model.repositories.DonationRepository;
import pl.coderslab.charity.model.repositories.InstitutionRepostiory;

import java.util.List;


@Controller
public class HomeController {

    private DonationRepository donationRepository;
    private InstitutionRepostiory institutionRepostiory;
    private CategoryRepository categoryRepository;

    public HomeController(DonationRepository donationRepository, InstitutionRepostiory institutionRepostiory, CategoryRepository categoryRepository) {
        this.donationRepository = donationRepository;
        this.institutionRepostiory = institutionRepostiory;
        this.categoryRepository = categoryRepository;
    }
@ModelAttribute("institutions")
public  List<Institution> institutions () {

    return institutionRepostiory.findAll();
}

@ModelAttribute("categories")
public List<Category> categories () {
        return categoryRepository.findAll();
}

@ModelAttribute("quantity")

public int donationQuantity () {
        return donationRepository.amountQuantity();
}

@ModelAttribute("sumHelpedInstitutions")

public int sumOfHelepedInstitutions (){
        return donationRepository.sumInstiutions();
}

    @RequestMapping("/")
    public String homeAction(Model model){
               return "index";
    }
}



