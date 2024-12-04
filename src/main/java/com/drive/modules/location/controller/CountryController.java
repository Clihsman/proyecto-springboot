package com.drive.modules.location.controller;

import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.drive.modules.api.ApiController;
import com.drive.modules.location.model.Country;
import com.drive.modules.location.repository.CountryRepository;

import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/country")
@RequiredArgsConstructor
public class CountryController extends ApiController {

    private CountryRepository countryRepository;

    @GetMapping("/{id}")
    public ResponseEntity<Country> getCountry(HttpServletRequest request) {
        Integer countryId = (Integer) request.getAttribute("id");
        Optional<Country> country = countryRepository.findById(countryId);
        return ResponseEntity.of(country);
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
