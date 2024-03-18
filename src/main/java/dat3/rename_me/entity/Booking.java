package dat3.rename_me.entity;


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
    String activity;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "customer_username", referencedColumnName = "username")
    Customer customer;

    @CreationTimestamp
    private LocalDateTime created;

    @UpdateTimestamp
    private LocalDateTime edited;
}
