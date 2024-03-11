package dat3.rename_me.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Setter
@Getter
@Entity
@NoArgsConstructor
@Table(name = "customers")

public class Customer {

    @Id
   private UUID id;
   private String firstName ;
   private String lastName ;
   private String email;

   private String streetName;

   private String streetNumber;

   private int zipCode;

   private String city;

   private int phoneNumber;




    public Customer(String firstName, String lastName, String email, String streetName, String streetNumber, int zipCode, String city, int phoneNumber) {
        this.id = UUID.randomUUID();
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.streetName = streetName;
        this.streetNumber = streetNumber;
        this.zipCode = zipCode;
        this.city = city;
        this.phoneNumber = phoneNumber;
    }


}
