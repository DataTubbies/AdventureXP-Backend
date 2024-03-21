package dat3.adventurexp.dto;

import dat3.adventurexp.entity.Activity;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.util.UUID;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)

public class ActivityDto {

    private UUID id;
    private String name;
    private double price;
    String base64image;
    String description;
    byte capacity;
    byte ageLimit;
    boolean isActive;
    int cancelLimit;
    int timeSpan;
    private LocalDateTime created;
    private LocalDateTime edited;

    public ActivityDto(Activity a, boolean includeAll) {
        this.id = a.getId();
        this.name = a.getName();
        this.price =a.getPrice();
        this.base64image=a.getBase64image();
        this.capacity =a.getCapacity();
        this.ageLimit=a.getAgeLimit();
        this.isActive =a.isActive();
        this.cancelLimit =a.getCancelLimit();
        this.timeSpan =a.getTimeSpan();
        this.description = a.getDescription();
        if(includeAll){
            this.created = a.getCreated();
            this.edited = a.getEdited();
        }

    }


}
