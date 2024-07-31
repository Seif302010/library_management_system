package com.lms.library_management_system.services.specific_services;

import com.lms.library_management_system.exceptions.InvalidException;
import com.lms.library_management_system.models.database_models.Patron;
import com.lms.library_management_system.repositories.PatronRepository;
import com.lms.library_management_system.services.generic_services.*;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PatronService extends GenericServiceImpl<Patron, Integer> {

    @Autowired
    private PatronRepository patronRepository;

    public PatronService(PatronRepository patronRepository) {
        this.repository = patronRepository;
    }

    @Override
    public void validatePost(Patron patron) {
        Map<String, String> errorMessages = new HashMap<>();
        if (patron.name == null || patron.name.trim().isEmpty()) {
            errorMessages.put("name", "cannot be null or empty");
        }
        if (patronRepository.findByName(patron.name).isPresent()) {
            errorMessages.put(patron.name, "there is a patron with this name");
        }
        if (patron.email == null || patron.email.trim().isEmpty()) {
            errorMessages.put("email", "cannot be null or empty");
        }
        if (patronRepository.findByEmail(patron.email).isPresent()) {
            errorMessages.put(patron.email, "there is a patron with this email");
        }
        if (patron.phone_number == null || patron.phone_number.trim().isEmpty()) {
            errorMessages.put("phone_number", "cannot be null or empty");
        }
        if (patronRepository.findByPhoneNumber(patron.phone_number).isPresent()) {
            errorMessages.put(patron.phone_number, "there is a patron with this phone number");
        }

        if (!errorMessages.isEmpty()) {
            throw new InvalidException(errorMessages);
        }
    }
}
