package pl.coderslab.charity.model.services;

import org.springframework.stereotype.Service;
import pl.coderslab.charity.model.entities.User;

@Service
public interface UserService {
    User findByUserName (String name);

    void saveUser (User user);
}
