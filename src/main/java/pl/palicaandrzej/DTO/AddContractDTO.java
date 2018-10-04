package pl.palicaandrzej.DTO;

import org.springframework.stereotype.Component;
import pl.palicaandrzej.models.MyContract;
import pl.palicaandrzej.models.Periodicity;
import pl.palicaandrzej.models.SystemName;

import java.util.List;

@Component
public class AddContractDTO {

    private MyContract myContract;
    private List<SystemName> systemNameList;
    private List<Periodicity> periodicityList;

    public AddContractDTO() {
    }

    public MyContract getMyContract() {
        return myContract;
    }

    public void setMyContract(MyContract myContract) {
        this.myContract = myContract;
    }

    public List<SystemName> getSystemNameList() {
        return systemNameList;
    }

    public void setSystemNameList(List<SystemName> systemNameList) {
        this.systemNameList = systemNameList;
    }

    public List<Periodicity> getPeriodicityList() {
        return periodicityList;
    }

    public void setPeriodicityList(List<Periodicity> periodicityList) {
        this.periodicityList = periodicityList;
    }
}
