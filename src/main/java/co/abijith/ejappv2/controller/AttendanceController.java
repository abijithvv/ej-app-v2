package co.abijith.ejappv2.controller;

import co.abijith.ejappv2.service.RegistrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/v2")
public class AttendanceController {

    @Autowired
    RegistrationService registrationService;

    @GetMapping("/attendance/bymember/{id}")
    public String showAttendanceFormFromMemberDetails(Model model, @PathVariable Long id){
        model.addAttribute("member",registrationService.getMemberById(id).get());
        return "/attendance/byMember";
    }
}
