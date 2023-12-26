package co.abijith.ejappv2.repo;

import co.abijith.ejappv2.entity.Programs;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProgramsRepo extends JpaRepository<Programs,Long> {
}
