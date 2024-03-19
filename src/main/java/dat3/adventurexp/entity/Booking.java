package dat3.adventurexp.entity;


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
    //@Column(columnDefinition = "VARCHAR(255)")
    private UUID id;

    @Column(nullable =true)
    String companyName;
    String customerFirstName;
    String customerLastName;
    String streetName;
    String streetNumber;
    int zipCode;
    String city;
    int phoneNumber;
    int bookingNumber;

    @ManyToOne
    @JoinColumn(name = "activity_id", referencedColumnName = "id")
    Activity activity;

    @ManyToOne
    @JoinColumn(name = "customer_id", referencedColumnName = "id")
    Customer customer;

    @CreationTimestamp
    private LocalDateTime created;

    @UpdateTimestamp
    private LocalDateTime edited;
}
