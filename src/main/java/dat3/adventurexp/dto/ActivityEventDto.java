package dat3.adventurexp.dto;


import com.fasterxml.jackson.annotation.JsonInclude;
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
}
