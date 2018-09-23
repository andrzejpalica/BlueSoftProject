package pl.palicaandrzej.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.palicaandrzej.models.SystemName;

public interface SystemNameRepository extends JpaRepository<SystemName, Long> {

}
