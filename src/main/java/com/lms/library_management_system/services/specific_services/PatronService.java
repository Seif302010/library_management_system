package com.lms.library_management_system.services.specific_services;

import com.lms.library_management_system.exceptions.InvalidException;
import com.lms.library_management_system.models.database_models.Patron;
import com.lms.library_management_system.repositories.PatronRepository;
import com.lms.library_management_system.services.generic_services.*;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

@Service
public class PatronService extends GenericServiceImpl<Patron, Integer> {

    public PatronService(PatronRepository patronRepository) {
        this.repository = patronRepository;
    }

    @Override
    public void validatePost(Patron patron) {
        Map<String, String> errorMessages = new HashMap<>();
        if (patron.name == null || patron.name.isEmpty()) {
            errorMessages.put("name", "cannot be null or empty");
        }
        if (patron.email == null || patron.email.isEmpty()) {
            errorMessages.put("email", "cannot be null or empty");
        }
        if (patron.phone_number == null || patron.phone_number.isEmpty()) {
            errorMessages.put("phone_number", "cannot be null or empty");
        }

        if (!errorMessages.isEmpty()) {
            throw new InvalidException(errorMessages);
        }
    }
}
