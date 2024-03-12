package dat3.rename_me.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import dat3.rename_me.entity.Company;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)

public class CompanyDto {
    private UUID id;
    private String companyName;
    private String cvr;
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
    private LocalDateTime created;
    private LocalDateTime edited;


    public CompanyDto(Company c, boolean includeAll) {
        this.id = c.getId();
        this.companyName = c.getCompanyName();
        this.phoneNumber =c.getPhoneNumber();
        this.firstName = c.getFirstName();
        this.lastName =c.getLastName();
        if(includeAll){
          
            this.email =c.getEmail();
            this.created = c.getCreated();
            this.edited = c.getEdited();
            this.cvr = c.getCvr();
            this.streetName =c.getStreetName();
            this.streetNumber =c.getStreetNumber();
            this.zipCode =c.getZipCode();
            this.city =c.getCity();
            this.password = c.getPassword();
            this.username =c.getUsername();

        }
    }
}
