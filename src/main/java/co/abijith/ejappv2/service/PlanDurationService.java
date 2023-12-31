package co.abijith.ejappv2.service;

import co.abijith.ejappv2.entity.PlanDuration;
import co.abijith.ejappv2.entity.Programs;
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

    public List<PlanDuration> fetchPlanDurationsByProgramId(Long id) {
        return planDurationRepo.findByProgramId(id);
    }

    public void saveNewPlanDuration(PlanDuration planDuration) {
        planDurationRepo.save(planDuration);
    }
}
