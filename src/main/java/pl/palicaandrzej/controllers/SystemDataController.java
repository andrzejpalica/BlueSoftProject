package pl.palicaandrzej.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.palicaandrzej.models.MySystem;
import pl.palicaandrzej.services.SystemDataService;

import java.util.List;

@Controller
@RequestMapping("/systems")
public class SystemDataController {

    private SystemDataService systemDataService;

    public SystemDataController(SystemDataService systemDataService) {
        this.systemDataService = systemDataService;
    }

    @GetMapping
    public String showSystemsList(Model model) {
        List<MySystem> systems = systemDataService.loadAllSystems();
        model.addAttribute("systems", systems);
        return "systems";
    }

//    @GetMapping("/${id}")
//    public String showSystemDetails(Model model, @PathVariable("id") Long systemId) {
//        MySystem system = systemDataService.loadSystemById(systemId);
//        model.addAttribute("system", system);
//        return "systemDetails";
//    }


}
