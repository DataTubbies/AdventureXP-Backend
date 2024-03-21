package dat3.adventurexp.service;

import dat3.adventurexp.dto.BookingDto;
import dat3.adventurexp.entity.Booking;
import dat3.adventurexp.repository.BookingRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.awt.print.Book;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class BookingService {

    private BookingRepository bookingRepository;

    public BookingService(BookingRepository bookingRepository) {
        this.bookingRepository = bookingRepository;
    }

    public List<BookingDto> getAllBookings() {
        List<Booking> bookings = bookingRepository.findAll();
        return bookings.stream().map((b)->new BookingDto(b, false)).collect(Collectors.toList());
    }

    public BookingDto getBookingByBookingNumber(int bookingNumber) {
        return new BookingDto(bookingRepository.findByBookingNumber(bookingNumber).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Booking not found")), false);
    }

    public List<BookingDto> getBookingsByUser(String username) {
        List<Booking> bookings = bookingRepository.findByCustomerUsername(username);
        return bookings.stream().map((b)->new BookingDto(b, false)).collect(Collectors.toList());
    }

    public BookingDto getBookingById(UUID id) {
        return new BookingDto(bookingRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Booking not found")), false);
    }


    private void updateBooking(Booking original, BookingDto r) {
        original.setCustomer(r.getCustomer());
        original.setBookingNumber(r.getBookingNumber());
        original.setActivity(r.getActivity());
    }

    public BookingDto addBooking(BookingDto bookingDto) {
        Booking booking = new Booking();
        updateBooking(booking, bookingDto);
        bookingRepository.save(booking);
        return new BookingDto(booking, false);
    }

    public List<Booking> getBookingsByCustomerId(UUID customerId) {
        // Call the repository method to fetch bookings by customer ID
        return bookingRepository.findByCustomerId(customerId);
    }
}
