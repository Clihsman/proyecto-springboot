package com.drive.modules.location.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.drive.modules.location.model.Country;
import com.drive.modules.location.repository.CountryRepository;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/country")
@RequiredArgsConstructor
public class CountryController {

    private final CountryRepository countryRepository;

    @GetMapping("/{countryId}")
    public ResponseEntity<Country> getCountryById(@PathVariable int countryId) {
        Optional<Country> country = countryRepository.findById(countryId);
        return ResponseEntity.of(country);
    }

    @GetMapping
    public ResponseEntity<List<Country>> getCountry() {
        List<Country>countries = countryRepository.findAll();
        return ResponseEntity.ok(countries);
    }

    @PostMapping
    public ResponseEntity<Integer> createCountry() {
        return ResponseEntity.ok(1);
    }

    @PutMapping
    public ResponseEntity<Integer> editCountry() {
        return ResponseEntity.ok(1);
    }

    @DeleteMapping
    public ResponseEntity<Integer> deleteCountry() {
        return ResponseEntity.ok(1);
    }
}
