package co.abijith.ejappv2.service;

import co.abijith.ejappv2.entity.Registration;
import co.abijith.ejappv2.repo.RegistrationRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public class RegistrationService {
    @Autowired
    RegistrationRepo registrationRepo;

    public List<Registration> findaAllRegistration() {
        return registrationRepo.findAll();
    }

    public void saveRegistration(Registration registration) {
        registrationRepo.save(registration);
    }
}
