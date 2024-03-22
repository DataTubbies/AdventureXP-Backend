package dat3.adventurexp.service;

import dat3.adventurexp.dto.BookingDto;
import dat3.adventurexp.entity.ActivityEvent;
import dat3.adventurexp.entity.Booking;
import dat3.adventurexp.repository.ActivityEventRepository;
import dat3.adventurexp.repository.BookingRepository;
import dat3.adventurexp.repository.CustomerRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class BookingService {

    private BookingRepository bookingRepository;

    private BookingNumberService bookingNumberService;

    private CustomerRepository customerRepository;

    private ActivityEventRepository activityEventRepository;

    private ActivityEventService activityEventService;

        public BookingService(BookingRepository bookingRepository, BookingNumberService bookingNumberService, CustomerRepository customerRepository, ActivityEventRepository activityEventRepository, ActivityEventService activityEventService) {
            this.bookingRepository = bookingRepository;
            this.customerRepository = customerRepository;
            this.activityEventRepository = activityEventRepository;
            this.bookingNumberService = bookingNumberService;
            this.activityEventService = activityEventService;
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


    private void updateBooking(Booking original, BookingDto r){
            original.setCustomer(customerRepository.findById(r.getCustomerId()).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Customer not found")));
        original.setActivityEvent(activityEventRepository.findById(r.getActivityEventId()).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Activity event not found")));
        original.setParticipants(r.getParticipants());
    }

    public BookingDto addBooking(BookingDto bookingDto) {
        Booking booking = new Booking();
        updateBooking(booking, bookingDto);
        booking.setBookingNumber(bookingNumberService.generateBookingNumber());

        ActivityEvent activityEvent = activityEventRepository.findById(bookingDto.getActivityEventId())
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "ActivityEvent not found"));

        activityEvent.getBookings().add(booking);
        activityEventService.calculateAvailableSpots(activityEvent);

        if (activityEvent.getAvailableSpots() < 0) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "No available spots for this activity event");
        }

        bookingRepository.save(booking);

        return new BookingDto(booking, false);
    }

    //public List<Booking> getBookingsByCustomerId(UUID customerId) {
        // Call the repository method to fetch bookings by customer ID
        //return bookingRepository.findByCustomerId(customerId).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "No activity events found"));
    //'}

}
