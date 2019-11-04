package pl.coderslab.charity.model.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import pl.coderslab.charity.model.entities.User;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String name);
     @Query(nativeQuery = true, value="SELECT * FROM users join user_role ur on users.id = ur.user_id " +
            "join role r on ur.role_id = r.id where name=:roleName")
    List<User> findAllByRoles(@Param("roleName") String roleName);

}
