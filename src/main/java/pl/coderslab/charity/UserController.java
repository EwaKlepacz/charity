package pl.coderslab.charity;



import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import pl.coderslab.charity.model.entities.User;
import pl.coderslab.charity.model.services.UserService;

@Controller
public class UserController {

    private final UserService userService;
    public UserController (UserService userService) {
        this.userService = userService;
    }
    @GetMapping("/create-user")
    @ResponseBody
    public String createUser() {
        User user = new User();
        user.setUsername("admin");
        user.setPassword("admin");
        userService.saveUser(user);
        return "admin";
    }
}

