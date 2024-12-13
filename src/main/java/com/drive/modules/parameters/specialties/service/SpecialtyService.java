package com.drive.modules.parameters.specialties.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.drive.modules.parameters.specialties.model.Specialty;
import com.drive.modules.parameters.specialties.repository.SpecialtyRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class SpecialtyService {

    private final SpecialtyRepository repository;

    public List<Specialty> getAllSpecialties() {
        return repository.findAll();
    }
}
