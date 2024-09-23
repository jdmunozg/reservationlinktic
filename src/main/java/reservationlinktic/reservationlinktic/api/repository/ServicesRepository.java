package reservationlinktic.reservationlinktic.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import reservationlinktic.reservationlinktic.api.model.Services; // Import the Services class

@Repository
public interface ServicesRepository extends JpaRepository<Services, Long> {
}
