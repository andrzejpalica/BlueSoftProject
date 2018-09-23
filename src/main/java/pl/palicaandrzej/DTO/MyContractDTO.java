package pl.palicaandrzej.DTO;

import org.springframework.stereotype.Component;
import pl.palicaandrzej.models.MyContract;
import pl.palicaandrzej.models.MySystem;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Optional;

@Component
public class MyContractDTO {

    private MySystem systemName;

    private LocalDate activeFrom;

    private LocalDate activeTo;

    private BigDecimal income;

    private String periodicity;

    private boolean isActive;

    private MyContract contract;

    public MyContractDTO() {
    }

    public MySystem getSystemName() {
        return systemName;
    }

    public void setSystemName(MySystem systemName) {
        this.systemName = systemName;
    }

    public LocalDate getActiveFrom() {
        return activeFrom;
    }

    public void setActiveFrom(LocalDate activeFrom) {
        this.activeFrom = activeFrom;
    }

    public LocalDate getActiveTo() {
        return activeTo;
    }

    public void setActiveTo(LocalDate activeTo) {
        this.activeTo = activeTo;
    }

    public BigDecimal getIncome() {
        return income;
    }

    public void setIncome(BigDecimal income) {
        this.income = income;
    }

    public String getPeriodicity() {
        return periodicity;
    }

    public void setPeriodicity(String periodicity) {
        this.periodicity = periodicity;
    }

    public Boolean getActive() {
        return isActive;
    }

    public void setActive(Boolean active) {
        isActive = active;
    }

    public MyContract getContract() {
        return contract;
    }

    public void setContract(MyContract contract) {
        this.contract = contract;
    }
}




