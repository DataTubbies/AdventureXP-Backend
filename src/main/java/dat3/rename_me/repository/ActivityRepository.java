package dat3.rename_me.repository;

import dat3.rename_me.entity.Activity;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface ActivityRepository extends JpaRepository <Activity, Integer> {
    public Optional<Activity> findByName(String Name);
}
