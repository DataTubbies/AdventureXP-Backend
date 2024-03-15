package dat3.rename_me.api;

import com.fasterxml.jackson.databind.deser.std.UUIDDeserializer;
import dat3.rename_me.dto.ActivityDto;
import dat3.rename_me.entity.Activity;
import dat3.rename_me.service.ActivityService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/activities")
public class ActivityController {

    private ActivityService activityService;

    public ActivityController(ActivityService activityService) {
        this.activityService = activityService;
    }

    @GetMapping
    public List<ActivityDto> getAllActivities() {
        return activityService.getAllActivities();
    }

    @GetMapping(path = "/{id}")
    public ActivityDto getActivityById(@PathVariable UUID id) {
        return activityService.getActivityById(id);
    }


    @PostMapping("/add")
    public ActivityDto addActivity(@RequestBody ActivityDto request) {
        return activityService.addActivity(request);
    }

    @PutMapping(path = "/{id}")
    public ActivityDto addActivity(@RequestBody ActivityDto request,@PathVariable UUID id) {
        return activityService.editActivity(request, id);
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity deleteActivity(@PathVariable UUID id) {
        return activityService.deleteActivity(id);
    }


};

