package dat3.adventurexp.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import dat3.adventurexp.entity.ActivityEvent;
import dat3.adventurexp.entity.Booking;
import dat3.adventurexp.entity.Customer;
import jakarta.persistence.Column;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class BookingDto {

    private UUID id;
    private UUID activityEventId;
    private UUID customerId;

    int bookingNumber;

    byte participants;

    @CreationTimestamp
    private LocalDateTime created;

    @UpdateTimestamp
    private LocalDateTime edited;

    public BookingDto(Booking b, boolean includeAll) {
        this.id = b.getId();
        this.activityEventId = b.getActivityEvent().getId();
        this.customerId = b.getCustomer().getId();
        this.participants = b.getParticipants();
        this.bookingNumber = b.getBookingNumber();

        if (includeAll) {
            this.created = b.getCreated();
            this.edited = b.getEdited();
        }
    }

}
