package com.lms.library_management_system.exceptions;

import java.util.HashMap;
import java.util.Map;

public abstract class GlobalException extends RuntimeException {
    protected final Map<String, String> errors = new HashMap<>();

    public GlobalException(Map<String, String> errors) {
        this.errors.putAll(errors);
    }

    public Map<String, String> getErrors() {
        return errors;
    }
}
