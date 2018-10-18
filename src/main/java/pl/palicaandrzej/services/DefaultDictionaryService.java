package pl.palicaandrzej.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.palicaandrzej.models.Periodicity;
import pl.palicaandrzej.models.SystemName;
import pl.palicaandrzej.repositories.PeriodicityRepository;
import pl.palicaandrzej.repositories.SystemNameRepository;

import java.util.List;

@Service
public class DefaultDictionaryService implements DictionaryService {

    private SystemNameRepository systemNameRepository;
    private PeriodicityRepository periodicityRepository;

    @Autowired
    public DefaultDictionaryService(SystemNameRepository systemNameRepository, PeriodicityRepository periodicityRepository) {
        this.systemNameRepository = systemNameRepository;
        this.periodicityRepository = periodicityRepository;
    }

    public DefaultDictionaryService(SystemNameRepository systemNameRepository) {
        this.systemNameRepository = systemNameRepository;
    }

    @Override
    public List<SystemName> getSystemNames() {
        return systemNameRepository.findAll();
    }

    @Override
    public List<Periodicity> getPeriodicity() {
        return periodicityRepository.findAll();
    }

    @Override
    public SystemName addSystemName(SystemName systemName) {
        return systemNameRepository.save(systemName);
    }

    @Override
    public SystemName loadSystemNameById(Long systemId) {
        return systemNameRepository.getOne(systemId);
    }

    @Override
    public void deleteSystemName(SystemName systemNameToDelete) {
        systemNameRepository.delete(systemNameToDelete);
    }
}
