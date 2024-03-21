package dat3.adventurexp.repository;

import dat3.adventurexp.entity.Booking;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface BookingRepository extends JpaRepository<Booking, UUID>{
    //List<Booking> findByBookingNumber(int bookingNumber);
    Optional<Booking> findByBookingNumber(int bookingNumber);
    List<Booking> findByCustomerUsername(String username);
    //Optional<Booking> findByName(String name);

    List<Booking> findByCustomerId(UUID customerId);
    }

