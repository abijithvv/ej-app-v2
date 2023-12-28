package co.abijith.ejappv2.controller;

import co.abijith.ejappv2.entity.Programs;
import co.abijith.ejappv2.service.ProgramService;
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
public class MasterController {

    @Autowired
    ProgramService programService;

    //login page
    @GetMapping({"/login", "/"})
    public String login() {
        return "Login";
    }

    //home page
    @GetMapping("/home")
    public String home() {
        return "Home";
    }

    // Display all programs
    @GetMapping("/programs")
    public String getAllPrograms(Model model) {
        List<Programs> programs = programService.fetchAllPrograms();
        model.addAttribute("programs", programs);
        return "admin/program/List";
    }

    // Display details of a program
//    @GetMapping("/programs/{id}")
//    public String getProgramDetails(@PathVariable Long id, Model model) {
//        Optional<Programs> program = programsRepository.findById(id);
//        program.ifPresent(value -> model.addAttribute("program", value));
//        return "admin/programs/details";
//    }
//
    // Show the form to create a new program
    @GetMapping("/programs/new")
    public String showCreateProgramForm(Model model) {
        model.addAttribute("program", new Programs());
        return "admin/program/New";
    }

    // Handle form submission to create a new program
    @PostMapping("/programs/new")
    public String createProgram(@ModelAttribute Programs program) {
        programService.saveNewProgram(program);
        return "redirect:/v2/programs";
    }
//
//    // Show the form to update a program
//    @GetMapping("/programs/edit/{id}")
//    public String showEditProgramForm(@PathVariable Long id, Model model) {
//        Optional<Programs> program = programsRepository.findById(id);
//        program.ifPresent(value -> model.addAttribute("program", value));
//        return "admin/programs/edit";
//    }
//
//    // Handle form submission to update a program
//    @PostMapping("/programs/edit/{id}")
//    public String updateProgram(@PathVariable Long id, @ModelAttribute Programs updatedProgram) {
//        Optional<Programs> existingProgram = programsRepository.findById(id);
//
//        existingProgram.ifPresent(program -> {
//            program.setProgramName(updatedProgram.getProgramName());
//            program.setStatus(updatedProgram.getStatus());
//            programsRepository.save(program);
//        });
//
//        return "redirect:/admin/programs";
//    }
//
//    // Delete a program by ID
//    @GetMapping("/programs/delete/{id}")
//    public String deleteProgram(@PathVariable Long id) {
//        programsRepository.deleteById(id);
//        return "redirect:/admin/programs";
//    }

    // Other methods for PlanDuration and Plans entities can be similarly implemented


}
