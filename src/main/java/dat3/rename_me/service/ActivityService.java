package dat3.rename_me.service;

import dat3.rename_me.repository.ActivityRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ActivityService {

    private ActivityRepository activityRepository;

    public ActivityService(ActivityRepository activityRepository) {
        this.activityRepository = activityRepository;
    }

    public List<ActivityDto> getAllActivities() {
        List<ActivityDto> activities = activityRepository.findAll();
        return activities.stream().map((b)->new ActivityDto(b, false).toList()).collect(Collectors.toList();
    }

    public ActivityDto getActivityById(int id) {
        return new ActivityDto(activityRepository.findById(id).orElseThrow(), false);
    }
}
