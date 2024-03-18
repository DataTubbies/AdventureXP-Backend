package dat3.adventurexp.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


import java.time.LocalDateTime;
import java.util.UUID;

@Setter
@Getter
@Entity
@NoArgsConstructor
@Table(name = "customers")
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    //@Column(columnDefinition = "VARCHAR(255)")
    private UUID id;

    @Column(nullable = true)
    private String companyName;
    @Column(nullable = true)
    private int cvr;


    private boolean isCompany;
   private String firstName ;
   private String lastName ;
   private String email;
   private String streetName;
   private String streetNumber;
   private int zipCode;
   private String city;
   private int phoneNumber;
   private String username;
   @Transient
   private String password;

    private LocalDateTime created;
    private LocalDateTime edited;


    public Customer(UUID id, String companyName, boolean isCompany, String firstName,String LastName, String email, int cvr, String streetName, String streetNumber, int zipCode, String city, int phoneNumber, String username, String password) {
        this.id = id;
        this.companyName = companyName;
        this.cvr = cvr;
        this.isCompany = isCompany;
        this.firstName = firstName;
        this.lastName = LastName;
        this.email = email;
        this.streetName = streetName;
        this.streetNumber = streetNumber;
        this.zipCode = zipCode;
        this.city = city;
        this.phoneNumber = phoneNumber;
        this.username = username;
        this.password = password;
    }

}
