package com.drive.modules.location.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.drive.modules.location.model.Department;
import com.drive.modules.location.repository.DepartmentRepository;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/department")
@RequiredArgsConstructor
public class DepartmentController {

    private final DepartmentRepository repository;

    @GetMapping
    public ResponseEntity<List<Department>> getDepartments() {
        List<Department> departments = repository.findAll();
        return ResponseEntity.ok(departments);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Integer> getDepartmentById(@PathVariable int id) {
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