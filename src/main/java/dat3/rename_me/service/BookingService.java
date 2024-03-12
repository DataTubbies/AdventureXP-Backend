package dat3.rename_me.service;

import dat3.rename_me.entity.Booking;
import dat3.rename_me.repository.BookingRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class BookingService {

    private BookingRepository bookingRepository;

    public BookingService(BookingRepository bookingRepository) {
        this.bookingRepository = bookingRepository;
    }

    public List<BookingDto> getAllBookings() {
        List<Booking> bookings = bookingRepository.findAll();
        return bookings.stream().map((b)->new BookingDto(b, false).toList()).collect(Collectors.toList();
    }

    public BookingDto getBookingByBookingNumber(int bookingNumber) {
        Booking booking = bookingRepository.findByBookingNumber(bookingNumber).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Booking not found"));
        return new BookingDto(booking, false);
    }

    public BookingDto getBookingById(int id) {
        return new BookingDto(bookingRepository.findById(id).orElseThrow(), false);
    }
}
