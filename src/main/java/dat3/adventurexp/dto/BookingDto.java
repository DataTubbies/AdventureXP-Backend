package dat3.adventurexp.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import dat3.adventurexp.entity.Booking;
import jakarta.persistence.Column;
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
    private UUID activityId;

    private UUID customerId;


    int bookingNumber;

    Activity activity;

    Customer customer;


    @CreationTimestamp
    private LocalDateTime created;

    @UpdateTimestamp
    private LocalDateTime edited;

public BookingDto(Booking b, boolean includeAll) {
    this.id = b.getId();
    this.activity = b.getActivity();
    this.customer = b.getCustomer();
    this.activityId = b.getActivity().getId();
    this.customerId =b.getCustomer().getId();

    if(includeAll){
        this.created = b.getCreated();
        this.edited = b.getEdited();
        this.bookingNumber = b.getBookingNumber();
        }
    }
}
