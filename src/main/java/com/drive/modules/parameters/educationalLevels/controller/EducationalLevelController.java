package com.drive.modules.parameters.educationalLevels.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.drive.modules.parameters.educationalLevels.model.EducationalLevel;
import com.drive.modules.parameters.educationalLevels.repository.EducationalLevelRepository;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/parameters/educational-level")
@RequiredArgsConstructor
public class EducationalLevelController {

    private final EducationalLevelRepository educationalLevelRepository;

    @GetMapping
    public ResponseEntity<List<EducationalLevel>> getAllEducationalLevel() {
        return ResponseEntity.ok(educationalLevelRepository.findAll());
    }
}
