package pl.palicaandrzej.DTO;

import org.springframework.stereotype.Component;
import pl.palicaandrzej.models.Periodicity;

@Component
public class PeriodicityDTO {

    private Periodicity periodicity;

    public PeriodicityDTO() {
    }

    public Periodicity getPeriodicity() {
        return periodicity;
    }

    public void setPeriodicity(Periodicity periodicity) {
        this.periodicity = periodicity;
    }
}
