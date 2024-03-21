package dat3.adventurexp.api;

import dat3.adventurexp.dto.BookingDto;
import dat3.adventurexp.entity.Booking;
import dat3.adventurexp.service.BookingService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.security.core.Authentication;


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
    public List<BookingDto> getAllBookings() {
            return bookingService.getAllBookings();

            // Extract bookings based on user information from authentication object


            // Assuming you have a method in bookingService to get bookings by user
            //UUID userId = UUID.fromString("123e4567-e89b-12d3-a456-426614174000");
            // return bookingService.getBookingsByUser(username);


    }
    @GetMapping("/bookings/customer")
    public ResponseEntity<List<BookingDto>> getBookingsByCustomerId(Authentication authentication) {

        String username = authentication.getName();
        List<BookingDto> bookings = bookingService.getBookingsByUser(username);
        return new ResponseEntity<>(bookings, HttpStatus.OK);
    }


    @GetMapping(path = "/{id}")
    public BookingDto getBookingById(@PathVariable UUID id) {
        return bookingService.getBookingById(id);
    }

    @PostMapping
    public BookingDto createBooking(@RequestBody BookingDto requestBody) {
        return bookingService.addBooking(requestBody);
    }
}
