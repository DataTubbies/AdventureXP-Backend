package dat3.rename_me.service;

import dat3.rename_me.dto.ActivityDto;
import dat3.rename_me.entity.Activity;
import dat3.rename_me.repository.ActivityRepository;
import org.springframework.stereotype.Service;

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
        return activities.stream().map( a ->new ActivityDto(a,false)).collect(Collectors.toList());
    }

    public ActivityDto getActivityById(UUID id) {
        return new ActivityDto(activityRepository.findById(id).orElseThrow(), false);
    }
}
