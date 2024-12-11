package com.drive.modules.parameters.educationalLevels.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.drive.modules.parameters.educationalLevels.model.EducationalLevel;

public interface EducationalLevelRepository extends JpaRepository<EducationalLevel, Integer>  {
    
}
