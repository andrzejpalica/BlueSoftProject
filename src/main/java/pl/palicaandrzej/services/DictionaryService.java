package pl.palicaandrzej.services;

import pl.palicaandrzej.models.Periodicity;
import pl.palicaandrzej.models.SystemName;

import java.util.List;

public interface DictionaryService {

    List<SystemName> getSystemNames();
    List<Periodicity> getPeriodicity();

    SystemName addSystemName(SystemName systemName);
}
