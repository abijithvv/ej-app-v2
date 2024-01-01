package co.abijith.ejappv2.repo;

import co.abijith.ejappv2.entity.Plans;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PlansRepo extends JpaRepository<Plans,Long> {
    List<Plans> findByPlanDurationId(Long planDurationId);
}
