package com.lms.library_management_system.exceptions;

import java.util.Map;

public class InvalidException extends GlobalException {
    public InvalidException(Map<String, String> errors) {
        super(errors);
    }
}
