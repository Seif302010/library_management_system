package com.lms.library_management_system;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

@Service
public class DatabaseService {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public boolean isDatabaseConnected() {
        try {
            // Execute a simple query to check the connection
            jdbcTemplate.execute("SELECT 1");
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
