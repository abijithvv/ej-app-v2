package co.abijith.ejappv2.controller;

import co.abijith.ejappv2.entity.Registration;
import co.abijith.ejappv2.service.RegistrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/v2")
public class RegistrationController {
    @Autowired
    RegistrationService registrationService;

    @GetMapping("/viewMembers")
    public String viewAllRegistrationList(Model model) {
        model.addAttribute("registration", registrationService.findaAllRegistration());
        return "/registration/List";
    }
//show form to add new member
    @GetMapping("/registration/new")
    public String showRegistrationForm(Model model) {
        model.addAttribute("registration", new Registration());
        return "registration/New";
    }

//handle form to save new registration
    @PostMapping("/registration/new")
    public String addRegistration(@ModelAttribute Registration registration) {
        registrationService.saveRegistration(registration);
        return "redirect:/v2/viewMembers";
    }
}
