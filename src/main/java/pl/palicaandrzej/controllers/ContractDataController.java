package pl.palicaandrzej.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.palicaandrzej.DTO.MyContractDTO;
import pl.palicaandrzej.DTO.PeriodicityDTO;
import pl.palicaandrzej.DTO.SystemNameDTO;
import pl.palicaandrzej.models.MyContract;
import pl.palicaandrzej.models.Periodicity;
import pl.palicaandrzej.models.SystemName;
import pl.palicaandrzej.services.ContractDataService;
import pl.palicaandrzej.services.DictionaryService;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Controller
@RequestMapping
public class ContractDataController {

    private ContractDataService contractDataService;
    private DictionaryService dictionaryService;

    @Autowired
    public ContractDataController(ContractDataService contractDataService, DictionaryService dictionaryService) {
        this.contractDataService = contractDataService;
        this.dictionaryService = dictionaryService;
    }

    @GetMapping("all")
    public String showAllContracts(Model model) {
        List<MyContract> allContracts = contractDataService.loadAllContracts();
        model.addAttribute("allContracts", allContracts);
        return "allContracts";

    }

    @GetMapping("active")
    public String showAllActiveContracts(Model model) {
        List<MyContract> activeContracts = contractDataService.loadAllActiveContracts();
        model.addAttribute("activeContracts", activeContracts);
        return "activeContracts";

    }

    @GetMapping("add")
    public String addContract(Model model) {
        List<SystemName> systemNames = dictionaryService.getSystemNames();
        List<Periodicity> periodicity = dictionaryService.getPeriodicity();
        MyContract myContract = new MyContract();
        model.addAttribute("systemNames", systemNames);
        model.addAttribute("periodicity", periodicity);
        model.addAttribute("addedContract", myContract);
        return "addContract";
    }

    @PostMapping("add")
    public String addedContract(
            @ModelAttribute("addedContract") MyContract contractToSave
    ) {
        contractDataService.addContract(contractToSave);
        return "redirect: allContracts";
    }

    @GetMapping("edit/{id}")
    public String editContract(Model model, @PathVariable("id") Long contractId) {
        MyContract editedContract = contractDataService.loadContractById(contractId);
        model.addAttribute("editedContract", editedContract);
        return "allContracts";
    }

    @PutMapping("edited/{id}")
    public String editedContract(@ModelAttribute("editedContract") MyContract contractToEdit) {
        MyContractDTO myContractDTO = new MyContractDTO();
        SystemNameDTO systemNameDTO = new SystemNameDTO();
        PeriodicityDTO periodicityDTO = new PeriodicityDTO();
        contractToEdit.setSystemName(systemNameDTO.getSystemName());
        contractToEdit.setActiveFrom(myContractDTO.getActiveFrom());
        contractToEdit.setActiveTo(myContractDTO.getActiveTo());
        contractToEdit.setIncome(myContractDTO.getIncome());
        contractToEdit.setPeriodicity(periodicityDTO.getPeriodicity());
        contractToEdit.setActive(myContractDTO.getActive());

        contractDataService.updateContract(contractToEdit);

        return "redirect: editContract/" + contractToEdit.getId();
    }

    @GetMapping("delete/{id}")
    public String deleteContract(Model model, @PathVariable("id") Long contractId) {
        MyContract deletedContract = contractDataService.loadContractById(contractId);
        model.addAttribute("deletedContract", deletedContract);
        return "activeContracts";
    }

    @PutMapping("deleted/{id}")
    public String deletedContract(@ModelAttribute("deletedContarct") MyContract contractToDelete) {
        MyContractDTO myContractDTO = new MyContractDTO();
        contractToDelete.setActive(myContractDTO.getActive());

        contractDataService.updateContract(contractToDelete);
        return "redirect: editContract/" + contractToDelete.getId();
    }
}


