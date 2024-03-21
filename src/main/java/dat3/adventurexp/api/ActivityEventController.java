package dat3.adventurexp.api;


import dat3.adventurexp.dto.ActivityEventDto;
import dat3.adventurexp.entity.ActivityEvent;

import dat3.adventurexp.service.ActivityEventService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/activityevent")
public class ActivityEventController {

    private ActivityEventService activityEventService;

    public ActivityEventController(ActivityEventService activityEventService) {
        this.activityEventService = activityEventService;
    }

    @GetMapping
    public List<ActivityEventDto> getAllActivityEvents() {return activityEventService.getAllActivityEvents();}

    @PostMapping
    public ActivityEventDto createActivityEvent(@RequestBody ActivityEventDto requestBody) {
        return activityEventService.addActivityEvent(requestBody);
    }
    //@GetMapping(path="/{id}")
    //public ActivityEventDto getActivityEventByActivityId(@PathVariable UUID id) {return activityEventService.getActivityEventById(id);}
}





