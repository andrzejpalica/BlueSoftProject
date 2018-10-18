package pl.palicaandrzej.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.palicaandrzej.DTO.AddContractDTO;
import pl.palicaandrzej.models.MyContract;
import pl.palicaandrzej.services.ContractDataService;
import pl.palicaandrzej.services.DictionaryService;

import java.util.List;

@Controller
@RequestMapping ("/contract")
public class ContractDataController {

    private final ContractDataService contractDataService;
    private final DictionaryService dictionaryService;

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
        AddContractDTO addContractDTO = new AddContractDTO();
        addContractDTO.setMyContract(new MyContract());
        addContractDTO.setSystemNameList(dictionaryService.getSystemNames());
        addContractDTO.setPeriodicityList(dictionaryService.getPeriodicity());
        model.addAttribute("addContractDTO", addContractDTO);
        return "addContract";
    }

    @PostMapping("add")
    public String addedContract(
            @ModelAttribute("addContractDTO") AddContractDTO addContractDTO
    ) {

        MyContract contractToSave = addContractDTO.getMyContract();
        contractDataService.addContract(contractToSave);
        return "redirect:/all";
    }

    @GetMapping("edit/{id}")
    public String editContract(Model model, @PathVariable("id") Long contractId) {
        AddContractDTO addContractDTO = new AddContractDTO();
        addContractDTO.setMyContract(contractDataService.loadContractById(contractId));
        addContractDTO.setSystemNameList(dictionaryService.getSystemNames());
        addContractDTO.setPeriodicityList(dictionaryService.getPeriodicity());
        model.addAttribute("addContractDTO", addContractDTO);
        return "editContract";
    }

    @PostMapping("{id}")
    public String editedContract(@ModelAttribute("addContractDTO") AddContractDTO addContractDTO) {

        MyContract contractToEdit = addContractDTO.getMyContract();


        contractDataService.updateContract(contractToEdit);

        return "redirect:/contract/all";
    }

    @GetMapping("delete/{id}")
    public String deletedContract(MyContract contractToDelete) {
        contractDataService.deleteContract(contractToDelete);
        return "redirect:/contract/all";
    }
}


