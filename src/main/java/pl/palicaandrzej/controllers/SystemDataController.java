package pl.palicaandrzej.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.palicaandrzej.DTO.MySystemDTO;
import pl.palicaandrzej.models.MySystem;
import pl.palicaandrzej.models.SystemName;
import pl.palicaandrzej.services.DictionaryService;
import pl.palicaandrzej.services.SystemDataService;

import java.util.List;

@Controller
@RequestMapping("/system")
public class SystemDataController {

    private final SystemDataService systemDataService;
    private final DictionaryService dictionaryService;

    @Autowired
    public SystemDataController(SystemDataService systemDataService, DictionaryService dictionaryService) {
        this.systemDataService = systemDataService;
        this.dictionaryService = dictionaryService;
    }

    @GetMapping("/all")
    public String showSystemsList(Model model) {
        List<MySystem> allSystems = systemDataService.loadAllSystems();
        model.addAttribute("allSystems", allSystems);
        return "allSystems";
    }

    @GetMapping("/add")
    public String addSystem(Model model) {
        MySystemDTO addSystemDTO = new MySystemDTO();
        addSystemDTO.setMySystem(new MySystem());
        addSystemDTO.setSystemName(new SystemName());
        model.addAttribute("addSystemDTO", addSystemDTO);
        return "addSystem";
    }

    @PostMapping("/add")
    public String addedSystem(
            @ModelAttribute("addSystemDTO") MySystemDTO addSystemDTO
    ) {

        SystemName systemNameToSave = addSystemDTO.getSystemName();
        MySystem systemToSave = addSystemDTO.getMySystem();
        dictionaryService.addSystemName(systemNameToSave);
        systemDataService.addSystem(systemToSave);
        return "redirect:/system/all";


    }

    @GetMapping("/{id}")
    public String showSystemDetails(Model model, @PathVariable("id") Long systemId) {
        MySystem showSystem = systemDataService.loadSystemById(systemId);
        model.addAttribute("showSystem", showSystem);
        return "showSystem";
    }

}

