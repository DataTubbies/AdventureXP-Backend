package dat3.adventurexp.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import dat3.adventurexp.entity.Booking;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import dat3.adventurexp.entity.Customer;
import dat3.adventurexp.entity.Activity;

import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class BookingDto {

    private UUID id;
    String companyName;
    String customerFirstName;
    String customerLastName;
    String streetName;
    String streetNumber;
    int zipCode;
    String city;
    int phoneNumber;
    int bookingNumber;

    Activity activity;

    Customer customer;


    @CreationTimestamp
    private LocalDateTime created;

    @UpdateTimestamp
    private LocalDateTime edited;

public BookingDto(Booking b, boolean includeAll) {
    this.id = b.getId();
    this.companyName = b.getCompanyName();
    this.bookingNumber = b.getBookingNumber();
    this.customerFirstName = b.getCustomerFirstName();
    this.customerLastName = b.getCustomerLastName();
    this.phoneNumber = b.getPhoneNumber();
    this.activity = b.getActivity();

    if(includeAll){
        this.streetName = b.getStreetName();
        this.streetNumber = b.getStreetNumber();
        this.zipCode = b.getZipCode();
        this.city = b.getCity();
        this.created = b.getCreated();
        this.edited = b.getEdited();
        }
    }
}
