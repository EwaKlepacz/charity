package pl.coderslab.charity.model.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import pl.coderslab.charity.model.entities.Donation;

public interface DonationRepository extends JpaRepository<Donation, Long> {
@Query(nativeQuery = true, value = "SELECT sum(quantity) from donations")
    int amountQuantity ();

@Query(nativeQuery = true, value = "SELECT count(distinct institution_id) from donations")
    int sumInstiutions ();

}



