package dat3.rename_me.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "companies")
public class Company extends Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    private String companyName;
    private String cvr;


    private LocalDateTime created;
    private LocalDateTime edited;


    public Company(String companyName, String firstName,String LastName, String email, String cvr, String streetName, String streetNumber, int zipCode, String city, int phoneNumber, String username, String password) {
        super(firstName, LastName, email, streetName, streetNumber, zipCode, city, phoneNumber, username, password);
        this.id = UUID.randomUUID();
        this.companyName = companyName;
        this.cvr = cvr;

    }


}
