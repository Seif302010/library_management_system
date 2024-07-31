package com.lms.library_management_system.exceptions;

import java.util.HashMap;
import java.util.Map;

public class InvalidIdException extends RuntimeException {
    private final Map<String, String> errors = new HashMap<>();

    public InvalidIdException(Map<String, String> errors) {
        super("Invalid IDs");
        this.errors.putAll(errors);
    }

    public Map<String, String> getErrors() {
        return errors;
    }
}
