package co.abijith.ejappv2.service;

import co.abijith.ejappv2.entity.PlanDuration;
import co.abijith.ejappv2.repo.PlanDurationRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PlanDurationService {
    @Autowired
    PlanDurationRepo planDurationRepo;

    @Autowired
    ProgramService programService;


    public List<PlanDuration> fetchAllPlanDurations() {
        return planDurationRepo.findAll();
    }

    public Optional<PlanDuration> findPlanDurationById(Long id){
        return planDurationRepo.findById(id);
    }

    public List<PlanDuration> fetchPlanDurationsByProgramId(Long id) {
        return planDurationRepo.findByProgramId(id);
    }

    public void saveNewPlanDuration(PlanDuration planDuration) {
        planDurationRepo.save(planDuration);
    }

    public Long togglePlanDurationStatus(Long id) {
        Optional<PlanDuration> existingPlanDuration = planDurationRepo.findById(id);
        existingPlanDuration.ifPresent(planDuration -> {
            planDuration.setStatus("Active".equals(planDuration.getStatus()) ? "Inactive" : "Active");
            planDurationRepo.save(planDuration);
        });
        return existingPlanDuration.get().getProgram().getId();

    }
}
