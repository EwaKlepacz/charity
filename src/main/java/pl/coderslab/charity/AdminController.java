package pl.coderslab.charity;

import org.springframework.stereotype.Controller;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.charity.model.entities.Institution;
import pl.coderslab.charity.model.entities.User;
import pl.coderslab.charity.model.repositories.CategoryRepository;
import pl.coderslab.charity.model.repositories.DonationRepository;
import pl.coderslab.charity.model.repositories.InstitutionRepostiory;
import pl.coderslab.charity.model.repositories.UserRepository;
import sun.security.util.Password;

import javax.validation.Valid;
import java.util.List;

@Controller
public class AdminController {

    private PasswordEncoder passwordEncoder;
    private CategoryRepository categoryRepository;
    private DonationRepository donationRepository;
    private InstitutionRepostiory institutionRepostiory;
    private UserRepository userRepository;

    public AdminController(PasswordEncoder passwordEncoder, CategoryRepository categoryRepository, DonationRepository donationRepository, InstitutionRepostiory institutionRepostiory, UserRepository userRepository) {
        this.passwordEncoder = passwordEncoder;
        this.categoryRepository = categoryRepository;
        this.donationRepository = donationRepository;
        this.institutionRepostiory = institutionRepostiory;
        this.userRepository = userRepository;
    }

    @ModelAttribute("institutions")
    public List<Institution> institutions() {
        return institutionRepostiory.findAll();
    }

    @ModelAttribute("users")
    public List<User> users () {
        return userRepository.findAllByRoles("ROLE_USER");
    }

    @ModelAttribute("admins")
    public List<User> admins () {
        return userRepository.findAllByRoles("ROLE_ADMIN");
    }
    @RequestMapping("/admin")
    public String adminPage (){
        return "admin/admin";
    }
          //Admins action

    @GetMapping({"/admin/add", "admin/edit"})
    public String prepareManageAdminPage (@RequestParam (required = false) Long id, Model model ){
     User user = new User();
     if (id != null) {
         user = userRepository.findById(id).orElse(new User());
     }
     model.addAttribute("user", user);
     return "admin/manage";
     }

     @PostMapping({"admin/add", "admin/edit"})
    public String processManageAdminPage (User user){
         String encodedPassword = passwordEncoder.encode(user.getPassword());
         user.setPassword(encodedPassword);
//         user.setRoles("ADMIN_ROLE");
         userRepository.save(user);
         return "redirect:/admin";
    }

@GetMapping("/admin/remove")
    public String prepeareRemoveAdminPage  (Long id, Model model){
        if (id != null) {
            User user = userRepository.findById(id).orElse(new User());
            model.addAttribute("userToRemove", user);
            return "admin/remove";
        }
        return "redirect:/";
}
@PostMapping("/admin/remove")
    public String processRemoveAdminPage (User user) {
        user = userRepository.findById(user.getId()).orElse(new User());
        userRepository.delete(user);
        return "redirect:/admin";

}

//Institutions ... miejsce na zarządzanie instytucjami
}

