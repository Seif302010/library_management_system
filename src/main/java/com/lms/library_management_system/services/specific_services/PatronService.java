package com.lms.library_management_system.services.specific_services;

import com.lms.library_management_system.models.database_models.Patron;
import com.lms.library_management_system.repositories.PatronRepository;
import com.lms.library_management_system.services.generic_services.*;
import org.springframework.stereotype.Service;

@Service
public class PatronService extends GenericServiceImpl<Patron, Integer> {

    public PatronService(PatronRepository patronRepository) {
        this.repository = patronRepository;
    }
}
