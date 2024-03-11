package dat3.rename_me.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
@Entity
@NoArgsConstructor
@Table(name = "activities")
public class Activity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private UUID id;

    @Column(unique = true)
    private String name;
    private double price;
    String base64image;

    @Column(columnDefinition="TEXT")
    String description;

    byte capacity;
    int ageLimit;
    boolean isActive;
    int cancelLimit;
    int timeSpan;
}
