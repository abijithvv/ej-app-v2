package co.abijith.ejappv2.controller;

import co.abijith.ejappv2.entity.PlanDuration;
import co.abijith.ejappv2.entity.Plans;
import co.abijith.ejappv2.entity.Programs;
import co.abijith.ejappv2.service.PlanDurationService;
import co.abijith.ejappv2.service.PlanService;
import co.abijith.ejappv2.service.ProgramService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/v2")
public class MasterController {

    @Autowired
    ProgramService programService;
    @Autowired
    PlanDurationService planDurationService;
    @Autowired
    PlanService planService;

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

    //----------------------------------------------------------
    //Program related controllers
    //----------------------------------------------------------

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

    //     Handle toggling Activate/Deactivate program
    @GetMapping("/programs/status/{id}")
    public String updateProgram(@PathVariable Long id) {
        programService.toggleProgramStatus(id);
        return "redirect:/v2/programs";
    }

    //------------------------------------------------
    //----Plan Duration related controllers-----------
    //------------------------------------------------
    // Display all plan Durations based on program id
    @GetMapping("/plandurations/program/{id}")
    public String getPlanDurationsBasedOnProgramId(@PathVariable Long id, Model model) {
        Optional<Programs> program = programService.findProgramById(id);
        List<PlanDuration> planDuration = planDurationService.fetchPlanDurationsByProgramId(id);
        model.addAttribute("planDuration", planDuration);
        model.addAttribute("program", program);
        return "admin/planDuration/DurationList";
    }
    //return list of plan durations based on program id passed as parameter
    @GetMapping("/fetchPlanDurations")
    @ResponseBody
    public ResponseEntity<List<PlanDuration>> fetchPlanDurationsByProgramId(@RequestParam Long programId){
        return ResponseEntity.ok(planDurationService.fetchPlanDurationsByProgramId(programId));
    }

    //show the form to create a new program duration
    @GetMapping("/plandurations/new/{progId}")
    public String showCreatePlanDurationForm(@PathVariable Long progId, Model model) {
        Optional<Programs> program = programService.findProgramById(progId);
        model.addAttribute("program", program);
        model.addAttribute("planDuration", new PlanDuration());
        return "/admin/planDuration/New";
    }

    // Handle form submission to create new plan duration
    @PostMapping("/plandurations/new")
    public String createPlanDuration(@ModelAttribute PlanDuration planDuration, @RequestParam Long programId) {
        Optional<Programs> program = programService.findProgramById(programId);
        planDuration.setProgram(program.get());
        planDurationService.saveNewPlanDuration(planDuration);
        return "redirect:/v2/plandurations/program/" + programId;
    }

    //     Handle toggling Activate/Deactivate planDuration
    @GetMapping("/planduration/status/{id}")
    public String updateStatusPlanDuration(@PathVariable Long id) {
        Long programId = planDurationService.togglePlanDurationStatus(id);
        return "redirect:/v2/plandurations/program/" + programId;
    }

    //-----------------------------------------------------
    //----Api for plans------------------------------------
    //-----------------------------------------------------
    //api to list plans based on a plan duration id

    @GetMapping("/plans/view/{id}")
    public String getPlansBasedOnPlanDuration(@PathVariable Long id, Model model) {
        Optional<PlanDuration> planDuration = planDurationService.findPlanDurationById(id);
        model.addAttribute("program", programService.findProgramById(planDuration.get().getProgram().getId()));
        List<Plans> plans = planService.fetchAllPlansByPlanDurationId(id);
        model.addAttribute("planDuration", planDuration);
        model.addAttribute("plans", plans);
        return "/admin/plans/PlanList";
    }

    // show form for adding new plan
    @GetMapping("/plans/new/{planDurId}")
    public String showFormForNewPlan(@PathVariable Long planDurId, Model model) {
        Optional<PlanDuration> planDuration = planDurationService.findPlanDurationById(planDurId);
        model.addAttribute("planDuration", planDuration);
        model.addAttribute("plan", new Plans());
        return "admin/plans/New";
    }

    // save new plan- handling the form data
    @PostMapping("plans/new")
    public String createNewPlan(@RequestParam Long planDurationId, @ModelAttribute Plans plans) {
        Optional<PlanDuration> currentPlanDuration = planDurationService.findPlanDurationById(planDurationId);
        plans.setPlanDuration(currentPlanDuration.get());
        planService.saveNewPlan(plans);
        return "redirect:/v2/plans/view/" + currentPlanDuration.get().getId();
    }

    //     Handle toggling Activate/Deactivate planDuration
    @GetMapping("/plans/status/{id}")
    public String updateStatusPlan(@PathVariable Long id) {
        Long planDurationId = planService.togglePlanStatus(id);
        return "redirect:/v2/plans/view/" + planDurationId;
    }
// return plans based on plan duration id
    @GetMapping("/fetchPlans")
    @ResponseBody
    public ResponseEntity<List<Plans>> fetchPlansByProgramId(@RequestParam Long planDurationId){
        return ResponseEntity.ok(planService.fetchAllPlansByPlanDurationId(planDurationId));
    }
}
