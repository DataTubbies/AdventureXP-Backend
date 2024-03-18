package dat3.adventurexp.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import dat3.adventurexp.entity.Customer;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)

public class CustomerDto {
    private UUID id;
    private String companyName;
    private int cvr;
    private boolean isCompany;
    private String firstName ;
    private String lastName ;
    private  String email;
    private String streetName;
    private String streetNumber;
    private int zipCode;
    private String city;
    private int phoneNumber;
    private String username;
    private String password;
    private LocalDateTime created;
    private LocalDateTime edited;


    public CustomerDto(Customer c, boolean includeAll) {
        this.id = c.getId();
        this.companyName = c.getCompanyName();
        this.cvr = c.getCvr();
        this.isCompany = c.isCompany();
        this.phoneNumber =c.getPhoneNumber();
        this.firstName = c.getFirstName();
        this.lastName =c.getLastName();
        if(includeAll){

            this.email =c.getEmail();
            this.created = c.getCreated();
            this.edited = c.getEdited();
            this.streetName =c.getStreetName();
            this.streetNumber =c.getStreetNumber();
            this.zipCode =c.getZipCode();
            this.city =c.getCity();
            this.username =c.getUsername();
            this.password =c.getPassword();
        }
    }
}
