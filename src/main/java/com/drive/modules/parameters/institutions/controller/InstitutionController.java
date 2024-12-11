package com.drive.modules.parameters.institutions.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.drive.modules.parameters.institutions.controller.request.InstitutionRequest;
import com.drive.modules.parameters.institutions.model.Institution;
import com.drive.modules.parameters.institutions.service.InstitutionService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/parameters/institutions")
@RequiredArgsConstructor
public class InstitutionController {

    private final InstitutionService institutionService;

    @GetMapping
    public ResponseEntity<List<Institution>> getAllInstitutions() {
        return ResponseEntity.ok(institutionService.getAllInstitutions());
    }

    @PostMapping
    public ResponseEntity<Institution> createInstitution(@RequestBody @Valid InstitutionRequest institutionRequest) {
        return ResponseEntity.ok(institutionService.createInstitution(institutionRequest));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Integer> deleteInstitution(@PathVariable final Integer id) {
        return ResponseEntity.ok(institutionService.deleteInstitution(id));
    }
}
