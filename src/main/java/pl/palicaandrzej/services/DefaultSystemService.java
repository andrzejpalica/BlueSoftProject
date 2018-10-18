package pl.palicaandrzej.services;

import org.springframework.stereotype.Service;
import pl.palicaandrzej.models.MySystem;
import pl.palicaandrzej.repositories.SystemRepository;

import java.util.List;
import java.util.Optional;

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

    @Override
    public void addSystem(MySystem systemToSave) {
        systemRepository.save(systemToSave);
    }

    @Override
    public void deleteSystem(MySystem systemToDelete) {
        systemRepository.delete(systemToDelete);
    }

    @Override
    public MySystem loadSystemById(Long systemId) {
        Optional<MySystem> mySystemOptional = systemRepository.findById(systemId);
        if (mySystemOptional.isPresent()) {
            return mySystemOptional.get();
        } else {
            throw new NullPointerException("No contract with such ID!");
        }
    }



}
