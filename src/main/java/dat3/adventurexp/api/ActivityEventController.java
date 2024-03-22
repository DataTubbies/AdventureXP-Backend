package dat3.adventurexp.api;


import dat3.adventurexp.dto.ActivityDto;
import dat3.adventurexp.dto.ActivityEventDto;
import dat3.adventurexp.entity.ActivityEvent;

import dat3.adventurexp.service.ActivityEventService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/activityevents")
public class ActivityEventController {

    private ActivityEventService activityEventService;

    public ActivityEventController(ActivityEventService activityEventService) {
        this.activityEventService = activityEventService;
    }

    @GetMapping
    public List<ActivityEventDto> getAllActivityEvents() {return activityEventService.getAllActivityEvents();}


    @GetMapping(path = "/{id}")
    public ActivityEventDto getActivityEventById(@PathVariable UUID id) {
        return activityEventService.getActivityEventById(id);
    }

    @GetMapping("/activity/{id}")
    public List<ActivityEventDto> getAllActivityEventsByActivityId(@PathVariable UUID id) {
        return activityEventService.getActivityEventsByActivityId(id);
    }

    @PostMapping
    public ActivityEventDto createActivityEvent(@RequestBody ActivityEventDto requestBody) {
        return activityEventService.addActivityEvent(requestBody);
    }


    @DeleteMapping(path = "/{id}")
    public ResponseEntity deleteActivityEvent(@PathVariable UUID id) {
        return activityEventService.deleteActivityEvent(id);
    }

    //@GetMapping(path="/{id}")
    //public ActivityEventDto getActivityEventByActivityId(@PathVariable UUID id) {return activityEventService.getActivityEventById(id);}
}





