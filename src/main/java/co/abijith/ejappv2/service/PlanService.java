package co.abijith.ejappv2.service;

import co.abijith.ejappv2.entity.Plans;
import co.abijith.ejappv2.repo.PlansRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlanService {

    @Autowired
    PlansRepo plansRepo;

    public List<Plans> fetchAllPlansByPlanDurationId(Long planDurationId){
        return plansRepo.findByPlanDurationId(planDurationId);
    }

    public void saveNewPlan(Plans plans) {
        plansRepo.save(plans);
    }
}
