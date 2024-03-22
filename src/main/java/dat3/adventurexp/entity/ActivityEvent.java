package dat3.adventurexp.entity;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.awt.print.Book;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Getter
@Setter
@Entity
@NoArgsConstructor
@Table(name = "activity_event")
public class ActivityEvent {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    //@Column(columnDefinition = "VARCHAR(255)")
    private UUID id;

    @ManyToOne
    @JoinColumn(name = "activity_id", referencedColumnName = "id")
    private Activity activity;

    @JsonIgnoreProperties("activityEvent")
    @OneToMany(mappedBy = "activityEvent")
    private Set<Booking> bookings = new HashSet<>();

    private LocalDateTime startTime;

    private int capacity;
    private int availableSpots;

    public ActivityEvent(String startTime, int capacity, int availableSpots) {
        this.startTime = LocalDateTime.parse(startTime);
        this.capacity = capacity;
        this.availableSpots = availableSpots;
    }

}
