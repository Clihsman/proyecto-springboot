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
@RequestMapping("/city")
@RequiredArgsConstructor
public class CityController {

    @GetMapping
    public ResponseEntity<Integer> getCity() {
        return ResponseEntity.ok(1);
    }

    @PostMapping
    public ResponseEntity<Integer> createCity() {
        return ResponseEntity.ok(1);
    }

    @PutMapping
    public ResponseEntity<Integer> editCity() {
        return ResponseEntity.ok(1);
    }

    @DeleteMapping
    public ResponseEntity<Integer> deleteCity() {
        return ResponseEntity.ok(1);
    }

}
