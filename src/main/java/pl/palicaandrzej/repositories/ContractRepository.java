package pl.palicaandrzej.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.palicaandrzej.models.MyContract;

import java.util.List;

public interface ContractRepository extends JpaRepository<MyContract, Long>{

    List<MyContract> findAllByIsActiveIsTrue();

}
