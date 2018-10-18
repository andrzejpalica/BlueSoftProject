package pl.palicaandrzej.services;

import org.springframework.stereotype.Service;
import pl.palicaandrzej.models.MyContract;
import pl.palicaandrzej.repositories.ContractRepository;

import java.util.List;
import java.util.Optional;

@Service
public class DefaultContractService implements ContractDataService {

    private ContractRepository contractRepository;

    public DefaultContractService(ContractRepository contractRepository) {
        this.contractRepository = contractRepository;
    }

    @Override
    public List<MyContract> loadAllContracts() {
        return contractRepository.findAll();
    }

    @Override
    public List<MyContract> loadAllActiveContracts() {
        return contractRepository.findAllByIsActiveIsTrue();
    }

    @Override
    public void addContract(MyContract contractToSave) {
        contractRepository.save(contractToSave);
    }

    @Override
    public MyContract loadContractById(Long contractId) {
        Optional<MyContract> myContractOptional = contractRepository.findById(contractId);
        if (myContractOptional.isPresent()) {
            return myContractOptional.get();
        } else {
           throw new NullPointerException("No contract with such ID!");
        }
    }



    @Override
    public void updateContract(MyContract contractToEdit) {
        contractRepository.save(contractToEdit);
    }

    @Override
    public void deleteContract(MyContract contractToDelete) {
        contractRepository.delete(contractToDelete);
    }


}
