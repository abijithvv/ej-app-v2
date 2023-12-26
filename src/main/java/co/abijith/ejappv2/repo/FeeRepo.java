package co.abijith.ejappv2.repo;

import co.abijith.ejappv2.entity.Fee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FeeRepo extends JpaRepository<Fee,Long> {
}
