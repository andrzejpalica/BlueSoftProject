package pl.palicaandrzej.services;

import org.springframework.stereotype.Service;
import pl.palicaandrzej.models.MySystem;
import pl.palicaandrzej.repositories.SystemRepository;

import java.util.List;

@Service
public class DefaultSystemService implements SystemDataService {

    private SystemRepository systemRepository;

    public DefaultSystemService(SystemRepository systemRepository) {
        this.systemRepository = systemRepository;
    }

    @Override
    public List<MySystem> loadAllSystems() {
        return systemRepository.findAll();
    }

}
