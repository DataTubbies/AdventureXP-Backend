package dat3.rename_me.service;

import dat3.rename_me.dto.ActivityDto;
import dat3.rename_me.entity.Activity;
import dat3.rename_me.repository.ActivityRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class ActivityService {

    private ActivityRepository activityRepository;

    public ActivityService(ActivityRepository activityRepository) {
        this.activityRepository = activityRepository;
    }

    public List<ActivityDto> getAllActivities() {
        List<Activity> activities = activityRepository.findAll();
        return activities.stream().map(a -> new ActivityDto(a, false)).collect(Collectors.toList());
    }

    public ActivityDto getActivityById(UUID id) {
        return new ActivityDto(activityRepository.findById(id).orElseThrow(), false);
    }


    public ActivityDto addActivity(ActivityDto request) {
        if (request.getId() != null) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "You cannot provide the id for a new activity");
        }
        Activity newActivity = new Activity();
        updateActivity(newActivity, request);
        activityRepository.save(newActivity);
        return new ActivityDto(newActivity, false);
    }

    private void updateActivity(Activity original, ActivityDto r) {
        original.setName(r.getName());
        original.setPrice(r.getPrice());
        original.setBase64image(r.getBase64image());
        original.setDescription(r.getDescription());
        original.setCapacity(r.getCapacity());
        original.setActive(r.isActive());
        original.setAgeLimit(r.getAgeLimit());
        original.setCancelLimit(r.getCancelLimit());
        original.setTimeSpan(r.getTimeSpan());
    }

        public ActivityDto editActivity(ActivityDto request, UUID id) {
        /*if (request.getId() != id) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "You cannot change the id of an existing recipe");
        } */
        Activity activityToEdit = activityRepository.findById(id).orElseThrow(()
                -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Activity not found"));
        updateActivity(activityToEdit,request);
        activityRepository.save(activityToEdit);
        return new ActivityDto(activityToEdit,false);
    }

    public ResponseEntity deleteActivity(UUID id) {
        Activity activity = activityRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Activity not found"));
        activityRepository.delete(activity);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }

};






