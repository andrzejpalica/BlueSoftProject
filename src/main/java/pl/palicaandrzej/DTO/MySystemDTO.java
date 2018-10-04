package pl.palicaandrzej.DTO;

import org.springframework.stereotype.Component;
import pl.palicaandrzej.models.MySystem;
import pl.palicaandrzej.models.SystemName;

@Component
public class MySystemDTO {

    private MySystem mySystem;
    private SystemName systemName;

    public MySystemDTO() {
    }

    public MySystem getMySystem() {
        return mySystem;
    }

    public void setMySystem(MySystem mySystem) {
        this.mySystem = mySystem;
    }

    public SystemName getSystemName() {
        return systemName;
    }

    public void setSystemName(SystemName systemName) {
        this.systemName = systemName;
    }
}
