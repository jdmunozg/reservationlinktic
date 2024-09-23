package reservationlinktic.reservationlinktic.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import reservationlinktic.reservationlinktic.api.model.Customer; // Import the Customer class

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {
}