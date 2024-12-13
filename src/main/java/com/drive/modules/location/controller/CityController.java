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

import com.drive.modules.location.model.City;
import com.drive.modules.location.repository.CityRepository;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/city")
@RequiredArgsConstructor
public class CityController {

    private final CityRepository repository;

    @GetMapping
    public ResponseEntity<List<City>> getCities() {
        List<City> cities = repository.findAll();
        return ResponseEntity.ok(cities);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Integer> getCityById(@PathVariable int id) {
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
