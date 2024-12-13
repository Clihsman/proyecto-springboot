package com.drive.modules.parameters.specialties.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.drive.modules.parameters.specialties.model.Specialty;
import com.drive.modules.parameters.specialties.service.SpecialtyService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/parameters/specialties")
@RequiredArgsConstructor
public class SpecialtyController {

    private final SpecialtyService service;

    @GetMapping
    public ResponseEntity<List<Specialty>> getAllSpecialties() {
        return ResponseEntity.ok(service.getAllSpecialties());
    }
}
