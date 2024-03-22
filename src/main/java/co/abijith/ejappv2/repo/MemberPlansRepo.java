package co.abijith.ejappv2.repo;

import co.abijith.ejappv2.entity.MemberPlans;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface MemberPlansRepo extends JpaRepository<MemberPlans,Long> {
    Optional<List<MemberPlans>> findByRegistrationId(Long id);
}
