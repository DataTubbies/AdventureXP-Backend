package dat3.rename_me.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import dat3.rename_me.entity.Customer;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CustomerDto {
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


    public CustomerDto(Customer c, boolean includeAll) {
        this.id = c.getId();
        this.firstName = c.getFirstName();
        this.lastName = c.getLastName();
        this.email = c.getEmail();
        this.phoneNumber = c.getPhoneNumber();
        if (includeAll) {
            this.streetName = c.getStreetName();
            this.streetNumber = c.getStreetNumber();
            this.zipCode = c.getZipCode();
            this.city = c.getCity();
            this.password = c.getPassword();
            this.username = c.getUsername();
        }
    }

}
