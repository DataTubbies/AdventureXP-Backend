package dat3.adventurexp.service;


import dat3.adventurexp.dto.ActivityDto;
import dat3.adventurexp.dto.ActivityEventDto;
import dat3.adventurexp.entity.Activity;
import dat3.adventurexp.entity.ActivityEvent;
import dat3.adventurexp.repository.ActivityEventRepository;
import dat3.adventurexp.repository.ActivityRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class ActivityEventService {

    private ActivityEventRepository activityEventRepository;
    private ActivityRepository activityRepository;


    public ActivityEventService(ActivityEventRepository activityEventRepository, ActivityRepository activityRepository) {
        this.activityEventRepository = activityEventRepository;
        this.activityRepository = activityRepository;
    }

    public List<ActivityEventDto> getAllActivityEvents() {
        List<ActivityEvent> activityEvents = activityEventRepository.findAll();
        return activityEvents.stream().map(ae -> new ActivityEventDto(ae, false)).collect(Collectors.toList());
    }

    public List <ActivityEventDto> getActivityEventByActivityId(UUID id) {
        List<ActivityEvent> activityEvents = activityEventRepository.findByActivityId(id);
        return activityEvents.stream().map(ae -> new ActivityEventDto(ae, false)).collect(Collectors.toList());
    }

    public ActivityEventDto addActivityEvent(ActivityEventDto request) {
        if (request.getId() != null) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "You cannot provide the id for a new activity event");
        }
        ActivityEvent newActivityEvent = new ActivityEvent();
        updateActivityEvent(newActivityEvent, request);
        activityEventRepository.save(newActivityEvent);
        return new ActivityEventDto(newActivityEvent, false);
    }

    private void updateActivityEvent(ActivityEvent original, ActivityEventDto r) {
        original.setActivity(activityRepository.findById(r.getActivityId( )).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Activity not found")));
        original.setStartTime(LocalDateTime.parse(r.getStartTime()));
        original.setCapacity(r.getCapacity());
        original.setAvailableSpots(r.getAvailableSpots());
        original.setBookings(r.getBookings());
    }
}
