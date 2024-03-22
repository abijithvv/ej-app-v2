package co.abijith.ejappv2.controller;

import co.abijith.ejappv2.entity.MemberPlans;
import co.abijith.ejappv2.entity.Plans;
import co.abijith.ejappv2.entity.Registration;
import co.abijith.ejappv2.service.MemberPlanService;
import co.abijith.ejappv2.service.PlanService;
import co.abijith.ejappv2.service.ProgramService;
import co.abijith.ejappv2.service.RegistrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/v2")
public class RegistrationController {
    @Autowired
    RegistrationService registrationService;
    @Autowired
    ProgramService programService;
    @Autowired
    MemberPlanService memberPlanService;
    @Autowired
    PlanService planService;

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

    //list details of selected member including enrolled plans
    @GetMapping("/registration/member/{regId}")
    public String memberDetailsView(Model model, @PathVariable Long regId) {
        model.addAttribute("member", registrationService.getMemberById(regId).get());
        model.addAttribute("memberPlans", memberPlanService.fetchMemberPlansByRegistrationId(regId).get());
        return "/registration/ManageMember";
    }
//for testing fetchMemberPlansByRegistrationId method
    @GetMapping("/planbyregid/{regId}")
    @ResponseBody
    public Optional<List<MemberPlans>> fetchMemberPlansByRegistrationId(@PathVariable Long regId){
        return memberPlanService.fetchMemberPlansByRegistrationId(regId);
    }
    //to show the form to add new plan for a member
    @GetMapping("/enrollPlan/member/{id}")
    public String showFormEnrollment(@PathVariable Long id, Model model) {
        model.addAttribute("member", registrationService.getMemberById(id).get());
        model.addAttribute("memberPlan", new MemberPlans());
        model.addAttribute("program", programService.fetchAllPrograms());
        return "/registration/NewMemberPlan";
    }

    //for handling the form to save new plan for a member
    @PostMapping("enrollPlan/member")
    public String saveNewPlanForMember(@RequestParam Long planId, @RequestParam Long memberid, @ModelAttribute MemberPlans memberPlans) {
        Optional<Registration> member = registrationService.getMemberById(memberid);
        Optional<Plans> plan = planService.fetchPlanById(planId);
        memberPlans.setToDate(null);
        memberPlans.setLastFeeGeneratedDate(null);
        memberPlans.setRegistration(member.get());
        memberPlans.setPlan(plan.get());
        memberPlanService.saveNewMemberPlan(memberPlans);
        return "redirect:/v2/registration/member/" + memberid;
    }
    //for testing memberplan list
//    @GetMapping("/testmemberPlan")
//    @ResponseBody
//    public List<MemberPlans> getAllMemberPlans(){
//        return memberPlanService.fetchAllMemberPlans();
//    }
}
