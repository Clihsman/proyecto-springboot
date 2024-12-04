package com.drive.modules.location.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/department")
@RequiredArgsConstructor
public class DepartmentController {

    @GetMapping
    public ResponseEntity<Integer> getDepartment() {
        return ResponseEntity.ok(1);
    }

    @PostMapping
    public ResponseEntity<Integer> createDepartment() {
        return ResponseEntity.ok(1);
    }

    @PutMapping
    public ResponseEntity<Integer> editDepartment() {
        return ResponseEntity.ok(1);
    }

    @DeleteMapping
    public ResponseEntity<Integer> deleteDepartment() {
        return ResponseEntity.ok(1);
    }
}