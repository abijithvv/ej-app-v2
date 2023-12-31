package co.abijith.ejappv2.repo;

import co.abijith.ejappv2.entity.PlanDuration;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PlanDurationRepo extends JpaRepository<PlanDuration,Long> {
    List<PlanDuration> findByProgramId(Long id);
}
