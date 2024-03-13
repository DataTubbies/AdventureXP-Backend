package dat3.rename_me.entity;

import jakarta.persistence.*;
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
    @GeneratedValue(strategy = GenerationType.UUID)
   private UUID id;
   private String firstName ;
   private String lastName ;
   private  String email;
   private String streetName;
   private String streetNumber;
   private int zipCode;
   private String city;
   private int phoneNumber;
   private String password;
   private String username;




    public Customer(String firstName, String lastName, String email, String streetName, String streetNumber, int zipCode, String city, int phoneNumber, String username, String password) {
        this.id = UUID.randomUUID();
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.streetName = streetName;
        this.streetNumber = streetNumber;
        this.zipCode = zipCode;
        this.city = city;
        this.phoneNumber = phoneNumber;
        this.password = password;
        this.username = username;

    }


}
