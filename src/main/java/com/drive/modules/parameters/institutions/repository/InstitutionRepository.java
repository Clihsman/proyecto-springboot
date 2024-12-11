package com.drive.modules.parameters.institutions.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.drive.modules.parameters.institutions.model.Institution;

@Repository
public interface InstitutionRepository extends JpaRepository<Institution, Integer>  {
    int deleteById(int id);
}
