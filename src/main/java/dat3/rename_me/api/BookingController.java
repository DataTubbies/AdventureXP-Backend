package dat3.rename_me.api;

import dat3.rename_me.dto.BookingDto;
import dat3.rename_me.service.BookingService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.security.core.Authentication;
import javax.servlet.http.HttpServletResponse;


import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/bookings")
public class BookingController {

    private BookingService bookingService;

    public BookingController(BookingService bookingService) {
        this.bookingService = bookingService;
    }

    @GetMapping
    public Object getAllBookings(Authentication authentication) {
        if (authentication.getAuthorities().toString().contains("ADMIN") || authentication.getAuthorities().toString().contains("EMPLOYEE")) {
            return bookingService.getAllBookings();
        } else if (authentication.getAuthorities().toString().contains("USER")) {
            // Extract bookings based on user information from authentication object
            String userName = authentication.getName();

            // Assuming you have a method in bookingService to get bookings by user
            UUID userId = UUID.fromString("123e4567-e89b-12d3-a456-426614174000");
            return bookingService.getBookingsByUserId(userId);
        } else {
            return "Unauthorized access";
        }
    }

    @GetMapping(path = "/{id}")
    public BookingDto getBookingById(@PathVariable UUID id) {
        return bookingService.getBookingById(id);
    }
}
