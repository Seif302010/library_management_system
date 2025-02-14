package com.lms.library_management_system.controllers;

import com.lms.library_management_system.services.specific_services.PatronService;

import jakarta.validation.Valid;

import com.lms.library_management_system.models.database_models.Patron;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/patrons")
public class PatronController {

    @Autowired
    private PatronService patronService;

    @GetMapping
    public List<Patron> getAllPatrons() {
        return patronService.getAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Patron> getPatronById(@PathVariable Integer id) {
        return patronService.getById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Patron addPatron(@Valid @RequestBody Patron Patron) {
        return patronService.add(Patron);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Patron> updatePatron(@PathVariable Integer id, @RequestBody Patron patron) {
        Patron updatedPatron = patronService.update(id, patron);
        return ResponseEntity.ok(updatedPatron);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePatron(@PathVariable Integer id) {
        patronService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
