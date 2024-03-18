package dat3.rename_me.service;

import dat3.rename_me.dto.ActivityDto;
import dat3.rename_me.dto.BookingDto;
import dat3.rename_me.entity.Activity;
import dat3.rename_me.entity.Booking;
import dat3.rename_me.repository.BookingRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

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

    public Object getBookingsByUser(String username) {
        List<Booking> bookings = bookingRepository.findByCustomerUsername(username);
        return bookings.stream().map((b)->new BookingDto(b, false)).collect(Collectors.toList());
    }

    public BookingDto getBookingById(UUID id) {
        return new BookingDto(bookingRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Booking not found")), false);
    }

    public Object getBookingsByUserId(UUID id) {
        return bookingRepository.findById(id);
    }

    private void updateBooking(Booking original, BookingDto r) {
        original.setCompanyName(r.getCompanyName());
        original.setCustomerFirstName(r.getCustomerFirstName());
        original.setCustomerLastName(r.getCustomerLastName());
        original.setCustomer(r.getCustomer());
        original.setStreetName(r.getStreetName());
        original.setStreetNumber(r.getStreetNumber());
        original.setZipCode(r.getZipCode());
        original.setCity(r.getCity());
        original.setPhoneNumber(r.getPhoneNumber());
        original.setBookingNumber(r.getBookingNumber());
        original.setActivity(r.getActivity());
    }

    public BookingDto addBooking(BookingDto bookingDto) {
        Booking booking = new Booking();
        updateBooking(booking, bookingDto);
        bookingRepository.save(booking);
        return new BookingDto(booking, false);
    }
}
