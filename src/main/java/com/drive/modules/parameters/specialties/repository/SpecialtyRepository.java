package com.drive.modules.parameters.specialties.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.drive.modules.parameters.specialties.model.Specialty;

public interface SpecialtyRepository extends JpaRepository<Specialty, Integer> {
    
}
