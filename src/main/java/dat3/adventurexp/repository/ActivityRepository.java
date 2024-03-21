package dat3.adventurexp.repository;

import dat3.adventurexp.entity.Activity;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;
import java.util.UUID;

public interface ActivityRepository extends JpaRepository <Activity, UUID> {
    Optional<Activity> findByName(String Name);

}
