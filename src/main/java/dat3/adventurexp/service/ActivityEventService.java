package dat3.adventurexp.service;


import dat3.adventurexp.dto.ActivityDto;
import dat3.adventurexp.dto.ActivityEventDto;
import dat3.adventurexp.entity.Activity;
import dat3.adventurexp.entity.ActivityEvent;
import dat3.adventurexp.repository.ActivityEventRepository;
import dat3.adventurexp.repository.ActivityRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class ActivityEventService {

    private ActivityEventRepository activityEventRepository;


    public ActivityEventService(ActivityEventRepository activityEventRepository) {
        this.activityEventRepository = activityEventRepository;
    }

    public List<ActivityEventDto> getAllActivityEvents() {
        List<ActivityEvent> activityEvents = activityEventRepository.findAll();
        return activityEvents.stream().map(ae -> new ActivityEventDto(ae, false)).collect(Collectors.toList());
    }

    public List <ActivityEventDto> getActivityEventByActivityId(UUID id) {
        List<ActivityEvent> activityEvents = activityEventRepository.findByActivityId(id);
        return activityEvents.stream().map(ae -> new ActivityEventDto(ae, false)).collect(Collectors.toList());
    }
}
