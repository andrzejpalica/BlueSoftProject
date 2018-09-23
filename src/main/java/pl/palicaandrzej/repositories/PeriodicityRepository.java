package pl.palicaandrzej.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.palicaandrzej.models.Periodicity;

public interface PeriodicityRepository extends JpaRepository<Periodicity, Long> {
}
