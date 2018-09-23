package pl.palicaandrzej.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.palicaandrzej.models.MySystem;

public interface SystemRepository extends JpaRepository<MySystem, Long> {



}
