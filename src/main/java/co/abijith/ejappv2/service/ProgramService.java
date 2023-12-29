package co.abijith.ejappv2.service;

import co.abijith.ejappv2.entity.Programs;
import co.abijith.ejappv2.repo.ProgramsRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProgramService {
    @Autowired
    private ProgramsRepo programsRepo;

    public List<Programs> fetchAllPrograms() {
        return programsRepo.findAll();
    }

    public void saveNewProgram(Programs program) {
        programsRepo.save(program);
    }

    public Optional<Programs> findProgramById(Long id) {
        return programsRepo.findById(id);
    }

    public void toggleProgramStatus(Long id) {
        Optional<Programs> existingProgram = findProgramById(id);
        existingProgram.ifPresent(program -> {
            program.setStatus("Active".equals(program.getStatus()) ? "Inactive" : "Active");
            programsRepo.save(program);
        });
    }
}
