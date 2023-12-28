package co.abijith.ejappv2.service;

import co.abijith.ejappv2.entity.Programs;
import co.abijith.ejappv2.repo.ProgramsRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProgramService {
    @Autowired
    private ProgramsRepo programsRepo;



    public List<Programs> fetchAllPrograms() {
        return programsRepo.findAll();
    }

    public void saveNewProgram(Programs program) {
//        Programs programs=new Programs();
//        programs.setStatus(true);
        programsRepo.save(program);
    }
}
