package pl.palicaandrzej.services;

import pl.palicaandrzej.models.MySystem;
import pl.palicaandrzej.models.SystemName;

import java.util.List;

public interface SystemDataService {


    List<MySystem> loadAllSystems();

    MySystem loadSystemById(Long systemId);

    void addSystem(MySystem systemToSave);

    void deleteSystem(MySystem systemToDelete);
}

