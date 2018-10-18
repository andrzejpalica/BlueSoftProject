package pl.palicaandrzej.services;

import pl.palicaandrzej.models.MyContract;

import java.util.List;

public interface ContractDataService {

    List<MyContract> loadAllContracts();

    List<MyContract> loadAllActiveContracts();

    void addContract(MyContract contractToSave);

    MyContract loadContractById(Long ContractId);

    void updateContract(MyContract contractToEdit);

    void deleteContract(MyContract contractToDelete);
}
