package pl.coderslab.charity.model.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.coderslab.charity.model.entities.Institution;

public interface InstitutionRepostiory extends JpaRepository<Institution, Long> {
}
