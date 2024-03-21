package dat3.adventurexp.repository;

import dat3.adventurexp.entity.ActivityEvent;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface ActivityEventRepository extends JpaRepository<ActivityEvent, UUID>{
    Optional<ActivityEvent> findById(UUID id);
    List<ActivityEvent> findByActivityId(UUID id);
}

