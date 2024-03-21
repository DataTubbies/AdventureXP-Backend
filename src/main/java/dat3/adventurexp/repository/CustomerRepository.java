package dat3.adventurexp.repository;

import dat3.adventurexp.entity.Booking;
import dat3.adventurexp.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface CustomerRepository extends JpaRepository<Customer, UUID> {
}
