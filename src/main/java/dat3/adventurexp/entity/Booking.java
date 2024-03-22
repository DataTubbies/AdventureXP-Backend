package dat3.adventurexp.entity;


import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@Setter
@Entity
@NoArgsConstructor
@Table(name = "bookings")
public class Booking {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(nullable = false)
    private int bookingNumber;

    @JsonIgnoreProperties("bookings")
    @ManyToOne
    @JoinColumn(name = "activity_event_id", referencedColumnName = "id")
    @JsonBackReference
    ActivityEvent activityEvent;

    @JsonIgnoreProperties("bookings")
    @ManyToOne
    @JoinColumn(name = "customer_id", referencedColumnName = "id")
    @JsonBackReference
    Customer customer;

    private byte participants;

    @CreationTimestamp
    private LocalDateTime created;

    @UpdateTimestamp
    private LocalDateTime edited;

     public Booking (int bookingNumber, ActivityEvent activityEvent, Customer customer, byte participants) {
        this.bookingNumber = bookingNumber;
        this.activityEvent = activityEvent;
        this.customer = customer;
        this.participants = participants;
    }
}
