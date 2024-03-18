package dat3.adventurexp.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@Setter
@Entity
@NoArgsConstructor
@Table(name = "activities")
public class Activity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    //@Column(columnDefinition = "VARCHAR(255)")
    private UUID id;

    @Column(unique = true)
    private String name;
    private double price;
    @Column(columnDefinition="MEDIUMBLOB")
    String base64image;

    @Column(columnDefinition="TEXT")
    String description;

    byte capacity;
    byte ageLimit;
    boolean isActive;
    int cancelLimit;
    int timeSpan;

    @CreationTimestamp
    private LocalDateTime created;

    @UpdateTimestamp
    private LocalDateTime edited;



}
