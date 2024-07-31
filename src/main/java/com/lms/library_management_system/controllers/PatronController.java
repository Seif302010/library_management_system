package com.lms.library_management_system.controllers;

import com.lms.library_management_system.services.specific_services.PatronService;
import com.lms.library_management_system.models.database_models.Patron;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/patrons")
public class PatronController {

    @Autowired
    private PatronService PatronService;

    @GetMapping
    public List<Patron> getAllPatrons() {
        return PatronService.getAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Patron> getPatronById(@PathVariable Integer id) {
        return PatronService.getById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Patron addPatron(@RequestBody Patron Patron) {
        return PatronService.add(Patron);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Patron> updatePatron(@PathVariable Integer id, @RequestBody Patron Patron) {
        return PatronService.getById(id)
                .map(existingPatron -> ResponseEntity.ok(PatronService.update(id, Patron)))
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePatron(@PathVariable Integer id) {
        PatronService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
