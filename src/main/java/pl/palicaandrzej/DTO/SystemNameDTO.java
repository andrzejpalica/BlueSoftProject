package pl.palicaandrzej.DTO;

import org.springframework.stereotype.Component;
import pl.palicaandrzej.models.SystemName;

@Component
public class SystemNameDTO {

    private SystemName systemName;

    public SystemNameDTO() {
    }

    public SystemName getSystemName() {
        return systemName;
    }

    public void setSystemName(SystemName systemName) {
        this.systemName = systemName;
    }
}
