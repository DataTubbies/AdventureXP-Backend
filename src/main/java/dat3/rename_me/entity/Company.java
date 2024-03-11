package dat3.rename_me.entity;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "companies")
public class Company extends Customer {


    @Id
    private UUID id;
    private String companyName;
    private String cvr;



    public Company(String companyName, String firstName,String LastName, String email, String cvr, String streetName, String streetNumber, int zipCode, String city, int phoneNumber, String username, String password) {
        super(firstName, LastName, email, streetName, streetNumber, zipCode, city, phoneNumber, username, password);
        this.id = UUID.randomUUID();
        this.companyName = companyName;
        this.cvr = cvr;
}
}