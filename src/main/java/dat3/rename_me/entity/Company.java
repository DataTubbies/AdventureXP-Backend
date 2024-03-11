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
public class Company {

    @Id
    private UUID id;
    private String name;
    private String cvr;
    private  String streetName;
    private  String streetNumber;
    private int zipCode;
    private String city;
    private int phoneNumber;



    public Company(String name, String cvr, int numEmployees, long marketValue) {
        this.id = UUID.randomUUID();
        this.name = name;
        this.cvr = cvr;
        this.numEmployees = numEmployees;
        this.marketValue = marketValue;
    }

}
