package dat3.adventurexp.dto;


import com.fasterxml.jackson.annotation.JsonInclude;
import dat3.adventurexp.entity.ActivityEvent;
import dat3.adventurexp.entity.Booking;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ActivityEventDto {

    private UUID id;
    private UUID activityId;
    private Set<Booking> bookings;
    private int capacity;
    private int availableSpots;
    private String startTime;

    public ActivityEventDto(ActivityEvent ae, boolean includeAll) {
        this.id = ae.getId();
        this.activityId = ae.getActivity().getId();
        this.bookings = ae.getBookings();
        this.startTime = ae.getStartTime().toString();
        this.capacity= ae.getCapacity();
        this.availableSpots=ae.getAvailableSpots();
    }
}
