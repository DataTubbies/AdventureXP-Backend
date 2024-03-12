package dat3.rename_me.api;

import dat3.rename_me.dto.BookingDto;
import dat3.rename_me.service.BookingService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/bookings")
public class BookingController {

    private BookingService bookingService;

    @GetMapping
    public List<BookingDto> getAllBookings() {
        return bookingService.getAllBookings();
    }

    @GetMapping(path = "/{id}")
    public BookingDto getBookingById(@PathVariable int id) {
        return bookingService.getBookingById(id);
    }
}
