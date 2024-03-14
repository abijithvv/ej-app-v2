package co.abijith.ejappv2.service;

import co.abijith.ejappv2.entity.Plans;
import co.abijith.ejappv2.repo.PlansRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PlanService {

    @Autowired
    PlansRepo plansRepo;

    public List<Plans> fetchAllPlansByPlanDurationId(Long planDurationId){
        return plansRepo.findByPlanDurationId(planDurationId);
    }

    public Optional<Plans> fetchPlanById(Long id){
        return plansRepo.findById(id);
    }

    public void saveNewPlan(Plans plans) {
        plansRepo.save(plans);
    }

    public Long togglePlanStatus(Long id) {
        Optional<Plans> existingPlan=plansRepo.findById(id);
        existingPlan.ifPresent(plan -> {
            plan.setStatus("Active".equals(plan.getStatus()) ? "Inactive" : "Active");
            plansRepo.save(plan);
        });
        return existingPlan.get().getPlanDuration().getId();
    }
}
