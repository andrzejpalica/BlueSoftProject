package pl.palicaandrzej.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class StartPageController {

    @RequestMapping(value = "/")
    public String showStartPage() {
        return "startPage";
    }
}
