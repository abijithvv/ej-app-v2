package co.abijith.ejappv2.repo;

import co.abijith.ejappv2.entity.MemberPlans;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MemberPlansRepo extends JpaRepository<MemberPlans,Long> {
}
